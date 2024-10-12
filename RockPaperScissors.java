

import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {
   public RockPaperScissors() {
   }

   public static void main(String[] args) {
      String[] rps = new String[]{"rock", "paper", "scissors"};
      Scanner scanner = new Scanner(System.in);
      Random random = new Random();
      System.out.println("Welcome to Rock-Paper-Scissors! Please enter \"rock\", \"paper\", \"scissors\", or \"quit\" to exit.");

      while(true) {
         while(true) {
            System.out.println("Hello,dude!");
            System.out.print("Enter your move: ");
            String userMove = scanner.nextLine();
            if (userMove.equals("quit")) {
               System.out.println("Thanks for playing! See you again.");
               return;
            }

            if (!userMove.equals("rock") && !userMove.equals("paper") && !userMove.equals("scissors")) {
               System.out.println("Invalid move, please try again.");
            } else {
               int compMoveIndex = random.nextInt(3);
               String compMove = rps[compMoveIndex];
               System.out.println("Computer move: " + compMove);
               if (userMove.equals(compMove)) {
                  System.out.println("It's a tie!");
               } else if ((!userMove.equals("rock") || !compMove.equals("scissors")) && (!userMove.equals("scissors") || !compMove.equals("paper")) && (!userMove.equals("paper") || !compMove.equals("rock"))) {
                  System.out.println("You lose!");
               } else {
                  System.out.println("You win!");
               }
            }
         }
      }
   }
}
