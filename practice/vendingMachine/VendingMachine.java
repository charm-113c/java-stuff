package practice.vendingMachine;

import java.util.Random;

public class VendingMachine {
    public Random random = new Random();
    public int N; 
    public double money;

    public VendingMachine() {
        System.out.println("The following items are available through their ID:");
        System.out.println("Water bottles, ID: "+ Items.WATERBOTTLE.getId());
        System.out.println("Chocolate bars, ID: "+ Items.CHOCOLATEBAR.getId());
        System.out.println("Chewing gums, ID: "+ Items.CHEWINGGUM.getId());
    }

    public void load(int N) {
        if (N<1) {
            System.out.println("Insert 1 or more items");
            return;
        }
        /**
         * To randomly generate N items, we generate two ints
         */
        int nWater = random.nextInt(N);
        int nChocoBars = random.nextInt(N - nWater);
        // so nChewinGums will be the rest

        Items.WATERBOTTLE.increaseItem(nWater);
        Items.CHOCOLATEBAR.increaseItem(nChocoBars);
        Items.CHEWINGGUM.increaseItem(N - nWater - nChocoBars);

        // money = 1.0;
    }

    public void insertMoney(double cash) {
        this.money += cash;
    }

    public void getItem(int id) {
        switch (id) {
            case 1:
                if (Items.WATERBOTTLE.getState() < 1) {
                    System.out.println("Sorry, no water bottles left");
                    break;
                }
                Items.WATERBOTTLE.decreaseItem();
                this.money -= Items.WATERBOTTLE.price;
                System.out.println("Here's your water bottle");
                break;

            case 2:
                if (Items.CHOCOLATEBAR.getState() < 1) {
                    System.out.println("Sorry, no chocolate bars left");
                    break;
                }
                Items.CHOCOLATEBAR.decreaseItem();
                this.money -= Items.CHOCOLATEBAR.price;
                System.out.println("Here's your chocolate bar");
                break;

            case 3:
                if (Items.CHEWINGGUM.getState() < 1) {
                    System.out.println("Sorry, no chewing gum left");
                    break;
                }
                Items.CHEWINGGUM.decreaseItem();
                this.money -= Items.CHEWINGGUM.price;
                System.out.println("Here's your chewing gum");
                break;
        
            default:
                System.out.println("There is no product with this ID");
                break;
        }
    }

    public double getBalance() {
        return this.money;
    }

    public double getRest() {
        double rest = this.money;
        this.money = 0;
        return rest; 
    }

    public String getState() {
        String s1 = "No. water bottles:" + Items.WATERBOTTLE.getState();
        String s2 = "\nNo. chocolate bars:" + Items.CHOCOLATEBAR.getState();
        String s3 = "\nNo. chewing gums:" + Items.CHEWINGGUM.getState();
        return s1 + s2 + s3;
    }
}
