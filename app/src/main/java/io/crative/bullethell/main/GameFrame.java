package io.crative.bullethell.main;

import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;

import javax.swing.JFrame;

/**
 * GameFrame
 */
public class GameFrame extends JFrame{

    public GameFrame(GamePanel gamePanel){
        System.out.println("Starting GameFrame...[4]");
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.add(gamePanel);
        this.pack();
        this.setSize(800, 800);
        this.addWindowFocusListener(new WindowFocusListener() {
            @Override
            public void windowGainedFocus(WindowEvent e){
            }

            @Override
            public void windowLostFocus(WindowEvent e){
                gamePanel.getGame().windowFocusLost();
            }
        });
        this.setVisible(true);
    }
}
