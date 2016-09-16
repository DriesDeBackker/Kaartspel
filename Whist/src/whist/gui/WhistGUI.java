package whist.gui;
import whist.model.CardDeck;
import whist.model.Facade;
import whist.model.Game;
import whist.model.GameRules;
import whist.model.Player;

public class WhistGUI {
	
	Facade facade;
	
	public WhistGUI (Facade facade) {
		this.setFacade(facade);
	}

	private void setFacade(Facade facade) {
		this.facade = facade;
	}
	
	public void start() {
		Player henk = facade.createPlayer("Henk", 1);
		Player teun = facade.createPlayer("Teun", 2);
		Player fons = facade.createPlayer("Fons", 3);
		Player staf = facade.createPlayer("Staf", 4);
		GameRules rules = facade.createGameRules();
		CardDeck deck = facade.createDeck();
		Game game = facade.createGame(henk, rules, deck);
		facade.addPlayer(game, teun);
		facade.addPlayer(game, fons);
		facade.addPlayer(game, staf);
		facade.startGame(game);
		
	}

}
