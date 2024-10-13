import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SudokuGame {
    private JFrame frame;
    private JTextField[][] cells;

    public SudokuGame() {
        frame = new JFrame("Sudoku game");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(9, 9));

        cells = new JTextField[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                cells[i][j] = new JTextField();
                frame.add(cells[i][j]);
            }
        }

        JButton solveButton = new JButton("Solve");
        solveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int[][] board = new int[9][9];
                for (int row = 0; row < 9; row++) {
                    for (int col = 0; col < 9; col++) {
                        String text = cells[row][col].getText();
                        if (!text.equals("")) {
                            board[row][col] = Integer.parseInt(text);
                        } else {
                            board[row][col] = 0;
                        }
                    }
                }
                if (solveSudoku(board)) {
                    updateBoard(board);
                } else {
                    JOptionPane.showMessageDialog(frame, "No solution exists");
                }
            }
        });

        frame.add(solveButton);
        frame.setVisible(true);
    }

    private void updateBoard(int[][] board) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                cells[row][col].setText(String.valueOf(board[row][col]));
            }
        }
    }

    public boolean solveSudoku(int[][] board) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col] == 0) { // Empty cell
                    for (int num = 1; num <= 9; num++) {
                        if (isSafe(board, row, col, num)) {
                            board[row][col] = num;
                            if (solveSudoku(board)) {
                                return true;
                            }
                            board[row][col] = 0;
                        }
                    }
                    return false; // Trigger backtracking
                }
            }
        }
        return true;
    }

    public boolean isSafe(int[][] board, int row, int col, int num) {
        // Check row
        for (int x = 0; x < 9; x++) {
            if (board[row][x] == num) {
                return false;
            }
        }
        // Check column
        for (int x = 0; x < 9; x++) {
            if (board[x][col] == num) {
                return false;
            }
        }
        // Check 3x3 subgrid
        int startRow = row - row % 3, startCol = col - col % 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i + startRow][j + startCol] == num) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            new SudokuGame();
        });
    }
}
