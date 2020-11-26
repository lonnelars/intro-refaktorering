package no.kantega;

import java.util.Optional;

public final class Pub {

    public static Optional<Order> createOrder(Drink drink, int numberOfDrinks) {
        if (numberOfDrinks > 2 && hasRestrictions(drink)) {
            return Optional.empty();
        } else {
            return Optional.of(new Order(drink, numberOfDrinks));
        }
    }

    private static boolean hasRestrictions(Drink drink) {
        return drink == Drink.GT || drink == Drink.BACARDI_SPECIAL;
    }

    public static int computeCost(Order order) {
        return order.drink.price * order.numberOfDrinks;
    }

    public static int computeStudentCost(Order order) {
        final int discount = qualifiesForDiscount(order.drink)
                ? order.drink.price / 10
                : 0;
        return (order.drink.price - discount) * order.numberOfDrinks;
    }

    private static boolean qualifiesForDiscount(Drink drink) {
        return drink == Drink.CIDER || drink == Drink.BEER || drink == Drink.PROPER_CIDER;
    }

    static class Order {
        final Drink drink;
        final int numberOfDrinks;

        private Order(Drink drink, int numberOfDrinks) {
            this.drink = drink;
            this.numberOfDrinks = numberOfDrinks;
        }
    }
}
