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
    Vakje startPosition = null;
    Speelboard speelboard;

    public abstract void draw(Graphics g); //force children to implement = override

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setVakje(Vakje vakje) {
        this.vakje = vakje;
    }

    public Vakje getVakje() {
        return this.vakje;
    }

    public Vakje getstartPositie() {
        return this.startPosition;
    }

    public void setStartPositie(Vakje vakje) {
        this.startPosition = vakje;
    }

}
