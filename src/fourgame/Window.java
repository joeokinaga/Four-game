/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author okinagajoe 
 */
package fourgame;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.util.List;


public class Window extends BaseWindow 
{
    private final int size;
    private final Game game;
    private final JLabel label;
    private final MainWindow mainWindow;

    // constructor
    public Window(int size, MainWindow mainWindow) 
    {
        this.size = size;
        this.mainWindow = mainWindow;
        game = new Game(size);


        JPanel top = new JPanel();
        
        label = new JLabel();
        updateLabelText();
        
        JButton newGameButton = new JButton();
        newGameButton.setText("New game");     
        newGameButton.addActionListener(e -> newGame());

        
        top.add(label);
        top.add(newGameButton);
        
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(size, size));

        for(int i = 0; i < size; ++i) 
        {
            for(int j = 0; j < size; ++j) 
            {
                addButton(mainPanel, i, j);
            }
        }

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(top, BorderLayout.NORTH);
        getContentPane().add(mainPanel, BorderLayout.CENTER);

        initializeBoard();
    }

    
    
    
    
    // make one tile and also tile's function when when the player choose its tile
    private void addButton(JPanel panel, final int i, final int j)
    {
        final JButton button = new JButton();


        button.setBackground(java.awt.Color.WHITE);
        button.setOpaque(true);
        button.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.GRAY, 1)); // 灰色の枠線を設定

        button.addActionListener(e -> {
            
            int boardValueBefore = game.getTileValue(i, j);
            
            if(boardValueBefore == 4)
            {
                // do nothing if the value is 4
            }
            else // we can choose the tile which is not >4
            {
                game.incrementNumbers(i, j);
                
                int boardValueAfter = game.getTileValue(i, j);
                button.setText(String.valueOf(game.getTileValue(i, j)));


                if(boardValueAfter == 4) 
                {
                    if(game.getActualPlayer() == Player.RED)
                    {
                        button.setBackground(java.awt.Color.RED);
                        game.addPoint(game.getActualPlayer());
                    }
                    else // if the actual player is blue
                    {
                        button.setBackground(java.awt.Color.BLUE);
                        game.addPoint(game.getActualPlayer());
                    }
                } 
                else
                {
                    // if the number of the tile is <4 nothing is changed
                }

                updateNeighborButtons(i, j, panel);  
                
                // change the colour of neighbours tile
                List<int[]> neighbours = game.getNeighboursInd(i, j);

                for(int[] neighbour : neighbours)
                {
                    int row = neighbour[0];
                    int col = neighbour[1];

                    JButton neighbourButton = (JButton) panel.getComponent(row * size + col);

                    if(game.getTileValue(row, col) == 4 && !neighbourButton.getBackground().equals(java.awt.Color.RED) &&!neighbourButton.getBackground().equals(java.awt.Color.BLUE)) 
                    {
                        if(game.getActualPlayer() == Player.RED)
                        {
                            neighbourButton.setBackground(java.awt.Color.RED);
                            game.addPoint(game.getActualPlayer());
                        }
                        else // if the actual player is blue
                        {
                            neighbourButton.setBackground(java.awt.Color.BLUE);
                            game.addPoint(game.getActualPlayer());
                        }
                    } 

                }
                
                game.switchPlayer();


                updateLabelText(); 

                if(game.isGameOver())
                {
                    Player winner = game.winner();
                    showGameOverMessage(winner);
                }
            }
        });

        panel.add(button); 
    }


    
    public void initializeBoard()
    {
        for(int i = 0; i < size; i++)
        {
            for(int j = 0; j < size; j++) 
            {
                JButton button = (JButton) ((JPanel) getContentPane().getComponent(1)).getComponent(i * size + j);
                button.setText("0");
            }
        }
    }  
    
    
    
    // update the the text of the neighbours tile
    public void updateNeighborButtons(int i, int j, JPanel panel) 
    {
        if(i > 0) //above
        {
            JButton neighborButton = (JButton) panel.getComponent((i - 1) * size + j);
            neighborButton.setText(String.valueOf(game.getTileValue(i - 1, j)));
        }
        if(i < size - 1) //under
        {
            JButton neighborButton = (JButton) panel.getComponent((i + 1) * size + j);
            neighborButton.setText(String.valueOf(game.getTileValue(i + 1, j)));
        }
        if(j > 0) //left
        {
            JButton neighborButton = (JButton) panel.getComponent(i * size + (j - 1));
            neighborButton.setText(String.valueOf(game.getTileValue(i, j - 1)));
        }
        if(j < size - 1) // right
        {
            JButton neighborButton = (JButton) panel.getComponent(i * size + (j + 1));
            neighborButton.setText(String.valueOf(game.getTileValue(i, j + 1)));
        }
    }

    
    
    // show who won (can be draw on 4x4) (popupwindow)
    private void showGameOverMessage(Player winner)
    {
        if(winner == Player.NONE)
        {
            JOptionPane.showMessageDialog(this, "Game is over! Result: Draw");
        }
        else
        {
            JOptionPane.showMessageDialog(this, "Game is over! Winner: " + winner);            
        }
        
        newGame();
    }
    
    

    // start a new game after finish the game
    public void newGame() 
    {
        Window newWindow = new Window(size, mainWindow);
        newWindow.setVisible(true);
        
        this.dispose();
        mainWindow.getWindowList().remove(this);
    }

    
    // show whose turn right now
    public void updateLabelText()
    {
        label.setText("Current player: " + game.getActualPlayer().name());
    }

    
    
    @Override
    public void doUponExit()
    {
        super.doUponExit();
        mainWindow.getWindowList().remove(this);
    }
}
