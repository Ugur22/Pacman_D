/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pacman.models;

/**
 *
 * @author ugur
 */

public class Vakje {

    private Vakje buurvakje;
    private Vakje vakje;
    public int xPos;
    public int yPos;
    public int height;
    public int width;
    
    public Vakje(int xPos, int yPos, int height, int width) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.height = height;
        this.width = width;
    }

    public void Setbuurvakje(Vakje buurVakje) {
        this.buurvakje = buurVakje;
    }

    public void Setvakje(Vakje vakje) {
        this.vakje = vakje;
    }
    
    
    
}
