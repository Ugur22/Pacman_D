/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pacman.models;

import java.awt.Graphics;
import java.util.ArrayList;

/**
 *
 * @author ugur
 */
public class Vakje {
    
    private Vakje buurvakje;
    private Vakje vakje;
    public int xPos =0;
    public int yPos =0;
    public int height= 40;
    public int width = 40;
    
    public SpelElement bevat;
    
    public Vakje(int xPos, int yPos, int height, int width) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.height = height;
        this.width = width;
    }
    
    public Vakje(SpelElement spelelement) {
        
        this.bevat = spelelement;
       this.bevat.setVakje(this);
        
    }
    
    public void draw(Graphics g) {

        this.bevat.vakje.setxPos(this.getxPos());
                this.bevat.vakje.setyPos(this.getyPos());
                this.bevat.vakje.setWidth(this.getWidth());
                this.bevat.vakje.setHeight(this.getHeight());
                this.bevat.draw(g);
        
        
    }
    
    public boolean isMuur() {
        return (this.bevat instanceof Muur);
    }
    
    public boolean isNormaalBolletje() {
        return (this.bevat instanceof Fruit);
    }
    
    public boolean isPacman() {
        
        return (this.bevat instanceof Pacman);
        
    }
    
    public void Setbuurvakje(Vakje buurVakje) {
        this.buurvakje = buurVakje;
    }
    
    public void Setvakje(Vakje vakje) {
        this.vakje = vakje;
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
