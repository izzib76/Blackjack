package main.blackjack;


import java.util.*;

public class Blackjack {

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        Game game = new Game();

        System.out.println("How many people are playing?");
        int players = scan.nextInt();
        while (!game.setNumberPlayers(players)){
            players = scan.nextInt();
        }


        int winningPlayer = game.playGame();

        System.out.println("The winning player is Player " + winningPlayer);
    }
}
