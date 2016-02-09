package com.swedbank;

/**
 * Created by Augustinas on 09 02 2016!
 */
public class Main {
    public static void main(String[] args){
        BowlingCalculator bc = new BowlingCalculator();
        for (int i = 0; i < 10 ; i++) {
            bc.addFrame(i);
        }
    }
}
