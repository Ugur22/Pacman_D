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

    public Pacman(Vakje vakje, int xPos, int yPos, int height, int width) {
        super(vakje, Color.YELLOW, xPos, yPos, height, width);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(getColor());
        if (direction == Direction.EAST) {
            g.fillArc(getxPos(), getyPos(), getWidth(), getHeight(), 30, 300);
        } else if (direction == Direction.NORTH) {
            g.fillArc(getxPos(), getyPos(), getWidth(), getHeight(), 120, 300);
        } else if (direction == Direction.WEST) {
            g.fillArc(getxPos(), getyPos(), getWidth(), getHeight(), 210, 300);
        } else {
            g.fillArc(getxPos(), getyPos(), getWidth(), getHeight(), 300, 300);
        }
        g.setColor(Color.black);
        if (direction == Direction.EAST) {
            g.fillRoundRect(getxPos() + 30, getyPos() + 15, 10, 10, 10, 10);
        } else if (direction == Direction.NORTH) {
            g.fillRoundRect(getxPos() + 15, getyPos() + 35, 10, 10, 10, 10);
        } else if (direction == Direction.WEST) {
            g.fillRoundRect(getxPos() + 35, getyPos() + 15, 10, 10, 10, 10);
        } else {
            g.fillRoundRect(getxPos() + 15, getyPos() + 25, 10, 10, 10, 10);
        }

    }

    @Override
    public void Bewegen(Direction direction) {
        this.direction = direction;
        switch (direction) {
            case NORTH:
                yPos -= MOVEMENT;
                break;
            case SOUTH:
                yPos += MOVEMENT;
                break;
            case WEST:
                xPos -= MOVEMENT;
                break;
            case EAST:
                xPos += MOVEMENT;
                break;

        }
    }

}
