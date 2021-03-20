package com.aleksandar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class TicTacToe implements ActionListener {

    Random random = new Random();
    JFrame frame = new JFrame();
    JPanel title_panel = new JPanel();
    JPanel button_panel = new JPanel();
    JLabel textField = new JLabel();
    JButton[] buttons = new JButton[9];
    JButton playAgain = new JButton("Play again?");
    boolean playerOneTurn;
    int count = 0;
    boolean isWon = false;


    public TicTacToe() {

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(700, 700);
        frame.getContentPane().setBackground(new Color(50, 50, 50));
        frame.setLayout(new BorderLayout());

        playAgain.setPreferredSize(new Dimension(0,50));
        playAgain.setFont(new Font("Comic Sans",Font.BOLD,40));
        playAgain.setFocusable(false);
        frame.add(playAgain,BorderLayout.SOUTH);
        frame.setVisible(true);

        // Implemented play again method!

        playAgain.addActionListener(e -> {
                for(JButton button :buttons){
                    button.setText("");
                    button.setBackground(new Color(230, 243, 255));
                    button.setEnabled(true);
                    count=0;
                    isWon= false;
                }
                firstTurn();
        });


        textField.setBackground(new Color(25, 25, 25));
        textField.setForeground(new Color(25, 255, 0));
        textField.setFont(new Font("Comic Sans", Font.BOLD, 75));
        textField.setHorizontalAlignment(JLabel.CENTER);
        textField.setText("Tic-Tac-Toe");
        textField.setOpaque(true);

        title_panel.setLayout(new BorderLayout());
        title_panel.setBounds(0, 0, 800, 100);


        button_panel.setLayout(new GridLayout(3, 3));

        firstTurn();

        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new JButton();
            button_panel.add(buttons[i]);
            buttons[i].setBackground(new Color(230, 243, 255));
            buttons[i].setFont(new Font("MV Boli", Font.BOLD, 120));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
        }


        title_panel.add(textField);
        frame.add(button_panel);
        frame.add(title_panel, BorderLayout.NORTH);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        for (JButton button : buttons) {
            if (e.getSource() == button) {
                if (playerOneTurn) {
                    if (button.getText().equals("")) {
                        button.setForeground(new Color(255, 0, 0));
                        button.setText("X");
                        playerOneTurn = false;
                        textField.setText("O turn");
                        count++;
                        System.out.println(count);
                        check();
                    }
                } else {
                    if (button.getText().equals("")) {
                        button.setForeground(new Color(0, 0, 255));
                        button.setText("O");
                        playerOneTurn = true;
                        textField.setText("X turn");
                        count++;
                        System.out.println(count);
                        check();
                    }
                }
            }

        }

    }

    public void firstTurn() {

        if (random.nextInt(2) == 0) {
            playerOneTurn = true;
            textField.setText("X turn");
        } else {
            playerOneTurn = false;
            textField.setText("O turn");
        }
    }

    public void check() {
        // check X winning conditions

        if (
                (buttons[0].getText().equals("X")) &&
                        (buttons[1].getText().equals("X")) &&
                        (buttons[2].getText().equals("X"))) {
            xWins(0, 1, 2);
        }
        if (
                (buttons[3].getText().equals("X")) &&
                        (buttons[4].getText().equals("X")) &&
                        (buttons[5].getText().equals("X"))) {
            xWins(3, 4, 5);
        }
        if (
                (buttons[6].getText().equals("X")) &&
                        (buttons[7].getText().equals("X")) &&
                        (buttons[8].getText().equals("X"))) {
            xWins(6, 7, 8);
        }
        if (
                (buttons[0].getText().equals("X")) &&
                        (buttons[3].getText().equals("X")) &&
                        (buttons[6].getText().equals("X"))) {
            xWins(0, 3, 6);
        }
        if (
                (buttons[1].getText().equals("X")) &&
                        (buttons[4].getText().equals("X")) &&
                        (buttons[7].getText().equals("X"))) {
            xWins(1, 4, 7);
        }
        if (
                (buttons[2].getText().equals("X")) &&
                        (buttons[5].getText().equals("X")) &&
                        (buttons[8].getText().equals("X"))) {
            xWins(2, 5, 8);
        }
        if (
                (buttons[0].getText().equals("X")) &&
                        (buttons[4].getText().equals("X")) &&
                        (buttons[8].getText().equals("X"))) {
            xWins(0, 4, 8);
        }
        if (
                (buttons[2].getText().equals("X")) &&
                        (buttons[4].getText().equals("X")) &&
                        (buttons[6].getText().equals("X"))) {
            xWins(2, 4, 6);
        }

        // check Y winning conditions
        if (
                (buttons[0].getText().equals("O")) &&
                        (buttons[1].getText().equals("O")) &&
                        (buttons[2].getText().equals("O"))) {
            oWins(0, 1, 2);
        }
        if (
                (buttons[3].getText().equals("O")) &&
                        (buttons[4].getText().equals("O")) &&
                        (buttons[5].getText().equals("O"))) {
            oWins(3, 4, 5);
        }
        if (
                (buttons[6].getText().equals("O")) &&
                        (buttons[7].getText().equals("O")) &&
                        (buttons[8].getText().equals("O"))) {
            oWins(6, 7, 8);
        }
        if (
                (buttons[0].getText().equals("O")) &&
                        (buttons[3].getText().equals("O")) &&
                        (buttons[6].getText().equals("O"))) {
            oWins(0, 3, 6);
        }
        if (
                (buttons[1].getText().equals("O")) &&
                        (buttons[4].getText().equals("O")) &&
                        (buttons[7].getText().equals("O"))) {
            oWins(1, 4, 7);
        }
        if (
                (buttons[2].getText().equals("O")) &&
                        (buttons[5].getText().equals("O")) &&
                        (buttons[8].getText().equals("O"))) {
            oWins(2, 5, 8);
        }
        if (
                (buttons[0].getText().equals("O")) &&
                        (buttons[4].getText().equals("O")) &&
                        (buttons[8].getText().equals("O"))) {
            oWins(0, 4, 8);
        }
        if (
                (buttons[2].getText().equals("O")) &&
                        (buttons[4].getText().equals("O")) &&
                        (buttons[6].getText().equals("O"))) {
            oWins(2, 4, 6);
        }

        // check if it's a draw

        if ((count == 9) && !isWon) {
            textField.setText("It's a draw!");
        }

    }

    public void xWins(int a, int b, int c) {
        buttons[a].setBackground(Color.green);
        buttons[b].setBackground(Color.green);
        buttons[c].setBackground(Color.green);
        for (JButton button : buttons) {
            button.setEnabled(false);
        }
        textField.setText("X wins!");
        isWon = true;


    }

    public void oWins(int a, int b, int c) {
        buttons[a].setBackground(Color.green);
        buttons[b].setBackground(Color.green);
        buttons[c].setBackground(Color.green);

        for (JButton button : buttons) {
            button.setEnabled(false);
        }
        textField.setText("O wins!");
        isWon = true;


    }

}
