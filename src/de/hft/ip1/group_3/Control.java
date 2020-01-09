package de.hft.ip1.group_3;

import java.awt.EventQueue;
import java.awt.Rectangle;

public class Control {

    private GameWindow window;
    private Player[] players = new Player[2];
    private Wall[] walls = new Wall[4];
    private Ball ball = null;
    private GameBoard board = null;
    private Movement mov;
    ScoringSystem Score;
    private PlayerScore playsc;

    public static void main(String[] args) {

        Control me = new Control();
        me.Score = new ScoringSystem(2);

        me.playsc = new PlayerScore(10, new Position(0, 0), true, new Rectangle(0, 0));

        me.ball = new Ball(1, new Position(Scaling.ballPosX, Scaling.ballPosY), true,
                new Rectangle(Scaling.ballRecX, Scaling.ballRecY), 1);
        me.players[0] = new Player(0, 0, new PlayerBar(0, new Position(Scaling.playerBarPos1X, Scaling.playerBarPos1Y),
                true, new Rectangle(Scaling.playerBarRecX, Scaling.playerBarRecY), 10));
        me.players[1] = new Player(1, 0, new PlayerBar(1, new Position(Scaling.playerBarPos2X, Scaling.playerBarPos2Y),
                true, new Rectangle(Scaling.playerBarRecX, (Scaling.playerBarRecY)), 10));
        me.walls[0] = new Wall(0, new Position(Scaling.wallPos1X, Scaling.wallPos1Y), true,
                new Rectangle(Scaling.wallRecX, Scaling.wallRecY));
        me.walls[1] = new Wall(1, new Position(Scaling.wallPos2X, Scaling.wallPos2Y), true,
                new Rectangle(Scaling.wallRecX, Scaling.wallRecY));
        me.walls[2] = new Wall(2, new Position(Scaling.wallPos3X, Scaling.wallPos3Y), true,
                new Rectangle(Scaling.wallRec1X, Scaling.wallRec1Y));
        me.walls[3] = new Wall(3, new Position(Scaling.wallPos4X, Scaling.wallPos4Y), true,
                new Rectangle(Scaling.wallRec1X, Scaling.wallRec1Y));
        me.board = new GameBoard(new GameComponent[] { me.ball, me.players[0].getBar(), me.players[1].getBar(),
                me.walls[0], me.walls[1], me.walls[2], me.walls[3], me.playsc });

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
                Thread.sleep(25);
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
        collision(board.getGameComponents());
        board.getBall().move();
        if (board.isValidHitboxPosition(board.getPlayerBar1().getHitbox()) == GameBoard.Validity.tooLow) {
            board.getPlayerBar1().move(new Position(Scaling.playerBarPos1X, Scaling.maxValid - Scaling.playerBarRecY));
        } else if (board.isValidHitboxPosition(board.getPlayerBar1().getHitbox()) == GameBoard.Validity.tooHigh) {
            board.getPlayerBar1().move(new Position(Scaling.playerBarPos1X, Scaling.minValid));
        }
        if (board.isValidHitboxPosition(board.getPlayerBar2().getHitbox()) == GameBoard.Validity.tooLow) {
            board.getPlayerBar2().move(new Position(Scaling.playerBarPos2X, Scaling.maxValid - Scaling.playerBarRecY));
        } else if (board.isValidHitboxPosition(board.getPlayerBar2().getHitbox()) == GameBoard.Validity.tooHigh) {
            board.getPlayerBar2().move(new Position(Scaling.playerBarPos2X, Scaling.minValid));
        }

        board.draw();
    }

    private void collision(GameComponent[] gameComponents) {
        if (gameComponents[0].getHitbox().intersects(gameComponents[1].getHitbox())
                || gameComponents[0].getHitbox().intersects(gameComponents[2].getHitbox())) {
            board.getBall().setDirectionX(board.getBall().getDirectionX() * (-1));
            board.getBall().setSpeed(board.getBall().getSpeed() * 1.1);
        }
        if (gameComponents[0].getHitbox().intersects(gameComponents[3].getHitbox())
                || gameComponents[0].getHitbox().intersects(gameComponents[4].getHitbox())) {
            board.getBall().setDirectionY(board.getBall().getDirectionY() * (-1));
        }
        if (gameComponents[0].getHitbox().intersects(gameComponents[5].getHitbox())) {
            Score.addPointToPlayer(1);
            reset();
        }
        if (gameComponents[0].getHitbox().intersects(gameComponents[6].getHitbox())) {
            Score.addPointToPlayer(2);
            reset();
        }
    }

    public void reset() {
        board.getBall().pos.setX(Scaling.sizeX / 2 - Scaling.ballRecX / 2);
        board.getBall().pos.setY(Scaling.sizeY / 2 - Scaling.ballRecY / 2);
        board.getBall().hitbox.setLocation(board.getBall().pos.getX(), board.getBall().pos.getY());
        board.getBall().setSpeed(0);
        board.getPlayerBar1().pos.setY(Scaling.playerBarPos1Y);
        board.getPlayerBar1().hitbox.setLocation(Scaling.playerBarPos1X, Scaling.playerBarPos1Y);
        board.getPlayerBar2().pos.setY(Scaling.playerBarPos2Y);
        board.getPlayerBar2().hitbox.setLocation(Scaling.playerBarPos2X, Scaling.playerBarPos2Y);

        playsc.setScore1(Score.getPointsOfPlayer(1));
        playsc.setScore2(Score.getPointsOfPlayer(2));
        board.draw();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        board.getBall().setDirectionY((int) (Math.random() * 21) - 10);
        board.getBall().setDirectionX(((int) (Math.random() * 2) == 0) ? -5 : 5);
        board.getBall().setSpeed(1);
    }

    private void goal(Player goalingPlayer) {
        goalingPlayer.goal();

    }
}
