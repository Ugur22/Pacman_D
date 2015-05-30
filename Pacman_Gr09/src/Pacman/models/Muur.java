/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pacman.models;

import java.awt.Color;
import java.awt.Graphics;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author ugur
 */


public class Muur extends SpelElement {
    
    public Muur(){
        
    }

    @Override
    public void draw(Graphics g) {
        try {
            g.drawImage(ImageIO.read(new File("wall.png")), vakje.getxPos(), vakje.getyPos(), vakje.getWidth(), vakje.getHeight(), null);
        } catch (IOException ex) {
            Logger.getLogger(Spookje.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
