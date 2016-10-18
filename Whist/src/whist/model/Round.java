package whist.model;

import java.util.ArrayList;

public class Round {

	private Game game;
	private int roundNumber;
	private ArrayList<Trick> tricks;
	private Suit trump;
	
	public Round (Game game, int roundNumber) {
		this.setGame(game);
		this.setRoundNumber(roundNumber);
		this.setTricks(new ArrayList<Trick>());
	}
	
	public ArrayList<Card> getCardsPlayed() {
		ArrayList<Card> playedCards = new ArrayList<Card>();
		for (Trick trick : this.getTricks()) {
			for (Card card : trick.getCards()) {
				playedCards.add(card);
			}
		}
		return null;
	}
	
	public ArrayList<Card> getCardsPlayedBy(Player player) {
		ArrayList<Card> playedCards = new ArrayList<Card>();
		for (Card card : this.getCardsPlayed()) {
			if (card.getOwner() == player) {
				playedCards.add(card);
			}
		}
		return playedCards;
	}
	
	public ArrayList<Card> getCardsPlayedOfSuit(Suit suit) {
		ArrayList<Card> playedCards = new ArrayList<Card>();
		for (Card card : this.getCardsPlayed()) {
			if (card.getSuit() == suit) {
				playedCards.add(card);
			}
		}
		return playedCards;
	}
	
	public ArrayList<Card> getCardsPlayedOfRank(Rank rank) {
		ArrayList<Card> playedCards = new ArrayList<Card>();
		for (Card card : this.getCardsPlayed()) {
			if (card.getRank() == rank) {
				playedCards.add(card);
			}
		}
		return playedCards;
	}
	
	private void setGame(Game game) {
		this.game = game;
	}
	
	public Game getGame() {
		return this.game;
	}

	private void setRoundNumber(int roundNumber) {
		assert(1 <= roundNumber);
		this.roundNumber = roundNumber;
	}
	
	public int getRoundNumber() {
		return this.roundNumber;
	}
	
	public ArrayList<Player> getPlayers () {
		return this.getGame().getPlayers();
	}
	
	public ArrayList<Team> getTeams() {
		return this.getGame().getTeams();
	}
	
	public int getNumberOfTricks() {
		return this.getTricks().size();
	}

	public ArrayList<Trick> getTricks() {
		return tricks;
	}

	private void setTricks(ArrayList<Trick> tricks) {
		this.tricks = tricks;
	}
	
	public Trick getCurrentTrick() {
		return this.getTricks().get(this.getNumberOfTricks() - 1);
	}
	
	public void addTrick(Trick trick) {
		assert(this.getTricks().size() < 13);
		this.tricks.add(trick);
	}

	public Suit getTrump() {
		return trump;
	}

	public void setTrump(Suit trump) {
		this.trump = trump;
	}
	
	public Card getWinningCardOfCurrentTrick() {
		return this.getWinningCardOfTrickNumber(this.getNumberOfTricks());
	}
	
	public Card getWinningCardOfTrickNumber(int trickNumber) {
		assert(trickNumber <= this.getNumberOfTricks());
		return this.getWinningCardOfTrick(this.getTricks().get(trickNumber-1));
	}
	
	public Card getWinningCardOfTrick(Trick trick) {
		return trick.getWinningCard(this.getTrump());
	}
	
}
