package whist.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class AI {
	
	private CardDeck cardDeck;
	private Game game;
	private Player player;
	private ArrayList<Player> simulatedPlayers;
	private ArrayList<Trick> playedTricks;
	private ArrayList<Card> orderedCards;
	private ArrayList<AINode> tree;
	private Round simulatedRound;
	
	public AI (Game game, Player player) {
		this.setGame(game);
		this.setPlayer(player);
		this.getSimulatedPlayers().add(new Player("firstPlayer",  1, game));
		this.getSimulatedPlayers().add(new Player("secondPlayer", 2, game));
		this.getSimulatedPlayers().add(new Player("thirdPlayer",  3, game));
		this.getSimulatedPlayers().add(new Player("fourthPlayer", 4, game));
		this.setTree(new ArrayList<AINode>());
		this.setOrderedCards(new ArrayList<Card>());
		this.setCardDeck(new CardDeck());
		this.getCardDeck().shuffle();
		this.setSimulatedRound(new Round(game, 666));
	}
	
	public void reset() {
		this.getSimulatedPlayers().get(0).setHand(new Hand(this.getSimulatedPlayers().get(0)));
		this.getSimulatedPlayers().get(1).setHand(new Hand(this.getSimulatedPlayers().get(1)));
		this.getSimulatedPlayers().get(2).setHand(new Hand(this.getSimulatedPlayers().get(2)));
		this.getSimulatedPlayers().get(3).setHand(new Hand(this.getSimulatedPlayers().get(3)));
		this.setCardDeck(new CardDeck());
	}
	
	public void iterate(int iterations) {
		this.initializeTricks();
		this.initializeDeckAndFirstPlayer();
		this.initializeSearchTree();
		for (int i = 1; i == iterations; i++) {
			this.initializeSimulatedRound();
			this.determinize();
			this.select();
			this.expand();
			this.simulate();
			this.propagateBack();
		}
		this.orderCards();
	}

	// Make a copy of the real tricks played using cards of a full simulation deck.
	private void initializeTricks() {
		assert (this.getCardDeck().getCards().size() == 52);
		ArrayList<Trick> playedTricks = new ArrayList<Trick>();
		for (Trick trick : this.getGame().getCurrentRound().getTricks()) {
			Trick newTrick = new Trick();
			for(Card card : trick.getCards()) {
				Card equivalentCard = this.getCardDeck().getCardBySuitAndRank(card.getRank().getValue(), card.getSuit().getValue());
				if (trick.getNumberOfCards() == 4) {
					equivalentCard.setOwner(this.getSimulatedPlayers().get(equivalentCard.getOwner().getNumber()-1));
				}
				this.getCardDeck().removeCard(equivalentCard);
				newTrick.addCard(equivalentCard);
			}
			playedTricks.add(newTrick);
		}
	}
	
	// Remove cards from the deck that are already played or in the hands of the first player
	// while making a copy of the hand of the first player using simulation deck cards and storing it in the first simulation player.
	private void initializeDeckAndFirstPlayer() {
		// Remove from the simulation deck the equivalent cards of the player and deal it to the simulated first player.
		for (Card card : this.getPlayer().getHand().getCards()) {
			Card equivalentCard = this.getCardDeck().getCardBySuitAndRank(card.getRank().getValue(), card.getSuit().getValue());
			this.getCardDeck().removeCard(equivalentCard);
			this.getSimulatedPlayers().get(this.getPlayer().getNumber()-1).getHand().addCard(equivalentCard);
		}
		// Remove from the simulation deck the cards already played.
		for (Card card : this.getCardsPlayed()) {
			Card equivalentCard = this.getCardDeck().getCardBySuitAndRank(card.getRank().getValue(), card.getSuit().getValue());
			this.getCardDeck().removeCard(equivalentCard);
		}
	}
	
	private void initializeSearchTree() {
		this.addNode(new AINode(null));
	}

	private void initializeSimulatedRound() {
		Round round = this.getSimulatedRound();
		round.setTrump(this.getGame().getCurrentRound().getTrump());
		for (Trick trick : this.getPlayedTricks()) {
			round.addTrick(trick);
		}
	}
	
	/**
	 * Deal the rest of the deck to the other players in a random manner.
	 */
	public void determinize() {
		int maxCards = this.getPlayer().getHand().countCards();
		int minCards = maxCards - 1;
		//create an array containing the simulation players whose real life equivalent has already played a card this trick.
		ArrayList<Player> alreadyPlayed = new ArrayList<Player>(this.getSimulatedPlayers());
		for (Player player : alreadyPlayed) {
			for (Card card : this.getPlayedTricks().get(this.getPlayedTricks().size()-1).getCards()) {
				if (card.getOwner() == player) {
					alreadyPlayed.remove(player);
				}
			}
		}
		//Create an array containing the simulation players that are eligible to receive cards (all players except this player).
		ArrayList<Player> possibleReceivers = new ArrayList<Player>(this.getSimulatedPlayers());
		possibleReceivers.remove(this.getSimulatedPlayers().get(this.getPlayer().getNumber()-1));
		Random rand = new Random();
		for (Card card : this.getCardDeck().getCards()) {
			Player chosenPlayer = this.getSimulatedPlayers().get(rand.nextInt(possibleReceivers.size()) + 1);
			chosenPlayer.getHand().addCard(card);
			if (alreadyPlayed.contains(chosenPlayer) && chosenPlayer.getHand().countCards() == minCards) {
				possibleReceivers.remove(chosenPlayer);
			} else if (! alreadyPlayed.contains(chosenPlayer) && chosenPlayer.getHand().countCards() == maxCards) {
				possibleReceivers.remove(chosenPlayer);
			}
		}
	}
	
	public void select() {
		
	}
	
	public void expand() {
		
	}
	
	public void simulate() {
		
	}
	
	public void propagateBack() {
		
	}
	
	private ArrayList<Card> getCardsPlayed() {
		ArrayList<Card> cardsPlayed = new ArrayList<Card>();
		for (Trick trick : this.getPlayedTricks()) {
			for (Card card : trick.getCards()) {
				cardsPlayed.add(card);
			}
		}
		return cardsPlayed;
	}
	
	private ArrayList<Card> getOptions(Player player) {
		return player.getPlayOptions();
	}
	
	private void orderCards() {
		// TODO Auto-generated method stub
		
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
	
	private void addNode(AINode aiNode) {
		this.getTree().add(aiNode);
	}

	public CardDeck getCardDeck() {
		return cardDeck;
	}

	public void setCardDeck(CardDeck cardDeck) {
		this.cardDeck = cardDeck;
	}

	public ArrayList<Player> getSimulatedPlayers() {
		return simulatedPlayers;
	}

	public void setSimulatedPlayers(ArrayList<Player> simulatedPlayers) {
		this.simulatedPlayers = simulatedPlayers;
	}
	
	public ArrayList<Trick> getPlayedTricks() {
		return this.playedTricks;
	}
	
	private void setPlayedTricks(ArrayList<Trick> playedTricks) {
		this.playedTricks = playedTricks;
	}

	public Round getSimulatedRound() {
		return simulatedRound;
	}

	public void setSimulatedRound(Round simulatedRound) {
		this.simulatedRound = simulatedRound;
	}
	
}
