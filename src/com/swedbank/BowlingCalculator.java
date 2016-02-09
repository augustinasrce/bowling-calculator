package com.swedbank;

import java.awt.*;
import java.util.ArrayList;

public class BowlingCalculator {
    ArrayList<Frame> frames = new ArrayList<Frame>();


    public void roll(int score) {
        roll(score, 10 - score);
    }

    public void roll(int firstScore, int secondScore) {
        frames.add(new Frame(firstScore, secondScore));
    }

    public void roll(int firstScore, int secondScore, int extraRollScore) {
        frames.add(new Frame(firstScore, secondScore, extraRollScore));
    }

    public int getTotalScore() {
        int totalScore = 0;
        for (int i = 0; i < frames.size(); i++) {
            if (frames.get(i).getFrameResult().equals("X")) {
                if (frames.get(i + 1).getFrameResult().equals("X")) {
                    totalScore += 20 + frames.get(i + 2).getFirstRoll();
                } else {
                    totalScore += 10 + frames.get(i + 1).getFirstRoll() + frames.get(i + 1).getSecondRoll();
                }
            } else if (frames.get(i).getFrameResult().equals("\\")) {
                totalScore += 10 + frames.get(i + 1).getFirstRoll();
            } else {
                totalScore += frames.get(i).getFrameScore();
            }
        }
        return totalScore;
    }
}
