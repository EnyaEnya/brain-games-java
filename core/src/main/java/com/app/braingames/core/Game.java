package com.app.braingames.core;

import com.app.braingames.core.history.HistoryService;

public interface Game {

    void runGame();

    void setHistoryService(HistoryService historyService);

    String getGameName();
}
