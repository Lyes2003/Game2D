
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

    public boolean haut, bas, gauche, droite;

    @Override
    public void keyTyped(KeyEvent e) {
        // Pas utilisé ici
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();

        if (code == KeyEvent.VK_Z) haut = true;
        if (code == KeyEvent.VK_S) bas = true;
        if (code == KeyEvent.VK_Q) gauche = true;
        if (code == KeyEvent.VK_D) droite = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();

        if (code == KeyEvent.VK_Z) haut = false;
        if (code == KeyEvent.VK_S) bas = false;
        if (code == KeyEvent.VK_Q) gauche = false;
        if (code == KeyEvent.VK_D) droite = false;
    }
}

