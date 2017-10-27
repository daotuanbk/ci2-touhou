package touhou.touhou.players;

import bases.GameObject;
import bases.Utils;
import bases.Vector2D;
import bases.physics.BoxCollider;
import bases.physics.PhysicsBody;
import touhou.touhou.inputs.InputManager;

import java.awt.event.KeyEvent;

import static java.awt.event.KeyEvent.*;

public class Player extends GameObject implements PhysicsBody {



    boolean shooted;


    PlayerCastSpell castSpell;
    PlayerCastOrb castOrb;
    public BoxCollider boxColider;

    final int SPEED = 5;

    final int LEFT = 0;
    final int RIGHT = 384;
    final int TOP = 0;
    final int BOTTOM = 552;

    public Player() {
        position.set(182, 500);
        image = Utils.loadImage("assets/images/players/straight/0.png");
        boxColider = new BoxCollider(8,8);
        this.castSpell = new PlayerCastSpell();
        this.castOrb = new PlayerCastOrb();
    }


    public void run() {
        move();
        boxColider.postition.set(this.position);
        castSpell.run(this);
        castOrb.run(this);
    }

    Vector2D velocity = new Vector2D(0, 0);

    private void move() {
        velocity.set(0, 0);
        InputManager inputManager = InputManager.instance;
        if (inputManager.rightPressed) {
            velocity.x += SPEED;
        }
        if (inputManager.leftPressed) {
            velocity.x -= SPEED;
        }
        if (inputManager.upPressed) {
            velocity.y -= SPEED;
        }
        if (inputManager.downPressed) {
            velocity.y += SPEED;
        }

        position.addUp(velocity);
        position.x = (int) clamp(position.x, LEFT, RIGHT);
        position.y = (int) clamp(position.y, TOP, BOTTOM);
    }

    private float clamp(float value, float min, float max) {
        if (value < min) {
            return min;
        }
        if (value > max) {
            return max;
        }

        return value;
    }


    public void getHit () {
        isActive = false;
    }

    @Override
    public BoxCollider getBoxCollider() {
        return boxColider;
    }
}
