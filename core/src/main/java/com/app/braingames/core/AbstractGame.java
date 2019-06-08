package com.app.braingames.core;

import com.app.braingames.core.history.HistoryService;

import java.util.Scanner;

public abstract class AbstractGame implements Game {

    private static final int ATTEMPTS = 3;

    private HistoryService historyService;

    @Override
    public void runGame() {
        try (Scanner scanner = new Scanner(System.in)) {
            String userName = getUserName(scanner);
            boolean gameResult = false;
            for (int i = 0; i < ATTEMPTS; i++) {
                Pair params = getGameParams();
                System.out.println("Question: " + params.question);
                System.out.print("Your answer: ");
                String answer = scanner.nextLine();
                boolean success = answer.equals(params.rightAnswer);
                if (success) {
                    System.out.println("Correct!");
                    gameResult = true;
                } else {
                    System.out.println(answer + " is wrong answer ;(. Correct answer was " + params.rightAnswer + ".");
                    gameResult = false;
                    break;
                }
            }

            if (gameResult) {
                System.out.println("Congratulations, " + userName + "!");
                historyService.log(userName, getGameName(), "success");
            } else {
                System.out.println("Let's try again, " + userName + "!");
                historyService.log(userName, getGameName(), "fail");
            }


        }
    }

    protected abstract String getGameCondition();

    protected abstract Pair getGameParams();

    protected abstract String getGameName();

    private String getUserName(Scanner scanner) {
        System.out.println("Welcome to the Brain Games!");
        System.out.println(getGameCondition());
        System.out.print("May I have your name? ");
        String userName = scanner.nextLine();
        System.out.println("Hello, " + userName);
        return userName;
    }

    protected static class Pair {

        private final String question;

        private final String rightAnswer;

        public Pair(String question, String rightAnswer) {
            this.question = question;
            this.rightAnswer = rightAnswer;
        }
    }

    @Override
    public void setHistoryService(HistoryService historyService) {
        this.historyService = historyService;
    }
}
