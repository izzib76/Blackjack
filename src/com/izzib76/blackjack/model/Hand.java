package com.izzib76.blackjack.model;

import java.util.List;

public class Hand {
    private List<Card> cards;
    private int playerId;
    private int pointValue;

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public String toString() {
        StringBuilder hand = new StringBuilder("Hand for player " + this.playerId + ": ");
        this.cards.forEach(card -> hand.append(card.toString() + " "));
        hand.append("\nPoint Value of Hand: " + calculatePointValue());
        return hand.toString();
    }

    public int calculatePointValue() {
        int temp = 0;
        for(Card card : cards) {
            temp += card.getNumber() ;
        }
        if (temp > 21){
            for (Card card : cards) {
                if(card.getValue().equals("A") && card.getNumber() == 11 && temp > 21) {
                    card.setNumber(1);
                    temp -= 10;
                }
            }
        }
        return temp;
    }
}
