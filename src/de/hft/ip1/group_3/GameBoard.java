package de.hft.ip1.group_3;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Stroke;
import java.awt.Toolkit;
import java.awt.BasicStroke;
import java.util.NoSuchElementException;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;

public class GameBoard extends JPanel {

    private static final long serialVersionUID = 1L;

    private GameComponent[] gameComponents;
    

    /**
     * Create the frame.
     */
    public GameBoard(GameComponent[] gameComponents) {
        this.gameComponents = gameComponents;

        setMinimumSize(new Dimension(300, 300));
        setMaximumSize(new Dimension(2560, 2560));
        setPreferredSize(new Dimension(Scaling.sizeX, Scaling.sizeY));
        for (GameComponent comp : gameComponents) {
            add(comp);
        }
        revalidate();
    }

    @Override
    public void paint(Graphics graphics) {
        super.paint(graphics);

        graphics.setColor(Color.WHITE);
        this.setBackground(Color.BLACK);
        Stroke dashed = new BasicStroke(Scaling.sizeX/170, BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND, 0, new float[]{Scaling.sizeY/50}, 0);
        ((Graphics2D)graphics).setStroke(dashed);
        graphics.drawLine(Scaling.sizeX/2, 0 + Scaling.wallRecY, Scaling.sizeX/2, Scaling.sizeY - Scaling.wallRecY);
        
        
        gameComponents[8].paintComponent(graphics);
        gameComponents[7].paintComponent(graphics);
        gameComponents[1].paintComponent(graphics);
        gameComponents[2].paintComponent(graphics);
        gameComponents[5].paintComponent(graphics);
        gameComponents[6].paintComponent(graphics);
        gameComponents[0].paintComponent(graphics);
        gameComponents[3].paintComponent(graphics);
        gameComponents[4].paintComponent(graphics);
        
        
    }

    public Ball getBall() throws NoSuchElementException {
        for (GameComponent elem : gameComponents) {
            if (elem.getClass().equals(Ball.class)) {
                return (Ball) elem;
            }
        }
        throw new NoSuchElementException("Whoops, looks like we lost the ball");
    }

    public PlayerBar getPlayerBar1() throws NoSuchElementException {
        for (GameComponent elem : gameComponents) {
            if (elem.getClass().equals(PlayerBar.class) && ((PlayerBar) elem).getId() == 0) {
                return (PlayerBar) elem;
            }
        }
        throw new NoSuchElementException("Whoops, looks like we lost the bar");
    }

    public PlayerBar getPlayerBar2() throws NoSuchElementException {
        for (GameComponent elem : gameComponents) {
            if (elem.getClass().equals(PlayerBar.class) && ((PlayerBar) elem).getId() == 1) {
                return (PlayerBar) elem;
            }
        }
        throw new NoSuchElementException("Whoops, looks like we lost the bar");
    }

    public GameComponent[] getGameComponents() {
        return gameComponents;
    }

    public void draw() {
        this.repaint();
        Toolkit.getDefaultToolkit().sync();
    }

    public enum Validity {

        tooHigh, tooLow, correct
    }

    public Validity isValidHitboxPosition(Rectangle hitbox) {

       

        if (hitbox.getMaxY() < Scaling.maxValid && hitbox.getY() > Scaling.minValid) {
            return Validity.correct;
            
        } else if (hitbox.getMaxY() >= Scaling.maxValid) {
            return Validity.tooLow;
            
        } else
            return Validity.tooHigh;
    }
}
