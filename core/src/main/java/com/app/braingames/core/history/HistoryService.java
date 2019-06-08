package com.app.braingames.core.history;

import java.util.List;

public interface HistoryService {

    void log(String user, String game, String result);

    List<HistoryRecord> getHistory();
}
