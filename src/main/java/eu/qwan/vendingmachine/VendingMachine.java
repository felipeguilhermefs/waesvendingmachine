package eu.qwan.vendingmachine;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class VendingMachine {
    private Map<Choice, Can> choices = new HashMap<>();

    public Optional<Can> deliver(Choice choice) {
        if (!choices.containsKey(choice)) return Optional.empty();
        return Optional.of(choices.get(choice));
    }

    public void configureChoice(Choice choice, Can can) {
        choices.put(choice, can);
    }
}
