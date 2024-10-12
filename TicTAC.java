
import java.util.Scanner;

public class TicTAC {
   private static char[][] board = new char[3][3];
   private static char currentPlayer = 'X';

   public TicTAC() {
   }

   public static void main(String[] args) {
      initializeBoard();

      while(true) {
         printBoard();
         playerMove();
         if (isWinner()) {
            printBoard();
            System.out.println("Player " + currentPlayer + " wins!");
            break;
         }

         if (isBoardFull()) {
            printBoard();
            System.out.println("The game is a tie!");
            break;
         }

         switchPlayer();
      }

   }

   private static void initializeBoard() {
      for(int i = 0; i < 3; ++i) {
         for(int j = 0; j < 3; ++j) {
            board[i][j] = '-';
         }
      }

   }

   private static void printBoard() {
      for(int i = 0; i < 3; ++i) {
         for(int j = 0; j < 3; ++j) {
            System.out.print(board[i][j] + " ");
         }

         System.out.println();
      }

   }

   private static void playerMove() {
      Scanner scanner = new Scanner(System.in);

      while(true) {
         System.out.println("Player " + currentPlayer + ", enter your move (row and column): ");
         int row = scanner.nextInt();
         int col = scanner.nextInt();
         if (row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == '-') {
            board[row][col] = currentPlayer;
            return;
         }

         System.out.println("This move is not valid");
      }
   }

   private static boolean isWinner() {
      for(int i = 0; i < 3; ++i) {
         if (board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer) {
            return true;
         }

         if (board[0][i] == currentPlayer && board[1][i] == currentPlayer && board[2][i] == currentPlayer) {
            return true;
         }
      }

      if (board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer) {
         return true;
      } else if (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer) {
         return true;
      } else {
         return false;
      }
   }

   private static boolean isBoardFull() {
      for(int i = 0; i < 3; ++i) {
         for(int j = 0; j < 3; ++j) {
            if (board[i][j] == '-') {
               return false;
            }
         }
      }

      return true;
   }

   private static void switchPlayer() {
      currentPlayer = (char)(currentPlayer == 'X' ? 79 : 88);
   }
}


