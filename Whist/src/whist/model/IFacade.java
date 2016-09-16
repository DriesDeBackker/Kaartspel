package whist.model;

/**
 * Implement this interface to connect your code to the user interface.
 * 
 */
public interface IFacade {
	
	Player createHost(String name, int number);
	
	GameRules createGameRules();
	
	Game createGame(Player host, GameRules rules, CardDeck deck);
	
	void startGame(Game game);
	
	void startNextRound(Game game);
	
	void startScoring(Game game);

	CardDeck createDeck();
	
	void shuffleDeck(CardDeck deck);
	
	void cutDeck(CardDeck deck, int number);
	
	Player createPlayer(String name, int number);
	
	boolean isGameIdle(Game game);
	
	void setGameIdle(Game game);
	
	boolean isGameReady(Game game);
	
	void setGameReady(Game game);
	
	boolean isDealing(Game game);
	
	void startDealing(Game game);
	
	boolean isPlaying(Game game);
	
	void startPlaying(Game game);
	
	boolean isGameOver(Game game);
	
	void setGameOver(Game game);
	
	Round getCurrentRound(Game game);
	
	int getCurrentRoundNumber(Game game);


}
