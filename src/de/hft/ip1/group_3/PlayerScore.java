package de.hft.ip1.group_3;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;

public class PlayerScore extends GameComponent {

    private Rectangle BoxBoxBloxs = new Rectangle(Scaling.sizeX/2+Scaling.wallRecX/30, Scaling.wallRecY*7, Scaling.sizeY/10, Scaling.sizeY/10);
    private Rectangle BoxBoxBloxs2 = new Rectangle(Scaling.sizeX/2-Scaling.wallRecX/30-BoxBoxBloxs.width, Scaling.wallRecY*7, Scaling.sizeY/10, Scaling.sizeY/10);

    public PlayerScore(int id, Position pos, boolean visible, Rectangle hitbox) {
        super(id, pos, visible, hitbox);
        
        Score1 = String.valueOf(0);
        Score2 = String.valueOf(0);
    }

    private static final long serialVersionUID = 1L;

    @Override
    public void paintComponent(Graphics g) {
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial Bold", Font.BOLD, Scaling.sizeY/10));
        
      g.drawString(Score1, BoxBoxBloxs.x+BoxBoxBloxs.width/2-g.getFontMetrics().stringWidth(Score1)/2, BoxBoxBloxs.y+BoxBoxBloxs.height/2);
      g.drawString(Score2, BoxBoxBloxs2.x+BoxBoxBloxs2.width/2-g.getFontMetrics().stringWidth(Score2)/2, BoxBoxBloxs2.y+BoxBoxBloxs2.height/2);

    }

    private String Score1;
    private String Score2;

    public int getScore1() {
        return Integer.parseInt(Score1);
    }

    public void setScore1(int score1) {
        Score1 = String.valueOf(score1);
    }

    public int getScore2() {
        return Integer.parseInt(Score2);
    }

    public void setScore2(int score2) {
        Score2 = String.valueOf(score2);
    }

}
