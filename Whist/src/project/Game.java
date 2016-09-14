package project;

import java.util.ArrayList;

public class Game {
	
	private int status;
	private Player host;
	private Players players;
	private ArrayList<Team> teams;
	private GameRules gameRules;
	private Round round;
	private int roundNumber;
	
	public Game (Player host, GameRules gameRules) {
		this.setHost(host);
		this.addPlayer(host);
		this.setGameRules(gameRules);
		this.setGameIdle();
		this.setRoundNumber(0);
	}
	
	public void start() {
		while (this.isGameIdle()) {
			if (this.getPlayers().getPlayers().size() == 4) {
				this.setGameReady();
			}
		}
		if (this.isGameReady()) {
			this.setRoundNumber(1);
			while (! this.isGameOver()) {
				this.setRound(new Round(this, roundNumber));
				this.setRoundOngoing();
				this.getRound().start();
				this.setScoringOngoing();
				this.updateScore();
				this.setRoundNumber(this.getRoundNumber() + 1);
				if (this.goalReached()) {
					this.setGameOver();
				}
			}
		}
		
	}
	
	private void setRound(Round round) {
		this.round = round;
	}
	
	public Round getRound() {
		return this.round;
	}

	public boolean isGameIdle() {
		return this.status == 1;
	}
	
	public void setGameIdle() {
		this.status = 1;
	}
	
	public void setGameReady() {
		this.status = 2;
	}
	
	public boolean isGameReady() {
		return this.status == 2;
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
	
	private void setGameOver() {
		this.status = 5;
	}
	
	public boolean goalReached() {
		return (this.getFirstTeam().getCurrentPoints() >= this.getGameRules().getMaximumPoints());
	}
	
	private void updateScore() {
		// TODO Auto-generated method stub
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
	
	public ArrayList<Team> getTeams() {
		return teams;
	}
	
	public Team getFirstTeam() {
		return this.getTeams().get(0);
	}
	
	public Team getSecondTeam() {
		return this.getTeams().get(0);
	}

	private void setTeams(ArrayList<Team> teams) {
		assert (teams.size() == 2);
		this.teams = teams;
	}
	
	public void initiateTeams() {
		Players players = this.getPlayers();
		assert(players.getPlayers().size() == 4);
		Team team1 = new Team(players.getFirstPlayer(), players.getThirdPlayer());
		Team team2 = new Team(players.getSecondPlayer(), players.getFourthPlayer());
		ArrayList<Team> teams = new ArrayList<Team>();
		teams.add(team1); teams.add(team2);
		this.setTeams(teams);
	}

	public int getRoundNumber() {
		return roundNumber;
	}

	public void setRoundNumber(int roundNumber) {
		this.roundNumber = roundNumber;
	}

}
