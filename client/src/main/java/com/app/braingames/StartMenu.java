package com.app.braingames;

import com.app.braingames.core.Game;
import com.app.braingames.core.history.HistoryRecord;
import com.app.braingames.core.history.HistoryService;
import com.app.braingames.core.history.JsonHistoryServiceImpl;
import com.app.braingames.game.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Scanner;

public class StartMenu {

    private final static Logger log = LoggerFactory.getLogger(StartMenu.class);

    private Scanner scanner = new Scanner(System.in);

    private boolean run = true;

    private HistoryService historyService = new JsonHistoryServiceImpl();


    public void run() {
        log.info("run game");
        while (run) {
            int num = getNum();
            if (num > 5) {
                run = false;
                log.info("exit");
            } else {
                Game startGame = getGame(num);
                log.info("run game {}", startGame.getGameName());
                startGame.setHistoryService(historyService);
                startGame.runGame();
                System.out.println(xmlToString(historyService.getHistory()));
                return;
            }
        }

    }

    private String xmlToString(List<HistoryRecord> historyRecords) {
        String result = "=====";
        for (HistoryRecord record: historyRecords) {
            result += "\n";
            result += record.toString();
        }
        result += "\n";
        result += "=====";
        return result;
    }



    private Game getGame(int num) {
        switch (num) {
            case 1:
                return new Calc();

            case 2:
                return new Even();

            case 3:
                return new Gcd();

            case 4:
                return new Prime();

            default:
                return new Progression();
        }
    }



    private int getNum(){
        System.out.println("Choose the game:");
        System.out.println("1 - Calculate");
        System.out.println("2 - Even");
        System.out.println("3 - Gcd");
        System.out.println("4 - Prime");
        System.out.println("5 - Progression");
        System.out.println("6 - Exit");
        String num = scanner.nextLine();
        return Integer.parseInt(num);
    }





}
