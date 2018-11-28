package com.izzib76.blackjack;

import com.izzib76.blackjack.model.Card;
import com.izzib76.blackjack.model.Deck;
import com.izzib76.blackjack.model.Hand;

import java.util.*;

public class Blackjack {

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        System.out.println("How many people are playing?");
        int numPlayers = scan.nextInt();
        //BUG-001
        while (numPlayers > 7){
            System.out.println("There can only be a max of 7 players. Please re-enter number playing");
            numPlayers = scan.nextInt();
        }

        //create the playing deck
        Deck deck = new Deck();

        //There can only be 4 suits. Lets create list of the 4 suits
        List<String> suits = Arrays.asList("Hearts", "Clubs", "Spades", "Diamonds");

        //Card values are also duplicated across the suits. Creating lists to store them
        List<String> cardValues = Arrays.asList("A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K");

        //create the list of cards that needs to go into the deck. There will be 52 total cards
        List<Card> playingCards = new ArrayList<>();
        suits.stream().forEach(suit ->
            cardValues.stream().forEach(cardValue -> playingCards.add(new Card(suit, cardValue))));

        //shuffle and add playing cards to the deck
        Collections.shuffle(playingCards);
        deck.setCards(playingCards);

        List<Hand> hands = new ArrayList<>();

        for(int i=1 ; i<=numPlayers ; i++){
            Hand hand = new Hand();
            hand.setPlayerId(i);
            hand.setCards(Arrays.asList(deck.getCards().remove(0), deck.getCards().remove(0)));
            hands.add(hand);
            System.out.println(hand.toString());
        }



        System.out.println("deck size: " + deck.getCards().size());

    }
}
