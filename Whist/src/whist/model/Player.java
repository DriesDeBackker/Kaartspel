package whist.model;

import java.util.ArrayList;

public class Player {
	
	private int number;
	private String name;
	private Game game;
	private Hand hand;
	private CardDeck cardDeck;
	private ArrayList<Trick> tricks;
	private boolean active;

	public Player (String name, int number, Game game) {
		this.setName(name);
		this.setNumber(number);
		this.setGame(game);
		this.setCardDeck(null);
		this.setHand(new Hand(this));
		this.setTricks(new ArrayList<Trick>());
		this.setActive();
	}
	
	public Player (String name, int number) {
		this.setName(name);
		this.setNumber(number);
		this.setCardDeck(null);
		this.setHand(new Hand(this));
		this.setTricks(new ArrayList<Trick>());
		this.setActive();
	}
	
	private void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}

	private void setNumber(int number) {
		if (1 <= number && number <= 4) {
			this.number = number;
		}
	}
	
	public int getNumber () {
		return this.number;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}
	
	public void setHand(Hand hand) {
		this.hand = hand;
	}
	
	public Hand getHand() {
		return this.hand;
	}
	
	public void sortHand() {
		if(this.hand != null) {
			/******To do******/
		}
	}

	public Card playCard() {
		/******To do******/
		return null;
	}

	public boolean hasTrull() {
		return (this.getHand().countAces() >= 3);
	}

	public CardDeck getCardDeck() {
		return cardDeck;
	}

	public void setCardDeck(CardDeck cardDeck) {
		this.cardDeck = cardDeck;
	}
	
	public void addCardDeck(CardDeck cardDeck) {
		this.setCardDeck(cardDeck);
	}
	
	public void removeCardDeck() {
		this.setCardDeck(null);
	}

	public ArrayList<Trick> getTricks() {
		return tricks;
	}

	public void setTricks(ArrayList<Trick> tricks) {
		this.tricks = tricks;
	}
	
	public void clearTricks() {
		this.setTricks(new ArrayList<Trick>());
	}
	
	public void addTrick(Trick trick) {
		this.tricks.add(trick);
	}

	public boolean isActive() {
		return active;
	}

	public void setActive() {
		this.active = true;
	}
	
	public void setNonActive() {
		this.active = false;
	}

}
