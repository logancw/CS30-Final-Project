//                                  CS30 Final Project 
//                                          PIG
//                                  By:  Logan Weisgerber
//                                  Date:  1/20/2024




import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        welcome();
    }

    public static void welcome(){
        Scanner kb = new Scanner(System.in); // Grabs the scanner file

        // STRING  MODULE 01
        System.out.println("Welcome to PIG. Would you like to read the rules, or get started? [1] Get Started [2] Rules"); // Prompts the user if they would like to read the rules or just start playing 
        int selection = kb.nextInt(); // VARIABLE MODULE 01 <- Creates a variable so the user can select an option in the string above
        if(selection == 1 || selection == 2){ // CONDITIONAL MODULE 10
            if(selection == 1){ // if its 1 getStarted() function runs
                getStarted();
            }else if(selection == 2){
                rules(); // if its 2 it displays the rules. 
            }
        }else{
            welcome();
        }
    }

    // This function does the same as teh welcome except it displays the rules
    public static void rules(){
        System.out.println("Rules \n1. You roll only one dice. \n2. If you roll a one you lose all your points for that round. \n3. First to 100 points wins. Player vs Computer");
        System.out.println("Back [1] Exit [2]");
        Scanner kb = new Scanner(System.in);
        int selection = kb.nextInt();
        if(selection == 1 || selection == 2){
            if(selection == 1){
                welcome();
            }
        }else{
            rules();
        }
    }
    // This function grabs the DiceRoller() Class and starts the game.
    public static void getStarted(){
        DiceRoller dr = new DiceRoller();
        dr.rollDice();
    }
}
