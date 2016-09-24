package whist.model;

import java.util.ArrayList;

public class Game {
	
	private Status status;
	private Player host;
	private ArrayList<Player> players = new ArrayList<Player>();
	private Player currentPlayer;
	private ArrayList<Team> teams;
	private GameRules gameRules;
	private CardDeck cardDeck;
	private ArrayList<Round> rounds;
	
	public Game (Player host, GameRules gameRules, CardDeck cardDeck) {
		this.setHost(host);
		this.addPlayer(host);
		this.setGameRules(gameRules);
		this.setCardDeck(cardDeck);
		this.setIdle();
		this.setRounds(new ArrayList<Round>());
	}
	
	public void start() {
		this.setCurrentPlayer(this.getPlayer(1));
	}
	
	public void goToReady() {
		assert(this.isIdle());
		this.setReady();
	}
	
	public void startDealing() {
		assert(this.isReady());
		this.setDealing();
	}
	
	public void startPlaying() {
		assert(this.isDealing());
		this.setPlaying();
	}
	
	public void startScoring() {
		assert(this.isPlaying());
		this.setScoring();
	}
	
	public Player getDealer() {
		assert(this.hasDealer());
		int playerNumber = this.getCurrentRoundNumber()/4;
		return this.getPlayer(playerNumber);
	}
	
	private boolean hasDealer() {
		return (! this.isIdle() && ! this.isGameOver());
	}
	
	public Round getCurrentRound() {
		return this.getRounds().get(this.getRounds().size()-1);
	}
	
	public int getCurrentRoundNumber() {
		return this.getRounds().size();
	}

	public boolean isIdle() {
		return this.status == Status.IDLE;
	}
	
	public void setIdle() {
		this.status = Status.IDLE;
	}
	
	public boolean isReady() {
		return this.status == Status.READY;
	}
	
	public void setReady() {
		this.status = Status.READY;
	}
	
	public boolean isDealing() {
		return this.status == Status.DEALING;
	}
	
	private void setDealing () {
		this.status = Status.DEALING;
	}
	
	public boolean isPlaying() {
		return this.status == Status.PLAYING;
	}
	
	private void setPlaying() {
		this.status = Status.PLAYING;
	}
	
	public boolean isScoring() {
		return this.status == Status.SCORING;
	}
	
	private void setScoring() {
		this.status = Status.SCORING;
	}
	
	public boolean isGameOver() {
		return this.status == Status.GAMEOVER;
	}
	
	public void setGameOver() {
		this.status = Status.GAMEOVER;
	}
	
	public boolean goalReached() {
		return (this.getFirstTeam().getScore() >= this.getGameRules().getMaximumPoints() || this.getSecondTeam().getScore() >= this.getGameRules().getMaximumPoints());
	}

	public void setGameRules(GameRules gameRules) {
		this.gameRules = gameRules;
	}
	
	public GameRules getGameRules() {
		return this.gameRules;
	}

	public ArrayList<Player> getPlayers() {
		return players;
	}
	
	public Player getPlayer(int number) {
		assert (1 <= number && number <= 4);
		int index = number-1;
		return this.getPlayers().get(index);
	}

	public void setPlayers(ArrayList<Player> players) {
		this.players = players;
	}
	
	public void addPlayer(Player player) {
		this.players.add(player);
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
	
	public ArrayList<Team> getTeams() {
		return teams;
	}
	
	public Team getFirstTeam() {
		return this.getTeams().get(0);
	}
	
	public Team getSecondTeam() {
		return this.getTeams().get(1);
	}

	private void setTeams(ArrayList<Team> teams) {
		assert (teams.size() == 2);
		this.teams = teams;
	}
	
	public void initiateTeams() {
		assert(this.getPlayers().size() == 4);
		Team team1 = new Team(1, this.getPlayer(1), this.getPlayer(3));
		Team team2 = new Team(2, this.getPlayer(2), this.getPlayer(4));
		this.getPlayer(1).setTeam(team1);
		this.getPlayer(2).setTeam(team2);
		this.getPlayer(3).setTeam(team1);
		this.getPlayer(4).setTeam(team2);
		ArrayList<Team> teams = new ArrayList<Team>();
		teams.add(team1); teams.add(team2);
		this.setTeams(teams);
	}

	public Player getCurrentPlayer() {
		return currentPlayer;
	}

	public void setCurrentPlayer(Player currentPlayer) {
		this.currentPlayer = currentPlayer;
	}

	public CardDeck getCardDeck() {
		return cardDeck;
	}

	public void setCardDeck(CardDeck cardDeck) {
		this.cardDeck = cardDeck;
	}

	public ArrayList<Round> getRounds() {
		return rounds;
	}

	private void setRounds(ArrayList<Round> rounds) {
		this.rounds = rounds;
	}
	
	public void addRound(Round round) {
		this.rounds.add(round);
	}

	public void setFirst(Player player) {
		//System.out.println("We gaan de spelervolgorde veranderen");
		//System.out.println("De speler die vooraan komt: " + player.getName());
		ArrayList<Player> newList = new ArrayList<Player>();
		newList.add(player);
		boolean add = false;
		//System.out.println("De eerste iteratieronde");
		for (Player iterationPlayer : this.getPlayers()) {
			//System.out.println("De speler die we overlopen " + iterationPlayer.getName());
			if (add == true) {
				//System.out.println("De speler moet toegevoegd worden: " + iterationPlayer.getName());
				newList.add(iterationPlayer);
			}
			if (iterationPlayer == player) {
				//System.out.println("We zijn de speler tegengekomen die opgegeven is. Alle volgende spelers moeten toegevoegd worden.");
				add = true;
			}
		}
		//System.out.println("De tweede iteratieronde");
		for (Player iterationPlayer2 : this.getPlayers()) {
			//System.out.println("De speler die we overlopen " + iterationPlayer2.getName());
			if (iterationPlayer2 == player) {
				//System.out.println("We zijn de speler tegengekomen die opgegeven is. Alle volgende spelers mogen niet toegevoegd worden.");
				add = false;
			}
			if (add == true) {
				//System.out.println("De speler moet toegevoegd worden: " + iterationPlayer2.getName());
				newList.add(iterationPlayer2);
			}
		}
		//System.out.println("We vervangen de lijst van spelers door de nieuwe lijst in de nieuwe volgorde."); 
		this.setPlayers(newList);
	}
	
}

