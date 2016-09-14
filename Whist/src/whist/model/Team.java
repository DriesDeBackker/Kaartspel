package whist.model;

import java.util.ArrayList;

public class Team {
	
	private Player firstPlayer;
	private Player secondPlayer;
	private ArrayList<Trick> tricks;
	private Score score;
	
	public Team(Player firstPlayer, Player secondPlayer, Score score) {
		this.setFirstPlayer(firstPlayer);
		this.setSecondPlayer(secondPlayer);
		this.setScore(score);
	}
	
	public Team(Player firstPlayer, Player secondPlayer) {
		this.setFirstPlayer(firstPlayer);
		this.setSecondPlayer(secondPlayer);
		this.setScore(new Score(this));
	}

	private void setFirstPlayer(Player firstPlayer) {
		this.firstPlayer = firstPlayer;
	}
	
	public Player getFirstPlayer() {
		return this.firstPlayer;
	}

	private void setSecondPlayer(Player secondPlayer) {
		this.secondPlayer = secondPlayer;
	}
	
	public Player getSecondPlayer() {
		return this.secondPlayer;
	}

	public ArrayList<Trick> getTricks() {
		return tricks;
	}

	public void addTrick(Trick trick) {
		this.tricks.add(trick);
	}

	public Score getScore() {
		return score;
	}

	public void setScore(Score score) {
		this.score = score;
	}
	
	public int getCurrentPoints() {
		return this.score.getLastScoreEntry();
	}
	
}
