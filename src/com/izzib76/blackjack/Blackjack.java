package com.izzib76.blackjack;

import com.izzib76.blackjack.model.Card;
import com.izzib76.blackjack.model.Deck;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Blackjack {

    public static void main(String[] args){
        System.out.println("Hello World");

        //create the playing deck
        Deck deck = new Deck();

        //There can only be 4 suits. Lets create list of the 4 suits
        List<String> suits = Arrays.asList("Hearts", "Clubs", "Spades", "Diamonds");

        //Card values are also duplicated across the suits. Creating lists to store them
        List<String> cardValues = Arrays.asList("A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K");

        //create the list of cards that needs to go into the deck. There will be 52 total cards
        List<Card> playingCards = new ArrayList<>();
        suits.stream().forEach(suit ->
            cardValues.stream().forEach(cardValue ->
                playingCards.add(new Card(suit, cardValue, 1))));

        //Add playing cards to the deck
        deck.setCards(playingCards);


    }
}
