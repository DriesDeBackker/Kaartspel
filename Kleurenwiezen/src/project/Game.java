package project;

import java.util.ArrayList;

public class Game {
	
	public Game (Player host, GameRules gameRules) {
		this.setHost(host);
		this.addPlayer(host);
		this.setGameRules(gameRules);
	}
	
	private void setGameRules(GameRules gameRules) {
		this.gameRules = gameRules;
	}

	public ArrayList<Player> getPlayers() {
		return players;
	}

	public void setPlayers(ArrayList<Player> players) {
		this.players = players;
	}
	
	public void addPlayer(Player player) {
		if (this.getPlayers().size() < 4) {
			this.players.add(player);
		}
	}
	
	public void removePlayer(Player player) {
		this.players.remove(player);
	}
	
	public Player getHost() {
		return this.host;
	}
	
	public void setHost(Player newHost) {
		this.host = newHost;
	}
	
	private Player host;
	private ArrayList<Player> players;
	private GameRules gameRules;

}
