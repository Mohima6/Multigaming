

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IwilltryHomePage extends JFrame {
    public IwilltryHomePage() {
        // Set the title of the window
        setTitle("Iwilltry Project Home Page");
        // Set the size of the window
        setSize(400, 400);
        // Set the default close operation
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Set the layout manager
        setLayout(new GridLayout(4, 1));

        // Create buttons for each game
        JButton ticTacButton = new JButton("Tic Tac Toe");
        JButton scissorRockButton = new JButton("Rock Paper Scissors");
        JButton snakeEatsButton = new JButton("Snake Game");
        JButton sudokuSolveButton = new JButton("Sudoku Solver");

        // Add action listeners to the buttons
        ticTacButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Code to open Tic Tac Toe game
                JOptionPane.showMessageDialog(null, "Tic Tac Toe game will start!");
            }
        });

        scissorRockButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Code to open Rock Paper Scissors game
                JOptionPane.showMessageDialog(null, "Rock Paper Scissors game will start!");
            }
        });

        snakeEatsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Code to open Snake Game
                JOptionPane.showMessageDialog(null, "Snake Game will start!");
            }
        });

        sudokuSolveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Code to open Sudoku Solver
                JOptionPane.showMessageDialog(null, "Sudoku Solver will start!");
            }
        });

        // Add buttons to the frame
        add(ticTacButton);
        add(scissorRockButton);
        add(snakeEatsButton);
        add(sudokuSolveButton);
    }

    public static void main(String[] args) {
        // Create and display the home page
        IwilltryHomePage homePage = new IwilltryHomePage();
        homePage.setVisible(true);
    }
}
