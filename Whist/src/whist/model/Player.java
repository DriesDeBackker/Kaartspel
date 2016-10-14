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
	private Team team;
	private boolean computerControlled;
	private AI ai;

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
	
	public ArrayList<Card> getPlayOptions() {
		assert(this.getGame().isPlaying());
		Round round = this.getGame().getCurrentRound();
		ArrayList<Card> options = new ArrayList<Card>();
		ArrayList<Card> trumpCards = new ArrayList<Card>();
		ArrayList<Card> leadingSuitCards = new ArrayList<Card>();
		ArrayList<Card> otherCards = new ArrayList<Card>();
		for (Card card : this.getHand().getCards()) {
			if (card.getSuit() == round.getTrump()) {
				trumpCards.add(card);
			} else if (card.getSuit() == round.getCurrentTrick().getLeadingSuit()) {
				leadingSuitCards.add(card);
			} else {
				otherCards.add(card);
			}
		}
		//Voeg sowieso alle troefkaarten toe. Deze zijn altijd speelbaar.
		options.addAll(trumpCards);
		//Als de speler niet kan volgen, voeg je de andere kaarten toe.
		if (leadingSuitCards.size() == 0) {
			options.addAll(otherCards);
		} 
		//Als de speler wel kan volgen, voeg dan de kaarten van de kleur van de uitgekomen kaart toe.
		else {
			options.addAll(leadingSuitCards);
		}
		return options;
	}
	
	public ArrayList<Card> sortOptions(ArrayList<Card> options) {
		return null;
	}
	
	public int winChance(Card card) {
		Trick currentTrick = this.getGame().getCurrentRound().getCurrentTrick();
		if (currentTrick.getCards().size() == 0) {
			
		} else if (currentTrick.getCards().size() == 1) {
			
		} else if (currentTrick.getCards().size() == 2) {
			
		} else if (currentTrick.getCards().size() == 3) {
			
		}
		int chance  = 0;
		Suit trump = this.getGame().getCurrentRound().getTrump();
		if (card.getSuit() == trump) {
			
		}
		return 100;
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

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public boolean isComputerControlled() {
		return computerControlled;
	}

	public void setComputerControlled(boolean computerControlled) {
		this.computerControlled = computerControlled;
	}

	public AI getAi() {
		return ai;
	}

	public void setAi(AI ai) {
		this.ai = ai;
	}

}
