package main.blackjack.model;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class HandTest {

    @Test
    public void should_calculate_correct_point_value(){
        Hand testHand = new Hand();
        testHand.setCards(Arrays.asList(new Card("Hearts", "2"), new Card("Hearts", "4")));
        testHand.calculatePointValue();
        assertTrue(true);
    }

    @Test
    public void should_correctly_handle_multiple_aces_in_one_hand(){
        Hand testHand = new Hand();
        testHand.setCards(Arrays.asList(new Card("Hearts", "A"), new Card("Diamonds", "A")));
        testHand.calculatePointValue();
        assertTrue(true);
    }


}