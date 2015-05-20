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

    int startpositie = 0;

    public Poppetje(Vakje vakje, Color color, int xPos, int yPos, int height, int width) {
        super(vakje, color, xPos, yPos, height, width);
    }

    //draw method
    @Override
    public void draw(Graphics g) {

    }

    public abstract void Bewegen(Direction direction);

}
