/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author okinagajoe
 */
package fourgame;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;

public class BaseWindow extends JFrame 
{
    // the window which display before the game
    public BaseWindow() 
    {
        setTitle("Four Game");
        setSize(400, 450);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter()
        {
            @Override
            public void windowClosing(WindowEvent e) 
            {
                showExitConfirmation();
            }
        });
    }
    
    // ask if the user really wants to close the window or not (if the user clicked the closing button)
    public void showExitConfirmation()
    {
        int n = JOptionPane.showConfirmDialog(this, "Do you really want to quit?",
                "Really?", JOptionPane.YES_NO_OPTION);
        if (n == JOptionPane.YES_OPTION)
        {
            doUponExit();
        }
    }

    // close the window
    public void doUponExit()
    {
        this.dispose();
    }
}

