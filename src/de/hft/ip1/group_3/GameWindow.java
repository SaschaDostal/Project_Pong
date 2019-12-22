package de.hft.ip1.group_3;

import java.awt.Dimension;

public class GameWindow {

    private GameBoard frame;

    /**
     * Create the application.
     */
    public GameWindow(GameBoard board) {
        this.frame = board;
        initialize();
        this.frame.setVisible(true);
    }

    public GameBoard getGameBoard() {
        return this.frame;
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame.setBounds(100, 100, 450, 300);
        frame.setMinimumSize(new Dimension(300, 300));
        frame.setMaximumSize(new Dimension(2560, 2560));
        frame.setDefaultCloseOperation(GameBoard.EXIT_ON_CLOSE);
    }

}
