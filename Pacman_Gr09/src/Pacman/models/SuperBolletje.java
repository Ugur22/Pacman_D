/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pacman.models;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

/**
 *
 * @author ugur
 */
public class SuperBolletje extends Fruit {

    public SuperBolletje(int point) {
        super(0);
    }

    @Override
    public void draw(Graphics g) {
        /* Voor scherpere rendering */
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(Color.white);
        g2.fillRoundRect(vakje.getxPos() + vakje.getHeight() / 4, vakje.getyPos() + vakje.getWidth() / 4, vakje.getHeight() / 2, vakje.getWidth() / 2,
                vakje.getHeight() / 2, vakje.getWidth() / 2);
    }

}
