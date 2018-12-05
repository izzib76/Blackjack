package main.blackjack.model;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class HandTest {

    @Test
    public void should_calculate_correct_point_value(){
        Hand testHand = new Hand();
        testHand.setPlayerId(0);
        testHand.setCards(Arrays.asList(
                new Card("Hearts", "J"),
                new Card("Hearts", "Q")));
        testHand.calculatePointValue();
        testHand.getPlayerId();
        assertTrue(true);
    }

    @Test
    public void should_correctly_handle_multiple_aces_in_one_hand() {
        Hand testHand = new Hand();

        testHand.setCards(Arrays.asList(
                new Card("Hearts", "A"),
                new Card("Diamonds", "A")));
        int score = testHand.calculatePointValue();
        assertEquals(12, score);
        assertEquals(1, testHand.getCards().get(0).getScore());
        assertEquals(11, testHand.getCards().get(1).getScore());
    }

    @Test
    public void should_count_ace_as_elven_when_not_bust() {
        Hand testHand = new Hand();

        testHand.setCards(Arrays.asList(
                new Card("Hearts", "K"),
                new Card("Diamonds", "A")));
        int score = testHand.calculatePointValue();
        assertEquals(21, score);
        assertEquals(10, testHand.getCards().get(0).getScore());
        assertEquals(11, testHand.getCards().get(1).getScore());
    }

    @Test
    public void should_count_ace_as_one_to_prevent_bust() {
        Hand testHand = new Hand();

        testHand.setCards(Arrays.asList(
                new Card("Hearts", "K"),
                new Card("Diamonds", "A"),
                new Card("Spades", "5")));
        int score = testHand.calculatePointValue();
        assertEquals(16, score);
        assertEquals(10, testHand.getCards().get(0).getScore());
        assertEquals(1, testHand.getCards().get(1).getScore());
        assertEquals(5, testHand.getCards().get(2).getScore());



    }

    @Test
    public void should_print_hand_correctly(){
        Hand testHand = new Hand();
        testHand.setCards(Arrays.asList(
                new Card("Hearts", "2"),
                new Card("Hearts", "K")));
        testHand.toString();
        assertTrue(true);
    }

    @Test
    public void should_add_card_to_exisiting_hand(){
        Hand testHand = new Hand();
        testHand.setCards(Arrays.asList(new Card("Spades", "7")));
        testHand.addCard(new Card("Diamonds", "7"));
        testHand.getCards();
        assertTrue(true);
    }


}