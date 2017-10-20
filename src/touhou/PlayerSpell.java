package touhou;

import bases.GameObject;
import bases.Utils;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import static java.awt.event.KeyEvent.*;
public class PlayerSpell extends GameObject{

    boolean xPressed;

    final int SPEED = 10;

    public PlayerSpell() {
        image = Utils.loadImage("assets/images/player-bullets/a/0.png");
    }

    public void run () {
        y -= SPEED;
    }

/*    public Rectangle pSpellBounds () {
        return new Rectangle(x,y,image.getWidth(),image.getHeight());
    }*/

}

