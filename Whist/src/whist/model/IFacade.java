package whist.model;

import java.util.ArrayList;

/**
 * Implement this interface to connect your code to the user interface.
 * 
 */
public interface IFacade {
	
	Player createHost(String name, int number);
	
	GameRules createGameRules();
	
	Game createGame(Player host, GameRules rules, CardDeck deck);
	
	void startGame(Game game);
	
	void startScoring(Game game);

	CardDeck createDeck();
	
	void shuffleDeck(CardDeck deck);
	
	void cutDeck(CardDeck deck, int number);
	
	void dealCards(Game game, Player player, int amount) ;
	
	Player createPlayer(String name, int number);
	
	void addPlayer(Game game, Player player);
	
	boolean isGameIdle(Game game);
	
	void setGameIdle(Game game);
	
	boolean isGameReady(Game game);
	
	void goToReady(Game game);
	
	boolean isDealing(Game game);
	
	void startDealing(Game game);
	
	boolean isPlaying(Game game);
	
	void startPlaying(Game game);
	
	boolean isGameOver(Game game);
	
	void setGameOver(Game game);
	
	Round getCurrentRound(Game game);
	
	int getCurrentRoundNumber(Game game);
	
	GameRules getGameRules(Game game);
	
	CardDeck getCardDeck(Game game);
	
	void setGameRules(Game game, GameRules rules);
	
	Player getFirstPlayer(Game game);
	
	Player getSecondPlayer(Game game);
	
	Player getThirdPlayer(Game game);
	
	Player getFourthPlayer(Game game);
	
	Player getCurrentPlayer(Game game);
	
	ArrayList<Player> getPlayers(Game game);
	
	boolean allPlayersPresent(Game game);
	
	int numberOfAvailablePlayers(Game game);
	
	boolean allPlayersActive(Game game);
	
	Trick createTrick();
	
	void addTrick(Game game, Trick trick);
	
	Trick getCurrentTrick(Game game);
	
	Round createRound(Game game, int number);
	
	void addRound(Game game, Round round);
	
	Card getLeadingCard(Trick trick);
	
	Suit getTrump(Game game);
	
	void setTrump(Game game, Suit trump);
	
	Object getCurrentTrickCards(Game game);
	
	Hand getHand(Player player);
	
	ArrayList<Card> getCards(Player player);
	
	void sortCards(Player player);
	
	void addTrick(Player player, Trick trick);
	
}
