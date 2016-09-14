package whist.model;


public class Card {
	
	/**
	 * Initialize a card with a given suit, rank and owner.
	 * 
	 * @param 	suit
	 * 		   	The suit of this card. This can be 1 (Hearts), 2 (Diamonds), 3 (Clubs), or 4 (Spades).
	 * 
	 * @param 	rank
	 * 			The rank of the card. This can be 2, ..... , 12, 13, 14. An ace is 14, a king is thirteen.
	 * 
	 * @param   owner
	 * 			The owner of this card. This is one of the players in the game, or null (the deck).
	 */
	public Card(int suit, int rank, Player owner) {
		this.suit = suit;
		this.rank = rank;
		this.setOwner(owner);
	}
	
	public Card(int suit, int rank) {
		this.suit = suit;
		this.rank = rank;
		this.setOwner(null);
	}

	/**
	 * 
	 * @return the rank of this card.
	 */
	public int getRank() {
		return rank;
	}
	
	/**
	 * 
	 * @return the suit of this card.
	 */
	public int getSuit() {
		return suit;
	}
	
	/**
	 * 
	 * Return whether this card is equal to a given card.
	 * 
	 * @param 	card
	 * 			The card to compare to this card.
	 * 
	 * @return 	whether the given card has the same suit and rank as this card.
	 */
	public boolean isEqualTo(Card card) {
		boolean isEqual = false;
		if (this.getRank() == card.getRank() && this.getSuit() == card.getSuit()) {
			isEqual = true;
		}
		return isEqual;
	}
	
	public void removeOwner() {
		this.setOwner(null);
	}
	
	/**
	 * 
	 * @return the owner of this card.
	 */
	public Player getOwner() {
		return owner;
	}
	
	/**
	 * Set the owner of this card to a given player.
	 * 
	 * @param 	owner
	 * 			The player that will be set to the owner of this card.
	 */
	public void setOwner(Player owner) {
		this.owner = owner;
	}

	private int suit;
	private int rank;
	private Player owner;
	
	
}
