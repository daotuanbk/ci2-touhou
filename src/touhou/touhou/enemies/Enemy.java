package touhou.touhou.enemies;

import bases.GameObject;
import bases.Utils;
import bases.physics.BoxCollider;
import bases.physics.PhysicsBody;

import javax.swing.*;


public class Enemy extends GameObject implements PhysicsBody {


    public BoxCollider boxColider;
    PlayerDamage playerDamage;
    EnemyCastSpell castSpell = new EnemyCastSpell();
    int SPEED = 3;
    int x = 1, y = 1;
    final int LEFT = 0;
    final int RIGHT = 352;

    public Enemy() {
        //position.set(20,20);
        boxColider = new BoxCollider(30, 30);
        image = Utils.loadImage("assets/images/enemies/level0/blue/0.png");
        this.playerDamage = new PlayerDamage();
    }

    public void run() {
        if (position.x >= RIGHT) {
            x = -2;
            y = -2;
        }
        if (position.y <= LEFT) {
            x = 2;
            y = 2;
        }
        position.addUp(x, y);
        castSpell.shoot(this);
        boxColider.postition.set(this.position);
        this.playerDamage.run(this);
    }

    public void getHit() {
        isActive = false;
    }

    @Override
    public BoxCollider getBoxCollider() {
        return boxColider;
    }
}

