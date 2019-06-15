package com.app.braingames;


import com.app.braingames.core.history.HistoryService;
import com.app.braingames.core.history.JsonHistoryServiceImpl;
import org.junit.Test;

public class JsonHistoryServiceTest {

    private HistoryService historyService = new JsonHistoryServiceImpl();

    @Test
    public void Test() {
        historyService.log("testUser", "testGame", "testResult");
    }
}
