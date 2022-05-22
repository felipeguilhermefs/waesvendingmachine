package eu.qwan.vendingmachine;

public class CashRegister implements Cashier {
    float credits;

    public CashRegister() {
    }

    public void insert(float amount) {
        credits += amount;
    }

    @Override
    public boolean checkout(float price) {
        if (price > credits) return false;
        credits -= price;
        return true;
    }
}