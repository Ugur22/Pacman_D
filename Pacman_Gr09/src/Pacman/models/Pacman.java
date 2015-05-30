package Pacman.models;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Ugur
 */
public class Pacman extends Poppetje {

    private final static int MOVEMENT = 45;
    private Direction direction = Direction.EAST;
    

    @Override
    public void draw(Graphics g) {
        g.setColor(getColor());
        if (direction == Direction.EAST) {
            g.fillArc(vakje.getxPos(), vakje.getyPos(), vakje.getWidth(), vakje.getHeight(), 30, 300);
        } else if (direction == Direction.NORTH) {
            g.fillArc(vakje.getxPos(), vakje.getyPos(), vakje.getWidth(), vakje.getHeight(), 120, 300);
        } else if (direction == Direction.WEST) {
            g.fillArc(vakje.getxPos(), vakje.getyPos(), vakje.getWidth(), vakje.getHeight(), 210, 300);
        } else {
            g.fillArc(vakje.getxPos(), vakje.getyPos(), vakje.getWidth(), vakje.getHeight(), 300, 300);
        }

        g.setColor(Color.black);
        if (direction == Direction.EAST) {
            g.fillRoundRect(vakje.getxPos() + 30, vakje.getyPos() + 15, 10, 10, 10, 10);
        } else if (direction == Direction.NORTH) {
            g.fillRoundRect(vakje.getxPos() + 15, vakje.getyPos() + 35, 10, 10, 10, 10);
        } else if (direction == Direction.WEST) {
            g.fillRoundRect(vakje.getxPos() + 35, vakje.getyPos() + 15, 10, 10, 10, 10);
        } else {
            g.fillRoundRect(vakje.getxPos() + 15, vakje.getyPos() + 25, 10, 10, 10, 10);
        }

    }

    public void startVakje(Vakje vakje) {

    }
    
      
    @Override
    public void Bewegen(Direction direction) {
        this.direction = direction;

        switch (direction) {
            case NORTH:
                vakje.yPos += 40;
                System.out.println("north");
                break;
            case SOUTH:
                vakje.yPos += 40;
                System.out.println("sout");
                break;
            case WEST:
                vakje.xPos -= 40;
                System.out.println("west");
                break;
            case EAST:
                vakje.xPos += 40;
                System.out.println("east");
                break;

        }
    }

}
