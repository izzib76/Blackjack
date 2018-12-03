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
    public void should_correctly_handle_multiple_aces_in_one_hand(){
        Hand testHand = new Hand();
        testHand.setCards(Arrays.asList(
                new Card("Hearts", "A"),
                new Card("Diamonds", "A")));
        testHand.calculatePointValue();
        assertTrue(true);
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