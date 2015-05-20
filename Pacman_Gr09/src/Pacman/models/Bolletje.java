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
public class Bolletje extends SpelElement {

    public Bolletje(Vakje vakje, int xPos, int yPos, int height, int width) {
        super(vakje, Color.ORANGE, xPos, yPos, width, height);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(getColor());
        g.fillRoundRect(getxPos()+getHeight()/4, getyPos()+getWidth()/4, getHeight()/2, getWidth()/2,getHeight()/2, getWidth()/2);
    }

}
