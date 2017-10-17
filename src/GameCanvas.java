import touhou.Enemy;
import touhou.EnemySpell;
import touhou.PlayerSpell;
import touhou.Player;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import static java.awt.event.KeyEvent.VK_X;

public class GameCanvas extends JPanel {

    BufferedImage background;
    int backgroundX = 0;
    int backgroundY = 0;


    BufferedImage backBuffer;
    Graphics backGraphics;

    Player player = new Player(); //=null
    Enemy enemy = new Enemy();
    ArrayList<PlayerSpell> spells = new ArrayList<>();
    ArrayList<EnemySpell> eSpells = new ArrayList<>();
    ArrayList<Enemy> enemies = new ArrayList<>();


    public GameCanvas() {
        //0. Create back buffer
        backBuffer = new BufferedImage(800, 600, BufferedImage.TYPE_INT_ARGB);
        backGraphics = backBuffer.getGraphics();
        enemies.add(new Enemy());
        //1. Load background
        try {
            background = ImageIO.read(new File("assets/images/background/0.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void render() {
        //1. Draw everything on backbuffer
        backGraphics.drawImage(background, backgroundX, backgroundY, null);
        for (PlayerSpell spell : spells) {
            spell.render(backGraphics);
        }
        for (EnemySpell eSpell : eSpells) {
            eSpell.render(backGraphics);
        }
        for (Enemy enemy : enemies) {
            enemy.render(backGraphics);
        }
            player.render(backGraphics);


        //2. Call repaint
        repaint();
    }

    public void keyPressed(KeyEvent e) {
        player.keyPressed(e);

    }

    public void keyReleased(KeyEvent e) {
        player.keyReleased(e);


    }

    public void checkDie() {
        for (int i = 0; i < spells.size(); i++) {
            PlayerSpell spell = spells.get(i);
            for (int j = 0; j < enemies.size(); j++) {
                Enemy enemyDie = enemies.get(j);
                if (spell.pSpellBounds().intersects(enemy.eBounds())) {
                    spells.remove(spell);
                    enemies.remove(enemyDie);
                    i--;
                    System.out.println("true");
                    break;
                }
            }
        }
        for (int i = 0; i < eSpells.size(); i++) {
            EnemySpell espell = eSpells.get(i);
            if (espell.eSpellBounds().intersects(player.pBounds())) {
                eSpells.remove(espell);
                System.exit(0);
                break;
            }
        }

    }

    @Override
    //2. Draw background
    protected void paintComponent(Graphics g) {
        g.drawImage(backBuffer, 0, 0, null);
    }

    public void run() {
        player.run();
        player.shoot(spells);

        for (PlayerSpell spell : spells) {
            spell.run();
        }
        for (EnemySpell eSpell : eSpells) {
            eSpell.run();
        }
        for (Enemy enemy : enemies) {
            enemy.run();
            enemy.shoot(eSpells);
        }
        checkDie();
    }

}
