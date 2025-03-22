
import java.awt.*;

public class Player {
    GamePanel gp;
    KeyHandler keyH;

    public int x, y;        // Position du joueur
    public int speed;       // Vitesse du joueur

    public Player(GamePanel gp, KeyHandler keyH) {
        this.gp = gp;
        this.keyH = keyH;

        setDefaultValues();
    }

    public void setDefaultValues() {
        x = 100;
        y = 100;
        speed = 4;
    }

    public void update() {
        if (keyH.haut) y -= speed;
        if (keyH.bas) y += speed;
        if (keyH.gauche) x -= speed;
        if (keyH.droite) x += speed;
    }

    public void draw(Graphics2D g2) {
        g2.setColor(Color.white);
        g2.fillRect(x, y, gp.tileSize, gp.tileSize);
    }
}
