package io.crative.bullethell.utilz;

import java.awt.image.BufferedImage;
import java.io.InputStream;

import javax.imageio.ImageIO;

/**
 * LoadSave
 */
public class LoadSave {
    public static String PLAYER_ATLAS = "player_atlas.png";

    /*
     * Loads an image depending on the filename given by 
     * the attributes. 
     */
    public static BufferedImage _loadImage(String filename) {
        BufferedImage img;
        InputStream is = LoadSave.class.getResourceAsStream("/" + filename);
        try {
            img = ImageIO.read(is);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            try {
                is.close();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return img;
    }

}

