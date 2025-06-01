
package com.mycompany.deck;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Main {

    public static class Card {
        private final String suit;
        private final String color;
        private final String value;

        public Card(String suit, String color, String value) {
            this.suit = suit;
            this.color = color;
            this.value = value;
        }

        @Override
        public String toString() {
            return suit + "," + color + "," + value;
        }
    }

    private final List<Card> deck;
    private final Random random;

    public Main() {
        this.deck = new ArrayList<>();
        this.random = new Random();
        initializeDeck();
    }

    private void initializeDeck() {
        String[] suits = {"tréboles", "corazones", "picas", "diamantes"};
        String[] values = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "A", "J", "Q", "K"};

        for (String suit : suits) {
            String color = (suit.equals("corazones") || suit.equals("diamantes")) ? "rojo" : "negro";
            for (String value : values) {
                deck.add(new Card(suit, color, value));
            }
        }
    }

    public void shuffle() {
        Collections.shuffle(deck);
        System.out.println("Se mezcló el Deck.");
    }

    public void head() {
        if (deck.isEmpty()) {
            System.out.println("El deck está vacío.");
            return;
        }
        Card card = deck.remove(0);
        System.out.println(card);
        System.out.println("Quedan " + deck.size() + " cartas\n");
    }

    public void pick() {
        if (deck.isEmpty()) {
            System.out.println("El deck está vacío.");
            return;
        }
        int index = random.nextInt(deck.size());
        Card card = deck.remove(index);
        System.out.println(card);
        System.out.println("Quedan " + deck.size() + " cartas\n");
    }

    public void hand() {
        if (deck.size() < 5) {
            System.out.println("No hay suficientes cartas en el deck.");
            return;
        }
        for (int i = 0; i < 5; i++) {
            Card card = deck.remove(0);
            System.out.println(card);
        }
        System.out.println("Quedan " + deck.size() + " cartas\n");
    }

    public static void main(String[] args) {
        Main deck = new Main();

        deck.shuffle();

        System.out.println("Primera carta:");
        deck.head();

        System.out.println("Carta al azar:");
        deck.pick();

        System.out.println("Mano de 5 cartas:");
        deck.hand();
    }
}