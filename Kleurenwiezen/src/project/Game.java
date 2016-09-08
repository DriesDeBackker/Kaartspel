package project;

import java.util.ArrayList;

public class Game {
	
	private boolean gameOver;
	
	public Game (Player host, GameRules gameRules) {
		this.setHost(host);
		this.addPlayer(host);
		this.setGameRules(gameRules);
		this.setGameNotOver();
	}
	
	public void start() {
		int roundNumber = 1;
		while (! this.isGameOver()) {
			ArrayList<String> discussionOptions = this.getDiscussionOptions();
			Discussion discussion = new Discussion(this, players, discussionOptions);
			discussion.start();
			Round round = new Round(roundNumber, discussion.getOutcome(), this.getPlayers(), discussion.getTeams());
			round.start();
			roundNumber++;
		}
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

	public boolean isGameOver() {
		return this.gameOver;
	}
	
	@SuppressWarnings("unused")
	private void setGameOver() {
		this.gameOver = true;
	}
	
	private void setGameNotOver() {
		this.gameOver = false;
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
