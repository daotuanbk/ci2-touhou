package touhou;

import bases.GameObject;
import bases.Utils;

import java.awt.*;
import java.awt.image.BufferedImage;

public class EnemySpell extends GameObject {
    Enemy enemy = new Enemy();

    final int SPEED = 6;

    public EnemySpell() {
        image = Utils.loadImage("assets/images/sphere-bullets/0.png");
        x = enemy.x;
        y = enemy.y;
    }

    public void run() {
        y += SPEED;
    }

/*    public Rectangle eSpellBounds() {
        return new Rectangle(x,y,image.getWidth(),image.getHeight());
    }*/
}