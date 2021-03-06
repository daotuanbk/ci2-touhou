package touhou.touhou.players;

import bases.GameObject;
import bases.Utils;
import bases.physics.BoxCollider;
import touhou.touhou.enemies.Enemy;

public class PlayerSpell extends GameObject{

    public BoxCollider boxCollider;
    final int SPEED = 10;

    public PlayerSpell() {
        image = Utils.loadImage("assets/images/player-bullets/a/0.png");
        boxCollider = new BoxCollider(20, 20);
    }

    public void run () {
        this.position.subtractBy(0, SPEED);
        boxCollider.postition.set(this.position);

        Enemy enemy = GameObject.collideWith(this.boxCollider, Enemy.class);
        if (enemy != null) {
            enemy.getHit();
            this.isActive = false;
        }
        deActiveIfNeeded();
    }

    private void deActiveIfNeeded() {
        if (position.y < 0) {
            this.isActive = false;
        }
    }

}

