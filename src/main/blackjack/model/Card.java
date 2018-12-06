package main.blackjack.model;

public class Card {
    private String suit;
    private String value;
    private int score;

    public Card(String suit, String faceValue) {
        this.suit = suit;
        this.value = faceValue;
        this.score = determineScoreFromFaceValue(faceValue);
    }

    public String getSuit() {
        return this.suit;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String faceValue) {
        this.value = faceValue;
    }

    public int getScore() {
        return this.score;
    }

    public void setScore(int score) {
        this.score = score;
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
