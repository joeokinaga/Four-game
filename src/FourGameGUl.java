/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author okinagajoe
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FourGameGUl extends javax.swing.JFrame {
    private PlayGame controller;
    private JButton[][] buttons;
    private int boardSize = 5;  // デフォルトのボードサイズ（3, 5, 7のいずれかに変更可能）

    public FourGameGUl() {
        initComponents();
        controller = new PlayGame(boardSize);
        buttons = new JButton[boardSize][boardSize];
        initializeButtons();
        updateButtonValues();
        updateButtonColors();
    }

    private void initComponents() {
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
        pack();
    }

    private void initializeButtons() {
        getContentPane().setLayout(new GridLayout(boardSize, boardSize));
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                buttons[i][j] = new JButton("0");
                int row = i, col = j;
                buttons[i][j].addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        controller.makeMove(row, col);
                        updateButtonValues();
                        updateButtonColors();
                    }
                });
                getContentPane().add(buttons[i][j]);
            }
        }
    }

    private void updateButtonValues() {
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                buttons[i][j].setText(String.valueOf(controller.getBoard().getTile(i, j).getValue()));
            }
        }
    }

    private void updateButtonColors() {
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                String color = controller.getBoard().getTile(i, j).getColor();
                buttons[i][j].setBackground(color.equals("RED") ? Color.RED : (color.equals("BLUE") ? Color.BLUE : Color.WHITE));
            }
        }
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FourGameGUI().setVisible(true);
            }
        });
    }
}
