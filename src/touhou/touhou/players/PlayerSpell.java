package touhou.touhou.players;

import bases.GameObject;
import bases.Utils;
import bases.physics.BoxColider;
import touhou.touhou.enemies.Enemy;

public class PlayerSpell extends GameObject{

    public BoxColider boxColider;
    final int SPEED = 10;

    public PlayerSpell() {
        image = Utils.loadImage("assets/images/player-bullets/a/0.png");
        boxColider = new BoxColider(20, 20);
    }

    public void run () {
        this.position.subtractBy(0, SPEED);
        boxColider.postition.set(this.position);
       // position.y -= SPEED;

        Enemy enemy = GameObject.collideWith(this.boxColider);

        if (enemy != null) {
            enemy.getHit();
            this.isActive = false;
        }
    }

/*    public Rectangle pSpellBounds () {
        return new Rectangle(x,y,image.getWidth(),image.getHeight());
    }*/

}

