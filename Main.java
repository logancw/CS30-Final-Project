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
            }else{
                rules();
            }
        }else{
            welcome();
        }
    }

    public static void rules(){}

    public static void getStarted(){}
}
