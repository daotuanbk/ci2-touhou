package touhou;

import bases.GameObject;
import bases.Utils;


public class Enemy extends GameObject {
    boolean checkDie = true;
    boolean spellDisabled;

    int coolDownCount;
    int SPEED = 3;

    final int coolDownTime = 30;
    final int LEFT = 0;
    final int RIGHT = 352;

    public Enemy() {
        x = 0;
        y = 0;
        image = Utils.loadImage("assets/images/enemies/level0/blue/0.png");
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
        shoot();


    }

    public void shoot() {
        if (spellDisabled) {
            coolDownCount++;
            if (coolDownCount >= coolDownTime) {
                spellDisabled = false;
                coolDownCount = 0;
            }
            return;
        } else {
            EnemySpell newSpell = new EnemySpell();
            newSpell.x = x;
            newSpell.y = y;
            GameObject.add(newSpell);
            spellDisabled = true;
        }
    }

 /*   public Rectangle eBounds() {
        return new Rectangle(x, y, image.getWidth(), image.getHeight());
    }*/
}

