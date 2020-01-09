package de.hft.ip1.group_3;

import java.awt.EventQueue;
import java.awt.Rectangle;

public class Control {

    private GameWindow window;
    private Player[] players = new Player[2];
    private Wall[] walls = new Wall[2];
    private Ball ball = null;
    private GameBoard board = null;
    private Movement mov;

    public static void main(String[] args) {
        Control me = new Control();

        me.ball = new Ball(1, new Position(Scaling.ballPosX, Scaling.ballPosY), true,
                new Rectangle(Scaling.ballRecX, Scaling.ballRecY), 1);
        me.players[0] = new Player(0, 0, new PlayerBar(0, new Position(Scaling.playerBarPos1X, Scaling.playerBarPos1Y),
                true, new Rectangle(Scaling.playerBarRecX, Scaling.playerBarRecY), 10));
        me.players[1] = new Player(1, 0, new PlayerBar(1, new Position(Scaling.playerBarPos2X, Scaling.playerBarPos2Y),
                true, new Rectangle(Scaling.playerBarRecX, Scaling.playerBarRecY), 10));
        me.walls[0] = new Wall(0, new Position(Scaling.wallPos1X, Scaling.wallPos1Y), true,
                new Rectangle(Scaling.wallRecX, Scaling.wallRecY));
        me.walls[1] = new Wall(1, new Position(Scaling.wallPos2X, Scaling.wallPos2Y), true,
                new Rectangle(Scaling.wallRecX, Scaling.wallRecY));
        me.board = new GameBoard(new GameComponent[] { me.ball, me.players[0].getBar(), me.players[1].getBar(),
                me.walls[0], me.walls[1] });

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                me.window = new GameWindow(me.board);
                me.window.addKeyListener(me.mov.getKeyListener());
            }
        });

        me.mov = new Movement();
       
        while (true) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }
            me.step();
        }

    }

    private void step() {
        if (mov.isDownPressed()) {
            board.getPlayerBar2().moveDown();
        }
        if (mov.isUpPressed()) {
            board.getPlayerBar2().moveUp();
        }
        if (mov.isWPressed()) {
            board.getPlayerBar1().moveUp();
        }
        if (mov.isSPressed()) {
            board.getPlayerBar1().moveDown();
        }

        board.getBall().move();

        board.draw();

    }

    private void goal(Player goalingPlayer) {
        goalingPlayer.goal();
    }
}
