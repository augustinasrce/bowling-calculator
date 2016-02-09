package com.swedbank;

import java.util.ArrayList;

/**
 * Created by p998ueh on 2016.02.09!
 */
public class Frame {
    private ArrayList<Integer> rollScoreList = new ArrayList<Integer>();
    private ArrayList<Frame> frames;
    private int frameNumber;

    public ArrayList<Integer> getRollScoreList() {
        return rollScoreList;
    }

    public void setFrames(ArrayList<Frame> frames) {
        this.frames = frames;
    }

    public void setFrameNumber(int frameNumber) {
        this.frameNumber = frameNumber;
    }

    public void roll(int score) {
        rollScoreList.add(score);
    }

    public boolean isStrike() {
        return rollScoreList.get(0) == 10;
    }

    public boolean isSpare() {
        return rollScoreList.get(0) + rollScoreList.get(1) == 10;
    }

    public int strikeBonus() {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = frameNumber + 1; i < 10; i++) {
            list.addAll(frames.get(i).getRollScoreList());
        }
        if (frameNumber == 9)
            return rollScoreList.get(1) + rollScoreList.get(2);
        return list.get(0) + list.get(1);
    }

    public int spareBonus() {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = frameNumber + 1; i < 10; i++) {
            list.addAll(frames.get(i).getRollScoreList());
        }
        if (frameNumber == 9)
            return rollScoreList.get(2);
        return list.get(0);
    }

    public int getFrameScore() {
        int score;
        if (isStrike())
            score = 10 + strikeBonus();
        else if (isSpare())
            score = 10 + spareBonus();
        else
            score = rollScoreList.get(0) + rollScoreList.get(1);
        return score;
    }
}
