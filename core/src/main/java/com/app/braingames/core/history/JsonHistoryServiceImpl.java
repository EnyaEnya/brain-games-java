package com.app.braingames.core.history;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class JsonHistoryServiceImpl extends AbstractHistoryService {

    private final static Logger log = LoggerFactory.getLogger(JsonHistoryServiceImpl.class);

    private ObjectMapper mapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);

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
        if (file.exists()) {
            try {
                return mapper.readValue(file, HistoryList.class);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return new HistoryList();
    }
}