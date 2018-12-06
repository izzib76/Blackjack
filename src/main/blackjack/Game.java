package main.blackjack;

import main.blackjack.model.Card;
import main.blackjack.model.Deck;
import main.blackjack.model.Hand;

import java.util.*;

public class Game {

    public int playGame(int numPlayers) {
        Scanner scan = new Scanner(System.in);

        Deck deck = createAndShuffleDeck();

        List<Hand> hands = dealHandsToPlayers(numPlayers, deck);
        //play game until someone busts
        boolean bust = false;
        while(!bust){
            bust = takePlayerTurns(numPlayers, scan, deck, hands, bust);
        }
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

    private boolean takePlayerTurns(int numPlayers, Scanner scan, Deck deck, List<Hand> hands, boolean bust) {
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
        return bust;
    }

    private List<Hand> dealHandsToPlayers(int numPlayers, Deck deck) {
        List<Hand> hands = new ArrayList<>();

        //Deal hands for all players. Each hand should start with two cards.
        for(int i=0 ; i<numPlayers ; i++){
            Hand hand = new Hand();
            hand.setPlayerId(i);
            hand.setCards(Arrays.asList(deck.getCards().remove(0), deck.getCards().remove(0)));
            hands.add(hand);
        }
        return hands;
    }

    private Deck createAndShuffleDeck() {
        Deck deck = new Deck();

        List<String> suits = Arrays.asList("Hearts", "Clubs", "Spades", "Diamonds");

        List<String> cardValues = Arrays.asList("A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K");

        List<Card> playingCards = new ArrayList<>();
        suits.stream().forEach(suit ->
                cardValues.stream().forEach(cardValue -> playingCards.add(new Card(suit, cardValue))));

        Collections.shuffle(playingCards);
        deck.setCards(playingCards);
        return deck;
    }
}
