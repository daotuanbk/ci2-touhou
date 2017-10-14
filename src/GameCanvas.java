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
    ArrayList<PlayerSpell> spells = new ArrayList<>();


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


    }

    public void render() {
        //1. Draw everything on backbuffer
        backGraphics.drawImage(background, backgroundX, backgroundY, null);
        player.render(backGraphics);

        for (PlayerSpell spell: spells) {
            spell.render(backGraphics);
        }
        repaint();

        //2. Call repaint

    }
    public void keyPressed(KeyEvent e) {
        player.keyPressed(e);

    }

    public void keyReleased(KeyEvent e) {
        player.keyReleased(e);



    }

    @Override
    //2. Draw background
       protected void paintComponent(Graphics g) {
        g.drawImage(backBuffer, 0, 0, null);
    }
    public void run () {
        player.run();
        player.shoot(spells);
        
        for (PlayerSpell spell: spells) {
            spell.run();
        }
    }

}
