package eu.qwan.vendingmachine;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class VendingMachine {
    private Map<Choice, Can> choices = new HashMap<>();
    private float price;
    private float credits;

    public Optional<Can> deliver(Choice choice) {
        if (!choices.containsKey(choice)) return Optional.empty();
        if (price != credits) return Optional.empty();
        return Optional.of(choices.get(choice));
    }

    public void configureChoice(Choice choice, Can can) {
        configureChoice(choice, can, 0);
    }

    public void configureChoice(Choice choice, Can can, float price) {
        this.price = price;
        choices.put(choice, can);
    }

    public void insert(float amount) {
        credits = amount;
    }
}
