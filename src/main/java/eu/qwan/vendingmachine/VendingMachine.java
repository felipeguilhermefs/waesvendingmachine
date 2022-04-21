package eu.qwan.vendingmachine;

import java.util.Optional;

public class VendingMachine {
    private Optional<Can> canToDeliver = Optional.empty();

    public Optional<Can> deliver(Choice choice) {
        return canToDeliver;
    }

    public void configureChoice(Choice choice, Can can) {
        canToDeliver = Optional.of(can);
    }
}
