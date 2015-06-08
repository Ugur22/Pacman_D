package Pacman.models;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Ugur
 */
public class Pacman extends Poppetje implements ActionListener {

    private Direction direction = Direction.EAST;
    private boolean isActive = false;
    private boolean isInvincible = false;
    boolean tijd = false;
    private int aantalGegetenBolletjes;
    private long begin;

    public Pacman(Vakje vakje) {
        this.vakje = vakje;
    }

    public Pacman() {

    }

    @Override
    public void draw(Graphics g) {

        if (begin + 10 == System.currentTimeMillis() / 1000) {
            isInvincible = false;
        }

        if (isInvincible) {
            g.setColor(Color.BLUE);
        } else {
            g.setColor(Color.ORANGE);
        }

        switch (direction) {
            case EAST:
                g.fillArc(vakje.getxPos(), vakje.getyPos(), vakje.getWidth(), vakje.getHeight(), 30, 300);
                break;

            case NORTH:
                g.fillArc(vakje.getxPos(), vakje.getyPos(), vakje.getWidth(), vakje.getHeight(), 120, 300);
                break;

            case WEST:
                g.fillArc(vakje.getxPos(), vakje.getyPos(), vakje.getWidth(), vakje.getHeight(), 210, 300);
                break;

            case SOUTH:
                g.fillArc(vakje.getxPos(), vakje.getyPos(), vakje.getWidth(), vakje.getHeight(), 300, 300);
                break;
        }

    }

    private void setpacmanPosition(Vakje vakje) {
        this.getVakje().removeSpelElement(this);
        vakje.addSpelElement(this);
        if (vakje.hasNormaalBolletje()) {

            vakje.removeSpelElement(vakje.normaalBollentje());
            this.aantalGegetenBolletjes = this.aantalGegetenBolletjes + 1;
            if (aantalGegetenBolletjes == Speelboard.aantalBolletjes / 2) {
                System.out.println("kersje is er");
                //speelboard.plaatsKers();
            }

            if (aantalGegetenBolletjes >= Speelboard.aantalBolletjes) {
                System.out.println("next level");
                //speelboard.volgendeLevel();
            }
        }

        if (vakje.hasSuperBollentje()) {
            vakje.removeSpelElement(vakje.superBollentje());
            begin = System.currentTimeMillis() / 1000;
            isInvincible = true;

        }
        if (vakje.hasdronkenspookje()) {
            if (!isInvincible) {
                vakje.removeSpelElement(this);
            } else {
                vakje.removeSpelElement(vakje.dronkenSpookje());
            }

        }

        if (vakje.hasKersje()) {
            vakje.removeSpelElement(vakje.Kersje());

        }

        this.setVakje(vakje);
    }

    @Override
    public void Bewegen(Direction direction) {
        if (this.isActive) {
            if (this.canMove(direction)) {
                this.direction = direction;
                this.setpacmanPosition(this.moveVakje(direction));
            }
        }
    }

    public void setActive(boolean active) {
        this.isActive = active;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
    }

    public void setgegetenbolletjes(int aantalgegeten) {
        aantalGegetenBolletjes = aantalgegeten;
    }

    public int getgegetenbolletje() {
        return aantalGegetenBolletjes;
    }

}
