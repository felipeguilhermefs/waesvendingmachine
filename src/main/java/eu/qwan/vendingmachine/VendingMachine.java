package eu.qwan.vendingmachine;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class VendingMachine {
    private Map<Choice, Can> choices = new HashMap<>();
    private Map<Choice, Float> prices = new HashMap<>();
    private float credits;

    public Optional<Can> deliver(Choice choice) {
        if (!choices.containsKey(choice)) return Optional.empty();
        if (prices.get(choice) > credits) return Optional.empty();
        credits -= prices.get(choice);
        return Optional.of(choices.get(choice));
    }

    public void configureChoice(Choice choice, Can can) {
        configureChoice(choice, can, 0);
    }

    public void configureChoice(Choice choice, Can can, float price) {
        prices.put(choice, price);
        choices.put(choice, can);
    }

    public void insert(float amount) {
        credits += amount;
    }
}
