package com.swedbank;

import java.util.ArrayList;
import java.util.Random;

public class BowlingCalculator {
    public ArrayList<Frame> frames;

    public BowlingCalculator() {
        frames = new ArrayList<Frame>();
    }

    public void addFrame(int frameNumber) {
        Frame frame = new Frame();
        frame.setFrames(frames);
        frame.setFrameNumber(frameNumber);
        int score = new Random().nextInt(10);
        if (frameNumber != 9) { // first 9 frames
            frame.roll(score);
            if (!frame.isStrike())
                frame.roll(new Random().nextInt(10 - score));

        } else { // 10th frame
            frame.roll(score);
            if (frame.isStrike()) {
                score = new Random().nextInt(10);
                frame.roll(score);
                if (score == 10)
                    frame.roll(new Random().nextInt(10));
                else
                    frame.roll(10 - score);
            } else {
                frame.roll(10 - score);
                if (frame.isSpare())
                    frame.roll(new Random().nextInt(10));
            }
        }
        frames.add(frame);
    }


    public int getTotalScore() {
        int totalScore = 0;
        for (Frame f : frames) {
            totalScore += f.getFrameScore();
        }
        return totalScore;
    }
}
