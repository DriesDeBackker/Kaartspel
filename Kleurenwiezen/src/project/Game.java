package project;

import java.util.ArrayList;

public class Game {
	
	private int status;
	
	public Game (Player host, GameRules gameRules) {
		this.setHost(host);
		this.addPlayer(host);
		this.setGameRules(gameRules);
		this.setGameIdle();
	}
	
	public void start() {
		int roundNumber = 1;
		while (! this.isGameOver() && ! this.isGameIdle()) {
			ArrayList<String> discussionOptions = this.getDiscussionOptions();
			Discussion discussion = new Discussion(this, players, discussionOptions);
			this.setDiscussionOngoing();
			discussion.start();
			Round round = new Round(roundNumber, discussion.getOutcome(), this.getPlayers(), discussion.getTeams());
			this.setRoundOngoing();
			round.start();
			this.setScoringOngoing();
			this.updateScore();
			roundNumber++;
		}
		// TODO Auto-generated method stub
	}

	private void updateScore() {
		// TODO Auto-generated method stub
	}

	private ArrayList<String> getDiscussionOptions() {
		ArrayList<String> discussionOptions = new ArrayList<String>();
		GameRules rules = this.getGameRules();
		if (rules.carteBlancheAllowed()) 	{ discussionOptions.add("Carte Blanche");}
		if (rules.openTrullAllowed()) 		{ discussionOptions.add("Open Trull");}
		if (rules.closedTrullAllowed()) 	{ discussionOptions.add("Closed Trull");}
		if (rules.fullPassAllowed())		{ discussionOptions.add("Full Pass");}
		discussionOptions.add("Bidding Round");
		if (rules.piccolinoAllowed())			{ discussionOptions.add("Piccolino");}
		if (rules.piccoloAllowed())			{ discussionOptions.add("Piccolo");}
		if (rules.smallMiseryAllowed()) 	{ discussionOptions.add("Small Misery");}
		if (rules.abundanceAllowed())		{ discussionOptions.add("Abundance");}
		if (rules.miseryAllowed()) 			{ discussionOptions.add("Misery");}
		if (rules.smallOpenMiseryAllowed())	{ discussionOptions.add("Small Open Misery");}
		if (rules.openMiseryAllowed())	 	{ discussionOptions.add("Open Misery");}
		if (rules.soloAllowed())		 	{ discussionOptions.add("Solo");}
		if (rules.carteBlancheAllowed()) 	{ discussionOptions.add("Carte Blanche");}
		if (rules.carteBlancheAllowed()) 	{ discussionOptions.add("Carte Blanche");}
		return discussionOptions;
	}
	
	public boolean isGameIdle() {
		return this.status == 1;
	}
	
	public void setGameIdle() {
		this.status = 1;
	}
	
	public boolean isDiscussionOngoing() {
		return this.status == 2;
	}

	private void setDiscussionOngoing() {
		this.status = 2;
	}
	
	public boolean isRoundOngoing() {
		return this.status == 3;
	}
	
	private void setRoundOngoing() {
		this.status = 3;
	}
	
	public boolean isScoringOngoing() {
		return this.status == 4;
	}
	
	private void setScoringOngoing() {
		this.status = 4;
	}
	
	public boolean isGameOver() {
		return this.status == 5;
	}
	
	@SuppressWarnings("unused")
	private void setGameOver() {
		this.status = 5;
	}

	private void setGameRules(GameRules gameRules) {
		this.gameRules = gameRules;
	}
	
	public GameRules getGameRules() {
		return this.gameRules;
	}

	public Players getPlayers() {
		return players;
	}

	public void setPlayers(Players players) {
		this.players = players;
	}
	
	public void addPlayer(Player player) {
		this.players.addPlayer(player);
	}
	
	public void removePlayer(Player player) {
		this.players.removePlayer(player);
	}
	
	public Player getHost() {
		return this.host;
	}
	
	public void setHost(Player newHost) {
		this.host = newHost;
	}
	
	private Player host;
	private Players players;
	private GameRules gameRules;

}
