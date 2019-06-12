package com.app.braingames.core.history;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

public class JsonHistoryServiceImpl implements HistoryService {

    private ObjectMapper mapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);

    @Override
    public void log(String user, String game, String result) {
        HistoryRecord record = new HistoryRecord();
        HistoryList list = getHistoryList();
        list.getRecords().add(record);
        record.setUser(user);
        record.setGame(game);
        record.setResult(result);
        record.setDate(new Date());
        File file = new File("records.json");
        try {
            FileUtils.touch(file);
            mapper.writeValue(file, list);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<HistoryRecord> getHistory() {
        return getHistoryList().getRecords();
    }

    private HistoryList getHistoryList() {
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
