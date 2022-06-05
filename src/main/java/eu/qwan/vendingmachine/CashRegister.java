package eu.qwan.vendingmachine;

public class CashRegister implements Cashier {
    float credits;

    public CashRegister() {
    }

    public void insert(float amount) {
        credits += amount;
    }

    public void insert(int amount) {
        var cents = (float) amount;
        insert(cents / 100.0f);
    }

    @Override
    public boolean checkout(float price) {
        if (price > credits) return false;
        credits -= price;
        return true;
    }
}