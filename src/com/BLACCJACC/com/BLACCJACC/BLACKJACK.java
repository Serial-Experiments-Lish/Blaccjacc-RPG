package com.BLACCJACC;

import java.util.Scanner;

public class BLACKJACK {
    private int wins;
    private int losses;
    private int pushes;

    public BLACKJACK() {
        wins = 0;
        losses = 0;
        pushes = 0;
    }

    public static void main(String[] args) {

        System.out.println("It is a nippy winter evening.  You find yourself stumbling through a forest that, just mere moments before, you had been unaware of its existence.");
        System.out.print("\nYou hear a rustle coming from your six.  You about face with the most reckless abandon that you could get cancelled for it had the right person only witnessed.");
        System.out.print("  With a sigh of relief, you notice it is just a rabbit... Riding a wolf. \n\n'This way, my child.  Your uneventful tale called a life very well depends on it!  Respectfully.'");
        System.out.println("\n\nDetermined to not receive emotional damage from a critter with floppy ears, you follow the rabbit deeper into the thicket.  You remember what your mother told you about following strangers, however, she never mentioned strange animals.");
        System.out.println("\nA few trips and a sasquatch-reminiscent-of-Jason-Momoa-sighting later, you begin to notice a faint glow.  It's a shack, deep in the woods.  You can feel an ominous aura eminating from inside, as if you're about to lose a lump sum of money if you step foot in there.");
        System.out.println("\n'Go on,' says the Narnia rabbit.  'Our employer has been awaiting your arrival-- and whatever it is you are carrying in those pockets.'");
        System.out.println("\nAs you walk in, you recognize the silhouette standing before you.  The hand beckons you forward until-- \nWait a minute, is that Lishenga?!-- you think to yourself.");
        System.out.println("\n'Oui, it is I!  How am I reading your mind, you are wondering?  Elementary, my dear Watson.'");
        System.out.println("\n'I have summoned you here because I grow tired of playing Bugs Bunny + wolf Aslan out there.  I already took his prized magic carrot + Waslan is the homie.'");
        System.out.println("'What's keeping you here to indulge me in my game, you ask?  WHY DON'T YOU TAKE A LOOK BEHIND CURTAIN A!!!' \n*Behind CURTAIN A is a dwarf and an elf running an illegal cockatrice fighting ring*");
        System.out.println("\n'I meant CURTAIN B!!!' \n*Behind CURTAIN B is your best friend being slowly boiled in a cauldron at a comfortable 125°F, along with your favorite rubber ducky.  Lishenga's lovely accomplice seasons your best friend every hour on the dot.*");
        System.out.println("\n'The cockatrice must eat, ya know?  They like their meal to be fall-off-the-bone tender.'");
        System.out.println("\n'Now, enough chat.  Out here, no one can hear you scream as I make you RUN THEM POCKET-O'S!' \n\n*Encounter Started* \n*A foul-intent 'Lishenga the Swindler' has appeared.* \n*Operation: Run them pockets*");
        System.out.println("\nWelcome to Blackjack!");

        //Create the playing deck
        DeCK playingDeck = new DeCK();
        playingDeck.createFullDeck();
        playingDeck.shuffleDeck();

        // Create hands for the player and the dealer - hands are created from methods that are made in the deck class
        DeCK playerHand = new DeCK();
        DeCK dealerHand = new DeCK();

        double betAmount = 1000.0;
        Scanner scanner = new Scanner(System.in);

        while (betAmount > 0) {
            System.out.println("\nYou are starting off with $" + betAmount + ".");
            System.out.println("\nFor how much would you like to run me those pockets?  Don't forget your friend is getting tender... \n(You can bet in increments of 10)");
            double playerPockets = scanner.nextDouble();

            if (playerPockets % 10 != 0) {
                System.out.println("You don't like to follow suggestions?  It's almost time for another round of seasoning.");
                continue;
            } else if (playerPockets > betAmount) {
                System.out.println("In some countries, being broke is a crime.");
                break;
            }

            boolean roundOver = false;
            playerHand.draw(playingDeck);
            playerHand.draw(playingDeck);

            dealerHand.draw(playingDeck);
            dealerHand.draw(playingDeck);

            while (true) {
                System.out.println("Your hand: ");
                System.out.println(playerHand.toString());
                System.out.println("Your hand adds up to: " + playerHand.handCalculations());
                System.out.println("Lishenga the Swindler's hand is: " + dealerHand.getCard(0).toString() + " and a trap card (and I end my turn).");                    
                System.out.println("What do you like to do? \n1. Hit \n2. Stand");
                int input = scanner.nextInt();

                if (input == 1) {
                    playerHand.draw(playingDeck);
                    System.out.println("You drew: " + playerHand.getCard(playerHand.deckSize() - 1).toString());
                    
                    if (playerHand.handCalculations() > 21) {
                        System.out.println("Run. Me. Them. Pockets!!!! This round is mine!  You flopped with a: " + playerHand.handCalculations());
                        System.out.println("The marinade is almost ready.");
                        betAmount -= playerPockets;
                        roundOver = true;
                        break;
                    }
                }
                if (input == 2) {
                    break;
                }
            }

            System.out.println("Lishenga the Swindler's hand: " + dealerHand.toString());
            
            if ((dealerHand.handCalculations() > playerHand.handCalculations()) && !roundOver) {
                System.out.println("The Swindler strikes again!");
                betAmount -= playerPockets;
                roundOver = true;
            }
            
            while ((dealerHand.handCalculations()) < 17 && !roundOver) {
                dealerHand.draw(playingDeck);
                System.out.println("Lishenga the Swindler draws: " + dealerHand.getCard(dealerHand.deckSize() - 1).toString());
            }
            
            System.out.println("Lishenga the Swindler's hand total: " + dealerHand.handCalculations());
            
            if ((dealerHand.handCalculations() > 21) && !roundOver) {
                System.out.println("No seasoning this round.  Good on you, mate.");
                betAmount += playerPockets;
                roundOver = true;
            }
            
            if ((playerHand.handCalculations() == dealerHand.handCalculations()) && !roundOver) {
                System.out.println("Tis a draw!");
                roundOver = true;
            }

            if ((playerHand.handCalculations() > dealerHand.handCalculations()) && !roundOver) {
                System.out.println("At this rate, the cockatrice may not eat tonight.  Your win.");
                betAmount += playerPockets;
                roundOver = true;
            } else if (!roundOver) {
                System.out.println("Food is almost ready, boys!");
                betAmount -= playerPockets;
                roundOver = true;
            }

            playerHand.moveAllToDeck(playingDeck);
            dealerHand.moveAllToDeck(playingDeck);
            System.out.println("Round over!");
        }


        if (betAmount == 0) {
            System.out.println("Your friend isn't gonna make it ;( ");
        }    
    }
}