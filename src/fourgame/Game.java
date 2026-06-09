/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author okinagajoe
 */
package fourgame;
import java.util.List;
import java.util.ArrayList;


public class Game 
{

    private int size;
    private Player actualPlayer;
    private int[][] board;
    private int redPoint;
    private int bluePoint;
    
    public Game(int size) 
    {
        this.size = size;
        actualPlayer = Player.RED;
        board = new int[size][size];
        redPoint = 0;
        bluePoint = 0;
    }

    
    
    public Player getActualPlayer() 
    {
        return actualPlayer;
    }

    
    
    public int getTileValue(int row, int col) 
    {
        return board[row][col];
    }
    
    
    
    public int getPoint(Player player)
    {
        if(player == Player.RED)
        {
            return redPoint;
        }
        else
        {
            return bluePoint;
        }
    }
    
        
        
    // increment numbers (max is 4)
    public void incrementNumbers(int row, int col) 
    {
        if(board[row][col] < 4) 
        {
            board[row][col]++;
            incrementNeighbors(row, col);
        }
    }

    
    
    // increment neighbours numbers (max is 4)
    public void incrementNeighbors(int row, int col) 
    {
        for(int i = -1; i <= 1; i++)
        {
            for(int j = -1; j <= 1; j++)
            {
                if(row + i >= 0 && row + i < size && col + j >= 0 && col + j < size) 
                {
                    if(Math.abs(i) != Math.abs(j))
                    {
                        if(board[row + i][col + j] < 4)
                        {
                            board[row + i][col + j]++;
                        }
                    }
                }
            }
        }
    }
    
    
    
    public void addPoint(Player player)
    {
        if(player == Player.RED)
        {
            redPoint++;
        }
        else
        {
            bluePoint++;
        }
    }    

    
    
    //switch player
    protected void switchPlayer()
    {
        if(actualPlayer == Player.RED) 
        {
            actualPlayer = Player.BLUE;
        }
        else 
        {
            actualPlayer = Player.RED;
        }
    }

    
    
    //check is the game is over or not
    public boolean isGameOver()
    {
        for(int i = 0; i < size; i++) 
        {
            for(int j = 0; j < size; j++) 
            {
                if(board[i][j] < 4) 
                {
                    return false;
                }
            }
        }
        return true;
    }

    

    
    public List<int[]> getNeighboursInd(int row, int col)
    {
        List<int[]> neighbours = new ArrayList<>();
        
        for(int i = -1; i <= 1; i++) 
        {
            for(int j = -1; j <= 1; j++) 
            {
                if(row + i >= 0 && row + i < size && col + j >= 0 && col + j < size) 
                {
                    if(Math.abs(i) != Math.abs(j)) 
                    {
                        neighbours.add(new int[] {row + i, col + j});
                    }
                }
            }
        }
        return neighbours;
    }
    
    
    
    public Player winner()
    {
        if(redPoint > bluePoint)
        {
            return Player.RED;        
        }
        else if(redPoint < bluePoint)
        {
            return Player.BLUE;
        }
        else
        {
            return Player.NONE;
        }
    }
}
