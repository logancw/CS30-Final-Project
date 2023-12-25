import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        welcome();
    }

    public static void welcome(){
        Scanner kb = new Scanner(System.in);


        System.out.println("Welcome to PIG. Would you like to read the rules, or get started? [1] Get Started [2] Rules");
        int selection = kb.nextInt();
        if(selection == 1 || selection == 2){
            if(selection == 1){
                getStarted();
            }else if(selection == 2){
                rules();
            }
        }else{
            welcome();
        }
    }

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

    public static void getStarted(){
        DiceRoller dr = new DiceRoller();
        dr.rollDice();
    }
}
