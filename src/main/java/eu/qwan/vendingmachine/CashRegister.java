package eu.qwan.vendingmachine;

public class CashRegister implements Cashier {
    int credits;

    public CashRegister() {
    }

    public void insert(int amount) {
        credits += amount;
    }

    @Override
    public boolean checkout(int price) {
        if (price > credits) return false;
        credits -= price;
        return true;
    }
}