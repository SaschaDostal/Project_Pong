package de.hft.ip1.group_3;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;

public class PlayerNames extends GameComponent {

    
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private String name1;
    private String name2;
    public PlayerNames(int id, Position pos, boolean visible, Rectangle hitbox, String name1, String name2) {
        super(id, pos, visible, hitbox);
         this.name1 = name1;
         this.name2 = name2;
    }

    @Override
    public void paintComponent(Graphics g) {
        // TODO Auto-generated method stub

        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial Bold", Font.BOLD, Scaling.sizeY / 30));

        g.drawString(name1, Scaling.wallRecY * 5, Scaling.wallRecY * 5);
        g.drawString(name2,  Scaling.sizeX - (g.getFontMetrics().stringWidth(name2) + Scaling.wallRecY * 5),
                Scaling.wallRecY * 5); 
        
        
    }

}
