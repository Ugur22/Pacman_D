/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pacman.models;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author ugur
 */
public abstract class Vakje {

    private ArrayList<SpelElement> spelElementen = new ArrayList<SpelElement>();
    private HashMap<Direction, Vakje> buren = new HashMap<Direction, Vakje>();

    public int xPos = 0;
    public int yPos = 0;
    public int height = 40;
    public int width = 40;
    private Pacman pacman;
    private DronkenSpook dronkenspook;

    public Vakje(int xPos, int yPos, int height, int width) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.height = height;
        this.width = width;
    }

    public Vakje(int xPos, int yPos, int height, int width, Pacman pacman, DronkenSpook dronkenspook) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.height = height;
        this.width = width;
        this.pacman = pacman;
        this.dronkenspook = dronkenspook;
    }

    public boolean canMove(Direction dir) {
        return !(this.buren.get(dir) instanceof Muur);
    }

    public void toevoegenBuurVakje(Direction direction, Vakje leegvakje) {
        this.buren.put(direction, leegvakje);
    }

    public Vakje(SpelElement spelelement) {
        spelelement.setVakje(this);
        this.spelElementen.add(spelelement);
        if (spelelement instanceof Pacman) {
            this.pacman = (Pacman) spelelement;
        }
        if (spelelement instanceof DronkenSpook) {
            this.dronkenspook = (DronkenSpook) spelelement;
        }

    }

    public void draw(Graphics g) {
        for (SpelElement se : this.spelElementen) {
            se.vakje.setxPos(this.getxPos());
            se.vakje.setyPos(this.getyPos());
            se.vakje.setWidth(this.getWidth());
            se.vakje.setHeight(this.getHeight());
            se.draw(g);
        }
    }

    public boolean isMuur() {
        return (this instanceof Muur);
    }

    public SpelElement normaalBollentje() {
        for (SpelElement se : this.spelElementen) {
            if (se instanceof NormaalBolletje) {
                return (NormaalBolletje) se;
            }
        }
        return null;
    }

    public boolean hasNormaalBolletje() {
        for (SpelElement se : this.spelElementen) {
            if (se instanceof NormaalBolletje) {
                return true;
            }
        }
        return false;
    }

    public SpelElement superBollentje() {
        for (SpelElement se : this.spelElementen) {
            if (se instanceof SuperBolletje) {
                return (SuperBolletje) se;
            }
        }
        return null;
    }

    public boolean hasSuperBollentje() {
        for (SpelElement se : this.spelElementen) {
            if (se instanceof SuperBolletje) {
                return true;
            }
        }
        return false;
    }

    public SpelElement Kersje() {
        for (SpelElement se : this.spelElementen) {
            if (se instanceof Kers) {
                return (Kers) se;
            }
        }
        return null;
    }

    public boolean hasKersje() {
        for (SpelElement se : this.spelElementen) {
            if (se instanceof Kers) {
                return true;
            }
        }
        return false;
    }

    public SpelElement dronkenSpookje() {
        for (SpelElement se : this.spelElementen) {
            if (se instanceof DronkenSpook) {
                return (DronkenSpook) se;
            }
        }
        return null;
    }

    public boolean hasdronkenspookje() {
        for (SpelElement se : this.spelElementen) {
            if (se instanceof DronkenSpook) {
                return true;
            }
        }
        return false;
    }

    public boolean isPacman() {

        return (this.pacman != null);

    }

    public boolean isDronkenSpook() {
        return (this.dronkenspook != null);
    }

    public Vakje getBuur(Direction key) {
        return buren.get(key);
    }

    public void addSpelElement(SpelElement spelelement) {
        if (spelelement instanceof Pacman) {
            pacman = (Pacman) spelelement;
        }

        if (spelelement instanceof DronkenSpook) {
            dronkenspook = (DronkenSpook) spelelement;
        }
        this.spelElementen.add(spelelement);
    }

    public void removeSpelElement(SpelElement spelelement) {
        if (spelelement instanceof Pacman) {
            pacman = null;
        }

        if (spelelement instanceof DronkenSpook) {
            dronkenspook = null;
        }
        this.spelElementen.remove(spelelement);
    }

    public ArrayList<SpelElement> getSpelElement() {
        return this.spelElementen;
    }

    public int getxPos() {
        return xPos;
    }

    public void setxPos(int xPos) {
        this.xPos = xPos;
    }

    public int getyPos() {
        return yPos;
    }

    public void setyPos(int yPos) {
        this.yPos = yPos;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

}
