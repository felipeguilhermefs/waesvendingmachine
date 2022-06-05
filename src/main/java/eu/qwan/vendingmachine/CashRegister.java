package eu.qwan.vendingmachine;

public class CashRegister implements Cashier {
    float credits;

    public CashRegister() {
    }

    public void insert(int amount) {
        var cents = (float) amount;
        credits += cents / 100.0f;
    }

    @Override
    public boolean checkout(float price) {
        if (price > credits) return false;
        credits -= price;
        return true;
    }

    @Override
    public boolean checkout(int price) {
        var cents = (float) price;
        return checkout(cents / 100.0f);
    }
}