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
public class NormaalBolletje extends Fruit {

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.ORANGE);
        g.fillRoundRect(vakje.getxPos() + vakje.getHeight() / 4, vakje.getyPos() + vakje.getWidth() / 4, vakje.getHeight() / 2, vakje.getWidth() / 2,
                vakje.getHeight() / 2, vakje.getWidth() / 2);
    }

}
