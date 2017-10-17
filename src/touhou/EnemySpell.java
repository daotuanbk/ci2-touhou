package touhou;

import bases.Utils;

import java.awt.*;
import java.awt.image.BufferedImage;

public class EnemySpell {
    BufferedImage image;
    Enemy enemy = new Enemy();

    public int x = enemy.x;
    public int y = enemy.y;

    final int SPEED = 6;

    public EnemySpell() {
        image = Utils.loadImage("assets/images/sphere-bullets/0.png");
    }

    public void render(Graphics graphics) {
        graphics.drawImage(image, x, y, null);
    }

    public void run() {
        y += SPEED;
    }

    public Rectangle eSpellBounds() {
        return new Rectangle(x,y,image.getWidth(),image.getHeight());
    }
}