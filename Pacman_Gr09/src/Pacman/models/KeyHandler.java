/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pacman.models;

import Pacman.gui.GamePanel;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author ugur
 */
public class KeyHandler implements KeyListener {

    Pacman Pacman;
    GamePanel gp;
    public static String direction = "";

    public void setPacman(Pacman pacman) {
        this.Pacman = pacman;

    }

    public void setGamePanel(GamePanel gp) {
        this.gp = gp;
    }

    @Override
    public void keyTyped(KeyEvent ke) {
    }

    @Override
    public void keyPressed(KeyEvent ke) {
    }

    public int getKey(KeyEvent ke) {
        return ke.getKeyCode();
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        switch (getKey(ke)) {
            case KeyEvent.VK_DOWN:
                Pacman.Bewegen(Direction.SOUTH);
                break;
            case KeyEvent.VK_UP:
                Pacman.Bewegen(Direction.NORTH);
                break;
            case KeyEvent.VK_RIGHT:
                Pacman.Bewegen(Direction.EAST);
                break;

            case KeyEvent.VK_LEFT:
                Pacman.Bewegen(Direction.WEST);
                break;
        }
        gp.repaint();
    }

}
