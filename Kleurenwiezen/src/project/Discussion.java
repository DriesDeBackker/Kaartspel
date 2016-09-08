package project;

import java.util.ArrayList;
import java.util.List;

public class Discussion {
	
	private Game game;
	private List<String> options;
	private Players players;
	private ArrayList<Team> teams;
	private String outcome;
	private Player currentPlayer;
	private boolean discussionOver;
	
	
	public Discussion(Game game, Players players, ArrayList<String> options) {
		this.setPlayers(players);
		this.setDiscussionNotOver();
		this.setOptions(options);
	}
	

	public void start() {
		GameRules gameRules = this.getGameRules();
		if (gameRules.closedTrullAllowed() || gameRules.openTrullAllowed()) {
			this.askTrull();
		}
		if (! this.isDiscussionOver() && gameRules.carteBlancheAllowed()) {
			this.askCarteBlanche();
		}
		if (! this.isDiscussionOver()) {
						
		}
		if (! this.isDiscussionOver()) {
			
		}
		
	}
	
	public void askTrull() {
		for (Player player: this.players.getPlayers()) {
			this.setCurrentPlayer(player);
			if (player.hasTrull()) {
				this.setOutcome("Closed Trull");
			}
			
		}
	}
	
	private void askCarteBlanche() {
		// TODO Auto-generated method stub
		
	}

	private void setDiscussionNotOver() {
		this.discussionOver = false;
	}
	
	@SuppressWarnings("unused")
	private void setDiscussionOver() {
		this.discussionOver = true;
	}
	
	private boolean isDiscussionOver() {
		return this.discussionOver;
	}
	
	public GameRules getGameRules() {
		return this.getGame().getGameRules();
	}

	public Players getPlayers() {
		return players;
	}

	public void setPlayers(Players players) {
		this.players = players;
	}

	public List<String> getOptions() {
		return options;
	}
	
	private void setOptions(ArrayList<String> options) {
		this.options = options;
	}
	
	public void removeOptionsUpTo(String option) {
		int index = 0;
		while(!(this.options.get(index) == option)) {
			this.options.remove(index);
		}
	}

	public String getOutcome() {
		return outcome;
	}

	public void setOutcome(String outcome) {
		this.outcome = outcome;
	}

	public ArrayList<Team> getTeams() {
		return teams;
	}

	public void setTeams(ArrayList<Team> teams) {
		this.teams = teams;
	}
	
	public void addTeam(Team team) {
		this.teams.add(team);
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public Player getCurrentPlayer() {
		return currentPlayer;
	}

	public void setCurrentPlayer(Player currentPlayer) {
		this.currentPlayer = currentPlayer;
	}
	
}
