package main.blackjack;

import main.blackjack.model.Card;
import main.blackjack.model.Deck;
import main.blackjack.model.Hand;

import java.util.*;

public class Blackjack {

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        System.out.println("How many people are playing?");
        int numPlayers = scan.nextInt();
        while (numPlayers > 7){
            System.out.println("There can only be a max of 7 players. Please re-enter number playing");
            numPlayers = scan.nextInt();
        }



        Game game = new Game();

        int winningPlayer = game.playGame(numPlayers);

        System.out.println("The winning player is Player " + winningPlayer);
    }
}
