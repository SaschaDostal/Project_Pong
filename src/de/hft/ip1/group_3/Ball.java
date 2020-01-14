package de.hft.ip1.group_3;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Ball extends GameComponent {
    
    private float floatPosX = this.pos.getX();
    private float floatPosY = this.pos.getY();

    private static final long serialVersionUID = 1L;
    private int lastComponentHit = 0;
    private int speed;
    private float[] direction = randomDirections();

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
        g.fillOval(pos.getX(), pos.getY(), hitbox.width, hitbox.height);
    }

    public void move() {
        float scale = (float) (Scaling.sizeX/1000.0);
        floatPosX += scale*direction[0];
        floatPosY += scale*direction[1];
        pos.setX(floatPosX);
        pos.setY(floatPosY);
        this.hitbox.setLocation(pos.getX(), pos.getY());
    }

    public void setSpeed(int d) {
        this.speed = d;
    }

    public int getLastComponentHit() {
        return lastComponentHit;
    }

    public void setLastComponentHit(int lastComponentHit) {
        this.lastComponentHit = lastComponentHit;
    }
    
    public void setDirection( float x, float y) {
        this.direction[0] = x;
        this.direction[1] = y;
    }
    
    public float[] getDirection() {
        return this.direction;
    }
    
    public void setFloatPosX( float x ) {
        this.floatPosX = x;
    }
    
    public void setFloatPosY( float y ) {
        this.floatPosY = y;
    }
    
    public float[] randomDirections() {
        float[] dir = new float[2];
        dir[0] = (float) (Math.random() * 0.5 + 1.3);
        dir[1] = (float) (Math.sqrt(4 - dir[0]*dir[0]));
        
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
