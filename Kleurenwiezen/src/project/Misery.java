package project;

import java.util.ArrayList;

public class Misery extends Round {

	private ArrayList<Player> miseryPlayers;

	public Misery(int roundNumber, ArrayList<Player> players, ArrayList<Player> miseryPlayers) {
		super(roundNumber, players);
		this.setMiseryPlayers(miseryPlayers);
	}
	
	public void start() {
		for (int trick = 1; trick < 13; trick++) {
			this.playTrick();
		}
	}
	
	private void setMiseryPlayers(ArrayList<Player> miseryPlayers) {
		this.miseryPlayers = miseryPlayers;
	}
	
	public ArrayList<Player> getMiseryPlayers() {
		return this.miseryPlayers;
	}

}
