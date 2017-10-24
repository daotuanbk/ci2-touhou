package touhou.touhou.players;

import bases.GameObject;
import bases.Utils;
import bases.Vector2D;
import bases.physics.BoxColider;

import java.awt.event.KeyEvent;

import static java.awt.event.KeyEvent.*;

public class Player extends GameObject {

    boolean rightPressed;
    boolean leftPressed;
    boolean downPressed;
    boolean upPressed;

    boolean xPressed;
    boolean shooted;
    boolean spellDisabled = false;

    int coolDownCount;

    public BoxColider boxColider;

    final int SPEED = 5;
    final int coolDownTime = 30;
    final int LEFT = 0;
    final int RIGHT = 384;
    final int TOP = 0;
    final int BOTTOM = 552;

    public Player() {
        position.set(182, 500);
        image = Utils.loadImage("assets/images/players/straight/0.png");
        boxColider = new BoxColider(32,48);
    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            rightPressed = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            leftPressed = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            upPressed = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            downPressed = true;
        }
        if (e.getKeyCode() == VK_X) {
            xPressed = true;
        }
    }

    public void keyReleased(KeyEvent e) {

        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            rightPressed = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            leftPressed = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            upPressed = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            downPressed = false;
        }
        if (e.getKeyCode() == VK_X) {
            shooted = false;
        }

    }

    public void run() {
        move();
        shoot();
        boxColider.postition.set(this.position);
    }

    Vector2D velocity = new Vector2D(0, 0);

    private void move() {
        velocity.set(0, 0);
        if (rightPressed) {
            velocity.x += SPEED;
        }
        if (leftPressed) {
            velocity.x -= SPEED;
        }
        if (upPressed) {
            velocity.y -= SPEED;
        }
        if (downPressed) {
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

    public void shoot() {
        if (spellDisabled) {
            coolDownCount++;
            if (coolDownCount >= coolDownTime) {
                spellDisabled = false;
                coolDownCount = 0;
            }
            return;
        }
        if (xPressed) {
            xPressed = false;
            PlayerSpell newSpell = new PlayerSpell();
            //newSpell.position.set(this.position);
            newSpell.position.set(position.x, position.y - image.getWidth()/2);
            GameObject.add(newSpell);
            spellDisabled = true;
        }
    }

    public void getHit () {
        isActive = false;
    }
}
