package com.app.braingames.game;

import com.app.braingames.core.AbstractGame;

import java.util.Random;

public class Prime extends AbstractGame{

    private static final String GAME_NAME = "Prime";

    private static final String CONDITION = "Answer \"yes\" if given number is prime. Otherwise answer \"no\".";

    private static final Random RANDOM = new Random();

    @Override
    protected String getGameCondition() {
        return CONDITION;
    }

    @Override
    protected Pair getGameParams() {
        int questionNum = RANDOM.nextInt(100);
        return new Pair(String.valueOf(questionNum), getRightAnswer(questionNum));
    }

    @Override
    public String getGameName() {
        return GAME_NAME;
    }

    private boolean isPrime(int questionNum) {
        if (questionNum < 2) {
            return false;
        }
        for (int i = 2; i <= questionNum / 2; i += 1) {
            if (questionNum % i == 0) {
                return false;
            }
        }
        return true;
    }

    private String getRightAnswer(int questionNum) {
        return isPrime(questionNum) ? "yes" : "no";
    }

}
