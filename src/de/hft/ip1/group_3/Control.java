package de.hft.ip1.group_3;

import java.awt.EventQueue;
import java.awt.Rectangle;

public class Control {

    private GameWindow window;
    private Player[] players = new Player[2];
    private Ball ball = null;
    private GameBoard board = null;

    public static void main(String[] args) {
        Control me = new Control();
        me.ball = new Ball(1, new Position(1, 1), true, new Rectangle(8, 8), 10);
        me.players[0] = new Player(0, 0, new PlayerBar(0, new Position(1, 1), true, new Rectangle(8, 20), 10));
        me.players[1] = new Player(1, 0, new PlayerBar(1, new Position(1, 1), true, new Rectangle(8, 20), 10));
        me.board = new GameBoard(new GameComponent[] { me.ball, me.players[0].getBar(), me.players[1].getBar() });
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                me.window = new GameWindow(me.board);
            }
        });

        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }
            me.step();
        }

    }

    private void step() {
        /* TODO: some transformation of things e.g.:
        board.getBall().move(new Position(100, 10));
        board.getPlayerBar1().move(new Position(10, 40));
        board.getPlayerBar2().move(new Position(50, 100));
        */
        board.draw();
    }

    private void goal(Player goalingPlayer) {
        goalingPlayer.goal();
    }

}
