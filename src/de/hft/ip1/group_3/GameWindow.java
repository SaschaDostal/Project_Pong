package de.hft.ip1.group_3;

import java.awt.Dimension;

import javax.swing.JFrame;

public class GameWindow extends JFrame {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private GameBoard gameBoard;

    /**
     * Create the application.
     */
    public GameWindow(GameBoard board) {
        this.gameBoard = board;
        initialize();
        this.setVisible(true);
    }

    public GameBoard getGameBoard() {
        return this.gameBoard;
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        setTitle("Pong");
        setMinimumSize(new Dimension(300, 300));
        setMaximumSize(new Dimension(2560, 2560));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        System.out.println(gameBoard.getPreferredSize());
        add(gameBoard);
        pack();
    }

}
