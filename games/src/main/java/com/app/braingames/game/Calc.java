package com.app.braingames.game;

import com.app.braingames.core.AbstractGame;

import java.util.Random;

public class Calc extends AbstractGame {

    private static final String GAMENAME = "Calc";

    private static final String CONDITION = "What is the result of the expression?";

    private static final Random RANDOM = new Random();

    @Override
    protected String getGameCondition() {
        return CONDITION;
    }

    @Override
    protected Pair getGameParams() {
        int questionNum1 = RANDOM.nextInt(100);
        int questionNum2 = RANDOM.nextInt(100);
        String operator = getRandomOperation();
        int rightAnswer = calculate(questionNum1, operator, questionNum2);
        return new Pair(questionNum1 + operator + questionNum2, String.valueOf(rightAnswer));
    }

    @Override
    protected String getGameName() {
        return GAMENAME;
    }

    private String getRandomOperation() {
        switch (RANDOM.nextInt(3)) {
            case 1:
                return "+";

            case 2:
                return "-";

            default:
                return "*";
        }
    }

    private int calculate(int questionNum1, String operator, int questionNum2) {
        switch (operator) {

            case "+":
                return questionNum1 + questionNum2;

            case "-":
                return questionNum1 - questionNum2;

            default:
                return questionNum1 * questionNum2;
        }
    }



}
