package com.app.braingames.core.history;

import com.app.braingames.core.parser.Parser;
import com.app.braingames.core.parser.impl.JaxbParser;
import org.apache.commons.io.FileUtils;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

public class XmlHistoryServiceImpl implements HistoryService {

    private Parser parser = new JaxbParser();

    @Override
    public void log(String user, String game, String result) {
        HistoryRecord record = new HistoryRecord();
        HistoryList list = getHistoryList();
        list.getRecords().add(record);
        record.setUser(user);
        record.setGame(game);
        record.setResult(result);
        record.setDate(new Date());
        File file = new File("records.xml");
        try {
            FileUtils.touch(file);
            parser.saveObject(file, list);
        } catch (IOException | JAXBException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<HistoryRecord> getHistory() {

        return getHistoryList().getRecords();
    }

    private HistoryList getHistoryList() {
        File file = new File("records.xml");
        if (file.exists()) {
            try {
                return parser.getObject(file, HistoryList.class);
            } catch (JAXBException e) {
                e.printStackTrace();
            }
        }
        return new HistoryList();
    }
}
