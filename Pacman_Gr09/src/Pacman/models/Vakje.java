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
    public HashMap<Direction, Vakje> buren = new HashMap<Direction, Vakje>();
    //Hierin komen alle vakjes (omdat je ze dan op 1 plaats heb staan).
    private static ArrayList<Vakje> alleVakjes = new ArrayList<Vakje>();
    private int xPos = 0;
    private int yPos = 0;
    private int height = 40;
    private int width = 40;
    private Pacman pacman;
    private DronkenSpook dronkenspook;

    public Vakje(int xPos, int yPos, int height, int width) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.height = height;
        this.width = width;
        Vakje.alleVakjes.add(this);
    }

    public Vakje(int xPos, int yPos, int height, int width, Pacman pacman, DronkenSpook dronkenspook) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.height = height;
        this.width = width;
        this.pacman = pacman;
        this.dronkenspook = dronkenspook;
        Vakje.alleVakjes.add(this);
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

    public SpelElement get(Class c) {
        for (SpelElement se : this.spelElementen) {
            if (c.isInstance(se)) {
                return (SpelElement) c.cast(se);
            }
        }
        return null;
    }

    public boolean has(Class c) {
        for (SpelElement se : this.spelElementen) {
            if (c.isInstance(se)) {
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

    public boolean isEmpty() {
        return this.spelElementen.isEmpty();
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
