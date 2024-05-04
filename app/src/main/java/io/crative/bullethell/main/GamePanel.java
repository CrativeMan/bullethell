package io.crative.bullethell.main;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;


import static io.crative.bullethell.main.Game.GAME_WIDTH;
import static io.crative.bullethell.main.Game.GAME_HEIGHT;
/**
 * GamePanel
 */
public class GamePanel extends JPanel{
    private final Game game;

    public GamePanel(Game game){
        System.out.println("Starting GamePanel...[3]");
        this.game = game;

        setPanelSize();
    }

    private void setPanelSize(){
        Dimension size = new Dimension(GAME_WIDTH, GAME_HEIGHT);
        setPreferredSize(size);
        System.out.println("Size : " + GAME_WIDTH + " | " + GAME_HEIGHT);
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);

        game.render(g);
    }

    public Game getGame(){
        return game;
    }
}
