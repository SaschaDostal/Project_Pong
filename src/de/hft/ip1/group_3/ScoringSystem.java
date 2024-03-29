package de.hft.ip1.group_3;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.security.InvalidParameterException;

public class ScoringSystem {
    private int pointsPlayer1 = 0;
    private int pointsPlayer2 = 0;
    private int pointsPlayer3 = 0;
    private int pointsPlayer4 = 0;
    private int numberOfPlayers;
    public int maxScore;

    public ScoringSystem(int numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
    }
    
    public void setMaxScore(int maxScore) {
        this.maxScore = maxScore;
    }
    
    public int getPointsOfPlayer(int playerNumber) throws InvalidParameterException {
        if (playerNumber > numberOfPlayers) {
            throw new InvalidParameterException("Player does not exist!");
        }
        int playerPoints;
        switch (playerNumber) {
        case 1:
            playerPoints = pointsPlayer1;
            break;
        case 2:
            playerPoints = pointsPlayer2;
            break;
        case 3:
            playerPoints = pointsPlayer3;
            break;
        case 4:
            playerPoints = pointsPlayer4;
            break;
        default:
            throw new InvalidParameterException("Player does not exist!");
        }
        return playerPoints;
    }

    public void addPointToPlayer(int playerNumber) throws InvalidParameterException {
        if (playerNumber > numberOfPlayers) {
            throw new InvalidParameterException("Player does not exist!");
        }
        switch (playerNumber) {
        case 1:
            pointsPlayer1++;
            break;
        case 2:
            pointsPlayer2++;
            break;
        case 3:
            pointsPlayer3++;
            break;
        case 4:
            pointsPlayer4++;
            break;
        default:
            throw new InvalidParameterException("Player does not exist!");
        }
    }

    public void resetPlayerPoints() {
        pointsPlayer1 = 0;
        pointsPlayer2 = 0;
        pointsPlayer3 = 0;
        pointsPlayer4 = 0;
    }

    public void printScore(String[] names) throws InvalidParameterException {
        if (maxScore == 3) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("Scores3.txt", true));) {
                if (names.length < numberOfPlayers) {
                    throw new InvalidParameterException("Not enough names for all players!");
                }
                switch (numberOfPlayers) {
                case 1:
                    writer.append("Score: " + names[0] + ": " + pointsPlayer1 + "\n");
                    break;
                case 2:
                    writer.append("Score: <" + pointsPlayer2 + " : " + pointsPlayer1 + ">, " + names[0] + " vs. "
                            + names[1] + "\n");
                    break;
                case 3:
                    writer.append("Scores: " + names[0] + ": " + pointsPlayer1 + ", " + names[1] + ": " + pointsPlayer2
                            + ", " + names[2] + ": " + pointsPlayer3 + "\n");
                    break;
                case 4:
                    writer.append("Scores: " + names[0] + ": " + pointsPlayer1 + ", " + names[1] + ": " + pointsPlayer2
                            + ", " + names[2] + ": " + pointsPlayer3 + ", " + names[3] + ": " + pointsPlayer4 + "\n");
                    break;
                }
            } catch (IOException e) {
                System.out.println(e);
            }
        }
        if (maxScore == 5) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("Scores5.txt", true));) {
                if (names.length < numberOfPlayers) {
                    throw new InvalidParameterException("Not enough names for all players!");
                }
                switch (numberOfPlayers) {
                case 1:
                    writer.append("Score: " + names[0] + ": " + pointsPlayer1 + "\n");
                    break;
                case 2:
                    writer.append("Score: <" + pointsPlayer2 + " : " + pointsPlayer1 + ">, " + names[0] + " vs. "
                            + names[1] + "\n");
                    break;
                case 3:
                    writer.append("Scores: " + names[0] + ": " + pointsPlayer1 + ", " + names[1] + ": " + pointsPlayer2
                            + ", " + names[2] + ": " + pointsPlayer3 + "\n");
                    break;
                case 4:
                    writer.append("Scores: " + names[0] + ": " + pointsPlayer1 + ", " + names[1] + ": " + pointsPlayer2
                            + ", " + names[2] + ": " + pointsPlayer3 + ", " + names[3] + ": " + pointsPlayer4 + "\n");
                    break;
                }
            } catch (IOException e) {
                System.out.println(e);
            }
        }
        if (maxScore == 10) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("Scores10.txt", true));) {
                if (names.length < numberOfPlayers) {
                    throw new InvalidParameterException("Not enough names for all players!");
                }
                switch (numberOfPlayers) {
                case 1:
                    writer.append("Score: " + names[0] + ": " + pointsPlayer1 + "\n");
                    break;
                case 2:
                    writer.append("Score: <" + pointsPlayer2 + " : " + pointsPlayer1 + ">, " + names[0] + " vs. "
                            + names[1] + "\n");
                    break;
                case 3:
                    writer.append("Scores: " + names[0] + ": " + pointsPlayer1 + ", " + names[1] + ": " + pointsPlayer2
                            + ", " + names[2] + ": " + pointsPlayer3 + "\n");
                    break;
                case 4:
                    writer.append("Scores: " + names[0] + ": " + pointsPlayer1 + ", " + names[1] + ": " + pointsPlayer2
                            + ", " + names[2] + ": " + pointsPlayer3 + ", " + names[3] + ": " + pointsPlayer4 + "\n");
                    break;
                }
            } catch (IOException e) {
                System.out.println(e);
            }
        }
    }

}
