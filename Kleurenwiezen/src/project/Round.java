package project;

import java.util.ArrayList;

public class Round {

	
	public Round (int roundNumber, RoundType roundType, ArrayList<Player> players) {
		this.setRoundNumber(roundNumber);
		this.setroundType(roundType);
		this.setPlayers(players);
	}

	private void setRoundNumber(int roundNumber) {
		this.roundNumber = roundNumber;
	}
	
	public int getRoundNumber() {
		return this.roundNumber;
	}
	
	public ArrayList<Player> getPlayers () {
		return this.players;
	}

	private void setPlayers(ArrayList<Player> players) {
		this.players = players;
	}

	public RoundType getRoundType() {
		return this.roundType;
	}

	private void setroundType(RoundType roundType) {
		this.roundType = roundType;
	}
	
	private int roundNumber;
	private RoundType roundType;
	private ArrayList<Player> players;

}
