package Pacman.models;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author remcoruijsenaars
 */
public abstract class SpelElement {

    Color color;
    int xPos;
    int yPos;
    int height;
    int width;
    Vakje vakje;
    public SpelElement(Vakje vakje, Color color, int xPos, int yPos, int height, int width) {
        this.color = color;
        this.xPos = xPos;
        this.yPos = yPos;
        this.height = height;
        this.width = width;
        this.vakje = vakje;
    }

    public abstract void draw(Graphics g); //force children to implement = override

    

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
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
