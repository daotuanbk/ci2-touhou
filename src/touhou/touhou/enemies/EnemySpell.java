package touhou.touhou.enemies;

import bases.GameObject;
import bases.Utils;
import bases.physics.BoxCollider;
import touhou.touhou.players.Player;


public class EnemySpell extends GameObject {
    BoxCollider boxColider;
    Enemy enemy = new Enemy();

    final int SPEED = 3;

    public EnemySpell() {
        image = Utils.loadImage("assets/images/sphere-bullets/0.png");
        position.x = enemy.position.x - enemy.position.x / 2;
        position.y = enemy.position.y - enemy.position.y / 2;
        boxColider = new BoxCollider(24, 24);
    }

    public void run() {
        position.y += SPEED;
        boxColider.postition.set(this.position);
        Player player = GameObject.collideWith(this.boxColider, Player.class);

        if (player != null) {
            player.getHit();
            this.isActive = false;
        }
    }
}