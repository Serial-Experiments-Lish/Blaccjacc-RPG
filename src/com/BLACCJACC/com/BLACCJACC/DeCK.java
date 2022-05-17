package com.BLACCJACC;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class DeCK {

    private ArrayList<CARD> deck;
    private ArrayList<CARD> hand;

    public DeCK() {
        this.deck = new ArrayList<CARD>();
    }

    public void createFullDeck() {
        // generate cards
        for(SUiTS suit : SUiTS.values()) {
            for(VALUEs cardValue : VALUEs.values()) {
                deck.add(new CARD(suit, cardValue));
            }
        }
    }

    public void shuffleDeck(){
        Collections.shuffle(deck, new Random());
    }



    public CARD getCard(int i){
        return this.deck.get(i);
    }

    public void removeCard(int i){
        this.deck.remove(i);
    }

    public void addCard(CARD addCard) {
        this.deck.add(addCard);
    }

    // Get the size of the deck
    public int deckSize() {
        return this.deck.size();
    }

    // Draws from the deck
    public void draw(DeCK comingFrom) {
        this.deck.add(comingFrom.getCard(0));
        comingFrom.deck.remove(0);
    }

    // This will move cards back into the deck to continue playing
    public void moveAllToDeck(DeCK moveTo) {
        int currentDeck = this.deck.size();
        for (int i = 0; i < currentDeck; i++) {
            moveTo.addCard(this.getCard(i));
            this.removeCard(0);
        }
    }

    public String toString() {
        String output = "";

        for (CARD card : deck) {
            output += card;
            output += "\n";
        }

        return output;
    }

    public int handCalculations() {
        int handValue = 0;
        int aceCase = 0;

        for(CARD card : hand){
            handValue += card.getValue();

            if (card.getValue() == 11){
                aceCase ++;
            }
        }

        if (handValue > 21 && aceCase > 0){
            while(aceCase > 0 && handValue > 21){
                aceCase --;
                handValue -= 10;
            }
        }
        return handValue;
    }

}