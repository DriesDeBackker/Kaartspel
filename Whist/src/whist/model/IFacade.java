package whist.model;

/**
 * Implement this interface to connect your code to the user interface.
 * 
 */
public interface IFacade {

	void createGame();
	
	void startGame();

	void createDeck();
	
	void createPlayers();
	
	void shuffleDeck();
	
	void cutDeck();
	
	void isGameIdle();
	
	void setGameIdle();
	
	void isGameReady();
	
	void setGameReady();
	
	void isRoundOngoing();
	
	void setRoundOngoing();
	
	void isScoringOngoing();	
	
	void isGameOver();
	
	void getCurrentRound();


}
