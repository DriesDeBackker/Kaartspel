package project;

import java.util.ArrayList;

public class Round {

	
	public Round (int roundNumber, ArrayList<Player> players) {
		this.setRoundNumber(roundNumber);
		this.setPlayers(players);
	}
	
	public void start() {
	}
	
	public void playTrick() {
		Trick trick = new Trick();
		Card firstCard = this.getPlayers().get(0).playCard();
		trick.addCard(firstCard);
		Card secondCard = this.getPlayers().get(1).playCard();
		trick.addCard(secondCard);
		Card thirdCard = this.getPlayers().get(2).playCard();
		trick.addCard(thirdCard);
		Card fourthCard = this.getPlayers().get(3).playCard();
		trick.addCard(fourthCard);
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
	
	private int roundNumber;
	private ArrayList<Player> players;

}
