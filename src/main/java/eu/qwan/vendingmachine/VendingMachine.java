package eu.qwan.vendingmachine;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class VendingMachine {
    private final CashRegister cashRegister;
    private Map<Choice, Drawer> choices = new HashMap<>();

    public VendingMachine(CashRegister cashRegister) {
        this.cashRegister = cashRegister;
    }

    public Optional<Can> deliver(Choice choice) {
        if (!choices.containsKey(choice)) return Optional.empty();
        return choices.get(choice).deliver(cashRegister);
    }

    public void configureChoice(Choice choice, Can can) {
        configureChoice(choice, can, 0);
    }

    public void configureChoice(Choice choice, Can can, float price) {
        choices.put(choice, new Drawer(can, price));
    }

    public void insert(int amount) {
        cashRegister.insert(amount);
    }
}
