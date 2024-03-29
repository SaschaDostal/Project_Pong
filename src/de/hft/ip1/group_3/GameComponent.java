package de.hft.ip1.group_3;

import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.JComponent;

public abstract class GameComponent extends JComponent {

    private static final long serialVersionUID = 1L;

    protected int id;
    protected Position pos;
    protected boolean visible;
    protected Rectangle hitbox;
    

    public GameComponent(int id, Position pos, boolean visible, Rectangle hitbox) {
        this.id = id;
        this.pos = pos;
        this.visible = visible;
        this.hitbox = hitbox;
        this.hitbox.setLocation(pos.getX(), pos.getY());
    }

    public int getId() {
        return this.id;
    }

    public Position getPosition() {
        return this.pos;
    }

    public boolean isVisible() {
        return this.visible;
    }

    public void move(Position newPos) {
        this.pos = newPos;
    }
    
    public Rectangle getHitbox() {
        return this.hitbox;
    }

    @Override
    abstract public void paintComponent(Graphics g);
}

class Position {
    private int x, y;
    // private float x, y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public void setX(double d) {
        this.x = (int) d;
    }

    public void setY(double y) {
        this.y = (int) y;
    }
    


}
