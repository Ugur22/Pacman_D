/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pacman.models;

import java.awt.Color;

/**
 *
 * @author ugur
 */
public abstract class Spookje extends Poppetje {

    private final static int MOVEMENT = 80;

    @Override
    public void Bewegen(Direction direction) {

        switch (direction) {
            case NORTH:
                vakje.yPos -= MOVEMENT;
                break;
            case SOUTH:
                vakje.yPos += MOVEMENT;
                break;
            case WEST:
                vakje.xPos -= MOVEMENT;
                break;
            case EAST:
                vakje.xPos += MOVEMENT;
                break;

        }
    }

}
