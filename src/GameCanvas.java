import bases.GameObject;
import touhou.touhou.enemies.Enemy;
import touhou.touhou.enemies.EnemySpawner;
import touhou.touhou.players.PlayerSpell;
import touhou.touhou.players.Player;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class GameCanvas extends JPanel {

    BufferedImage background;
    int backgroundX = 0;
    int backgroundY = 0;


    BufferedImage backBuffer;
    Graphics backGraphics;

    Player player = new Player(); //=null
    Enemy enemy = new Enemy();
    PlayerSpell playerSpell = new PlayerSpell();

    public GameCanvas() {
        //0. Create back buffer
        backBuffer = new BufferedImage(800, 600, BufferedImage.TYPE_INT_ARGB);
        backGraphics = backBuffer.getGraphics();
        //1. Load background
        try {
            background = ImageIO.read(new File("assets/images/background/0.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
        GameObject.add(player);
        GameObject.add(enemy);
        GameObject.add(new EnemySpawner());

    }

    public void render() {
        //1. Draw everything on backbuffer
        backGraphics.drawImage(background, backgroundX, backgroundY, null);

        GameObject.renderAll(backGraphics);

        //2. Call repaint
        repaint();
    }


//    public void checkDie() {
//        for (int i = 0; i < spells.size(); i++) {
//            PlayerSpell spell = spells.get(i);
//            for (int j = 0; j < enemies.size(); j++) {
//                Enemy enemyDie = enemies.get(j);
//                if (spell.getRetangle().intersects(enemy.getRetangle())) {
//                    spells.remove(spell);
//                    enemies.remove(enemyDie);
//                    i--;
//                    break;
//                }
//            }
//        }
//        for (int i = 0; i < eSpells.size(); i++) {
//            EnemySpell espell = eSpells.get(i);
//            if (espell.getRetangle().intersects(player.getRetangle())) {
//                eSpells.remove(espell);
//                System.exit(0);
//                break;
//            }
//        }
//
//    }


    @Override
    //2. Draw background
    protected void paintComponent(Graphics g) {
        g.drawImage(backBuffer, 0, 0, null);
    }

    public void run() {
        GameObject.runAll();
        // checkDie();
    }

}
