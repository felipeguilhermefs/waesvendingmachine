package eu.qwan.vendingmachine;

public interface Cashier {
    boolean checkout(float price);
    boolean checkout(int price);
}
