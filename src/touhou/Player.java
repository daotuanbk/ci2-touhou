package touhou;

import bases.GameObject;
import bases.Utils;

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

    final int SPEED = 5;
    final int coolDownTime = 30;
    final int LEFT = 0;
    final int RIGHT = 360;
    final int TOP = 0;
    final int BOTTOM = 518;

    public Player() {
        x = 182;
        y = 510;
        image = Utils.loadImage("assets/images/players/straight/0.png");
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
    }

    private void move() {
        int vx = 0;
        int vy = 0;

        if (rightPressed) {
            vx += SPEED;
        }
        if (leftPressed) {
            vx -= SPEED;
        }
        if (upPressed) {
            vy -= SPEED;
        }
        if (downPressed) {
            vy += SPEED;
        }

        x += vx;
        y += vy;
        x = (int) clamp(x, LEFT, RIGHT);
        y = (int) clamp(y, TOP, BOTTOM);
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
            newSpell.x = x;
            newSpell.y = y;
            GameObject.add(newSpell);
            spellDisabled = true;
        }
    }
}
