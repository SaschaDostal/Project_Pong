package de.hft.ip1.group_3;

import java.awt.EventQueue;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Control {

    private GameWindow window;
    private Player[] players = new Player[2];
    private Wall[] walls = new Wall[2];
    private Ball ball = null;
    private GameBoard board = null;

    public static void main(String[] args) {
        Control me = new Control();
        me.ball = new Ball(1, new Position(5, 5), true, new Rectangle(8, 8), 1);
        me.players[0] = new Player(0, 0,
                new PlayerBar(0, new Position(0, 700 / 2 - 35), true, new Rectangle(8, 70), 10));
        me.players[1] = new Player(1, 0,
                new PlayerBar(1, new Position(700 - 24, 700 / 2 - 35), true, new Rectangle(8, 70), 10));
        me.walls[0] = new Wall(0, new Position(0, 0), true, new Rectangle(700, 5));
        me.walls[1] = new Wall(1, new Position(0, 659), true, new Rectangle(700, 5));
        me.board = new GameBoard(new GameComponent[] { me.ball, me.players[0].getBar(), me.players[1].getBar(),
                me.walls[0], me.walls[1] });
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                me.window = new GameWindow(me.board);
            }
        });

        Movement mov = new Movement(me);
      
        me.board.addKeyListener(mov.keylis);
        me.board.addKeyListener(mov.keylis2);
        while (true) {
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }
            me.step();
        }

    }

    private void step() {
        // TODO: some transformation of things e.g.:

        board.getBall().move();

        board.draw();

    }

    private void goal(Player goalingPlayer) {
        goalingPlayer.goal();
    }
    public void UpWPressed() {
       board.getPlayerBar1().moveUp();

    }

    public void UpKeyPressed() {
        // TODO Auto-generated method stub
        board.getPlayerBar2().moveUp();
    }

    public void DownKeyPressed() {
        // TODO Auto-generated method stub
        board.getPlayerBar2().moveDown();
    }

    public void DownSPressed() {
        // TODO Auto-generated method stub
        board.getPlayerBar1().moveDown();
    }
}
