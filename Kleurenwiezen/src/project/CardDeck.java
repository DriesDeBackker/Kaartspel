package project;

import java.util.ArrayList;

public class CardDeck {
	
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
	
	private void setCards(ArrayList<Card> cards) {
		this.cards = cards;
	}
	
	/**
	 * 
	 * @return the cards of the deck.
	 */
	public ArrayList<Card> getCards() {
		return cards;
	}
	
	/**
	 * 
	 * @param 	rank
	 * 			The rank of the card that we are looking for.
	 * 
	 * @param 	suit
	 * 			The suit of the card that we are looking for.
	 * 
	 * @return
	 */
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
	
	public Card getCardByNumber(int number) {
		return this.getCards().get(number-1);
	}


	private ArrayList<Card> cards = new ArrayList<Card>();
	
}
