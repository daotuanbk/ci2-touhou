package bases;

import bases.physics.BoxColider;
import touhou.touhou.enemies.Enemy;
import touhou.touhou.players.Player;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Vector;

public class GameObject {
    public Vector2D position;
    public BufferedImage image;
    public boolean isActive;

    static Vector<GameObject> gameObjects = new Vector<>();
    static Vector<GameObject> newObjects = new Vector<>();

    public static void runAll() {
        for (GameObject gameObject : gameObjects) {
            if (gameObject.isActive)
                gameObject.run();
        }
        gameObjects.addAll(newObjects);
        newObjects.clear();
    }

    public static void renderAll(Graphics graphics) {
        for (GameObject gameObject : gameObjects) {
            if (gameObject.isActive)
                gameObject.render(graphics);
        }
    }

    public static void add(GameObject gameObject) {
        newObjects.add(gameObject);

    }

    public GameObject() {
        position = new Vector2D();
        isActive = true;

    }

    public void run() {

    }

    public void render(Graphics graphics) {
        if (image != null) {
            graphics.drawImage(image,
                    (int) position.x - image.getWidth() / 2,
                    (int) position.y - image.getHeight() / 2,
                    null);
        }
    }

    public static Enemy collideWith(BoxColider boxColider) {
        for (GameObject gameObject : gameObjects) {
            if (gameObject.isActive && gameObject instanceof Enemy) {
                Enemy enemy = (Enemy)gameObject;
                if (enemy.boxColider.collideWith(boxColider)) {
                    return enemy;
                }
            }
        }
        return null;
    }

    public static Player collidePlayer(BoxColider boxColider) {
        for (GameObject gameObject : gameObjects) {
            if (gameObject.isActive && gameObject instanceof Player) {
                Player player = (Player)gameObject;
                if (player.boxColider.collideWith(boxColider)) {
                    return player;
                }
            }
        }
        return null;
    }
}
