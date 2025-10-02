// @author - el
// DISCLAIMER !
// Kode ini hanyalah implementasi konsep dasar 

import java.util.Random;
import java.util.Scanner;

public class diceRolling {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        Random random = new Random();
        int numOfDice;
        int total = 0;

        System.out.print("Enter how many dice did u want to roll: ");
        numOfDice = in.nextInt();
        if(numOfDice > 0){
            for(int i= 0; i< numOfDice; i++){
                int roll =random.nextInt(1,7);
                System.out.println("You rolled: "+roll);
                total += roll;
              printDice(roll);
            }
            System.out.println("Total: " + total);
        }else{
            System.out.println("The # of dice can't be negative number!");
        }
    }
    static void printDice(int roll){
        String dice1 = """
                ------------
                |          |
                |          |
                |     ●    |
                |          |
                |          |
                ------------
                
                """;
        String dice2 = """
                ------------
                | ●        |
                |          |
                |          |
                |          |
                |         ●|
                ------------
                
                """;
        String dice3 = """
                ------------
                |●         |
                |          |
                |     ●    |
                |          |
                |         ●|
                ------------
                
                """;
        String dice4 = """
                ------------
                |●        ●|
                |          |
                |          |
                |          |
                |●        ●|
                ------------
                
                """;
        String dice5 = """
                ------------
                |●        ●|
                |          |
                |     ●    |
                |          |
                |●        ●|
                ------------
                
                """;
        String dice6 = """
                ------------
                |●        ●|
                |          |
                |●        ●|
                |          |
                |●        ●|
                ------------
                
                """;

        switch (roll){
            case 1 -> System.out.println(dice1);
            case 2 -> System.out.println(dice2);
            case 3 -> System.out.println(dice3);
            case 4 -> System.out.println(dice4);
            case 5 -> System.out.println(dice5);
            case 6 -> System.out.println(dice6);
            default -> System.out.println("Invalid choice.");



        }
    }
}
