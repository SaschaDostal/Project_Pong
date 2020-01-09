package de.hft.ip1.group_3;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Ball extends GameComponent {

    private static final long serialVersionUID = 1L;

    private float speed;
    private int directionX = (int) (((Math.random() * 2) == 0) ? -5 : 5);
    private int directionY = (int) (Math.random() * 21) - 10;

    public Ball(int id, Position pos, boolean visible, Rectangle hitbox, float speed) {
        super(id, pos, visible, hitbox);
        this.speed = speed;
    }

    public float getSpeed() {
        return this.speed;
    }

    @Override
    public void paintComponent(Graphics g) {
        g.setColor(Color.RED);
        g.fillOval(pos.getX(), pos.getY(), hitbox.width, hitbox.height);
    }

    public void move() {
        pos.setX(pos.getX() + directionX);
        pos.setY(pos.getY() + directionY);
        this.hitbox.setLocation(pos.getX(), pos.getY());
    }

    public void setSpeed(double d) {
        this.speed = (float) d;
    }

    public int getDirectionX() {
        return directionX;
    }

    public int getDirectionY() {
        return directionY;
    }

    public void setDirectionX(int directionX) {
        this.directionX = directionX;
    }

    public void setDirectionY(int directionY) {
        this.directionY = directionY;
    }
}
