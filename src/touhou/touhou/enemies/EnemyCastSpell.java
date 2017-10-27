package touhou.touhou.enemies;

import bases.GameObject;

import java.util.Random;

public class EnemyCastSpell {
    boolean spellDisabled;
    int coolDownCount;
    final int coolDownTime = 100;

    public void shoot(Enemy owner) {
        if (spellDisabled) {
            coolDownCount++;
            if (coolDownCount >= coolDownTime) {
                spellDisabled = false;
                coolDownCount = 0;
            }
            return;
        } else {
            EnemySpell enemySpell = GameObject.recycle(EnemySpell.class);
            EnemySpell enemySpell2 = GameObject.recycle(EnemySpell.class);
            EnemySpell enemySpell3 = GameObject.recycle(EnemySpell.class);
            //newSpell.position.set(position.x, position.y + image.getWidth()/2);
            enemySpell.position.set(owner.position.x +20, owner.position.y + owner.image.getWidth() / 2);
            enemySpell2.position.set(owner.position.x -20, owner.position.y + owner.image.getWidth() / 2);
            enemySpell3.position.set(owner.position.x, owner.position.y + owner.image.getWidth() / 2);
            spellDisabled = true;
        }

    }
}
