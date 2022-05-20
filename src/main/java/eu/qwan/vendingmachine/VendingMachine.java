package eu.qwan.vendingmachine;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class VendingMachine {
    private Map<Choice, Drawer> choices = new HashMap<>();
    private float credits;

    public Optional<Can> deliver(Choice choice) {
        if (!choices.containsKey(choice)) return Optional.empty();
        Drawer drawer = choices.get(choice);
        if (drawer.price > credits) return Optional.empty();
        credits -= drawer.price;
        return Optional.of(drawer.can);
    }

    public void configureChoice(Choice choice, Can can) {
        configureChoice(choice, can, 0);
    }

    public void configureChoice(Choice choice, Can can, float price) {
        choices.put(choice, new Drawer(can, price));
    }

    public void insert(float amount) {
        credits += amount;
    }
}
