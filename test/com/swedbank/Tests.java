package com.swedbank;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Tests {

    @Test
    public void testAllZero() throws Exception {
        BowlingCalculator bc = new BowlingCalculator();
        for (int i = 0; i < 10; i++) {
            bc.frames.add(new Frame());
            bc.frames.get(i).roll(0);
            bc.frames.get(i).roll(0);
        }
        assertEquals(0, bc.getTotalScore());
    }

    @Test
    public void testAllOne() throws Exception {
        BowlingCalculator bc = new BowlingCalculator();
        for (int i = 0; i < 10; i++) {
            bc.frames.add(new Frame());
            bc.frames.get(i).roll(1);
            bc.frames.get(i).roll(1);
        }
        assertEquals(20, bc.getTotalScore());
    }

    @Test
    public void testAllStrike() throws Exception {
        BowlingCalculator bc = new BowlingCalculator();
        for (int i = 0; i < 10; i++) {
            bc.frames.add(new Frame());
            bc.frames.get(i).setFrames(bc.frames);
            bc.frames.get(i).setFrameNumber(i);
            bc.frames.get(i).roll(10);
        }
        bc.frames.get(9).roll(10);
        bc.frames.get(9).roll(10);
        assertEquals(300, bc.getTotalScore());
    }

    @Test
    public void testAllFive() throws Exception {
        BowlingCalculator bc = new BowlingCalculator();
        for (int i = 0; i < 10; i++) {
            bc.frames.add(new Frame());
            bc.frames.get(i).setFrames(bc.frames);
            bc.frames.get(i).setFrameNumber(i);
            bc.frames.get(i).roll(5);
            bc.frames.get(i).roll(5);
        }
        bc.frames.get(9).roll(5);
        assertEquals(150, bc.getTotalScore());
    }

    @Test
    public void testStrike() throws Exception {
        BowlingCalculator bc = new BowlingCalculator();
        bc.frames.add(new Frame());
        bc.frames.get(0).setFrames(bc.frames);
        bc.frames.get(0).setFrameNumber(0);
        bc.frames.get(0).roll(10);

        bc.frames.add(new Frame());
        bc.frames.get(1).setFrames(bc.frames);
        bc.frames.get(1).setFrameNumber(0);
        bc.frames.get(1).roll(7);
        bc.frames.get(1).roll(1);

        for (int i = 2; i < 10; i++) {
            bc.frames.add(new Frame());
            bc.frames.get(i).setFrames(bc.frames);
            bc.frames.get(i).setFrameNumber(i);
            bc.frames.get(i).roll(0);
            bc.frames.get(i).roll(0);
        }
        assertEquals(26, bc.getTotalScore());
    }


}