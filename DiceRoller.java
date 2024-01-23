import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DiceRoller {
    int round = 1; // Int var to see what round is being played
    int total = 0; // The total the user / computer has collected in one round.
    List<Integer> scoresP = new ArrayList<Integer>(); // These two ArrayLists are used to store the scores for the player and computer
    List<Integer> scoresC = new ArrayList<Integer>();

    public void rollDice() {

        double ddice = Math.random() * 7; // Random creates a double (4.5) which is a decimal number 
        int dice = (int) ddice; // So we cast it as an int so we can get a whole number

        if (dice == 0) {
            dice = 1;
        }

        System.out.println("You rolled a " + dice); // Displays what the user rolled 

        if (dice == 1) {
            System.out.println("You lose all your points for this round."); // If the user rolls a 1 they lose all their points for that round
            compDice(); // Moves on to the computers turn

        } else {
            total += dice;
            System.out.println("Your total is " + total); // Displays the total the user has collected so far
            System.out.println("Would you like to roll again? [1] Yes [2] No"); // Asks user if they would like to keep gambling their points or keep what they have. 
            Scanner kb = new Scanner(System.in);
            int selection = kb.nextInt();
            if (selection == 1) {
                rollDice();
            } else {
                scoresP.add(total); // Adds the total to the ArrayList
                total = 0;
                compDice(); // Runs the computer
            }
        }

    }

    // This function is the same as the player but adds more Random variables to allow the computer to choose how they want to play. 
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

    // Results displays how many points computer and the player has after each round 
    public void results() {


        int csum = 0;
        int psum = 0;
        // A for loop is used to add up all the scores in the ArrayLists into one variable called psum or csum meaning computer sum or player sum
        for (int i = 0; i < scoresP.size(); i++) {
            psum += scoresP.get(i);
        }

        for (int i = 0; i < scoresC.size(); i++) {
            csum += scoresC.get(i);
        }

        try {
            System.out.println("Player score is " + psum);
            Thread.sleep(2000); // Thread.Sleep() allows a wait time inbetween each message being sent about scores. 
            System.out.println("Computer score is " + csum);
            Thread.sleep(2000);
            if (psum >= 100 || csum >= 100) { // Checks what player is over 100 points
                if(psum >= 100){ // if player wins
                    System.out.println("Congratulations! You have won the game!");
                    playAgain();
                }else{ // computer wins
                    System.out.println("Computer has won the game!");
                    playAgain();
                } // or if its a tie. 
                if(psum >= 100 && csum >= 100){
                    System.out.println("It's a tie!");
                    playAgain();
                }
            } else {
                round++;
                System.out.println("Round " + round + " is starting...");
                Thread.sleep(2000);
                rollDice();
            }
        } catch (InterruptedException e) {
            System.out.println("Error"); // Random error message in case the TRY fails. 
        }

    }

    // Displays a play again screen after the user has won or lost. 
    public void playAgain(){
        System.out.println("Would you like to play again? [1] Yes [2] No");
        Scanner kb = new Scanner(System.in);
        int selection = kb.nextInt();
        if(selection == 1){
            round = 1; // Resets variables. 
            total = 0;
            scoresP.clear();
            scoresC.clear();
            rollDice();
        }else{
            System.out.println("Thanks for playing!");
        }
    }

}
