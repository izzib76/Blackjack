package main.blackjack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    private Game game = new Game();

    @Test
    public void should_return_false_if_more_than_7_players() {
        assertFalse(game.setNumberPlayers(42));
        assertFalse(game.setNumberPlayers(25));
        assertFalse(game.setNumberPlayers(76));
        assertFalse(game.setNumberPlayers(8));
        assertFalse(game.setNumberPlayers(100));
    }

    @Test
    public void should_return_false_if_0_players() {
        assertFalse(game.setNumberPlayers(0));
    }

    @Test
    public void should_return_true_if_less_than_7_players() {
        assertTrue(game.setNumberPlayers(1));
        assertTrue(game.setNumberPlayers(2));
        assertTrue(game.setNumberPlayers(3));
        assertTrue(game.setNumberPlayers(4));
        assertTrue(game.setNumberPlayers(5));
        assertTrue(game.setNumberPlayers(6));
        assertTrue(game.setNumberPlayers(7));
    }

}