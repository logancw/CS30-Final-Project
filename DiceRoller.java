import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DiceRoller {
    int round = 1;
    int total = 0;
    List<Integer> scoresP = new ArrayList<Integer>();
    List<Integer> scoresC = new ArrayList<Integer>();

    public void rollDice() {

        double ddice = Math.random() * 7;
        int dice = (int) ddice;

        if (dice == 0) {
            dice = 1;
        }

        System.out.println("You rolled a " + dice);

        if (dice == 1) {
            System.out.println("You lose all your points for this round.");
            compDice();

        } else {
            total += dice;
            System.out.println("Your total is " + total);
            System.out.println("Would you like to roll again? [1] Yes [2] No");
            Scanner kb = new Scanner(System.in);
            int selection = kb.nextInt();
            if (selection == 1) {
                rollDice();
            } else {
                scoresP.add(total);
                total = 0;
                compDice();
            }
        }

    }

    public void compDice() {
        // DICE
        double ddice = Math.random() * 7;
        int dice = (int) ddice;

        if (dice == 0) {
            dice = 1;
        }

        if(dice == 1){
            total = 0;
            System.out.println("Computer lost all points for this round.");
            results();
        }else{
            total += dice;
            System.out.println("Computer rolled a " + dice);
            if(total < 6){
                compDice();
            }else{
                System.out.println("Computer's total is " + total);
                scoresC.add(total);
                total = 0;
                results();
            }
        }
        
    }

    public void results() {

        // scoresP.add(100);

        int csum = 0;
        int psum = 0;
        for (int i = 0; i < scoresP.size(); i++) {
            psum += scoresP.get(i);
        }

        for (int i = 0; i < scoresC.size(); i++) {
            csum += scoresC.get(i);
        }

        try {
            System.out.println("Player score is " + psum);
            Thread.sleep(2000);
            System.out.println("Computer score is " + csum);
            Thread.sleep(2000);
            if (psum >= 100 || csum >= 100) {
                if(psum >= 100){
                    System.out.println("Congratulations! You have won the game!");
                }else{
                    System.out.println("Computer has won the game!");
                }
            } else {
                round++;
                System.out.println("Round " + round + " is starting...");
                Thread.sleep(2000);
                rollDice();
            }
        } catch (InterruptedException e) {
            System.out.println("Error");
        }

    }


    public void playAgain(){
        System.out.println("Would you like to play again? [1] Yes [2] No");
        Scanner kb = new Scanner(System.in);
        int selection = kb.nextInt();
        if(selection == 1){
            round = 1;
            total = 0;
            scoresP.clear();
            scoresC.clear();
            rollDice();
        }else{
            System.out.println("Thanks for playing!");
        }
    }

}
