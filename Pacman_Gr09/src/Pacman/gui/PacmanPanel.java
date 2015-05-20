/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Pacman.gui;

import Pacman.models.Bolletje;
import Pacman.models.Direction;
import Pacman.models.Muur;
import java.awt.Graphics;

import java.util.ArrayList;
import Pacman.models.Pacman;
import Pacman.models.Poppetje;
import Pacman.models.Speelboard;
import Pacman.models.SpelElement;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author Ugur
 */
public class PacmanPanel extends javax.swing.JPanel implements KeyListener {

    private int level;
    private Speelboard speelboard;
    private ArrayList<Poppetje> popjes;
    private int punten = 0;
    PacmanFrame pacmanFrame;

    public PacmanPanel(PacmanFrame pacmanFrame) {
        initComponents();
        level = 1;
        punten = 0;
        speelboard = new Speelboard(level);
        popjes = new ArrayList<Poppetje>();
        this.pacmanFrame = pacmanFrame;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    public void start() {
        init();
        this.addKeyListener(this);
    }

    public void reset() {
        speelboard = new Speelboard(level);
        init();
    }

    private void init() {
        initShapes();
        this.requestFocusInWindow();
        this.repaint();
    }

    private void initShapes() {
        popjes.clear();
        for (SpelElement spelElement : speelboard.getSpelElements()) {
            if (spelElement instanceof Pacman) {
                popjes.add((Pacman) spelElement);
            }
        }
        pacmanFrame.jLabel1.setText("Punten: " + 0);
        punten = 0;
    }

    private void moveShapes(Direction direction) {
        for (Poppetje popje : popjes) {
            int[] oldpos = {popje.getxPos(), popje.getyPos()};
            popje.Bewegen(direction);
            SpelElement remove = null;
            for (SpelElement spelElement : speelboard.getSpelElements()) {
                if (spelElement instanceof Muur) {
                    if (spelElement.getyPos() == popje.getyPos() && spelElement.getxPos() == popje.getxPos()) {
                        popje.setxPos(oldpos[0]);
                        popje.setyPos(oldpos[1]);
                    }
                } else if (spelElement instanceof Bolletje) {
                    if (spelElement.getyPos() == popje.getyPos() && spelElement.getxPos() == popje.getxPos()) {
                        remove = spelElement;
                        punten++;
                        pacmanFrame.jLabel1.setText("Punten: " + punten);
                    }

                }
            }
            if (remove != null) {
                speelboard.spelElements.remove(remove);

            }
        }

        repaint();
    }

    @Override
    public void keyReleased(KeyEvent ke) {

        switch (ke.getKeyCode()) {
            case KeyEvent.VK_DOWN:
                moveShapes(Direction.SOUTH);
                break;
            case KeyEvent.VK_UP:
                moveShapes(Direction.NORTH);
                break;
            case KeyEvent.VK_RIGHT:
                moveShapes(Direction.EAST);
                break;
            case KeyEvent.VK_LEFT:
                moveShapes(Direction.WEST);
                break;
        }
    }

    private void draw(Graphics g) {
        for (SpelElement spelElement : speelboard.getSpelElements()) {

            spelElement.draw(g);
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(1, 1, 1));

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 1145, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 582, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

    @Override
    public void keyTyped(KeyEvent ke) {

    }

    @Override
    public void keyPressed(KeyEvent ke) {

    }

}
