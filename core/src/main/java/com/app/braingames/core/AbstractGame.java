package com.app.braingames.core;

import com.app.braingames.core.history.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Scanner;

public abstract class AbstractGame implements Game {

    private static final int ATTEMPTS = 3;

    @Autowired
    private HistoryService historyService;

    protected boolean stopped;

    @Override
    public void runGame() {
        init();
        stopped = false;
        try (Scanner scanner = new Scanner(System.in)) {
            String userName = getUserName(scanner);
            boolean gameResult = false;
            for (int i = 0; i < ATTEMPTS && !stopped; i++) {
                Pair params = getGameParams();
                System.out.println("Question: " + params.question);
                System.out.print("Your answer: ");
                String answer = scanner.nextLine();
                boolean success = isRightAnswer(answer, params.rightAnswer);
                if (success) {
                    gameResult = true;
                    afterCorrectAnswer();
                } else {
                    gameResult = false;
                    afterIncorrectAnswer(answer, params);
                }
            }

            String result;
            if (gameResult) {
                System.out.println("Congratulations, " + userName + "!");
                result = "success";
            } else {
                notSuccessGame(userName);
                result = "fail";
            }
            historyService.log(userName, getGameName(), result);
        }
    }

    protected void init() {
    }

    protected boolean isRightAnswer(String answer, String rightAnswer) {
        return answer.equals(rightAnswer);
    }

    protected void afterCorrectAnswer() {
        System.out.println("Correct!");
    }

    protected void notSuccessGame(String userName) {
        System.out.println("Let's try again, " + userName + "!");
    }

    protected void afterIncorrectAnswer(String answer, Pair params) {
        System.out.println(answer + " is wrong answer ;(. Correct answer was " + params.rightAnswer + ".");
        stopped = true;
    }

    protected abstract String getGameCondition();

    protected abstract Pair getGameParams();

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

}
