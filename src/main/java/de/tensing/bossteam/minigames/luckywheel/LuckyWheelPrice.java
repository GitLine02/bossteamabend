package de.tensing.bossteam.minigames.luckywheel;

public enum LuckyWheelPrice {
    TEST("TEST");
    // TODO: implement prices

    private final String price;

    LuckyWheelPrice(String price) {
        this.price = price;
    }

    public String getPrice() {
        return price;
    }
}
