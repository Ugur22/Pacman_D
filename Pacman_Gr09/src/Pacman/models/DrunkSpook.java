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
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author ugur
 */
public class DrunkSpook extends Spookje {

    @Override
    public void draw(Graphics g) {
        try {
            g.drawImage(ImageIO.read(new File("drunk.png")), vakje.getxPos(), vakje.getyPos(), vakje.getWidth(), vakje.getHeight(), null);
        } catch (IOException ex) {
            Logger.getLogger(Spookje.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void RandomMove() {
        Random rand = new Random();
        int random = rand.nextInt(5);

        switch (random) {
            case 1:
                Bewegen(Direction.SOUTH);
                break;
            case 2:
                Bewegen(Direction.NORTH);
                break;
            case 3:
                Bewegen(Direction.EAST);
                break;
            case 4:
                Bewegen(Direction.WEST);
                break;
        }
    }

}
