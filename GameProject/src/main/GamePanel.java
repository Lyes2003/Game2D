

import javax.swing.*;
import java.awt.*;



public class GamePanel extends JPanel implements Runnable {

    // 1. TAILLE DE L'ÉCRAN
    final int originalTileSize = 16; // Taille de base du tile (16x16)
    final int scale = 3;             // Zoom

    public final int tileSize = originalTileSize * scale; // 48x48 pixels
    public final int maxScreenCol = 16;
    public final int maxScreenRow = 12;
    public final int screenWidth = tileSize * maxScreenCol; // 768 pixels
    public final int screenHeight = tileSize * maxScreenRow; // 576 pixels

    // 2. BOUCLE DE JEU
    Thread gameThread;
    KeyHandler keyH = new KeyHandler();
    Player player = new Player(this, keyH);


    // 3. Constructeur
    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true); // améliore les performances de rendu
        this.setFocusable(true); // pour recevoir les entrées clavier
        this.addKeyListener(keyH);
    }

    // 4. Démarrer le thread de jeu
    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    // 5. Boucle principale du jeu
    @Override
    public void run() {
        double drawInterval = 1000000000.0 / 60; // 60 FPS
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;

        while (gameThread != null) {
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            lastTime = currentTime;

            if (delta >= 1) {
                update();      // Logique du jeu
                repaint();     // Dessin
                delta--;
            }
        }
    }

    // 6. Mettre à jour le jeu
    public void update() {
        player.update();
    }

    // 7. Dessiner à l'écran
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
    
        player.draw(g2);
    
        g2.dispose();
    }
}
