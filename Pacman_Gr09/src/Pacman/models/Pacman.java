package Pacman.models;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Ugur
 */
public class Pacman extends Poppetje {

    private Direction direction = Direction.EAST;
    private boolean isActive = false;
    private boolean isInvincible = false;
    boolean tijd = false;
    private int aantalGegetenBolletjes;
    private long begin;
    Pacman Pacman;

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

    private void setpacmanNextPosition(Vakje newvakje) {

        this.getVakje().removeSpelElement(this);

        newvakje.addSpelElement(this);
        if (newvakje.hasNormaalBolletje()) {

            newvakje.removeSpelElement(newvakje.normaalBollentje());
            this.aantalGegetenBolletjes = this.aantalGegetenBolletjes + 1;
            if (aantalGegetenBolletjes == Speelboard.aantalBolletjes / 2) {
                System.out.println("kersje is er");
                // new Speelboard().plaatsKers();
                new Speelboard().volgendeLevel();

            }

            if (aantalGegetenBolletjes >= Speelboard.aantalBolletjes) {
                System.out.println("next level");

            }
        }

        if (newvakje.hasSuperBollentje()) {
            newvakje.removeSpelElement(newvakje.superBollentje());
            begin = System.currentTimeMillis() / 1000;
            isInvincible = true;

        }
        if (newvakje.hasdronkenspookje()) {
            if (!isInvincible) {
                newvakje.removeSpelElement(this);
            } else {
                newvakje.removeSpelElement(newvakje.dronkenSpookje());
            }

        }

        if (newvakje.hasKersje()) {
            newvakje.removeSpelElement(newvakje.Kersje());

        }

        this.setVakje(newvakje);
    }

    @Override
    public void Bewegen(Direction direction) {
        if (this.isActive) {
            if (this.canMove(direction)) {
                this.direction = direction;
                this.setpacmanNextPosition(this.moveVakje(direction));
            }
        }
    }

    public void setActive(boolean active) {
        this.isActive = active;
    }

    public void setgegetenbolletjes(int aantalgegeten) {
        aantalGegetenBolletjes = aantalgegeten;
    }

    public int getgegetenbolletje() {
        return aantalGegetenBolletjes;
    }

}
