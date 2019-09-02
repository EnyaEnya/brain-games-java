package com.app.braingames.game;

import com.app.braingames.core.AbstractGame;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class GuessNum extends AbstractGame {

    private static final String GAME_NAME = "GuessNum";

    private static final String CONDITION = "Guess the number from 0 to 10";

    private static final Random RANDOM = new Random();

    private int rightAnswer;

    @Override
    protected String getGameCondition() {
        return CONDITION;
    }


    @Override
    protected Pair getGameParams() {
        String questionNum = "Enter your number:";
        return new Pair(questionNum, String.valueOf(rightAnswer));
    }

    @Override
    public String getGameName() {
        return GAME_NAME;
    }


    @Override
    protected void afterIncorrectAnswer(String answer, Pair params) {
        int intAnswer = Integer.parseInt(answer);

        if (intAnswer > rightAnswer) {
            System.out.println("Right number less then your number");
        } else {
            System.out.println("Right number more then your number");
        }

    }

    @Override
    protected void afterCorrectAnswer() {
        super.afterCorrectAnswer();
        stopped = true;
    }

    @Override
    protected boolean isRightAnswer(String answer, String rightAnswer) {
        int intAnswer = Integer.parseInt(answer);
        return intAnswer == this.rightAnswer;
    }

    @Override
    protected void notSuccessGame (String userName) {
        System.out.println("Correct answer was: " + rightAnswer + " Let's try again, " + userName + "!");
    }

    @Override
    protected void init() {
        rightAnswer = RANDOM.nextInt(10);
    }


}
