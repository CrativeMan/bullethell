package io.crative.bullethell.main;

import java.awt.Graphics;

import io.crative.bullethell.entities.Player;

/**
 * Game
 */
public class Game implements Runnable {
    // Static variables
    public static float SCALE = 1.0f;
    public static int GAME_WIDTH = (int)(1920 * SCALE);
    public static int GAME_HEIGHT = (int)(1080*SCALE);

    // Classes
    private Thread gameThread;
    private GamePanel gamePanel;
    private GameFrame gameFrame;
    private Player player;
    
    // private variables
    private int FPS_SET = 120;
    private int UPS_SET = 200;


    public Game() {
        System.out.println("Starting game ...[2]");
        // Initializing Window
        gamePanel = new GamePanel(this);
        gameFrame = new GameFrame(gamePanel);
        gamePanel.requestFocus();

        // Initializing other Classes
        initClasses();

        // you shall not pass
        startGameThread();
    }

    private void initClasses() {
        this.player = new Player(200, 20, 1, 1);
    }

    private void startGameThread() {
        // Starting new thread for the game/update process
        gameThread = new Thread(this);
        gameThread.start();
    }

    public void windowFocusLost() {
        // if(GameState.state == GameState.PLAYING)
        // playing.getPlayer().resetDirBooleans();
    }

    public void update() {
        // Update different things
    }

    public void render(Graphics g) {
        player.render(g);
    }

    @Override
    public void run() {
        System.out.println("Game thread started...");

        double timePerFrame = 1000000000.0 / FPS_SET;
        double timePerUpdate = 1000000000.0 / UPS_SET;

        long previousTime = System.nanoTime();

        int frames = 0;
        int updates = 0;
        long lastCheck = System.currentTimeMillis();

        // delta updates and frames
        double deltaU = 0;
        double deltaF = 0;

        // Game loop
        while (true) {
            long currentTime = System.nanoTime();

            deltaU += (currentTime - previousTime) / timePerUpdate;
            deltaF += (currentTime - previousTime) / timePerFrame;
            previousTime = currentTime;

            if (deltaU >= 1) {
                update();
                updates++;
                deltaU--;
            }

            if (deltaF >= 1) {
                gamePanel.repaint();
                frames++;
                deltaF--;
            }

            if (System.currentTimeMillis() - lastCheck >= 1000) {
                lastCheck = System.currentTimeMillis();
                System.out.println("FPS: " + frames + " | UPS: " + updates);
                frames = 0;
                updates = 0;
            }
        }
    }

    // Getters and Setters
    public Player getPlayer(){
        return player;
    }

}
