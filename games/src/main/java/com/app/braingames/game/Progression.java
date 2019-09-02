package com.app.braingames.game;

import com.app.braingames.core.AbstractGame;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class Progression extends AbstractGame {

    private static final String GAME_NAME = "Progression";

    private static final String CONDITION = "What number is missing in the progression?";

    private static final Random RANDOM = new Random();

    @Override
    protected String getGameCondition() {
        return CONDITION;
    }

    @Override
    protected Pair getGameParams() {
        int step = 2 + RANDOM.nextInt(10 - 2);
        int length = 10;
        return brainProgression(length, step);
    }

    @Override
    public String getGameName() {
        return GAME_NAME;
    }

    private Pair brainProgression(int length, int step) {
        int firstElement = 2 + RANDOM.nextInt(10 - 2);
        int hiddenElementPosition = RANDOM.nextInt(length);
        int rightAnswer = firstElement + step * hiddenElementPosition;
        String questionStr = "";

        for (int i = 0; i < length; i ++) {
            if (i == hiddenElementPosition) {
                questionStr += " .. ";
            } else {
                int currentElement = firstElement + step * i;
                questionStr += String.valueOf(currentElement);
                questionStr += " ";
            }
        }
        return new Pair(questionStr, String.valueOf(rightAnswer));
    }
}
