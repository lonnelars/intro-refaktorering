package no.kantega;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PubPricesTest {

    @Test
    public void oneBeerTest() {
        Optional<Integer> actualPrice = Pub.createOrder(Drink.BEER, 1).map(Pub::computeCost);
        assertEquals(Optional.of(74), actualPrice);
    }

    @Test
    public void testStudentsGetADiscountForBeer() {
        Optional<Integer> actualPrice = Pub.createOrder(Drink.BEER, 1)
                .map(Pub::computeStudentCost);
        assertEquals(Optional.of(67), actualPrice);
    }

    @Test
    public void testCidersAreCostly() {
        Optional<Integer> actualPrice = Pub.createOrder(Drink.CIDER, 1).map(Pub::computeCost);
        assertEquals(Optional.of(103), actualPrice);
    }

    @Test
    public void testProperCidersAreEvenMoreExpensive() {
        Optional<Integer> actualPrice = Pub.createOrder(Drink.PROPER_CIDER, 1).map(Pub::computeCost);
        assertEquals(Optional.of(110), actualPrice);
    }

    @Test
    public void testACocktail() {
        Optional<Integer> actualPrice = Pub.createOrder(Drink.GT, 1).map(Pub::computeCost);
        assertEquals(Optional.of(115), actualPrice);
    }

    @Test
    public void testStudentsDoNotGetDiscountsForCocktails() {
        Optional<Integer> actualPrice = Pub.createOrder(Drink.GT, 1).map(Pub::computeStudentCost);
        assertEquals(Optional.of(115), actualPrice);
    }

    @Test
    public void testBacardiSpecial() {
        Optional<Integer> actualPrice = Pub.createOrder(Drink.BACARDI_SPECIAL, 1).map(Pub::computeCost);
        assertEquals(Optional.of(127), actualPrice);
    }

    @Test
    public void testCanBuyAtMostTwoDrinksInOneGo() {
        assertEquals(Pub.createOrder(Drink.BACARDI_SPECIAL, 3), Optional.empty());
    }

    @Test
    public void testStudentsGetDiscountsWhenOrderingMoreThanOneBeer() {
        Optional<Integer> actualPrice = Pub.createOrder(Drink.BEER, 2).map(Pub::computeStudentCost);
        assertEquals(Optional.of(67 * 2), actualPrice);
    }

    @Test
    public void testCanOrderMoreThanTwoBeers() {
        assertTrue(Pub.createOrder(Drink.BEER, 5).isPresent());
    }
}
