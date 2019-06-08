package com.app.braingames;

import com.app.braingames.core.Game;
import com.app.braingames.core.history.XmlHistoryServiceImpl;
import com.app.braingames.game.*;

import java.util.Scanner;

public class StartMenu {

    private Scanner scanner = new Scanner(System.in);

    private boolean run = true;


    public void run() {
        while (run) {
            int num = getNum();
            if (num > 5) {
                run = false;
            } else {
                Game startGame = getGame(num);
                startGame.setHistoryService(new XmlHistoryServiceImpl());
                startGame.runGame();
                return;
            }
        }

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
