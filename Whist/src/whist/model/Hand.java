package whist.model;

import java.util.ArrayList;

public class Hand {
	
	public Hand (Player owner) {
		this.setOwner(owner);
	}
	
	public void sortCards() {
		// TODO Auto-generated method stub
	}
	
	public int countCards() {
		return this.getCards().size();
	}
	
	public int countAces() {
		return countCardsOfRank(14);
	}
	
	public int countCardsOfSuit(int suit) {
		assert(1 <= suit && suit <= 4);
		int numberOfCards = 0;
		for (Card card: this.getCards()) {
			if (card.getSuit() == suit){
				numberOfCards ++;
			}
		} return numberOfCards;
	}
	
	public int countCardsOfRank (int rank) {
		assert(2 <= rank && rank <= 14);
		int numberOfCards = 0;
		for (Card card: this.getCards()) {
			if (card.getRank() == rank){
				numberOfCards ++;
			}
		} return numberOfCards;
	}
	
	public Card getCardBysuitAndRank(int rank, int suit) {
		assert(1 <= suit && suit <= 4);
		assert(2 <= rank && rank <= 14);
		Card cloneCard = new Card(suit, rank);
		Card soughtCard = null;
		for (Card card: this.getCards()) {
			if (cloneCard.isEqualTo(card)) {
				soughtCard = card;
			}
		} return soughtCard;
	}
	
	public boolean isSuitPresent(int suit) {
		boolean suitPresent = false;
		for (Card card: this.getCards()) {
			if (card.getSuit() == suit) {
				suitPresent = true;
			}
		} return suitPresent;
	}
	
	public Card findHighestCardOfSuit(int suit) {
		assert(1 <= suit && suit <= 4);
		assert (this.isSuitPresent(suit));
		Card soughtCard = null;
		int rank = 0;
		for (Card card: this.getCards()) {
			if (card.getSuit() == suit && card.getRank() > rank) {
				soughtCard = card;
				rank = card.getRank();
			}
		} return soughtCard;
	}
	
	public Card findLowestCardOfSuit(int suit) {
		assert(1 <= suit && suit <= 4);
		assert (this.isSuitPresent(suit));
		Card soughtCard = null;
		int rank = 15;
		for (Card card: this.getCards()) {
			if (card.getSuit() == suit && card.getRank() < rank) {
				soughtCard = card;
				rank = card.getRank();
			}
		} return soughtCard;
	}
	
	public void addCard (Card card) {
		this.cards.add(card);
	}
	
	public void removeCard (Card card) {
		for (Card iterationCard: this.getCards()) {
			if (iterationCard.getRank() == card.getRank() && iterationCard.getSuit() == card.getSuit()) {
				this.cards.remove(iterationCard);
			}
		}
	}

	public void setCards(ArrayList<Card> cards) {
		this.cards = cards;
	}
	
	public ArrayList<Card> getCards() {
		return cards;
	}
	
	public boolean isOpen() {
		return open;
	}

	public void setOpen() {
		this.open = true;
	}
	
	public void setClosed() {
		this.open = false;
	}

	public Player getOwner() {
		return owner;
	}

	public void setOwner(Player owner) {
		this.owner = owner;
	}

	private ArrayList<Card> cards;
	private Player owner;
	private boolean open;

}
