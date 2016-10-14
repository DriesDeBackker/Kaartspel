package whist.model;

import java.util.ArrayList;

public class AI {
	
	private Game game;
	private Player player;
	private Hand secondHand;
	private Hand thirdHand;
	private Hand fourthHand;
	private ArrayList<Card> orderedCards;
	private ArrayList<AINode> tree;
	
	public AI (Game game, Player player) {
		this.setGame(game);
		this.setPlayer(player);
		this.setTree(new ArrayList<AINode>());
		this.setOrderedCards(new ArrayList<Card>());
	}
	
	public void iterate(int iterations) {
		this.getOrderedCards().addAll(this.getPlayer().getPlayOptions());
		for (int i = 1; i == iterations; i++) {
			this.determinize();
			this.select();
			this.expand();
			this.simulate();
			this.propagateBack();
		}
		this.orderCards();
	}
	
	private void orderCards() {
		// TODO Auto-generated method stub
		
	}

	public void determinize() {
		
	}
	
	public void select() {
		
	}
	
	public void expand() {
		
	}
	
	public void simulate() {
		
	}
	
	public void propagateBack() {
		
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public ArrayList<Card> getOrderedCards() {
		return orderedCards;
	}

	public void setOrderedCards(ArrayList<Card> orderedCards) {
		this.orderedCards = orderedCards;
	}

	public ArrayList<AINode> getTree() {
		return tree;
	}

	public void setTree(ArrayList<AINode> tree) {
		this.tree = tree;
	}

	public Hand getSecondHand() {
		return secondHand;
	}

	public void setSecondHand(Hand secondHand) {
		this.secondHand = secondHand;
	}

	public Hand getThirdHand() {
		return thirdHand;
	}

	public void setThirdHand(Hand thirdHand) {
		this.thirdHand = thirdHand;
	}

	public Hand getFourthHand() {
		return fourthHand;
	}

	public void setFourthHand(Hand fourthHand) {
		this.fourthHand = fourthHand;
	}
	
}
