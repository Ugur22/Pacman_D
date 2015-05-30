/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pacman.models;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author ugur
 */
public class Speelboard {

    private ArrayList<Vakje> vakjes;
    public ArrayList<SpelElement> spelElements;
    public LevelHandler levelhandler = new LevelHandler();
    private int[] level;
    public Vakje pacmanStartVakje = new Vakje(new Pacman());
    public int aantalBolletjes;

    private List vakken = new ArrayList<Vakje>();

    public void setLevel(int[] level) {
        this.level = level;
    }

    public Speelboard() {
        this.setLevel(levelhandler.level_one);
        this.laden();
    }

    public void laden() {
        vakken = new ArrayList<Vakje>();

        for (int i = 0; i < level.length; i++) {
            if (level[i] == 1) {
                vakken.add(new Vakje(new Muur()));
            } else if (level[i] == 0) {
                aantalBolletjes = aantalBolletjes + 1;
                vakken.add(new Vakje(new NormaalBolletje()));
            } else if (level[i] == 2) {
                vakken.add(new Vakje(new SmartGhost()));
            } else if (level[i] == 3) {
                vakken.add(this.pacmanStartVakje);
            } else if (level[i] == 4) {
                vakken.add(new Vakje(new DrunkSpook()));

            }
        }
        this.vakjesVerdelen();

    }

    private void vakjesVerdelen() {
        int y = 0;
        int x = 0;
        int i = 0;
        for (Iterator it = vakken.iterator(); it.hasNext();) {

            Vakje vakje = (Vakje) it.next();

            vakje.setyPos(y);
            vakje.setxPos(x);
            x = x + vakje.getWidth();
            i++;

            if (i % levelhandler.rowMax == 0) {
                y = y + vakje.getHeight();
                x = 0;
            }

        }
    }

    public Speelboard(ArrayList<SpelElement> spelElements, ArrayList<Vakje> vakjes) {
        this.spelElements = spelElements;
        this.vakjes = vakjes;
    }

    public void draw(Graphics g) {
        for (Iterator it = vakken.iterator(); it.hasNext();) {

            Vakje vakje = (Vakje) it.next();
            vakje.draw(g);

        }
    }

    public ArrayList<Vakje> getVakjes() {
        return vakjes;
    }

    public ArrayList<SpelElement> getSpelElements() {
        return spelElements;
    }

}
