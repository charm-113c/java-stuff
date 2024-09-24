package practice.vendingMachine;
/**
 * The goal of this exercise is to simulate a vending machine. 
 * Specifications require the creation of a class Items with three types of items:
 * WaterBottle, ChocolateBar, and ChewingGum
 * We are then asked to create a class VendingMachine constructed with an int N 
 * which dictates the number of items it will contain, with the following methods:
 * load() which randomly loads N items within the class
 * insertMoney() to allow users to insert a sum of money in the machine
 * getItem() which, given a number, outputs the corresponding item to the user
 * and decreases the money and number of that item
 * getBalance() which outputs the remaining available balance of user
 * getRest() which zeroes the balance and gives the rest to user 
 */
public enum Items {
    WATERBOTTLE(1, 0, 0.5), CHOCOLATEBAR(2, 0, 1.0), CHEWINGGUM(3, 0,0.75);

    private int id;
    public int number;
    public double price;

    Items(int id, int number, double price) {
        this.id = id;
        this.number = number;
        this.price = price;
    }

    public int getState() {
        /**
         * Return reamining number of items
         */
        return this.number;
    }

    public int getId() { return this.id; }

    public void increaseItem(int k) { this.number += k; }

    /*
    * Allow user to buy only one item at a time
     */
    public void decreaseItem() { this.number--; }

    public void changePrice(double newPrice) { this.price = newPrice; }
}
