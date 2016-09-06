package project;


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
			Discussion discussion = new Discussion(this, players);
			discussion.start();
			Round round = new Round(roundNumber, discussion.getOutcome(), this.getPlayers(), discussion.getTeams());
			round.start();
			roundNumber++;
		}
		// TODO Auto-generated method stub
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
