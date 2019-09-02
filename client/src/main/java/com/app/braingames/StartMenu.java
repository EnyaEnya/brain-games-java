package com.app.braingames;

import com.app.braingames.core.Game;
import com.app.braingames.core.history.HistoryRecord;
import com.app.braingames.core.history.HistoryService;
import com.app.braingames.game.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Component
public class StartMenu {

    private final static Logger log = LoggerFactory.getLogger(StartMenu.class);

    private Scanner scanner = new Scanner(System.in);

    private boolean run = true;

    @Autowired
    private Calc calc;

    @Autowired
    private Even even;

    @Autowired
    private Gcd gcd;

    @Autowired
    private GuessNum guessNum;

    @Autowired
    private Prime prime;

    @Autowired
    private Progression progression;

    @Autowired
    private HistoryService historyService;


    public void run() {
        log.info("run game");
        while (run) {
            int num = getNum();
            if (num > 6) {
                run = false;
                log.info("exit");
            } else {
                Game startGame = getGame(num);
                log.info("run game {}", startGame.getGameName());
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
                return calc;

            case 2:
                return even;

            case 3:
                return gcd;

            case 4:
                return prime;

            case 5:
                return progression;

            default:
                return guessNum;
        }
    }



    private int getNum(){
        System.out.println("Choose the game:");
        System.out.println("1 - Calculate");
        System.out.println("2 - Even");
        System.out.println("3 - Gcd");
        System.out.println("4 - Prime");
        System.out.println("5 - Progression");
        System.out.println("6 - GuessNum");
        System.out.println("7 - Exit");
        String num = scanner.nextLine();
        return Integer.parseInt(num);
    }





}
