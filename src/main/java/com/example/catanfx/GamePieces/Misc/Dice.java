package com.example.catanfx.GamePieces.Misc;

public class Dice {

    private int number, number0;

    public Dice() {
        number = 0;
        number0 = 0;
    }

    public int getRolledNum() {

        number = (int)Math.random()*(6)+1;
        number0 = (int)Math.random()*(6)+1;
        return number + number0;
    }

    public int[] rollDice() {
        int[] num = new int[2];
        num[0] = number;
        num[1] = number0;
        return num;
    }
}
