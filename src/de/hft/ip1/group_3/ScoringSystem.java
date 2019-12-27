package de.hft.ip1.group_3;

import java.security.InvalidParameterException;

public class ScoringSystem {
	private int pointsPlayer1 = 0;
	private int pointsPlayer2 = 0;
	private int pointsPlayer3 = 0;
	private int pointsPlayer4 = 0;
	private int numberOfPlayers;
	
	ScoringSystem (int numberOfPlayers){
		this.numberOfPlayers = numberOfPlayers;
	}
	
	public int getPointsOfPlayer(int playerNumber) throws InvalidParameterException {
		if (playerNumber > numberOfPlayers) {
			throw new InvalidParameterException("Player does not exist!");
		}
		int playerPoints;
		switch(playerNumber) {
		case 1: playerPoints = pointsPlayer1; break;
		case 2: playerPoints = pointsPlayer2; break;
		case 3: playerPoints = pointsPlayer3; break;
		case 4: playerPoints = pointsPlayer4; break;
		default: throw new InvalidParameterException("Player does not exist!");
		}
		return playerPoints;
	}
	
	public void addPointToPlayer(int playerNumber) {
		if (playerNumber > numberOfPlayers) {
			throw new InvalidParameterException("Player does not exist!");
		}
		switch(playerNumber) {
		case 1: pointsPlayer1++; break;
		case 2: pointsPlayer2++; break;
		case 3: pointsPlayer3++; break;
		case 4: pointsPlayer4++; break;
		default: throw new InvalidParameterException("Player does not exist!");
		}
	}
	
	public void resetPlayerPoints() {
		pointsPlayer1 = 0;
		pointsPlayer2 = 0;
		pointsPlayer3 = 0;
		pointsPlayer4 = 0;
	}
}
