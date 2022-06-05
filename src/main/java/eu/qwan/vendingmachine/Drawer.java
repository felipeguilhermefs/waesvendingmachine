package eu.qwan.vendingmachine;

import java.util.Optional;

public class Drawer {
    private final Can can;
    private final int price;

    public Drawer(Can can, int price) {
        this.can = can;
        this.price = price;
    }

    Optional<Can> deliver(Cashier cashier) {
        if (!cashier.checkout(price)) {
            return Optional.empty();
        }
        return Optional.of(can);
    }
}
