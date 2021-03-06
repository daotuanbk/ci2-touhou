package touhou.touhou.inputs;

import touhou.touhou.players.Player;

import java.awt.event.KeyEvent;

import static java.awt.event.KeyEvent.VK_V;
import static java.awt.event.KeyEvent.VK_X;

public class InputManager {
    //Tracking user input
    //Provide input states for other classes
    //Singleton
    public boolean rightPressed;
    public boolean leftPressed;
    public boolean downPressed;
    public boolean upPressed;
    public boolean xPressed;
    public boolean vPressed;
    public static final InputManager instance = new InputManager();
    private InputManager () {

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
        if (e.getKeyCode() == VK_V) {
            vPressed = true;
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
            xPressed = false;
        }
        if (e.getKeyCode() == VK_V) {
            vPressed = false;
        }

    }

}
