package no.kantega;

public enum Drink {
    BEER(74), CIDER(103), PROPER_CIDER(110), GT(115), BACARDI_SPECIAL(127);

    final int price;

    Drink(int price) {
        this.price = price;
    }
}
