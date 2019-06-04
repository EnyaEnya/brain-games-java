package com.app.braingames.core;

import java.util.Scanner;

public abstract class AbstractGame implements Game {

    private static final int ATTEMPTS = 3;

    @Override
    public void runGame() {
        try (Scanner scanner = new Scanner(System.in)) {
            String userName = getUserName(scanner);
            for (int i = 0; i < ATTEMPTS; i++) {
                Pair params = getGameParams();
                System.out.println("Question: " + params.question);
                System.out.print("Your answer: ");
                String answer = scanner.nextLine();
                boolean success = answer.equals(params.rightAnswer);
                if (success) {
                    System.out.println("Correct!");
                } else {
                    System.out.println(answer + " is wrong answer ;(. Correct answer was " + params.rightAnswer + ".");
                    System.out.println("Let's try again, " + userName + "!");
                    return;
                }
            }
            System.out.println("Congratulations, " + userName + "!");
        }
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
