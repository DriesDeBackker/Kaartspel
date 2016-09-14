package whist.model;

import java.util.ArrayList;

public class CardDeck {
	
	
	/**
	 * @invar	The amount of cards in the deck is always between 0 and 52.
	 */
	
	public CardDeck () {
		this.setCards(generateCards());
	}
	
	/**
	 * Generate a new card deck.
	 * 
	 * @return the new deck
	 */
	private ArrayList<Card> generateCards() {
		ArrayList<Card> cards = new ArrayList<Card>();
		for(int suit = 1; suit <= 4; suit++) {
			for(int rank=1; rank<=13; rank++) {
				cards.add(new Card(suit,rank));
			}
		}
		return cards;
	}
	
	public void dealCards(int number, Player player) {
		assert(1 <= number && number <= 52);
		for (int i = 1; i == number; i++) {
			this.dealCard(player);
		}
	}
	
	public void dealCard(Player player) {
		assert(this.getCards().size() > 0);
		Card card = this.drawCard();
		player.getHand().addCard(card);
	}
	
	private Card drawCard() {
		assert(this.getCards().size() > 0);
		Card card = this.getCards().get(0);
		this.cards.remove(card);
		return card;
	}
	
	private void setCards(ArrayList<Card> cards) {
		this.cards = cards;
	}
	
	public ArrayList<Card> getCards() {
		return cards;
	}
	
	public Card getCardByNumber(int number) {
		return this.getCards().get(number-1);
	}
	
	public Card getCardBysuitAndRank(int rank, int suit) {
		Card cloneCard = new Card(suit, rank);
		Card soughtCard = null;
		for (Card card: this.getCards()) {
			if (cloneCard.isEqualTo(card)) {
				soughtCard = card;
			}
		}
		return soughtCard;
	}
	
	public int getNumberOfCardsInDeck() {
		return this.getCards().size();
	}
	
	public boolean areCardsDealt() {
		return (this.getNumberOfCardsInDeck() == 0);
	}

	
	private ArrayList<Card> cards = new ArrayList<Card>();
}
