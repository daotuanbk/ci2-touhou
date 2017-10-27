package touhou.touhou.players;

import bases.GameObject;
import bases.Vector2D;
import bases.physics.BoxCollider;
import touhou.touhou.enemies.Enemy;
import touhou.touhou.inputs.InputManager;
import touhou.touhou.players.Player;

import java.awt.image.BufferedImage;


public class PlayerCastSpell {
    final int coolDownTime = 30;
    boolean spellDisabled = false;
    int coolDownCount;
    public void run(Player owner) {
        if (spellDisabled) {
            coolDownCount++;
            if (coolDownCount >= coolDownTime) {
                spellDisabled = false;
                coolDownCount = 0;
            }
            return;
        }
        if (InputManager.instance.vPressed) {
            InputManager.instance.vPressed = false;
            GameObject.recycle(PlayerSpell.class);
            GameObject.recycle(PlayerSpell.class).position.set(owner.position.x, owner.position.y - owner.image.getWidth()/2);
            spellDisabled = true;
        }

    }
}
