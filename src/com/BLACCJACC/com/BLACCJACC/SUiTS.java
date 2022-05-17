package com.BLACCJACC;

public enum SUiTS {
    DIAMOND("Diamonds"), HEART("Hearts"), SPADE("Spades"), CLUB("Clubs");

    String name;

    SUiTS(String name) {
        this.name = name;
    }

    public String toString() {
        return name;
    }
}