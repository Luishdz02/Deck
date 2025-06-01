package com.mycompany.deck;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Deck {

    // Clase interna para representar cartas
    public static class Card {
        private final String palo;
        private final String color;
        private final String valor;

        public Card(String palo, String color, String valor) {
            this.palo = palo;
            this.color = color;
            this.valor = valor;
        }

        @Override
        public String toString() {
            return palo + "," + color + "," + valor;
        }
    }

    private final List<Card> cartas;
    private final Random random;

    public Deck() {
        this.cartas = new ArrayList<>();
        this.random = new Random();
        inicializarDeck();
    }

    private void inicializarDeck() {
        String[] palos = {"tréboles", "corazones", "picas", "diamantes"};
        String[] valores = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "A", "J", "Q", "K"};

        for (String palo : palos) {
            String color = (palo.equals("corazones") || palo.equals("diamantes")) ? "rojo" : "negro";
            for (String valor : valores) {
                cartas.add(new Card(palo, color, valor));
            }
        }
    }

    public void barajar() {
        Collections.shuffle(cartas);
        System.out.println("Se mezcló el Deck.");
    }

    public void primeraCarta() {
        if (cartas.isEmpty()) {
            System.out.println("El deck está vacío.");
            return;
        }
        Card carta = cartas.remove(0);
        System.out.println(carta);
        System.out.println("Quedan " + cartas.size() + " cartas\n");
    }

    public void cartaAlAzar() {
        if (cartas.isEmpty()) {
            System.out.println("El deck está vacío.");
            return;
        }
        int indice = random.nextInt(cartas.size());
        Card carta = cartas.remove(indice);
        System.out.println(carta);
        System.out.println("Quedan " + cartas.size() + " cartas\n");
    }

    public void mano() {
        if (cartas.size() < 5) {
            System.out.println("No hay suficientes cartas en el deck.");
            return;
        }
        for (int i = 0; i < 5; i++) {
            Card carta = cartas.remove(0);
            System.out.println(carta);
        }
        System.out.println("Quedan " + cartas.size() + " cartas\n");
    }

    public static void main(String[] args) {
        Deck deck = new Deck();

        deck.barajar();

        System.out.println("Primera carta:");
        deck.primeraCarta();

        System.out.println("Carta al azar:");
        deck.cartaAlAzar();

        System.out.println("Mano de 5 cartas:");
        deck.mano();
    }
}