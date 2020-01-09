package de.hft.ip1.group_3;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Ball extends GameComponent {

    private static final long serialVersionUID = 1L;

    private int speed;

    public Ball(int id, Position pos, boolean visible, Rectangle hitbox, int speed) {
        super(id, pos, visible, hitbox);
        this.speed = speed;
    }

    public int getSpeed() {
        return this.speed;
    }

    @Override
    public void paintComponent(Graphics g) {
        g.setColor(Color.RED);
        g.fillOval(pos.getX(), pos.getY(), 15, 15);
    }

    public void move() {
        pos.setX(pos.getX() + 1 * speed);

    }

}
