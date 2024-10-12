
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class SudokuGame extends JFrame {
   private static final int SIZE = 9;
   private static final int SUBGRID_SIZE = 3;
   private JTextField[][] cells = new JTextField[9][9];
   private int[][] board = new int[][]{{5, 3, 0, 0, 7, 0, 0, 0, 0}, {6, 0, 0, 1, 9, 5, 0, 0, 0}, {0, 9, 8, 0, 0, 0, 0, 6, 0}, {8, 0, 0, 0, 6, 0, 0, 0, 3}, {4, 0, 0, 8, 0, 3, 0, 0, 1}, {7, 0, 0, 0, 2, 0, 0, 0, 6}, {0, 6, 0, 0, 0, 0, 2, 8, 0}, {0, 0, 0, 4, 1, 9, 0, 0, 5}, {0, 0, 0, 0, 8, 0, 0, 7, 9}};

   public SudokuGame() {
      this.initUI();
   }

   private void initUI() {
      this.setTitle("Sudoku Game");
      this.setSize(400, 400);
      this.setDefaultCloseOperation(3);
      this.setLocationRelativeTo((Component)null);
      this.setLayout(new GridLayout(10, 9));

      for(int row = 0; row < 9; ++row) {
         for(int col = 0; col < 9; ++col) {
            this.cells[row][col] = new JTextField();
            if (this.board[row][col] != 0) {
               this.cells[row][col].setText(String.valueOf(this.board[row][col]));
               this.cells[row][col].setEditable(false);
            }

            this.cells[row][col].setHorizontalAlignment(0);
            this.add(this.cells[row][col]);
         }
      }

      JButton solveButton = new JButton("Solve");
      solveButton.addActionListener(new(this));
      this.add(solveButton);
   }

   private void updateBoard() {
      for(int row = 0; row < 9; ++row) {
         for(int col = 0; col < 9; ++col) {
            this.cells[row][col].setText(String.valueOf(this.board[row][col]));
         }
      }

   }

   private boolean solveSudoku(int[][] board) {
      for(int row = 0; row < 9; ++row) {
         for(int col = 0; col < 9; ++col) {
            if (board[row][col] == 0) {
               for(int num = 1; num <= 9; ++num) {
                  if (this.isSafe(board, row, col, num)) {
                     board[row][col] = num;
                     if (this.solveSudoku(board)) {
                        return true;
                     }

                     board[row][col] = 0;
                  }
               }

               return false;
            }
         }
      }

      return true;
   }

   private boolean isSafe(int[][] board, int row, int col, int num) {
      for(int x = 0; x < 9; ++x) {
         if (board[row][x] == num || board[x][col] == num || board[row - row % 3 + x / 3][col - col % 3 + x % 3] == num) {
            return false;
         }
      }

      return true;
   }

   public static void main(String[] args) {
      EventQueue.invokeLater(() -> {
         SudokuGame game = new SudokuGame();
         game.setVisible(true);
      });
   }
}
