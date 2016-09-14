package project;

import java.util.ArrayList;

public class Trick {

	public Trick () {
		this.setUnplayed();
		this.setUnturnable();
	}

	public void setUnplayed() {
		this.played = false;
	}

	public void setPlayed() {
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
	
	public ArrayList<Card> getCards() {
		return cards;
	}

	public void addCard(Card card) {
		this.cards.add(card);
	}

	public Player getOwner() {
		return owner;
	}

	public void setOwner(Player owner) {
		this.owner = owner;
	}

	private boolean played;
	private boolean turnable;
	private ArrayList<Card> cards;
	private Player owner;
	

}
