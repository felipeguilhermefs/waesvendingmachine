package eu.qwan.vendingmachine;

import java.util.Optional;

public class Drawer {
    private final Can can;
    private final float price;

    public Drawer(Can can, float price) {
        this.can = can;
        this.price = price;
    }

    Optional<Can> deliver(Cashier cashier) {
        if (!cashier.checkout((int) (price * 100))) {
            return Optional.empty();
        }
        return Optional.of(can);
    }
}
