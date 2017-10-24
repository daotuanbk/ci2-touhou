package touhou.touhou.enemies;

import bases.GameObject;
import bases.Utils;
import bases.physics.BoxColider;


public class Enemy extends GameObject {
    boolean spellDisabled;

    public BoxColider boxColider;

    int coolDownCount;
    int SPEED = 3;

    final int coolDownTime = 30;
    final int LEFT = 0;
    final int RIGHT = 352;

    public Enemy() {
        position.set(20,20);
        boxColider = new BoxColider(30, 30);
        image = Utils.loadImage("assets/images/enemies/level0/blue/0.png");
    }

    public void run() {
        position.addUp(0, 2);
        shoot();
        boxColider.postition.set(this.position);
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
            newSpell.position.set(position.x, position.y + image.getWidth()/2);
            GameObject.add(newSpell);
            spellDisabled = true;
        }
    }

    public void getHit() {
        isActive = false;
    }

 /*   public Rectangle eBounds() {
        return new Rectangle(x, y, image.getWidth(), image.getHeight());
    }*/
}

