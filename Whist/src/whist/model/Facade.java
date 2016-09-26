package whist.model;

import java.util.ArrayList;

public class Facade implements IFacade {
	
	public Player createHost(String name, int number) {
		return new Player(name, number);
	}
	
	public Player getHost(Game game) {
		return game.getHost();
	}	
	
	public Player createPlayer(String name, int number) {
		return new Player(name, number);
	}
	
	public GameRules createGameRules() {
		return new GameRules();
	}
	
	public CardDeck createDeck() {
		return new CardDeck();
	}
	
	public void shuffleDeck(CardDeck deck) {
		deck.shuffle();
	}

	public void cutDeck(CardDeck deck, int number) {
		deck.cut(number);
	}
	
	public Game createGame(Player host, GameRules rules, CardDeck deck) {
		return new Game(host, rules, deck);
	}
	
	public void addPlayer(Game game, Player player) {
		game.addPlayer(player);
	}
	
	public void startGame(Game game) {
		game.start();
	}
	
	public boolean isGameIdle(Game game) {
		return game.isIdle();
	}

	public void setGameIdle(Game game) {
		game.setIdle();
	}

	public boolean isGameReady(Game game) {
		return game.isReady();
	}
	
	public void goToReady(Game game) {
		game.goToReady();
	}

	public boolean isDealing(Game game) {
		return game.isDealing();
	}

	public void startDealing(Game game) {
		game.startDealing();
	}

	public boolean isPlaying(Game game) {
		return game.isPlaying();
	}

	public void startPlaying(Game game) {
		game.startPlaying();
	}
	
	public void startScoring(Game game) {
		game.startScoring();
	}

	public boolean isGameOver(Game game) {
		return game.isGameOver();
	}

	public void setGameOver(Game game) {
		game.setGameOver();
	}

	public Round getCurrentRound(Game game) {
		return game.getCurrentRound();
	}

	public int getCurrentRoundNumber(Game game) {
		return game.getCurrentRoundNumber();
	}

	public GameRules getGameRules(Game game) {
		return game.getGameRules();
	}
	
	public void setGameRules(Game game, GameRules newGameRules) {
		game.setGameRules(newGameRules);
	}

	public CardDeck getCardDeck(Game game) {
		return game.getCardDeck();
	}

	public Player getFirstPlayer(Game game) {
		return game.getPlayer(1);
	}
	
	public Player getSecondPlayer(Game game) {
		return game.getPlayer(2);
	}
	
	public Player getThirdPlayer(Game game) {
		return game.getPlayer(3);
	}
	
	public Player getFourthPlayer(Game game) {
		return game.getPlayer(4);
	}
	
	public Player getCurrentPlayer(Game game) {
		return game.getCurrentPlayer();
	}
	
	public ArrayList<Player> getPlayers(Game game) {
		return game.getPlayers();
	}
	
	public boolean allPlayersPresent(Game game) {
		return this.getPlayers(game).size() == 4;
	}
	
	public boolean allPlayersActive(Game game) {
		ArrayList<Player> players = game.getPlayers();
		return (players.get(0).isActive() && players.get(1).isActive() && players.get(2).isActive() && players.get(3).isActive());
	}
	
	public int numberOfAvailablePlayers(Game game) {
		return game.getPlayers().size();
	}
	
	public void createTeams(Game game) {
		game.initiateTeams();
	}
	
	public ArrayList<Team> getTeams(Game game) {
		return game.getTeams();
	}
	
	public Team getFirstTeam(Game game) {
		return game.getFirstTeam();
	}
	
	public Team getSecondTeam(Game game) {
		return game.getSecondTeam();
	}
	
	public int getTeamNumber(Team team) {
		return team.getNumber();
	}
	
	public int getScore(Team team) {
		return team.getScore();
	}

	public void dealCards(Game game, Player player, int amount) {
		game.getCardDeck().dealCards(amount, player);	
	}

	public Trick createTrick() {
		return new Trick();
	}
	
	public void addTrick(Game game, Trick trick) {
		game.getCurrentRound().addTrick(trick);
	}
	
	public void addTrick(Player player, Trick trick) {
		player.addTrick(trick);
	}
	
	public ArrayList<Trick> getTricks(Player player) {
		return player.getTricks();
	}
	
	public void addTrick(Team team, Trick trick) {
		team.addTrick(trick);
	}
	
	public ArrayList<Trick> getTricks(Team team) {
		return team.getTricks();
	}
	
	public Trick getCurrentTrick(Game game) {
		return game.getCurrentRound().getCurrentTrick();
	}
	
	public Round createRound(Game game, int number) {
		return new Round(game, number);
	}

	public void addRound(Game game, Round round) {
		game.addRound(round);
	}

	public void addCard(Game game, Card card) {
		game.getCurrentRound().getCurrentTrick().addCard(card);		
	}
	
	public ArrayList<Card> getCards(Player player) {
		return player.getHand().getCards();
	}
	
	public Hand getHand(Player player) {
		return player.getHand();
	}

	public Card getLeadingCard(Trick trick) {
		return trick.getLeadingCard();
	}

	public Suit getTrump(Game game) {
		return this.getCurrentRound(game).getTrump();
	}
	
	public void setTrump(Game game, Suit trump) {
		game.getCurrentRound().setTrump(trump);
	}

	public ArrayList<Card> getCurrentTrickCards(Game game) {
		return game.getCurrentRound().getCurrentTrick().getCards();
	}

	public void setTrickOwner(Trick trick, Player player) {
		trick.setOwner(player);
	}

	public void removeCardByNumber(Player player, int cardNumber) {
		player.getHand().getCards().remove(cardNumber-1);
	}

	public void setFirst(Game game, Player owner) {
		game.setFirst(owner);
	}

	public void sortCards(Player player) {
		player.getHand().sortCards();
	}

	public void setCurrentPlayer(Game game, Player player) {
		game.setCurrentPlayer(player);
	}
	
	public Player getCardOwner(Card card) {
		return card.getOwner();
	}
	
	public Team getCardOwnerTeam(Card card) {
		return card.getOwner().getTeam();
	}

	public void increaseScoreOfBy(Team team, int amount) {
		team.increaseScore(amount);
	}

	public Player getFirstPlayer(Team team) {
		return team.getFirstPlayer();
	}
	
	public Player getSecondPlayer(Team team) {
		return team.getSecondPlayer();
	}

	public void addCardToDeck(Game game, Card card) {
		game.getCardDeck().addCard(card);
	}

	public void clearTricks(Player player) {
		player.clearTricks();
	}
	
	public void clearTricks(Team team) {
		team.clearTricks();
	}
		
}
