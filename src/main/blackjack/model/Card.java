package main.blackjack.model;

public class Card {
    private String suit;
    private String value;
    private int number;

//    /**
//     * @param s suit
//     * @param v face value
//     * @param n point number
//     */
//    public Card(String s, String v, int n) {
//        this.suit = s;
//        this.value = v;
//        this.number = n;
//    }

    /**
     * @param x suit
     * @param y face value
     */
    public Card(String x, String y) {
        this.suit = x;
        this.value = y;
        this.number = determinePointValueFromFaceValue(y);
    }

    /**
     * @return the suit of the card
     */
    public String getSuit() {
        return this.suit;
    }

    /**
     * @param x a string representing the suit of the card
     */
    public void setSuit(String x) {
        this.suit = x;
    }

    /**
     * @return the face value of the card
     */
    public String getValue() {
        return this.value;
    }

    /**
     * @param x the face value of the card
     */
    public void setValue(String x) {
        this.value = x;
    }

    /**
     * @return the point value of the card
     */
    public int getNumber() {
        return this.number;
    }

    /**
     * @param x the point value of the card
     */
    public void setNumber(int x) {
        this.number = x;
    }

    public int determinePointValueFromFaceValue(String faceValue){
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
