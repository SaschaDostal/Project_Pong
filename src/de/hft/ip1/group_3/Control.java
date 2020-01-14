package de.hft.ip1.group_3;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.UIManager;

public class Control implements ActionListener {

    private GameWindow window;
    private StartWindow startWindow;
    private Player[] players = new Player[2];
    private Wall[] walls = new Wall[2];
    private Goal[] goals = new Goal[2];
    private String[] playerNames;
    private Ball ball = null;
    private GameBoard board = null;
    private Movement mov;
    private ScoringSystem score;
    private PlayerScore playsc;
    private Timer timer;

    public static void main(String[] args) {

        Control me = new Control();
        me.timer = new Timer(25, me);
        me.score = new ScoringSystem(2);
        me.mov = new Movement();

        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                me.startWindow = new StartWindow(me);
                me.startWindow.setVisible(true);
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        step();
    }

    private void step() {
        for (int i = 0; i < board.getBall().getSpeed(); i++) {
            collision(board.getGameComponents());
            board.getBall().move();
//            board.draw();
        }
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
        if (board.getBall().getPosition().getX() <= 0
                || board.getBall().getPosition().getX() >= (Scaling.sizeX - Scaling.ballRecX)
                || board.getBall().getPosition().getY() <= 0
                || board.getBall().getPosition().getY() >= (Scaling.sizeY - Scaling.ballRecY)) {
            reset();
        }
        // collision(board.getGameComponents());

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
                && !(board.getBall().getLastComponentHit() == 1)) {
            board.getBall().setDirection( board.getBall().getDirection()[0] * (-1), board.getBall().getDirection()[1] );
            if (board.getBall().getSpeed() < 6) {
                board.getBall().setSpeed(board.getBall().getSpeed() + 1);
            }
            board.getBall().setLastComponentHit(1);
        }
        if (gameComponents[0].getHitbox().intersects(gameComponents[2].getHitbox())
                && !(board.getBall().getLastComponentHit() == 2)) {
            board.getBall().setDirection( board.getBall().getDirection()[0] * (-1), board.getBall().getDirection()[1] );
            if (board.getBall().getSpeed() < 6) {
                board.getBall().setSpeed(board.getBall().getSpeed() + 1);
            }
            board.getBall().setLastComponentHit(2);
        }
        if (gameComponents[0].getHitbox().intersects(gameComponents[3].getHitbox())
                && !(board.getBall().getLastComponentHit() == 3)) {
            board.getBall().setDirection( board.getBall().getDirection()[0], board.getBall().getDirection()[1] * (-1) );
            board.getBall().setLastComponentHit(3);
        }
        if (gameComponents[0].getHitbox().intersects(gameComponents[4].getHitbox())
                && !(board.getBall().getLastComponentHit() == 4)) {
            board.getBall().setDirection( board.getBall().getDirection()[0], board.getBall().getDirection()[1] * (-1) );
            board.getBall().setLastComponentHit(4);
        }
        if (gameComponents[0].getHitbox().intersects(gameComponents[5].getHitbox())
                && !(board.getBall().getLastComponentHit() == 5)) {
            score.addPointToPlayer(1);
            board.getBall().setLastComponentHit(5);
            reset();
        }
        if (gameComponents[0].getHitbox().intersects(gameComponents[6].getHitbox())
                && !(board.getBall().getLastComponentHit() == 6)) {
            score.addPointToPlayer(2);
            board.getBall().setLastComponentHit(6);
            reset();
        }
    }

    public void reset() {
        board.getBall().setFloatPosX((float) (Scaling.sizeX / 2.0 - Scaling.ballRecX / 2.0));
        board.getBall().setFloatPosY((float) (Scaling.sizeY / 2.0 - Scaling.ballRecY / 2.0));
        board.getBall().pos.setX(Scaling.sizeX / 2 - Scaling.ballRecX / 2);
        board.getBall().pos.setY(Scaling.sizeY / 2 - Scaling.ballRecY / 2);
        board.getBall().hitbox.setLocation(board.getBall().pos.getX(), board.getBall().pos.getY());
        board.getBall().setSpeed(0);
        board.getPlayerBar1().pos.setY(Scaling.playerBarPos1Y);
        board.getPlayerBar1().hitbox.setLocation(Scaling.playerBarPos1X, Scaling.playerBarPos1Y);
        board.getPlayerBar2().pos.setY(Scaling.playerBarPos2Y);
        board.getPlayerBar2().hitbox.setLocation(Scaling.playerBarPos2X, Scaling.playerBarPos2Y);

        playsc.setScore1(score.getPointsOfPlayer(1));
        playsc.setScore2(score.getPointsOfPlayer(2));
        board.draw();

        timer.stop();
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                timer.restart();
                endGame();
            }
        });
        board.getBall().setDirection(board.getBall().randomDirections());
        board.getBall().setSpeed(3);
    }

    public void startGame(String name1, String name2, int sizeX) {
        playerNames = new String[] { name1, name2 };
        PlayerNames displayName = new PlayerNames(0, new Position(0, 0), true, new Rectangle(), name1, name2);
        Scaling.sizeX = sizeX;
        @SuppressWarnings("unused")
        Scaling scale = new Scaling();
        System.out.println(Scaling.sizeX);

        playsc = new PlayerScore(10, new Position(0, 0), true, new Rectangle(0, 0));

        ball = new Ball(1, new Position(Scaling.ballPosX, Scaling.ballPosY), true,
                new Rectangle(Scaling.ballRecX, Scaling.ballRecY), 3);
        players[0] = new Player(0, new PlayerBar(0, new Position(Scaling.playerBarPos1X, Scaling.playerBarPos1Y), true,
                new Rectangle(Scaling.playerBarRecX, Scaling.playerBarRecY), 10));
        players[1] = new Player(1, new PlayerBar(1, new Position(Scaling.playerBarPos2X, Scaling.playerBarPos2Y), true,
                new Rectangle(Scaling.playerBarRecX, (Scaling.playerBarRecY)), 10));
        walls[0] = new Wall(0, new Position(Scaling.wallPos1X, Scaling.wallPos1Y), true,
                new Rectangle(Scaling.wallRecX, Scaling.wallRecY));
        walls[1] = new Wall(1, new Position(Scaling.wallPos2X, Scaling.wallPos2Y), true,
                new Rectangle(Scaling.wallRecX, Scaling.wallRecY));
        goals[0] = new Goal(2, new Position(Scaling.wallPos3X, Scaling.wallPos3Y), true,
                new Rectangle(Scaling.wallRec1X, Scaling.wallRec1Y));
        goals[1] = new Goal(3, new Position(Scaling.wallPos4X, Scaling.wallPos4Y), true,
                new Rectangle(Scaling.wallRec1X, Scaling.wallRec1Y));
        board = new GameBoard(new GameComponent[] { ball, players[0].getBar(), players[1].getBar(), walls[0], walls[1],
                goals[0], goals[1], playsc, displayName });
        window = new GameWindow(board);
        window.addKeyListener(mov.getKeyListener());

        timer.start();
        window.setVisible(true);
    }

    public void endGame() {
        if (score.getPointsOfPlayer(1) >= 3 || score.getPointsOfPlayer(2) >= 3) {
            if (playerNames[0].contentEquals("")) {
                playerNames[0] = "Player 1";
            }
            if (playerNames[1].contentEquals("")) {
                playerNames[1] = "Player 2";
            }
            score.printScore(playerNames);

//            JDialog win = new JDialog(window, "Finish", JDialog.DEFAULT_MODALITY_TYPE);
            window.setVisible(false);
            window.setEnabled(false);
            timer.stop();
            UIManager.put("OptionPane.messageFont", new Font("Impact", Font.PLAIN, 40));
            UIManager.put("OptionPane.buttonFont", new Font("Impact", Font.ITALIC, 20));
            JOptionPane.showConfirmDialog(window,
                    "GAME OVER!\nScore: <" + score.getPointsOfPlayer(2) + " : " + score.getPointsOfPlayer(1) + ">, "
                            + playerNames[0] + " vs. " + playerNames[1],
                    ((score.getPointsOfPlayer(2) > score.getPointsOfPlayer(1)) ? "Player1" : "Player2") + " wins",
                    JOptionPane.PLAIN_MESSAGE, JOptionPane.OK_OPTION);
            System.exit(0);
        }
    }
}
