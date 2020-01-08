package de.hft.ip1.group_3;

import java.awt.Graphics;
import java.util.NoSuchElementException;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;

public class GameBoard extends JPanel {

    private static final long serialVersionUID = 1L;

    private GameComponent[] gameComponents;
    private Position[] validPositions;

    /**
     * Create the frame.
     */
    public GameBoard(GameComponent[] gameComponents) {
        this.gameComponents = gameComponents;

        setMinimumSize(new Dimension(300, 300));
        setMaximumSize(new Dimension(2560, 2560));
        setPreferredSize(new Dimension(Scaling.sizeX, Scaling.sizeY));
        setVisible(true);
        setEnabled(true);
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
        for (GameComponent elem : gameComponents) {
            elem.paintComponent(graphics);
        }
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
    }

}
