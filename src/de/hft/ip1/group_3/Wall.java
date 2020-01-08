package de.hft.ip1.group_3;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Wall extends GameComponent {

    private static final long serialVersionUID = 1L;

    public Wall(int id, Position pos, boolean visible, Rectangle hitbox) {
        super(id, pos, visible, hitbox);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void paintComponent(Graphics g) {
        g.setColor(Color.gray);
        g.fillRect(pos.getX(), pos.getY(), hitbox.width, hitbox.height);
    }

}
