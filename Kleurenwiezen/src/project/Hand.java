package project;

import java.util.ArrayList;

public class Hand {
	
	/**
	 * Initialize a hand with a certain number.
	 * @param number
	 */
	public Hand (int number) {
		this.setNumber(number);
	}
	
	/**
	 * Sets the number of this hand to a given number.
	 * 
	 * @param 	number
	 * 			The number this hand will be set to.
	 */
	private void setNumber(int number) {
		if (1 <= number && number <= 4) {
			this.number = number;
		}
	}
	
	/**
	 * @return the number of this hand.
	 */
	public int getNumber() {
		return this.number;
	}
	
	
	/**
	 * Adds a card to this hand.
	 * 
	 * @param card
	 */
	public void addCard (Card card) {
		this.cards.add(card);
	}
	
	/**
	 * Removes a given card from this hand.
	 * 
	 * @param 	card
	 * 			The card to be removed from the hand.
	 */
	public void removeCard (Card card) {
		for (Card iterationCard: this.getCards()) {
			if (iterationCard.getRank() == card.getRank() && iterationCard.getSuit() == card.getSuit()) {
				this.cards.remove(iterationCard);
			}
		}
	}

	/**
	 * Sets this hand to a certain array of cards.
	 * 
	 * @param 	cards
	 * 			The hand of cards that will be set.
	 */
	public void setCards(ArrayList<Card> cards) {
		this.cards = cards;
	}
	
	/**
	 * @return the cards of this hand.
	 */
	public ArrayList<Card> getCards() {
		return cards;
	}
	
	/**
	 * Variable registering the number of this hand.
	 */
	private int number;
	
	/**
	 * Variable registering the different cards in the hand.
	 */
	private ArrayList<Card> cards;

}
