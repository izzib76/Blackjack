package com.izzib76.blackjack.model;

import java.util.List;

public class Hand {
    private List<Card> cards;
    private int playerId;

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
        return hand.toString();
    }
}
