package com.app.braingames.core.history;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Component
public class JsonHistoryServiceImpl extends AbstractHistoryService {

    private final static Logger log = LoggerFactory.getLogger(JsonHistoryServiceImpl.class);

    private ObjectMapper mapper;

    public JsonHistoryServiceImpl(ObjectMapper objectMapper) {
        this.mapper = objectMapper;
    }

    @Override
    public void log(String user, String game, String result) {
        File file = new File("records.json");
        try {
            FileUtils.touch(file);
            mapper.writeValue(file, prepareHistoryList(user, game, result));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public List<HistoryRecord> getHistory() {
        return getHistoryList().getRecords();
    }

    @Override
    protected HistoryList getHistoryList() {
        File file = new File("records.json");
        if (file.exists() && file.length() > 0) {
            try {
                return mapper.readValue(file, HistoryList.class);
            } catch (IOException e) {
                log.error("cannot read file " + file.getAbsolutePath(), e);
                throw new RuntimeException(e);
            }
        }
        return new HistoryList();
    }
}
