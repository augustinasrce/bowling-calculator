package com.swedbank;

import org.junit.Test;

import static org.junit.Assert.*;

public class Tests {

    @Test
    public void testLastFrameWithExtraRollFirstRoll() throws Exception {
        BowlingCalculator bc = new BowlingCalculator();
        bc.roll(10, 10, 10);
        bc.roll(3, 3, 3);
        bc.roll(5, 5, 5);
        bc.roll(0, 0, 0);

        assertEquals("Should be 10", 10, bc.frames.get(0).getFirstRoll());
        assertEquals("Should be 10", 3, bc.frames.get(1).getFirstRoll());
        assertEquals("Should be 10", 5, bc.frames.get(2).getFirstRoll());
        assertEquals("Should be 10", 0, bc.frames.get(3).getFirstRoll());
    }

    @Test
    public void testLastFrameWithExtraRollSecondRoll() throws Exception {
        BowlingCalculator bc = new BowlingCalculator();
        bc.roll(10, 10, 10);
        bc.roll(3, 3, 3);
        bc.roll(5, 5, 5);
        bc.roll(0, 0, 0);

        assertEquals("Should be 10", 10, bc.frames.get(0).getSecondRoll());
        assertEquals("Should be 10", 3, bc.frames.get(1).getSecondRoll());
        assertEquals("Should be 10", 5, bc.frames.get(2).getSecondRoll());
        assertEquals("Should be 10", 0, bc.frames.get(3).getSecondRoll());
    }

    @Test
    public void testLastFrameWithExtraRollExtraRoll() throws Exception {
        BowlingCalculator bc = new BowlingCalculator();
        bc.roll(10, 10, 10);
        bc.roll(3, 3, 3);
        bc.roll(5, 5, 5);
        bc.roll(0, 0, 0);

        assertEquals("Should be 10", 10, bc.frames.get(0).getExtraRoll());
        assertEquals("Should be 10", 3, bc.frames.get(1).getExtraRoll());
        assertEquals("Should be 10", 5, bc.frames.get(2).getExtraRoll());
        assertEquals("Should be 10", 0, bc.frames.get(3).getExtraRoll());
    }


    @Test
    public void testFrameFirstRoll() throws Exception {
        BowlingCalculator bc = new BowlingCalculator();

        bc.roll(0, 2);
        bc.roll(3, 0);
        bc.roll(10);
        bc.roll(7, 3);

        assertEquals("Should be 0", 0, bc.frames.get(0).getFirstRoll());
        assertEquals("Should be 3", 3, bc.frames.get(1).getFirstRoll());
        assertEquals("Should be 10", 10, bc.frames.get(2).getFirstRoll());
        assertEquals("Should be 10", 7, bc.frames.get(3).getFirstRoll());
    }

    @Test
    public void testFrameSecondRoll() throws Exception {
        BowlingCalculator bc = new BowlingCalculator();
        bc.roll(0, 2);
        bc.roll(3, 0);
        bc.roll(7, 3);

        assertEquals("Should be 0", 2, bc.frames.get(0).getSecondRoll());
        assertEquals("Should be 0", 0, bc.frames.get(1).getSecondRoll());
        assertEquals("Should be 0", 3, bc.frames.get(2).getSecondRoll());
    }


    @Test
    public void testGetTotalScore() throws Exception {
        BowlingCalculator bcForMaxScore = new BowlingCalculator();
        for (int i = 0; i < 9; i++) {
            bcForMaxScore.roll(10);
        }
        bcForMaxScore.roll(10, 10, 10);

        assertEquals("Should be 300", 300, bcForMaxScore.getTotalScore());

        BowlingCalculator bc = new BowlingCalculator();
        for (int i = 0; i < 9; i++) {
            bc.roll(5, 5);
        }
        bc.roll(5, 5, 5);
        assertEquals("Should be 150", 150, bc.getTotalScore());


    }
}