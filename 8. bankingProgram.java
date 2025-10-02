// @author - el
// DISCLAIMER !
// Kode ini hanyalah implementasi konsep dasar 

import java.util.Scanner;

public class bankingProgram {
    static Scanner in = new Scanner(System.in);
    public static void main(String[] args){
//!!! Java Simple Banking app (Methods Exercise)

//   Declare Variables
        double amount;
        double balance = 0;
        boolean isRunning = true;
        String[] menu = {"menu 1", "menu 2", "menu 2"};


        int[] arr = new int[3] ;
        System.out.println();
        System.out.println(arr.length);

//   Display menu
        while (isRunning){
            System.out.println("******************");
            System.out.println("BANKING PROGRAM");
            System.out.println("******************");
            System.out.println("1. Show Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.println("******************");
            System.out.print("Enter your choice (1-4): ");
//   Get user Choice
        int choice = in.nextInt();

        switch (choice){
            case 1-> showBalance(balance);
            case 2-> balance += deposit();
            case 3-> balance -= withdraw(balance);
            case 4-> isRunning = false;
            default -> System.out.println("Invalid Choice!");
         }
        }
    }

        static void showBalance(double balance){
            System.out.printf("$%.2f %n",balance);
        }
        static double deposit(){
            double amount = 0;
            System.out.println("Enter the deposit value: ");
            amount = in.nextDouble();
            if(amount < 0){
                System.out.println("Deposit amount cant be negative! ");
                return 0;
            }else{
                return amount;
            }
        }
        static double withdraw(double balance){
            double amount;
            System.out.print("Input the amount to be withdrawn: ");
            amount = in.nextDouble();
            if(amount > balance){
                System.out.println("INSUFFICIENT FUNDS");
                return 0;
            } else if (amount < 0) {
                System.out.println("Amount can't be negative");
                return 0;
            }else {
                return amount;
            }

        }
}
