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
public abstract class Spookje extends Poppetje {

    private final static int MOVEMENT = 80;

    public Spookje(Vakje vakje, int xPos, int yPos, int height, int width) {
        super(vakje, null, xPos, yPos, height, width);
    }

   

    @Override
    public void Bewegen(Direction direction) {

        switch (direction) {
            case NORTH:
                yPos -= MOVEMENT;
                break;
            case SOUTH:
                yPos += MOVEMENT;
                break;
            case WEST:
                xPos -= MOVEMENT;
                break;
            case EAST:
                xPos += MOVEMENT;
                break;

        }
    }


}
