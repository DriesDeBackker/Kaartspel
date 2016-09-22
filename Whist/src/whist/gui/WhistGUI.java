package whist.gui;
import java.util.ArrayList;
import java.util.Scanner;

import whist.model.Card;
import whist.model.CardDeck;
import whist.model.Facade;
import whist.model.Game;
import whist.model.GameRules;
import whist.model.Player;

public class WhistGUI {
	
	Facade facade;
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
		facade.startGame(game);
		this.playRound();
	}

	private void createGame() {	
		System.out.print("Player 1 (host), enter your name:");
		String playerName = in.nextLine();
		Player playerOne = facade.createPlayer(playerName, 1);
		GameRules rules = facade.createGameRules();
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
	
	private void playRound() {
		this.dealCards();
	}

	private void dealCards() {
		ArrayList<Player> players = facade.getPlayers(game);
		int dealMethod = facade.getGameRules(game).getDealMethod();
		if (dealMethod == 1) {
			for (Player player: players) {
				facade.dealCards(game, player, 4);
				System.out.println("De hand van " + player.getName() + ": " +  newLine + stringifyCards(player));
			}
			System.out.println("eerste deelronde afgerond");
			for (Player player: players) {
				facade.dealCards(game, player, 4);
				System.out.println("De hand van " + player.getName() + ": " +  newLine + stringifyCards(player));
			}
			System.out.println("tweede deelronde afgerond");
			for (Player player: players) {
				facade.dealCards(game, player, 5);
				System.out.println("De hand van " + player.getName() + ": " +  newLine + stringifyCards(player));
			}
			System.out.println("derde deelronde afgerond");
		} else if (dealMethod == 2) {
			for (Player player: players) {
				facade.dealCards(game, player, 6);
				System.out.println("De hand van " + player.getName() + ": " +  newLine + stringifyCards(player));
			}
			System.out.println("eerste deelronde afgerond");
			for (Player player: players) {
				facade.dealCards(game, player, 7);
				System.out.println("De hand van " + player.getName() + ": " +  newLine + stringifyCards(player));
			}
			System.out.println("tweede deelronde afgerond");
		}
		
		System.out.println("Dit is troef: " + players.get(3).getHand().getCards().get(12).getSuit());
		
	}

	private static String stringifyCards(Player player) {
		
		String cardsString = "";
		for (Card card: player.getHand().getCards()) {
			cardsString = cardsString + card.getSuit() + " " + card.getRank() + ", ";
		}
		return cardsString;
	}
}
