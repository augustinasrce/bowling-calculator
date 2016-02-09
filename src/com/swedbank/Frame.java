package com.swedbank;

/**
 * Created by p998ueh on 2016.02.09.
 */
public class Frame {
    private int firstRoll;
    private int secondRoll;
    private int extraRoll;


    public Frame(int firstRoll, int secondRoll, int extraRoll){
        this.firstRoll = firstRoll;
        this.secondRoll = secondRoll;
        this.extraRoll = extraRoll;
    }

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

    public int getExtraRoll() {
        return extraRoll;
    }

    public String getFrameResult() {
        if (firstRoll == 10)
            return "X";
        else if (firstRoll + secondRoll == 10)
            return firstRoll + "\\";
        else
            return Integer.toString(firstRoll + secondRoll);
    }

    public int getFrameScore(){
        return firstRoll+secondRoll;
    }
}
