package whist.model;

import java.util.ArrayList;

public class Team {
	
	private int number;
	private Player firstPlayer;
	private Player secondPlayer;
	private ArrayList<Trick> tricks;
	private int score;
	
	public Team(int number, Player firstPlayer, Player secondPlayer, int score) {
		this.setNumber(number);
		this.setFirstPlayer(firstPlayer);
		this.setSecondPlayer(secondPlayer);
		this.setScore(score);
		this.setTricks(new ArrayList<Trick>());
	}
	
	public Team(int number, Player firstPlayer, Player secondPlayer) {
		this.setNumber(number);
		this.setFirstPlayer(firstPlayer);
		this.setSecondPlayer(secondPlayer);
		this.setScore(0);
		this.setTricks(new ArrayList<Trick>());
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
	
	private void setTricks(ArrayList<Trick> tricks) {
		this.tricks = tricks;
	}

	public ArrayList<Trick> getTricks() {
		return tricks;
	}

	public void addTrick(Trick trick) {
		this.tricks.add(trick);
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public void increaseScore(int amount) {
		assert(amount >= 0);
		this.setScore(this.getScore() + amount);
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}
	
}
