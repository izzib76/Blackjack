package main.blackjack;

import main.blackjack.model.Card;
import main.blackjack.model.Deck;
import main.blackjack.model.Hand;

import java.util.*;

public class Game {

    private int numPlayers;

    public boolean setNumberPlayers(int numPlayers){
        if (numPlayers > 7 ){
            System.out.println("There can only be a max of 7 players. Please re-enter number playing");
            return false;
        } else if (numPlayers == 0){
            System.out.println("A minimum of one player is needed. Please re-enter number playing");
            return false;
        }
        else {
            this.numPlayers = numPlayers;
            return true;
        }
    }

    public int playGame() {
        Scanner scan = new Scanner(System.in);

        //create the playing deck
        Deck deck = new Deck();
        setUpDeck(deck);

        List<Hand> hands = dealHands(deck);
        //play game until someone busts
        boolean bust = false;
        takeTurns(scan, deck, hands, bust);
        int maxScore = 0, winningPlayer = 10;
        for(int i=0 ; i<numPlayers ; i++){
            Hand currentHand = hands.get(i);
            if(currentHand.calculatePointValue() <= 21 && currentHand.calculatePointValue() > maxScore){
                maxScore = currentHand.calculatePointValue();
                winningPlayer = currentHand.getPlayerId();
            }
        }

        return winningPlayer;
    }

    private void takeTurns(Scanner scan, Deck deck, List<Hand> hands, boolean bust) {
        while(!bust){
            int standCount = 0;
            //loop through players and allow them to chose their action.
            for(int i=0 ; i<numPlayers ; i++){
                System.out.println("Player " + i + "'s turn:");
                System.out.println(hands.get(i).toString());
                System.out.println("What action would you like to take? Stand(S) or Hit(H)?");
                String action = scan.next();
                if(action.equalsIgnoreCase("H")){
                    hands.get(i).addCard(deck.getCards().remove(0));
                    System.out.println(hands.get(i).toString());
                    if(hands.get(i).calculatePointValue() > 21){
                        bust = true;
                    }
                }
                if(action.equalsIgnoreCase("S")){
                    System.out.println(hands.get(i).toString());
                    standCount++;
                    if (standCount == numPlayers) {
                        bust = true;
                    }
                }
                System.out.println();
            }
        }
    }

    private List<Hand> dealHands(Deck deck) {
        List<Hand> hands = new ArrayList<>();

        for(int i=0 ; i<numPlayers ; i++){
            Hand hand = new Hand();
            hand.setPlayerId(i);
            hand.setCards(Arrays.asList(deck.getCards().remove(0), deck.getCards().remove(0)));
            hands.add(hand);
        }
        return hands;
    }

    private void setUpDeck(Deck deck) {
        List<String> suits = Arrays.asList("Hearts", "Clubs", "Spades", "Diamonds");

        List<String> cardValues = Arrays.asList("A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K");

        List<Card> playingCards = new ArrayList<>();
        suits.stream().forEach(suit ->
                cardValues.stream().forEach(cardValue -> playingCards.add(new Card(suit, cardValue))));

        Collections.shuffle(playingCards);
        deck.setCards(playingCards);
    }
}
