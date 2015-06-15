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
public class IntelligentSpook extends Spookje {

    Pacman pacman;

    public IntelligentSpook(Pacman pacman) {
        this.pacman = pacman;
    }

    @Override
    public void draw(Graphics g) {
        try {
            /* Voor scherpere rendering */
            Graphics2D g2 = (Graphics2D) g;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.drawImage(ImageIO.read(new File("smart.png")), vakje.getxPos(), vakje.getyPos(), vakje.getWidth(), vakje.getHeight(), null);
        } catch (IOException ex) {
            Logger.getLogger(Spookje.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void Move() {

        if (!this.searching) {
            setSearching(true);
            findPacman();
        }
        if (this.movementStack.size() > 0) {
            Vakje vakje = this.movementStack.pop();

            this.getVakje().removeSpelElement(this);
            Vakje x = this.moveToVakje(vakje);
            x.addSpelElement(this);
            this.setVakje(x);
        }
    }

}
