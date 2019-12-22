package de.hft.ip1.group_3;

import java.awt.BorderLayout;
import java.util.NoSuchElementException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;

public class GameBoard extends JFrame {

    private static final long serialVersionUID = 1L;

    private JPanel contentPane;
    private GameComponent[] gameComponents;
    private Position[] validPositions;

    /**
     * Create the frame.
     */
    public GameBoard(GameComponent[] gameComponents) {
        this.gameComponents = gameComponents;

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBackground(Color.BLACK);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        
        for (GameComponent elem : gameComponents) {
            contentPane.add(elem);
        }
        contentPane.revalidate();
        contentPane.repaint();
        
        setContentPane(contentPane);
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
        //TODO: for some reason only the first PlayerBar is being repainted
        this.repaint();
    }

}
