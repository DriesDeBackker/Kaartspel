package whist.model;

import java.util.ArrayList;

public class Facade implements IFacade {
	
	public Player createHost(String name, int number) {
		return new Player(name, number);
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
	
	public void goToReady(Game game) {
		game.goToReady();
	}
	
	public void startScoring(Game game) {
		game.startScoring();
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

	public void setGameReady(Game game) {
		game.setReady();
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

	public void dealCards(Game game, Player player, int amount) {
		game.getCardDeck().dealCards(amount, player);	
	}

	public Trick createTrick() {
		return new Trick();
	}
	
	public void addTrick(Game game, Trick trick) {
		game.getCurrentRound().addTrick(trick);
	}
	
	public Trick getCurrentTrick(Game game) {
		return game.getCurrentRound().getLastTrick();
	}
	
	public Round createRound(Game game, int number) {
		return new Round(game, number);
	}

	public void addRound(Game game, Round round) {
		game.addRound(round);
	}

	public void addCard(Game game, Card card) {
		game.getCurrentRound().getLastTrick().addCard(card);		
	}

	@Override
	public Card getLeadingCard(Trick trick) {
		return trick.getLeadingCard();
	}

	public Suit getTrump(Game game) {
		return this.getCurrentRound(game).getTrump();
	}

	public ArrayList<Card> getLastTrickCards(Game game) {
		return game.getCurrentRound().getLastTrick().getCards();
	}
	
}
