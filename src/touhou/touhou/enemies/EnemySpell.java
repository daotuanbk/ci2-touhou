package touhou.touhou.enemies;

import bases.GameObject;
import bases.Utils;
import bases.physics.BoxColider;
import touhou.touhou.players.Player;


public class EnemySpell extends GameObject {
    BoxColider boxColider;
    Enemy enemy = new Enemy();

    final int SPEED = 6;

    public EnemySpell() {
        image = Utils.loadImage("assets/images/sphere-bullets/0.png");
        position.x = enemy.position.x - enemy.position.x/2;
        position.y = enemy.position.y - enemy.position.y/2;
        boxColider = new BoxColider(24, 24);
    }

    public void run() {
        position.y += SPEED;
        boxColider.postition.set(this.position);

        Player player = GameObject.collidePlayer(this.boxColider);

        if (player != null) {
            player.getHit();
            this.isActive = false;
        }
    }

/*    public Rectangle eSpellBounds() {
        return new Rectangle(x,y,image.getWidth(),image.getHeight());
    }*/
}