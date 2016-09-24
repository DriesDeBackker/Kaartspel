package whist.gui;
import java.util.ArrayList;
import java.util.Scanner;

import whist.model.Card;
import whist.model.CardDeck;
import whist.model.Facade;
import whist.model.Game;
import whist.model.GameRules;
import whist.model.Player;
import whist.model.Round;
import whist.model.Suit;
import whist.model.Team;
import whist.model.Trick;

public class WhistGUI {
	
	private Facade facade;
	Game game;
	private Scanner in;
	String newLine = System.getProperty("line.separator");
	
	public WhistGUI (Facade facade) {
		this.setFacade(facade);
	}

	private void setFacade(Facade facade) {
		this.facade = facade;
	}
	
	public void start() {
		in = new Scanner(System.in);	
		this.createGame();
		this.chooseRules();
		this.addOtherPlayers();
		facade.createTeams(game);
		facade.startGame(game);
		this.play();
	}
	
	private void play() {
		while (! facade.isGameOver(game)) {
			System.out.println("Het spel is nog niet gedaan");
			while (facade.isGameIdle(game)) {
				System.out.println("Het spel is idle. We kijken of alle spelers aanwezig zijn.");
				if(facade.allPlayersPresent(game)) {
					System.out.println("Alle spelers zijn aanwezig. We zetten het spel op ready");
					facade.goToReady(game);
				}
			}
			while (facade.isGameReady(game)) {
				System.out.println("Het spel is ready. We kijken of alle spelers actief zijn.");
				if(facade.allPlayersActive(game)) {
					System.out.println("Alle spelers zijn actief. We maken een nieuwe ronde aan en zetten het spel op delen.");
					facade.addRound(game, facade.createRound(game, facade.getCurrentRoundNumber(game) + 1));
					facade.startDealing(game);
				}
			}
			System.out.print("We gaan delen." + newLine);
			this.dealCards();
			System.out.print("We hebben gedeeld." + newLine);
			System.out.print("We zetten het spel op spelen." + newLine);
			facade.startPlaying(game);
			for (int i = 1; i <= 13; i++) {
				System.out.print("Er wordt een slag gespeeld." + newLine);
				this.playTrick();
			}
			System.out.print("De ronde is gedaan. We zetten het spel op scoren." + newLine);
			facade.startScoring(game);
			System.out.println("We passen de score aan.");
			this.updateScore();
			System.out.print("We evalueren de score");
			this.evaluateScore();
			System.out.print("We steken de kaarten terug in de boek");
			this.resetForNewRound();
		}
		
	}

	private void createGame() {	
		System.out.print("Player 1 (host), enter your name:");
		String playerName = in.nextLine();
		Player playerOne = facade.createPlayer(playerName, 1);
		GameRules rules = facade.createGameRules();
		System.out.println("We gaan een nieuwe stok aanmaken");
		CardDeck deck = facade.createDeck();
		facade.shuffleDeck(deck);
		this.game = facade.createGame(playerOne, rules, deck);
	}
	
	private void addOtherPlayers() {
		System.out.print("Player 2, enter your name:");
		String playerName = in.nextLine();
		Player playerTwo = facade.createPlayer(playerName, 2);
		facade.addPlayer(game, playerTwo);
		
		System.out.print("Player 3, enter your name:");
		playerName = in.nextLine();
		Player playerThree = facade.createPlayer(playerName, 3);
		facade.addPlayer(game, playerThree);
		
		System.out.print("Player 4, enter your name:");
		playerName = in.nextLine();
		Player playerFour = facade.createPlayer(playerName, 4);
		facade.addPlayer(game, playerFour);
	}

	private void chooseRules() {
		int dealMethod = 1;
		boolean dealMethodSettled = false;
		while (dealMethodSettled == false) {
			System.out.print("Choose dealing method:");
			dealMethod = Integer.parseInt(in.nextLine());
			if (1 <= dealMethod && dealMethod <= 2) {
				dealMethodSettled = true;
			}
		}
		int extraTrickPoints = 1;
		boolean extraTrickPointsSettled = false;
		while (extraTrickPointsSettled == false) {
			System.out.print("Choose how many points will be obtained for one extra trick above 6:");
			extraTrickPoints = Integer.parseInt(in.nextLine());
			if (1 <= extraTrickPoints && extraTrickPoints <= 5) {
				extraTrickPointsSettled = true;
			}
		}
		int maximumPoints = 5;
		boolean maximumPointsSettled = false;
		while (maximumPointsSettled == false) {
			System.out.print("Choose the amount of points a team has to obtain in order to win the game:");
			maximumPoints = Integer.parseInt(in.nextLine());
			if (5 <= maximumPoints && maximumPoints <= 25) {
				maximumPointsSettled = true;
			}
		}
		GameRules newGameRules = facade.createGameRules();
		newGameRules.setDealMethod(dealMethod);
		newGameRules.setExtraTrickPoints(extraTrickPoints);
		newGameRules.setMaximumPoints(maximumPoints);
		facade.setGameRules(game, newGameRules);
	}

	private void playTrick() {
		facade.addTrick(game, facade.createTrick());
		System.out.println("Slag spelen");
		for (Player player : facade.getPlayers(game)) {
			facade.setCurrentPlayer(game,player);
			System.out.println("Dit is de slag tot nu toe:");
			System.out.println(stringifyCards(facade.getCurrentRound(game).getCurrentTrick().getCards()));
			System.out.print(player.getName() + ", Dit zijn je kaarten: " + newLine);
			System.out.println(stringifyCards(player.getHand().getCards()));
			System.out.print("Kies een kaart om te spelen:");
			int cardNumber = Integer.parseInt(in.nextLine());
			Card card = facade.getCards(player).get(cardNumber-1);
			facade.removeCardByNumber(player, cardNumber);
			System.out.println(player.getName() + " speelt: " + stringifyCard(card));
			facade.addCard(game, card);
			System.out.println("Dit is de slag nu:");
			System.out.println(stringifyCards(facade.getCurrentRound(game).getCurrentTrick().getCards()));
		}
		Card leadingCard = facade.getLeadingCard(facade.getCurrentTrick(game));
		Suit leadingSuit = leadingCard.getSuit();
		Suit trump = facade.getTrump(game);
		Card winningCard = leadingCard;
		for (Card card : facade.getCurrentTrickCards(game)){
			if(card.getSuit() == winningCard.getSuit() && card.getRank().getValue() > winningCard.getRank().getValue()) {
				winningCard = card;
			} else if (card.getSuit() == trump && winningCard.getSuit() == leadingSuit && leadingSuit != trump) {
				winningCard = card;
			}
		}
		facade.setTrickOwner(facade.getCurrentTrick(game), winningCard.getOwner());
		facade.addTrick(facade.getCardOwner(winningCard), facade.getCurrentTrick(game));
		facade.addTrick(facade.getCardOwnerTeam(winningCard), facade.getCurrentTrick(game));
		System.out.println("De slag gaat naar " + winningCard.getOwner().getName());
		facade.setFirst(game, winningCard.getOwner());
		ArrayList<Player> playersInNewOrder = facade.getPlayers(game);
		System.out.println("De nieuwe speelvolgorde: " + playersInNewOrder.get(0).getName() + " " + playersInNewOrder.get(1).getName() + " " + playersInNewOrder.get(2).getName() + " " + playersInNewOrder.get(3).getName());
		System.out.println("Deze speler komt de volgende slag uit: " + facade.getPlayers(game).get(0).getName());
	}

	private void dealCards() {
		System.out.print("Kies het aantal kaarten om af te pakken:");
		int cutNumber = Integer.parseInt(in.nextLine());
		facade.cutDeck(facade.getCardDeck(game), cutNumber);
		ArrayList<Player> players = facade.getPlayers(game);
		int dealMethod = facade.getGameRules(game).getDealMethod();
		if (dealMethod == 1) {
			for (Player player: players) {
				facade.dealCards(game, player, 4);
			}
			for (Player player: players) {
				facade.dealCards(game, player, 4);
			}
			for (Player player: players) {
				facade.dealCards(game, player, 5);
				System.out.println("De hand van " + player.getName() + ": " +  newLine + stringifyCards(player.getHand().getCards()));
			}
		} else if (dealMethod == 2) {
			for (Player player: players) {
				facade.dealCards(game, player, 6);
			}
			for (Player player: players) {
				facade.dealCards(game, player, 7);
				System.out.println("De hand van " + player.getName() + ": " +  newLine + stringifyCards(player.getHand().getCards()));
			}
		}
		for (Player player: players) {
			for (Card card : facade.getCards(player)) {
				card.setOwner(player);
			}
		}
		Card lastCardDealt = facade.getCards(players.get(3)).get(12);
		System.out.println("Dit is troef: " + stringifyCard(lastCardDealt));
		facade.setTrump(game, lastCardDealt.getSuit());
		for (Player player: players) {
			facade.sortCards(player);
		}
	}
	
	private void updateScore() {
		System.out.println("de score bijwerken");
		int firstTeamNumberOfTricks  = facade.getTricks(facade.getFirstTeam(game)).size();
		System.out.println("Team " + facade.getTeamNumber(facade.getFirstTeam(game)) + " behaalde " + firstTeamNumberOfTricks + " slagen.");
		int secondTeamNumberOfTricks = facade.getTricks(facade.getSecondTeam(game)).size();
		System.out.println("Team " + facade.getTeamNumber(facade.getSecondTeam(game)) + " behaalde " + secondTeamNumberOfTricks + " slagen.");
		int totalTricks = firstTeamNumberOfTricks + secondTeamNumberOfTricks;
		System.out.println(totalTricks);
		assert (totalTricks == 13);
		Team winningTeam = facade.getFirstTeam(game);
		if (firstTeamNumberOfTricks < secondTeamNumberOfTricks) {
			winningTeam = facade.getSecondTeam(game);
		}
		System.out.println("Team " + facade.getTeamNumber(winningTeam) + " heeft deze ronde gewonnen.");
		int winningAmount = Math.max(firstTeamNumberOfTricks, secondTeamNumberOfTricks);
		System.out.println("Ze behaalden " + winningAmount + " slagen.");
		int scoreIncrease = (winningAmount - 6)*facade.getGameRules(game).getExtraTrickPoints();
		System.out.println("Ze krijgen hiervoor " + scoreIncrease  + " punten.");
		facade.increaseScoreOfBy(winningTeam, scoreIncrease);
		System.out.println("De score van team 1 is nu: " + facade.getScore(facade.getFirstTeam(game)));
		System.out.println("De score van team 2 is nu: " + facade.getScore(facade.getSecondTeam(game)));
	}
	
	private void evaluateScore() {
		int score1 = facade.getScore(facade.getFirstTeam(game));
		int score2 = facade.getScore(facade.getSecondTeam(game));
		Team leadingTeam = facade.getFirstTeam(game);
		if (score2 > score1) {
			leadingTeam = facade.getSecondTeam(game);
		}
		if (facade.getScore(leadingTeam) >= facade.getGameRules(game).getMaximumPoints()) {
			facade.setGameOver(game);
			System.out.println("Team " + facade.getTeamNumber(leadingTeam) + " heeft het spel gewonnen.");
			System.out.println("Proficiat " + facade.getFirstPlayer(leadingTeam).getName() + " en " + facade.getSecondPlayer(leadingTeam).getName());
		} else {
			facade.setFirst(game, facade.getHost(game));
			int newRoundNumber = facade.getCurrentRoundNumber(game) + 1;
			Player newFirstPlayer = facade.getPlayers(game).get(newRoundNumber%4 - 1);
			facade.setFirst(game, newFirstPlayer);
			facade.setGameIdle(game);
		}
	}
	
	private void resetForNewRound() {
		for (Player player : facade.getPlayers(game)) {
			for (Trick trick : facade.getTricks(player)) {
				for (Card card : trick.getCards()) {
					card.setOwner(null);
					facade.addCardToDeck(game,card);
				}
			}
			facade.clearTricks(player);
		}
		for (Team team : facade.getTeams(game)) {
			facade.clearTricks(team);
		}
		
	}

	private static String stringifyCards(ArrayList<Card> cards) {
		String cardsString = "";
		for (Card card: cards) {
			cardsString = cardsString + stringifyCard(card) + ", ";
		}
		return cardsString;
	}
	
	private static String stringifyCard(Card card) {
		String cardString = card.getSuit() + " " + card.getRank();
		return cardString;
	}
}
