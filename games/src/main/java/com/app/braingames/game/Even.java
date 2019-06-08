package com.app.braingames.game;

import com.app.braingames.core.AbstractGame;

import java.util.Random;

public class Even extends AbstractGame {

    private static final String GAMENAME = "Even";

    private static final String CONDITION = "Answer \"yes\" if number even otherwise answer \"no\".";

    private static final Random RANDOM = new Random();

    @Override
    protected String getGameCondition() {
        return CONDITION;
    }

    @Override
    protected Pair getGameParams() {
        int randomNumber = RANDOM.nextInt(100);
        return new Pair(String.valueOf(randomNumber), getRightAnswer(randomNumber));
    }

    @Override
    protected String getGameName() {
        return GAMENAME;
    }

    private String getRightAnswer(int number) {
        return number % 2 == 0 ? "yes" : "no";
    }
}
