package touhou.touhou.players;

import bases.GameObject;
import touhou.touhou.inputs.InputManager;

public class PlayerCastOrb {
    final int coolDownTime = 30;
    boolean spellDisabled = false;
    int coolDownCount;
    final int SPEED = 10;
    PlayerOrb playerOrb = new PlayerOrb();
    public void run(Player owner) {
        if (spellDisabled) {
            coolDownCount++;
            if (coolDownCount >= coolDownTime) {
                spellDisabled = false;
                coolDownCount = 0;
            }
            return;
        }
        if (InputManager.instance.xPressed) {
            InputManager.instance.xPressed = false;
            PlayerOrb newSpell = GameObject.recycle(PlayerOrb.class);
            newSpell.position.set(owner.position.x-20, owner.position.y - owner.image.getWidth()/2);
            PlayerOrb newSpell2 = GameObject.recycle(PlayerOrb.class);
            newSpell2.position.set(owner.position.x+20, owner.position.y - owner.image.getWidth()/2);
            PlayerOrb newSpell3 = GameObject.recycle(PlayerOrb.class);
            newSpell3.position.set(owner.position.x, owner.position.y - owner.image.getWidth()/2);
            spellDisabled = true;
        }

    }
}
