/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pacman.models;

import Pacman.gui.GamePanel;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.TimerTask;
import java.util.Timer;

/**
 *
 * @author ugur
 */
public class Speelboard {

    public Timer tim = new Timer();
    public TimerTask timtask = new TimerTask() {

        @Override
        public void run() {
            if (!FirstRun) {
                for (Iterator it = vakken.iterator(); it.hasNext();) {
                    Vakje vakje = (Vakje) it.next();
                    if (vakje.hasdronkenspookje()) {
                        if (vakje.dronkenSpookje() instanceof DronkenSpook) {
                            ((DronkenSpook) vakje.dronkenSpookje()).RandomMove();
                        }
                    }
                }
                gamepanel.repaint();
            }
        }
    };

    private ArrayList<Vakje> vakjes;
    public ArrayList<SpelElement> spelElements;
    public LevelHandler levelhandler = new LevelHandler();
    private int[] level;
    public Pacman pacman;
    public DronkenSpook dronkenspook;
    public ArrayList<DronkenSpook> dronkenspookjes = new ArrayList<>();
    public static int aantalBolletjes;
    int timeplayed = 1;

    Vakje vak;
    private GamePanel gamepanel;

    public Speelboard(GamePanel gamepanel) {
        this.setLevel(levelhandler.level_one);
        this.laden();
        this.gamepanel = gamepanel;

    }

    private List vakken = new ArrayList<Vakje>();

    public void setLevel(int[] level) {
        this.level = level;
    }

    public Speelboard() {
        this.setLevel(levelhandler.level_one);
        this.laden();
    }

    public void laden() {

        vakken = new ArrayList<>();
        for (int i = 0; i < level.length; i++) {

            switch (level[i]) {
                case 0:
                    aantalBolletjes = aantalBolletjes + 1;
                    vakken.add(new Leegvakje(new NormaalBolletje()));
                    break;
                case 1:
                    vakken.add(new Muur(40, 40, 40, 40));
                    break;
                case 2:
                    vakken.add(new Leegvakje(new IntelligentSpook()));
                    break;
                case 3:
                    pacman = new Pacman();
                    vakken.add(new Leegvakje(pacman));
                    break;
                case 4:
                    dronkenspook = new DronkenSpook();

                    vakken.add(new Leegvakje(dronkenspook));
                    break;
                case 5:
                    vakken.add(new Leegvakje(new SuperBolletje()));
                    break;
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

            // Dit checkt of er kolommen naast zijn
            if (i % levelhandler.rowMax == 0) {
                vakje.toevoegenBuurVakje(Direction.EAST, (Vakje) vakken.get(i + 1));
            } else if (i % levelhandler.rowMax == levelhandler.rowMax - 1) {
                vakje.toevoegenBuurVakje(Direction.WEST, (Vakje) vakken.get(i - 1));
            } else {
                vakje.toevoegenBuurVakje(Direction.EAST, (Vakje) vakken.get(i + 1));
                vakje.toevoegenBuurVakje(Direction.WEST, (Vakje) vakken.get(i - 1));
            }

            // Dit checkt of er rijen boven en onder zijn
            if (Math.floor(i / levelhandler.rowMax) == 0) {
                vakje.toevoegenBuurVakje(Direction.SOUTH, (Vakje) vakken.get(i + levelhandler.rowMax));
            } else if (Math.floor(i / levelhandler.rowMax) == this.level.length / levelhandler.rowMax - 1) {
                vakje.toevoegenBuurVakje(Direction.NORTH, (Vakje) vakken.get(i - levelhandler.rowMax));
            } else {
                vakje.toevoegenBuurVakje(Direction.SOUTH, (Vakje) vakken.get(i + levelhandler.rowMax));
                vakje.toevoegenBuurVakje(Direction.NORTH, (Vakje) vakken.get(i - levelhandler.rowMax));
            }

            i++;

            if (i % levelhandler.rowMax == 0) {
                y = y + vakje.getHeight();
                x = 0;
            }

        }
        pacman.setActive(true);
        FirstRun = false;
    }

    public void plaatsKers() {
        ArrayList<Vakje> vakjes = this.zoekLeegVakje();
        Random random = new Random();

        Vakje kersVak = vakjes.get(random.nextInt(vakjes.size()));

        Kers kersje = new Kers();

        kersje.setVakje(kersVak);
        kersVak.addSpelElement(kersje);
    }

    private ArrayList<Vakje> zoekLeegVakje() {
        ArrayList<Vakje> LeegVakjes = new ArrayList<>();
        for (int i = 0; i < level.length; i++) {
            if (this.vak.getSpelElement().isEmpty()) {
                LeegVakjes.add(this.vak);
            }
        }

        return LeegVakjes;
    }

    public Speelboard(ArrayList<SpelElement> spelElements, ArrayList<Vakje> vakjes) {
        this.spelElements = spelElements;
        this.vakjes = vakjes;
    }
    public boolean FirstRun = true;

    public void draw(Graphics g) {

        g.setColor(Color.BLACK);
        g.fillRect(1, 400, 200, 100);
        g.setColor(Color.white);
        g.setFont(new Font("TimesRoman", Font.CENTER_BASELINE, 24));
        g.drawString("score: " + pacman.getgegetenbolletje(), 40, 470);

        for (Iterator it = vakken.iterator(); it.hasNext();) {

            Vakje vakje = (Vakje) it.next();

            vakje.draw(g);

        }
    }

    public void volgendeLevel() {
        timeplayed++;

        switch (timeplayed) {
            case 2:
                this.setLevel(levelhandler.level_two);
                break;
            case 3:
                this.setLevel(levelhandler.level_three);
                break;
        }

        if (timeplayed > 3) {
// hier methoden stop spel
            System.out.println("spel ends");
        }
        this.laden();
    }

    public ArrayList<Vakje> getVakjes() {
        return vakjes;
    }

    public ArrayList<SpelElement> getSpelElements() {
        return spelElements;
    }

    public int getaantalbolletje() {
        return aantalBolletjes;
    }

    public void setaantalbolletjes(int aantalbolletjes) {
        aantalBolletjes = aantalbolletjes;
    }

}
