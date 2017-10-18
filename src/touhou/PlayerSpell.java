package touhou;

import bases.Utils;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import static java.awt.event.KeyEvent.*;
public class PlayerSpell {
    BufferedImage image;

    Player player = new Player();
    public int x = player.x;
    public int y = player.y;

    boolean xPressed;

    final int SPEED = 10;

    public PlayerSpell() {
        image = Utils.loadImage("assets/images/player-bullets/a/0.png");
    }

    public void render(Graphics graphics) {
        graphics.drawImage(image, x, y, null);
    }

    public void run () {
        y -= SPEED;
    }


    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == VK_X) {
            xPressed = true;
        }
    }

    public void keyReleased(KeyEvent e) {

        if (e.getKeyCode() == VK_X) {
            xPressed = false;
        }


    }
    public Rectangle pSpellBounds () {
        return new Rectangle(x,y,image.getWidth(),image.getHeight());
    }

}

