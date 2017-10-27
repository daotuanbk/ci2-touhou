package touhou.touhou.enemies;

import bases.FrameCounter;
import bases.GameObject;

import java.util.Random;

public class EnemySpawner extends GameObject {
    FrameCounter frameCounter = new FrameCounter(200);
    Random random = new Random();
    public void run() {
        if (frameCounter.run()) {
            frameCounter.reset();
            spawn();
        }

    }

    private void spawn() {
        Enemy enemy = new Enemy();
        enemy.position.y = 10;
        enemy.position.x = random.nextInt(180);
        GameObject.add(enemy);
    }
}
