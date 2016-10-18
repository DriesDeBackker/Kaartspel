package whist.model;

import java.util.ArrayList;
import java.util.Collections;

public class CardDeck {
	
	private ArrayList<Card> cards = new ArrayList<Card>();
	
	
	public CardDeck () {
		this.setCards(generateCards());
	}
	
	private ArrayList<Card> generateCards() {
		System.out.println("We gaan kaarten genereren en toevoegen aan de stok");
		ArrayList<Card> cards = new ArrayList<Card>();
		for(int suit = 1; suit <= 4; suit++) {
			for(int rank=1; rank<=13; rank++) {
				cards.add(new Card(suit,rank));
			}
		}
		System.out.println("Aantal kaarten in stok: " + cards.size());
		return cards;
	}
	
	public void addCard(Card card) {
		this.cards.add(card);
	}
	
	public void removeCard(Card card) {
		assert this.cards.contains(card);
		this.cards.remove(card);
	}

	public void dealCards(int number, Player player) {
		assert(1 <= number && number <= 52);
		for(int i=1; i<=number; i++){
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
	
	public Card getCardBySuitAndRank(int rank, int suit) {
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

	public void shuffle() {
		Collections.shuffle(this.getCards());
	}
	
	public void cut (int cardNumber) {
		assert (1 <= cardNumber && cardNumber <= 52);
		cardNumber--;
		ArrayList<Card> firstHalf  = new ArrayList<Card> (this.getCards().subList(0, cardNumber));
		ArrayList<Card> secondHalf = new ArrayList<Card> (this.getCards().subList(cardNumber+1, 51));
		ArrayList<Card> cutCards = new ArrayList<Card>();
		cutCards.addAll(secondHalf);
		cutCards.addAll(firstHalf);
	}
}
