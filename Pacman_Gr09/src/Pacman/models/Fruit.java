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
public abstract class Fruit extends SpelElement {

    public int points;

    public Fruit(int point) {
        this.points = point;
    }
}
