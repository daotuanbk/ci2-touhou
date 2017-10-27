package bases;

import bases.physics.BoxCollider;
import bases.physics.PhysicsBody;
import touhou.touhou.enemies.Enemy;
import touhou.touhou.players.Player;
import touhou.touhou.players.PlayerSpell;

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

    // Tìm trong tất cả các GameObject nếu gặp 1 Object thỏa mãn 2 điều kiện
    // 1. Nếu GameObject này là PlayerSpell
    // 2. isActive == false
    // return Object này
    // Nếu không tìm thấy, tự khởi tạo 1 PlayerSpell mới => return
    public static <T extends GameObject> T recycle(Class<T> cls) {
        for (GameObject gameObject : gameObjects) {
            if (gameObject.getClass().equals(cls) && gameObject.isActive == false) {
                gameObject.isActive = true;
                return (T) gameObject;
            }

        }
        T t = null; // = new
        try {
            T newGameObject = cls.newInstance();
            add(newGameObject);
            return newGameObject;
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
            return null;
        }
    }


    public static <T extends PhysicsBody> T collideWith(BoxCollider boxCollider, Class<T> cls) {
        for (GameObject gameObject : gameObjects) {
            if (!gameObject.isActive) continue;
            if (!(gameObject instanceof PhysicsBody)) continue;
            if (!(gameObject.getClass().equals(cls))) continue;
            BoxCollider otherBoxCollider = ((PhysicsBody) gameObject).getBoxCollider();
            if (otherBoxCollider.collideWith(boxCollider)) {
                return (T) gameObject;
            }
        }
        return null;
    }

}
