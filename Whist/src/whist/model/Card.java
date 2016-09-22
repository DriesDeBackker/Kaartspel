package whist.model;


public class Card {
	
	private Suit suit;
	private Rank rank;
	private Player owner;
	
	/**
	 * Initialize a card with a given suit, rank and owner.
	 * 
	 * @param 	suit
	 * 		   	The suit of this card.
	 * 
	 * @param 	rank
	 * 			The rank of the card.
	 * 
	 * @param   owner
	 * 			The owner of this card. This is one of the players in the game, or null (the deck).
	 */
	public Card(int suit, int rank, Player owner) {
		this.suit = Suit.valueOf(suit);
		this.rank = Rank.valueOf(rank);
		this.setOwner(owner);
	}
	
	public Card(int suit, int rank) {
		this.suit = Suit.valueOf(suit);
		this.rank = Rank.valueOf(rank);
		this.setOwner(null);
	}

	public Rank getRank() {
		return rank;
	}
	
	public Suit getSuit() {
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
	
	public Player getOwner() {
		return owner;
	}
	
	public void setOwner(Player owner) {
		this.owner = owner;
	}	
	
}
