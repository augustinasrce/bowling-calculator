package com.swedbank;

/**
 * Created by p998ueh on 2016.02.09.
 */
public class Frame {
    private int firstRoll;
    private int secondRoll;

    public Frame(int firstRoll, int secondRoll) {
        this.firstRoll = firstRoll;
        this.secondRoll = secondRoll;
    }

    public int getFirstRoll() {
        return firstRoll;
    }

    public int getSecondRoll() {
        return secondRoll;
    }

    public String getFrameResult() {
        if (firstRoll == 10)
            return "X";
        else if (firstRoll + secondRoll == 10)
            return firstRoll + "\\";
        else
            return Integer.toString(firstRoll + secondRoll);
    }

    public int getFrameScore() {
        return firstRoll + secondRoll;
    }
}
