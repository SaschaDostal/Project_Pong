package de.hft.ip1.group_3;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Goal extends GameComponent {

    public Goal(int id, Position pos, boolean visible, Rectangle hitbox) {
        super(id, pos, visible, hitbox);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void paintComponent(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(pos.getX(), pos.getY(), hitbox.width, hitbox.height);
    }

}
