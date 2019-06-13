package com.app.braingames.core.history;

import com.app.braingames.core.parser.Parser;
import com.app.braingames.core.parser.impl.JaxbParser;
import org.apache.commons.io.FileUtils;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class XmlHistoryServiceImpl extends AbstractHistoryService {

    private Parser parser = new JaxbParser();

    @Override
    public void log(String user, String game, String result) {
        File file = new File("records.xml");
        try {
            FileUtils.touch(file);
            parser.saveObject(file, prepareHistoryList(user, game, result));
        } catch (IOException | JAXBException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<HistoryRecord> getHistory() {

        return getHistoryList().getRecords();
    }

    @Override
    protected HistoryList getHistoryList() {
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
