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
        
        me.ball = new Ball(1, new Position(Scaling.ballPosX, Scaling.ballPosY), true, new Rectangle(Scaling.ballRecX, Scaling.ballRecY), 1);
        me.players[0] = new Player(0, 0, new PlayerBar(0, new Position(Scaling.playerBarPos1X, Scaling.playerBarPos1Y), true, new Rectangle(Scaling.playerBarRecX, Scaling.playerBarRecY), 10));
        me.players[1] = new Player(1, 0, new PlayerBar(1, new Position(Scaling.playerBarPos2X, Scaling.playerBarPos2Y), true, new Rectangle(Scaling.playerBarRecX, Scaling.playerBarRecY), 10));
        me.walls[0] = new Wall(0, new Position(Scaling.wallPos1X, Scaling.wallPos1Y), true, new Rectangle(Scaling.wallRecX, Scaling.wallRecY));
        me.walls[1] = new Wall(1, new Position(Scaling.wallPos2X, Scaling.wallPos2Y), true, new Rectangle(Scaling.wallRecX, Scaling.wallRecY));
        me.board = new GameBoard(new GameComponent[] { me.ball, me.players[0].getBar(), me.players[1].getBar(), me.walls[0], me.walls[1] });

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
