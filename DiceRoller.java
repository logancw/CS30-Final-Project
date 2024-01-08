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
            compDice();

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
                compDice();
            }
        }
    
    }


    public void compDice(){
                // DICE
                double ddice = Math.random() * 7;
                int dice = (int) ddice;


                if(dice == 0){

                }

                if(dice == 1){
                     System.out.println("Computer has lost all points for this round.");
                     total = 0;
                }else{
                    total += dice; 
                    System.out.println("Computer rolled a " + dice);
                    if(total < 6){
                        System.out.println("Computer has chosen to continue...");
                        compDice();
                    }else{
                        scoresC.add(total);
                        System.out.println("Computer has stopped rolling.");
                        results();
                        total = 0;
                    }
                }
    }

    public void results(){
        int csum = 0;
        int psum = 0;
        for(int i = 0; i < scoresP.size(); i++){
            psum += scoresP.get(i);
        }

        for(int i = 0; i < scoresC.size(); i++){
           csum += scoresC.get(i);
        }

        System.out.println("Player score is " + psum);
        System.out.println("Computer score is " + csum);
    }

}
