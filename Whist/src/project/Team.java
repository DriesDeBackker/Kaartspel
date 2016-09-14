package project;

import java.util.ArrayList;

public class Team {
	
	private ArrayList<Player> players;
	private ArrayList<Trick> tricks;
	private String roundType;
	private boolean attemptingTeam;
	
	public Team(ArrayList<Player> players, String roundType, boolean attemptingTeam) {
		this.setPlayers(players);
		this.setRoundType(roundType);
		this.setAttemptingTeam(attemptingTeam);
	}

	private void setPlayers(ArrayList<Player> players) {
		this.players = players;
	}
	
	public ArrayList<Player> getPlayers () {
		return this.players;
	}

	public ArrayList<Trick> getTricks() {
		return tricks;
	}

	public void addTrick(Trick trick) {
		this.tricks.add(trick);
	}

	public String getRoundType() {
		return roundType;
	}

	public void setRoundType(String roundType) {
		this.roundType = roundType;
	}

	public boolean isAttemptingTeam() {
		return attemptingTeam;
	}

	public void setAttemptingTeam(boolean attemptingTeam) {
		this.attemptingTeam = attemptingTeam;
	}
	
}
