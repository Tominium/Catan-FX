package com.example.catanfx.GamePieces.Misc;

public class Dice {

    private static int number, number0;

    public Dice() {
        number = 0;
        number0 = 0;
    }

    public static int getRolledNum() {

        number = (int)Math.random()*(6)+1;
        number0 = (int)Math.random()*(6)+1;
        return number + number0;
    }

    public static int[] rollDice() {
        int[] num = new int[2];
        num[0] = number;
        num[1] = number0;
        return num;
    }
}
