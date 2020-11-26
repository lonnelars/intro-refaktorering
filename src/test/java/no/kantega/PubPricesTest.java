package no.kantega;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PubPricesTest {

    @DisplayName("prices spec")
    @Nested
    class Prices {
        @Test
        @DisplayName("when we order a beer, the price is 74")
        public void oneBeerTest() {
            Optional<Integer> actualPrice = Pub.createOrder(Drink.BEER, 1).map(Pub::computeCost);
            assertEquals(Optional.of(74), actualPrice);
        }

        @Test
        @DisplayName("when we order a cider, the price is 103")
        public void testCidersAreCostly() {
            Optional<Integer> actualPrice = Pub.createOrder(Drink.CIDER, 1).map(Pub::computeCost);
            assertEquals(Optional.of(103), actualPrice);
        }

        @Test
        @DisplayName("when we order a proper cider, the price is 110")
        public void testProperCidersAreEvenMoreExpensive() {
            Optional<Integer> actualPrice = Pub.createOrder(Drink.PROPER_CIDER, 1).map(Pub::computeCost);
            assertEquals(Optional.of(110), actualPrice);
        }

        @Test
        @DisplayName("when we order a cocktail, the price is 115")
        public void testACocktail() {
            Optional<Integer> actualPrice = Pub.createOrder(Drink.GT, 1).map(Pub::computeCost);
            assertEquals(Optional.of(115), actualPrice);
        }

        @Test
        @DisplayName("when we order a bacardi special, the price is 127")
        public void testBacardiSpecial() {
            Optional<Integer> actualPrice = Pub.createOrder(Drink.BACARDI_SPECIAL, 1).map(Pub::computeCost);
            assertEquals(Optional.of(127), actualPrice);
        }

    }
    @DisplayName("discounts spec")
    @Nested
    class Discounts {

        @Test
        @DisplayName("when students order beer, then they get a discount")
        public void testStudentsGetADiscountForBeer() {
            Optional<Integer> actualPrice = Pub.createOrder(Drink.BEER, 1)
                    .map(Pub::computeStudentCost);
            assertEquals(Optional.of(67), actualPrice);
        }

        @Test
        @DisplayName("when students order cocktails, then they do not get a discount")
        public void testStudentsDoNotGetDiscountsForCocktails() {
            Optional<Integer> actualPrice = Pub.createOrder(Drink.GT, 1).map(Pub::computeStudentCost);
            assertEquals(Optional.of(115), actualPrice);
        }

        @Test
        public void testStudentsGetDiscountsWhenOrderingMoreThanOneBeer() {
            Optional<Integer> actualPrice = Pub.createOrder(Drink.BEER, 2).map(Pub::computeStudentCost);
            assertEquals(Optional.of(67 * 2), actualPrice);
        }
    }

    @DisplayName("ordering multiple drinks spec")
    @Nested
    class MultipleDrinks {
        @Test
        @DisplayName("when ordering more than two cocktails, then the order is refused")
        public void testCanBuyAtMostTwoDrinksInOneGo() {
            assertEquals(Pub.createOrder(Drink.BACARDI_SPECIAL, 3), Optional.empty());
        }

        @Test
        @DisplayName("when ordering more than two beers, then the order is accepted")
        public void testCanOrderMoreThanTwoBeers() {
            assertTrue(Pub.createOrder(Drink.BEER, 5).isPresent());
        }
    }
}
