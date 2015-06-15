package Pacman.models;

import Pacman.gui.GamePanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

/**
 *
 * @author Ugur
 */
public class Pacman extends Poppetje {

    private Direction direction = Direction.EAST;
    private boolean isActive = false;
    private boolean isInvincible = false;
    boolean tijd = false;
    public int aantalGegetenBolletjes;
    public int score;
    public int levens = 3;
    private long begin;
    DronkenSpook dronkenspook;
    Pacman Pacman;
    GamePanel gamepanel;
    private boolean gamestatus = true;

    public Pacman(Vakje vakje) {
        this.vakje = vakje;
    }

    public Pacman() {

    }

    @Override
    public void draw(Graphics g) {

        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        if (begin + 10 == System.currentTimeMillis() / 1000) {
            isInvincible = false;
        }

        if (isInvincible) {

            g2.setColor(Color.BLUE);
        } else {
            g2.setColor(Color.ORANGE);
        }

        switch (direction) {
            case EAST:
                g2.fillArc(vakje.getxPos(), vakje.getyPos(), vakje.getWidth(), vakje.getHeight(), 30, 300);
                break;

            case NORTH:
                g2.fillArc(vakje.getxPos(), vakje.getyPos(), vakje.getWidth(), vakje.getHeight(), 120, 300);
                break;

            case WEST:
                g2.fillArc(vakje.getxPos(), vakje.getyPos(), vakje.getWidth(), vakje.getHeight(), 210, 300);
                break;

            case SOUTH:
                g2.fillArc(vakje.getxPos(), vakje.getyPos(), vakje.getWidth(), vakje.getHeight(), 300, 300);
                break;
        }

    }

    public void checkLevend() {
        if (levens == 0) {
            gamestatus = false;

        }

    }

    private void eetBolletje(Vakje newvakje) {

        this.score += ((NormaalBolletje) newvakje.get(NormaalBolletje.class)).points;
        newvakje.removeSpelElement(newvakje.get(NormaalBolletje.class));
        this.aantalGegetenBolletjes = this.aantalGegetenBolletjes + 1;

    }

    private void eetSuperBolletje(Vakje newvakje) {
        newvakje.removeSpelElement(newvakje.get(SuperBolletje.class));
        begin = System.currentTimeMillis() / 1000;
        isInvincible = true;
    }

    private void eetspook(Vakje newvakje) {
        if (!isInvincible) {
            newvakje.removeSpelElement(this);
            levens = levens - 1;
            checkLevend();
        } else {
            newvakje.removeSpelElement(newvakje.get(DronkenSpook.class));

        }
    }

    private void eetKers(Vakje newvakje) {
        this.score += ((Kers) newvakje.get(Kers.class)).points;
        newvakje.removeSpelElement(newvakje.get(Kers.class));
    }

    private void setpacmanNextPosition(Vakje newvakje) {

        this.getVakje().removeSpelElement(this);

        newvakje.addSpelElement(this);

        if (newvakje.has(NormaalBolletje.class)) {

            eetBolletje(newvakje);
        }

        if (newvakje.has(SuperBolletje.class)) {
            eetSuperBolletje(newvakje);

        }
        if (newvakje.has(DronkenSpook.class)) {
            eetspook(newvakje);
        }

        if (newvakje.has(Kers.class)) {
            eetKers(newvakje);
        }

        this.setVakje(newvakje);
    }

    /* Deze gebruikt de gezetten direction */
    public void Bewegen() {
        if (this.isActive) {
            if (this.canMove(this.direction)) {
                this.setpacmanNextPosition(this.moveVakje(this.direction));
            }
        }
    }
    /* Deze zet een nieuwe direction en beweegt hem hier naar toe. */

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

    public boolean getcheckGamestatus() {
        return gamestatus;
    }

    public void SetcheckGamestatus(boolean gamestatus) {
        this.gamestatus = gamestatus;
    }

    public int getgegetenbolletje() {
        return aantalGegetenBolletjes;
    }

}
