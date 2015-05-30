package Pacman.models;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author remcoruijsenaars
 */
public abstract class SpelElement {

    Color color;
    Vakje vakje;

 

    public abstract void draw(Graphics g); //force children to implement = override

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    void setVakje(Vakje aThis) {
        this.vakje = aThis;
    }

}
