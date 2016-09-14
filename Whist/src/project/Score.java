package project;

import java.util.ArrayList;

public class Score {
	
	public Score (Player player) {
		this.setPlayer(player);
	}

	private void setPlayer(Player player) {
		this.player = player;
	}
	
	public Player getPlayer() {
		return this.player;
	}
	
	public ArrayList<Integer> getScoreEntries() {
		return this.scoreEntries;
	}
	
	public int getLastScoreEntry() {
		return this.scoreEntries.get(this.scoreEntries.size()-1);
	}

	@SuppressWarnings("unused")
	private void setScore(ArrayList<Integer> score) {
		this.scoreEntries = score;
	}
	
	public void addScoreEntry(int scoreEntry) {
		this.scoreEntries.add(scoreEntry);
	}
	
	public void updateScore(int points, String roundType) {
		int lastScore = this.getLastScoreEntry();
		int newScore = lastScore + points;
		this.addScoreEntry(newScore);
		this.addRoundType(roundType);
	}
	
	public void addRoundType(String roundType) {
		this.roundTypes.add(roundType);
	}

	private Player player;
	private ArrayList<Integer> scoreEntries;
	private ArrayList<String> roundTypes;

}
