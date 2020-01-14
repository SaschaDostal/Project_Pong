package de.hft.ip1.group_3;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;

public class PlayerScore extends GameComponent {

    private Rectangle boxBoxBloxs = new Rectangle(Scaling.sizeX / 2 + Scaling.wallRecX / 30, Scaling.wallRecY * 7,
            Scaling.sizeY / 10, Scaling.sizeY / 10);
    private Rectangle boxBoxBloxs2 = new Rectangle(Scaling.sizeX / 2 - Scaling.wallRecX / 30 - boxBoxBloxs.width,
            Scaling.wallRecY * 7, Scaling.sizeY / 10, Scaling.sizeY / 10);

    public PlayerScore(int id, Position pos, boolean visible, Rectangle hitbox) {
        super(id, pos, visible, hitbox);

        score1 = String.valueOf(0);
        score2 = String.valueOf(0);
    }

    private static final long serialVersionUID = 1L;

    @Override
    public void paintComponent(Graphics g) {
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial Bold", Font.BOLD, Scaling.sizeY / 10));

        g.drawString(score1, boxBoxBloxs.x + boxBoxBloxs.width / 2 - g.getFontMetrics().stringWidth(score1) / 2,
                boxBoxBloxs.y + boxBoxBloxs.height / 2);
        g.drawString(score2, boxBoxBloxs2.x + boxBoxBloxs2.width / 2 - g.getFontMetrics().stringWidth(score2) / 2,
                boxBoxBloxs2.y + boxBoxBloxs2.height / 2);

    }

    private String score1;
    private String score2;

    public int getScore1() {
        return Integer.parseInt(score1);
    }

    public void setScore1(int score1) {
        this.score1 = String.valueOf(score1);
    }

    public int getScore2() {
        return Integer.parseInt(score2);
    }

    public void setScore2(int score2) {
        this.score2 = String.valueOf(score2);
    }

}
