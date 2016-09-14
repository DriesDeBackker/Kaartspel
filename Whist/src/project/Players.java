package project;

import java.util.ArrayList;

public class Players {
	
	private ArrayList<Player> players;

	public Players(ArrayList<Player> players) {
		this.setPlayers(players);
	}

	private void setPlayers(ArrayList<Player> players) {
		this.players = players;
	}
	
	public ArrayList<Player> getPlayers() {
		return this.players;
	}
	
	public Player getPlayer(int number) {
		assert(this.getPlayers().size() > number);
		return this.players.get(number-1);
	}
	
	public void addPlayer(Player player) {
		assert(this.getPlayers().size() < 4);
		this.players.add(player);
	}
	
	public void removePlayer(Player player) {
		assert(this.getPlayers().contains(player));
		this.players.remove(player);
		
	}
	
	public Player getFirstPlayer() {
		assert(this.getPlayers().size() > 0);
		return this.getPlayers().get(0);
	}
	
	public Player getSecondPlayer() {
		assert(this.getPlayers().size() > 1);
		return this.getPlayers().get(1);
	}
	
	public Player getThirdPlayer() {
		assert(this.getPlayers().size() > 2);
		return this.getPlayers().get(2);
	}
	
	public Player getFourthPlayer() {
		assert(this.getPlayers().size() > 3);
		return this.getPlayers().get(3);
	}

}
