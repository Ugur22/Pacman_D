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
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.Timer;

/**
 *
 * @author ugur
 */
public class Speelboard {

    public Timer timdronkenspook = new Timer(400, new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (!FirstRun) {

                for (Vakje vakje : vakken) {
                    if (vakje.has(DronkenSpook.class)) {
                        if (vakje.get(DronkenSpook.class) instanceof DronkenSpook) {
                            ((DronkenSpook) vakje.get(DronkenSpook.class)).Move();
                        }

                    }
                }

                gamepanel.repaint();
            }
        }
    });

    public Timer timslimspook = new Timer(100, new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (!FirstRun) {
                for (Vakje vakje : vakken) {
                    if (vakje.has(IntelligentSpook.class)) {
                        if (vakje.get(IntelligentSpook.class) instanceof IntelligentSpook) {
                            ((IntelligentSpook) vakje.get(IntelligentSpook.class)).Move();
                        }
                    }
                }

                gamepanel.repaint();
            }

        }
    });

    public Timer timpacman = new Timer(190, new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (!FirstRun) {
                pacman.Bewegen();

            }

            if (pacman.getgegetenbolletje() > aantalBolletjes / 2 && toonKers) {
                plaatsKers();
                toonKers = false;
            }

            if (pacman.getgegetenbolletje() == aantalBolletjes) {

                aantalBolletjes = 0;
                volgendeLevel();

                gamepanel.addkeyPacman();
            }
            gamepanel.repaint();

        }
    });

    public ArrayList<Vakje> vakken = new ArrayList<Vakje>();

    private ArrayList<Vakje> vakjes;
    public ArrayList<SpelElement> spelElements;
    public LevelHandler levelhandler = new LevelHandler();
    private int[] level;
    public Pacman pacman;
    public DronkenSpook dronkenspook;
    public int aantalBolletjes;
    public int timeplayed = 1;
    private boolean toonKers = true;

    Image gameover = new ImageIcon("gameover.png").getImage();
    Image win = new ImageIcon("youwin.png").getImage();

    Vakje vak;
    public GamePanel gamepanel;

    public Speelboard(GamePanel gamepanel) {
        this.setLevel(levelhandler.level_one);
        this.laden();
        this.gamepanel = gamepanel;

    }

    public void setLevel(int[] level) {
        this.level = level;
    }

    public int[] getLevel() {
        return level;
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
                    vakken.add(new Leegvakje(new NormaalBolletje(10)));
                    break;
                case 1:
                    vakken.add(new Muur(40, 40, 40, 40));
                    break;
                case 2:
                    vakken.add(new Leegvakje(new IntelligentSpook(pacman)));
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
                    vakken.add(new Leegvakje(new SuperBolletje(0)));
                    break;
            }
        }
        this.vakjesVerdelen();

    }

    private void vakjesVerdelen() {
        int y = 0;
        int x = 0;
        int i = 0;
        for (Vakje vakje : vakken) {
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

        Kers kersje = new Kers(100);
        kersje.setVakje(kersVak);
        kersVak.addSpelElement(kersje);
    }

    private void endGame(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        if (pacman.getcheckGamestatus() == false) {
            gamepanel.stop();
            pacman.setActive(false);
            g2.setColor(Color.black);
            g2.fillRect(0, 0, 1240, 687);

            g2.setColor(Color.white);
            g2.setFont(new Font("TimesRoman", Font.PLAIN, 24));

            if (timeplayed <= 3) {
                g2.drawImage(gameover, -100, 0, 1100, 500, null);
            } else if (timeplayed == 4) {
                g2.drawImage(win, -180, 0, 1100, 500, null);
            }

            g2.setFont(new Font("TimesRoman", Font.PLAIN, 20));
            g2.drawString("Uw score: " + pacman.score, 360, 500);
            g2.drawString("Druk op R om opnieuw te starten of druk op de restart knop", 200, 50);
        }
    }

    private ArrayList<Vakje> zoekLeegVakje() {
        ArrayList<Vakje> LeegVakjes = new ArrayList<>();
        for (Vakje vakje : this.vakken) {
            if (vakje.isEmpty()) {
                LeegVakjes.add(vakje);
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

        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.BLACK);
        g2.fillRect(1, 400, 200, 100);
        g2.setColor(Color.white);
        g2.setFont(new Font("Helvetica Neue", Font.CENTER_BASELINE, 24));
        g2.setRenderingHint(
                RenderingHints.KEY_TEXT_ANTIALIASING,
                RenderingHints.VALUE_TEXT_ANTIALIAS_GASP);
        g2.drawString("Score: " + pacman.score, 40, 470);
        g2.drawString("levens: " + pacman.levens, 40, 500);

        g2.setColor(Color.lightGray);

        for (Vakje vakje : vakken) {
            vakje.draw(g);
        }
        endGame(g);

    }

    public void volgendeLevel() {
        timeplayed++;

        switch (timeplayed) {
            case 2:
                timdronkenspook.setDelay(300);
                this.setLevel(levelhandler.level_two);

                break;
            case 3:
                timdronkenspook.setDelay(230);
                this.setLevel(levelhandler.level_three);
                break;
        }

        if (timeplayed <= 3) {
            this.laden();

        } else {
            pacman.SetcheckGamestatus(false);
        }
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
