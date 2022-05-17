package com.BLACCJACC;

import java.util.Random;

public class CARD {

    private SUiTS suit;
    private VALUEs value;

    // create arrays for values and suits - need these to generate random cards
    private VALUEs[] values = VALUEs.values();
    private Random randomValues = new Random();
    private SUiTS[] suits = SUiTS.values();
    private Random randomSuits = new Random();

    public CARD(SUiTS suit, VALUEs value) {
        this.value = value;
        this.suit = suit;
    }

    // random card generated
    public CARD() {
        this.suit = getRandomSuit();
        this.value = getRandomValue();
    }

    public String toString() {
        return this.suit.toString() + "-" + this.value.toString();
    }

    public VALUEs getValue() {
        return this.value;
    }

    public VALUEs getRandomValue() {
        return values[randomValues.nextInt(values.length)];
    }

    public SUiTS getRandomSuit() {
        return suits[randomSuits.nextInt(values.length)];
    }
}