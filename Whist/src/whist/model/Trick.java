package whist.model;

import java.util.ArrayList;

public class Trick {
	
	private boolean played;
	private boolean turnable;
	private ArrayList<Card> cards;
	private Player owner;

	public Trick () {
		this.setCards(new ArrayList<Card>());
		this.setUnplayed();
		this.setUnturnable();
	}

	public void setUnplayed() {
		assert(this.getNumberOfCards() == 0);
		this.played = false;
	}

	public void setPlayed() {
		assert(this.getNumberOfCards() == 4);
		this.played = true;
	}
	
	public boolean isPlayed() {
		return this.played;
	}
	
	public void setUnturnable() {
		this.turnable = false;
	}
	
	public void setTurnable() {
		this.turnable = true;
	}
	
	public boolean isTurnable() {
		return this.turnable;
	}
	
	private void setCards(ArrayList<Card> cards) {
		this.cards = cards;
	}
	
	public ArrayList<Card> getCards() {
		return cards;
	}
	
	public int getNumberOfCards() {
		return this.getCards().size();
	}

	public void addCard(Card card) {
		assert(this.getNumberOfCards() < 4);
		this.cards.add(card);
	}
	
	public Card getLeadingCard() {
		return this.getCard(1);
	}	
	
	public Card getCard(int number) {
		assert(this.getNumberOfCards() >= number);
		return this.getCards().get(number-1);
	}

	public Player getOwner() {
		return owner;
	}

	public void setOwner(Player owner) {
		this.owner = owner;
	}

	

}
