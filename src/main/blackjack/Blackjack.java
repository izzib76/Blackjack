package main.blackjack;


import java.util.*;

public class Blackjack {

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        Game game = new Game();

        //TODO: Add UI Elements to make gameplay prettier
        System.out.println("How many people are playing?");
        int players = scan.nextInt();
        // BUG-001
        while (!game.setNumberPlayers(players)){
            players = scan.nextInt();
        }

//        //create the playing deck
//        Deck deck = new Deck();
//
//        //There can only be 4 suits. Lets create list of the 4 suits
//        List<String> suits = Arrays.asList("Hearts", "Clubs", "Spades", "Diamonds");
//
//        //Card values are also duplicated across the suits. Creating lists to store them
//        List<String> cardValues = Arrays.asList("A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K");
//
//        //create the list of cards that needs to go into the deck. There will be 52 total cards
//        List<Card> playingCards = new ArrayList<>();
//        suits.stream().forEach(suit ->
//                cardValues.stream().forEach(cardValue -> playingCards.add(new Card(suit, cardValue))));
//
//        //shuffle and add playing cards to the deck
//        Collections.shuffle(playingCards);
//        deck.setCards(playingCards);
//
//        List<Hand> hands = new ArrayList<>();
//
//        //Deal hands for all players. Each hand should start with two cards.
//        for(int i=0 ; i<numPlayers ; i++){
//            Hand hand = new Hand();
//            hand.setPlayerId(i);
//            hand.setCards(Arrays.asList(deck.getCards().remove(0), deck.getCards().remove(0)));
//            hands.add(hand);
//        }
//        //play game until someone busts
//        boolean bust = false;
//        while(!bust){
//            int standCount = 0;
//            //loop through players and allow them to chose their action.
//            for(int i=0 ; i<numPlayers ; i++){
//                System.out.println("Player " + i + "'s turn:");
//                System.out.println(hands.get(i).toString());
//                System.out.println("What action would you like to take? Stand(S) or Hit(H)?");
//                String action = scan.next();
//                if(action.equalsIgnoreCase("H")){
//                    hands.get(i).addCard(deck.getCards().remove(0));
//                    System.out.println(hands.get(i).toString());
//                    if(hands.get(i).calculatePointValue() > 21){
//                        bust = true;
//                    }
//                }
//                if(action.equalsIgnoreCase("S")){
//                    System.out.println(hands.get(i).toString());
//                    standCount++;
//                    if (standCount == numPlayers) {
//                        bust = true;
//                    }
//                }
//                System.out.println();
//            }
//        }
//        int maxScore = 0, winningPlayer = 10;
//        for(int i=0 ; i<numPlayers ; i++){
//            Hand currentHand = hands.get(i);
//            if(currentHand.calculatePointValue() <= 21 && currentHand.calculatePointValue() > maxScore){
//                maxScore = currentHand.calculatePointValue();
//                winningPlayer = currentHand.getPlayerId();
//            }
//        }




        int winningPlayer = game.playGame();

        //TODO: Add UI Elements to make gameplay prettier
        if(winningPlayer == 10){
            System.out.println("No one won the game.");
        } else {
            System.out.println("The winning player is Player " + winningPlayer);
        }
    }
}
