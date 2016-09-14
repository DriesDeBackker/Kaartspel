package project;

import java.util.ArrayList;

public class Score {
	
	private Team team;
	private ArrayList<Integer> scoreEntries;
	private ArrayList<String> roundTypes;
	
	public Score (Team team) {
		this.setTeam(team);
	}

	private void setTeam(Team team) {
		this.team = team;
	}
	
	public Team getTeam() {
		return this.team;
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

}
