package com.app.braingames.core.history;

import java.util.Date;

public abstract class AbstractHistoryService implements HistoryService {

    protected HistoryList prepareHistoryList(String user, String game, String result) {
        HistoryRecord record = new HistoryRecord();
        HistoryList list = getHistoryList();
        list.getRecords().add(record);
        record.setUser(user);
        record.setGame(game);
        record.setResult(result);
        record.setDate(new Date());
        return list;
    }

    protected abstract HistoryList getHistoryList();

}
