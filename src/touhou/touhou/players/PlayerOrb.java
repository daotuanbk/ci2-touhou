package touhou.touhou.players;

import bases.GameObject;
import bases.Utils;
import bases.Vector2D;
import bases.physics.BoxCollider;
import touhou.touhou.enemies.Enemy;

public class PlayerOrb extends GameObject {
    public BoxCollider boxCollider;
    final int SPEED = 10;
    PlayerCastOrb playerCastOrb;
    public PlayerOrb() {
        image = Utils.loadImage("assets/images/sphere/0.png");
        boxCollider = new BoxCollider(20, 20);

    }

    public void run() {
        this.position.subtractBy(0, SPEED);
        //position.set(player.position.x, player.position.y - 20);
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

