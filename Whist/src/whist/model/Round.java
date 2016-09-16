package whist.model;

import java.util.ArrayList;

public class Round {

	private Game game;
	private int roundNumber;
	private ArrayList<Trick> tricks;
	
	public Round (Game game, int roundNumber) {
		this.setGame(game);
		this.setRoundNumber(roundNumber);
		this.setTricks(new ArrayList<Trick>());
	}
	
	private void setGame(Game game) {
		this.game = game;
	}
	
	public Game getGame() {
		return this.game;
	}

	private void setRoundNumber(int roundNumber) {
		assert(1 <= roundNumber);
		this.roundNumber = roundNumber;
	}
	
	public int getRoundNumber() {
		return this.roundNumber;
	}
	
	public ArrayList<Player> getPlayers () {
		return this.getGame().getPlayers();
	}
	
	public ArrayList<Team> getTeams() {
		return this.getGame().getTeams();
	}
	
	public int getTrickNumber() {
		return this.getTricks().size();
	}

	public ArrayList<Trick> getTricks() {
		return tricks;
	}

	private void setTricks(ArrayList<Trick> tricks) {
		this.tricks = tricks;
	}
	
	private void addTrick(Trick trick) {
		this.tricks.add(trick);
	}
	
}
