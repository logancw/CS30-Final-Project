import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DiceRoller {
    int total = 0; 
    List<Integer> scoresP = new ArrayList<Integer>();
    List<Integer> scoresC = new ArrayList<Integer>();
    public void rollDice(){
    
        double ddice = Math.random() * 7;
        int dice = (int) ddice;

        if(ddice == 0){
            // Add Later; 
        }

        System.out.println("You rolled a " + dice);

        if(dice == 1){
            System.out.println("You lose all your points for this round.");
            total = 0;
            System.out.println("Your total is " + total);

        }else{
            total += dice; 
            System.out.println("Your total is " + total);
            System.out.println("Would you like to roll again? [1] Yes [2] No");
            Scanner kb = new Scanner(System.in);
            int selection = kb.nextInt();
            if(selection == 1){
                rollDice();
            }else{
                scoresP.add(total);
                total = 0;
                results();
            }
        }
    
    }

    public void results(){
        System.out.println("Player scores are: ");
        for(int i = 0; i < scoresP.size(); i++){
            System.out.println(scoresP.get(i));
        }
        System.out.println("Computer scores are: ");
        for(int i = 0; i < scoresC.size(); i++){
            System.out.println(scoresC.get(i));
        }
    }

}
