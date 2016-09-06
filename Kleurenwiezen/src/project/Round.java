package project;

import java.util.ArrayList;

public class Round {

	public Round (int roundNumber, String roundType, Players players, ArrayList<Team> teams) {
		this.setRoundNumber(roundNumber);
		this.setRoundType(roundType);
		this.setPlayers(players);
		this.setTeams(teams);
		this.setTrickNumber(1);
	}

	private void setRoundType(String roundType) {
		this.roundType = roundType;
	}
	
	public String getRoundType() {
		return this.roundType;
	}

	public void start() {
		while (this.getTrickNumber() < 14) {
			this.playTrick();
		}
	}
	
	public void playTrick() {
		Trick trick = new Trick();
		Card firstCard = this.getPlayers().getFirstPlayer().playCard();
		trick.addCard(firstCard);
		Card secondCard = this.getPlayers().getSecondPlayer().playCard();
		trick.addCard(secondCard);
		Card thirdCard = this.getPlayers().getThirdPlayer().playCard();
		trick.addCard(thirdCard);
		Card fourthCard = this.getPlayers().getFourthPlayer().playCard();
		trick.addCard(fourthCard);
	}

	private void setRoundNumber(int roundNumber) {
		this.roundNumber = roundNumber;
	}
	
	public int getRoundNumber() {
		return this.roundNumber;
	}
	
	public Players getPlayers () {
		return this.players;
	}
	
	public ArrayList<Player> getListOfPlayers() {
		return this.getPlayers().getPlayers();
	}

	private void setPlayers(Players players) {
		this.players = players;
	}
	
	public ArrayList<Team> getTeams() {
		return this.teams;
	}
	
	private void setTeams(ArrayList<Team> teams) {
		this.teams = teams;
	}
	
	private void setTrickNumber(int trickNumber) {
		this.trickNumber = trickNumber;
	}
	
	public int getTrickNumber() {
		return this.trickNumber;
	}
	
	private int roundNumber;
	private String roundType;
	private Players players;
	private ArrayList<Team> teams;
	private int trickNumber;

}
