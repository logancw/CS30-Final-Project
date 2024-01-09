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
                results();
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

        if (dice == 1) {
            total = 0;
            try {
                System.out.println("Computer has rolled a 1");
                System.out.println("Computer has lost all points for this round...");
                Thread.sleep(2000);
                results();
            } catch (InterruptedException e) {
                System.out.println("Error");
            }
        } else {
            total += dice;
            System.out.println("Computer rolled a " + dice);
            if (total < 6) {
                System.out.println("Computer has chosen to continue...");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    System.out.println("Error");
                }
                compDice();
            } else {
                scoresC.add(total);
                System.out.println("Computer has stopped rolling.");
                try {
                    Thread.sleep(2000);
                    results();
                } catch (InterruptedException e) {
                    System.out.println("Error");
                }
                results();
                total = 0;
            }
        }
    }

    public void results() {
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

}
