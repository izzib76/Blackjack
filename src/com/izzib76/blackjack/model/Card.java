package com.izzib76.blackjack.model;

public class Card {
    private String suit;
    private String value;
    private int number;

    /**
     * @param s suit
     * @param v face value
     * @param n point number
     */
    public Card(String s, String v, int n) {
        this.suit = s;
        this.value = v;
        this.number = n;
    }

    /**
     * @return the suit of the card
     */
    public String getSuit() {
        return this.suit;
    }

    /**
     * @param s a string representing the suit of the card
     */
    public void setSuit(String s) {
        this.suit = s;
    }

    /**
     * @return the face value of the card
     */
    public String getValue() {
        return this.value;
    }

    /**
     * @param v the face value of the card
     */
    public void setValue(String v) {
        this.value = v;
    }

    /**
     * @return the point value of the card
     */
    public int getNumber() {
        return this.number;
    }

    /**
     * @param n the point value of the card
     */
    public void setNumber(int n) {
        this.number = n;
    }

}