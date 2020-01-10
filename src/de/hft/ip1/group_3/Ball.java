package de.hft.ip1.group_3;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Ball extends GameComponent {

    private static final long serialVersionUID = 1L;
    private int lastComponentHit = 0;
    private float speed;
    private float[] direction = randomDirections();

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
        pos.setX(pos.getX() + 4 * Scaling.sizeX/1000 * direction[0]);
        pos.setY(pos.getY() + 4 * Scaling.sizeX/1000 * direction[1]);
        this.hitbox.setLocation(pos.getX(), pos.getY());
    }

    public void setSpeed(double d) {
        this.speed = (float) d;
    }

    public int getLastComponentHit() {
        return lastComponentHit;
    }

    public void setLastComponentHit(int lastComponentHit) {
        this.lastComponentHit = lastComponentHit;
    }
    
    public void setDirection( float[] dir) {
        this.direction = dir;
    }
    
    public float[] getDirection() {
        return this.direction;
    }
    
    public float[] randomDirections() {
        float[] dir = new float[2];
        dir[0] = (float) (Math.random() * 0.4 + 0.4);
        dir[1] = (float) (Math.sqrt(1.0 - dir[0]*dir[0]));
        
        int quadrant = (int) (Math.random() * 4);
        if (quadrant == 0) {
            dir[0] = -dir[0];
        }
        if (quadrant == 1) {
            dir[0] = -dir[0];
            dir[1] = -dir[1];
        }
        if (quadrant == 2) {
            dir[1] = -dir[1];
        }
        return dir;
    }
}
