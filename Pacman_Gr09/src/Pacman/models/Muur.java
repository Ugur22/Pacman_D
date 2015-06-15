/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pacman.models;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author ugur
 */
public class Muur extends Vakje {

    public Muur(int xPos, int yPos, int height, int width) {
        super(xPos, yPos, height, width);
    }

    @Override
    public void draw(Graphics g) {
        try {
            /* Voor scherpere rendering */
            Graphics2D g2 = (Graphics2D) g;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.drawImage(ImageIO.read(new File("wall.png")), getxPos(), getyPos(), getWidth(), getHeight(), null);
        } catch (IOException ex) {
            Logger.getLogger(Spookje.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
