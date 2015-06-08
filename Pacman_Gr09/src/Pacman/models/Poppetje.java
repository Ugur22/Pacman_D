/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pacman.models;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author ugur
 */
public abstract class Poppetje extends SpelElement {

    protected boolean canMove(Direction dir) {
        return this.getVakje().canMove(dir);
    }

    protected Vakje moveVakje(Direction dir) {
        return this.getVakje().getBuur(dir);
    }

    //draw method
    @Override
    public void draw(Graphics g) {

    }

    public abstract void Bewegen(Direction direction);

}
