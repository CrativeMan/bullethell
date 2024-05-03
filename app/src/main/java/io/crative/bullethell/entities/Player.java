package io.crative.bullethell.entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

/**
 * Player
 */
public class Player extends Entity{
    private BufferedImage img;
    private String filename = "player_atlas.png";

    public Player(int x, int y, int width, int height){
        super(x, y, width, height);
        loadImages();
    }

    private void loadImages(){
        InputStream is = this.getClass().getResourceAsStream("/" + filename);
        try {
            img = ImageIO.read(is);
        } catch (IOException e){
            throw new RuntimeException(e);
        } finally {
            try {
                is.close();
            } catch (IOException e){
                throw new RuntimeException(e);
            }
        }
    }
       
    public void render(Graphics g){
        BufferedImage sub = img.getSubimage(0, 0, 16, 16);
        g.drawImage(sub, x, y, null);
    }
    
}
