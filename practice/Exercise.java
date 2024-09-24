package practice;

import practice.vendingMachine.VendingMachine; 

public class Exercise {
    /**
     * This is the main function of the exercise, everything else will run inside it
     * As such, make subpackages if necessary
     */
    public static void main(String[] args) {
        System.out.println("Beggining exercises");
        VendingMachine vm1 = new VendingMachine();
        vm1.load(2);
        System.out.println(vm1.getState());
        vm1.insertMoney(5.0);
        vm1.getItem(2);
        vm1.getItem(3);
        vm1.getItem(1);
        System.out.println(vm1.getState());
        System.out.println(vm1.getBalance());
        System.out.println(vm1.getRest());
    }
}
