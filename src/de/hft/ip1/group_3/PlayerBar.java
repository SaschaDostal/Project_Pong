package de.hft.ip1.group_3;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class PlayerBar extends GameComponent {

    private static final long serialVersionUID = 1L;

    private int speed;

    public PlayerBar(int id, Position pos, boolean visible, Rectangle hitbox, int speed) {
        super(id, pos, visible, hitbox);
        this.speed = speed;
    }

    public int getSpeed() {
        return this.speed;
    }

    @Override
    public void paintComponent(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(pos.getX(), pos.getY(), hitbox.width, hitbox.height);
    }

    public void moveUp() {
        pos.setY(pos.getY() - 10 * 1);
        
       
    }

    public void moveDown() {
        pos.setY(pos.getY() + 10 * 1);

    }

}
