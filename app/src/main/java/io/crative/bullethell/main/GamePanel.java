package io.crative.bullethell.main;

import java.awt.Graphics;

import javax.swing.JPanel;

/**
 * GamePanel
 */
public class GamePanel extends JPanel{
    private final Game game;

    public GamePanel(Game game){
        System.out.println("Starting GamePanel...[3]");
        this.game = game;
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);

        game.render(g);
    }

    public Game getGame(){
        return game;
    }
}
