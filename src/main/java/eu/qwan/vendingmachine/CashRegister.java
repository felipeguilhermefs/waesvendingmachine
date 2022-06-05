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
    public boolean checkout(int price) {
        var cents = (float) price;
        var cost = cents / 100.0f;
        if (cost > credits) return false;
        credits -= cost;
        return true;
    }
}