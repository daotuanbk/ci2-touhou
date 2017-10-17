package touhou;

import bases.Utils;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Enemy {
    BufferedImage image;
    long lastTimeUpdate;

    public int x = 0;
    public int y = 0;

    boolean checkDie = true;

    int SPEED = 3;
    final int LEFT = 0;
    final int RIGHT = 352;

    public Enemy() {
        image = Utils.loadImage("assets/images/enemies/level0/blue/0.png");
        lastTimeUpdate = System.nanoTime();
    }

    public void render(Graphics graphics) {
        graphics.drawImage(image, x, y, null);
    }

    public void run() {
        if (checkDie) {
            if (x >= RIGHT) {
                SPEED = -3;
            } else if (x <= LEFT) {
                SPEED = 3;
            }
            x += SPEED;
        }


    }

    public void shoot(ArrayList<EnemySpell> spells) {
        long currentTime = System.nanoTime();
        if (currentTime - lastTimeUpdate >= 900000000) {

            EnemySpell newSpell = new EnemySpell();
            newSpell.x = x;
            newSpell.y = y;

            spells.add(newSpell);
            lastTimeUpdate = currentTime;
        }
    }
    public Rectangle eBounds () {
        return new Rectangle(x,y,image.getWidth(),image.getHeight());
    }
}

