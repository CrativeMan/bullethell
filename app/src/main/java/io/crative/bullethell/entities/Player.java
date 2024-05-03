package io.crative.bullethell.entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import io.crative.bullethell.utilz.LoadSave;

import static io.crative.bullethell.utilz.LoadSave.PLAYER_ATLAS;

/**
 * Player
 */
public class Player extends Entity{
    private BufferedImage img;

    public Player(int x, int y, int width, int height){
        super(x, y, width, height);
        loadImages();
    }

    private void loadImages(){
        img = LoadSave._loadImage(PLAYER_ATLAS);
    }
       
    public void render(Graphics g){
        BufferedImage sub = img.getSubimage(0, 0, 16, 16);
        g.drawImage(sub, x, y, null);
    }
    
    // Getters and Setters
    public void setX(int x){
        this.x += x;
    }
    public void setY(int y){
        this.y = y;
    }

}
