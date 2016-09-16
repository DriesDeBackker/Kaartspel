package whist.model;


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
	
	public void startGame(Game game) {
		game.start();
	}
	
	public void startNextRound(Game game) {
		game.startNexRound();
	}
	
	public void startScoring(Game game) {
		game.startScoring();
	}
	
	public void shuffleCardDeck(CardDeck cardDeck) {
		cardDeck.shuffle();
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
	
}
