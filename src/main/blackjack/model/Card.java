package main.blackjack.model;

public class Card {
    private String suit;
    private String value;
    private int score;

    /**
     * @param x suit
     * @param y face value
     */
    public Card(String x, String y) {
        this.suit = x;
        this.value = y;
        this.score = determineScoreFromFaceValue(y);
    }

    public String getSuit() {
        return this.suit;
    }

    /**
     * @param x a string representing the suit of the card
     */
    public void setSuit(String x) {
        this.suit = x;
    }

    public String getValue() {
        return this.value;
    }

    /**
     * @param x the face value of the card
     */
    public void setValue(String x) {
        this.value = x;
    }

    public int getScore() {
        return this.score;
    }

    /**
     * @param x the point value of the card
     */
    public void setScore(int x) {
        this.score = x;
    }

    public int determineScoreFromFaceValue(String faceValue){
        switch(faceValue) {
            case "K" : return 10;
            case "Q" : return 10;
            case "J" : return 10;
            case "A" : return 11;
            default : return Integer.valueOf(faceValue);
        }
    }

    public String toString(){
        return this.suit + " " + this.value;
    }

}
