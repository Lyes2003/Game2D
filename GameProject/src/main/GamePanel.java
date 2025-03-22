public class GamePanel {
    public class GamePanel extends JPanel implements Runnable {
        final int originalTileSize = 16; // taille d’un tile en pixels
        final int scale = 3;
    
        public final int tileSize = originalTileSize * scale;
        public final int maxScreenCol = 16;
        public final int maxScreenRow = 12;
        public final int screenWidth = tileSize * maxScreenCol;
        public final int screenHeight = tileSize * maxScreenRow;
    
        Thread gameThread;
        KeyHandler keyHandler = new KeyHandler();
        Player player = new Player(this, keyHandler);
    
        public GamePanel() {
            this.setPreferredSize(new Dimension(screenWidth, screenHeight));
            this.setBackground(Color.black);
            this.setDoubleBuffered(true);
            this.addKeyListener(keyHandler);
            this.setFocusable(true);
        }
    
        public void startGameThread() {
            gameThread = new Thread(this);
            gameThread.start();
        }
    
        public void run() {
            double drawInterval = 1000000000 / 60;
            double delta = 0;
            long lastTime = System.nanoTime();
    
            while (gameThread != null) {
                long currentTime = System.nanoTime();
                delta += (currentTime - lastTime) / drawInterval;
                lastTime = currentTime;
    
                if (delta >= 1) {
                    update();
                    repaint();
                    delta--;
                }
            }
        }
    
        public void update() {
            player.update();
        }
    
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;
    
            player.draw(g2);
    
            g2.dispose();
        }
    }    
}