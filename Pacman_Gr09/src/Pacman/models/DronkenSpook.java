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
import java.util.ArrayList;
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
            /* Voor scherpere rendering */
            Graphics2D g2 = (Graphics2D) g;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.drawImage(ImageIO.read(new File("drunk.png")), vakje.getxPos(), vakje.getyPos(), vakje.getWidth(), vakje.getHeight(), null);
        } catch (IOException ex) {
            Logger.getLogger(Spookje.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    Random rand = new Random();
    
    public void Move() {
        int random = rand.nextInt(5);
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
            ArrayList<Direction> directions = new ArrayList<Direction>();
            directions.add(dir);
            Move(directions);
        }
    }
    public void Move(ArrayList<Direction> oldpositions) {
        ArrayList<Direction> possible= new ArrayList<Direction>();
        if (oldpositions.indexOf(Direction.EAST) == -1) {
            possible.add(Direction.EAST);
        }
        if (oldpositions.indexOf(Direction.WEST) == -1) {
            possible.add(Direction.WEST);
        }
        if (oldpositions.indexOf(Direction.NORTH) == -1) {
            possible.add(Direction.NORTH);
        }
        if (oldpositions.indexOf(Direction.SOUTH) == -1) {
            possible.add(Direction.SOUTH);
        }
//         //Direction dir = possible.g
//        if (this.canMove(dir)) {
//            this.getVakje().removeSpelElement(this);
//            Vakje x = this.moveVakje(dir);
//            x.addSpelElement(this);
//            this.setVakje(x);
//        } else {
//            ArrayList<Direction> directions = new ArrayList<Direction>();
//            directions.add(dir);
//            Move(directions);
//        }
        
        
    } 

}
