/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pacman.models;

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
public class DronkenSpook extends Spookje {

    @Override
    public void draw(Graphics g) {
        try {
            g.drawImage(ImageIO.read(new File("drunk.png")), vakje.getxPos(), vakje.getyPos(), vakje.getWidth(), vakje.getHeight(), null);
        } catch (IOException ex) {
            Logger.getLogger(Spookje.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    Random rand = new Random();

    public void RandomMove() {
        int random = rand.nextInt(4);
        Direction dir = Direction.EAST;

        switch (random) {
            case 1:
                dir = Direction.EAST;
                break;
            case 2:
                dir = Direction.NORTH;
                break;
            case 3:
                dir = Direction.SOUTH;
                break;
            case 4:
                dir = Direction.WEST;
                break;

        }

        if (this.canMove(dir)) {
            this.getVakje().removeSpelElement(this);
            Vakje x = this.moveVakje(dir);
            x.addSpelElement(this);
            this.setVakje(x);
        } else {
            RandomMove();
        }
    }

}
