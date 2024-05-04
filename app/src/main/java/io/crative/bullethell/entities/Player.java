package io.crative.bullethell.entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import io.crative.bullethell.utilz.LoadSave;

import static io.crative.bullethell.utilz.LoadSave.PLAYER_ATLAS;

/**
 * Player
 */
public class Player extends Entity{
    private BufferedImage playerImg;

    public Player(int xPos, int yPos, int width, int height){
        super(xPos, yPos, width, height);
        loadImages();
    }

    private void loadImages(){
        playerImg = LoadSave._loadImage(PLAYER_ATLAS);
    }
       
    public void render(Graphics g){
        BufferedImage sub = playerImg.getSubimage(0, 0, 16, 16);
        g.drawImage(sub, xPos, yPos, null);
    }
    
    // Getters and Setters
    public void setX(int x){
        this.xPos += x;
    }
    public void setY(int y){
        this.yPos = y;
    }

}
