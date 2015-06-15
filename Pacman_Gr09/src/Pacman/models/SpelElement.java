package Pacman.models;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author remcoruijsenaars
 */
public abstract class SpelElement {

    Vakje vakje;
    Speelboard speelboard;

    public abstract void draw(Graphics g); //force children to implement = override

    public void setVakje(Vakje vakje) {
        this.vakje = vakje;
    }

    public Vakje getVakje() {
        return this.vakje;
    }

}
