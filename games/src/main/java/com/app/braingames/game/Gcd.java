package com.app.braingames.game;

import com.app.braingames.core.AbstractGame;

import java.util.Random;

public class Gcd extends AbstractGame{

    private static final String GAME_NAME = "Gcd";

    private static final String CONDITION = "Find the greatest common divisor of given numbers.";

    private static final Random RANDOM = new Random();

    @Override
    protected String getGameCondition() {
        return CONDITION;
    }

    @Override
    protected Pair getGameParams() {
        int questionNum1 = RANDOM.nextInt(100);
        int questionNum2 = RANDOM.nextInt(100);
        int rightAnswer = gcd(questionNum1, questionNum2);
        return new Pair(questionNum1 + ", " + questionNum2, String.valueOf(rightAnswer));
    }

    @Override
    public String getGameName() {
        return GAME_NAME;
    }

    private int gcd(int questionNum1, int questionNum2) {
        if (questionNum2 == 0) {
            return questionNum1;
        }
        return gcd(questionNum2, questionNum1 % questionNum2);
    }

}
