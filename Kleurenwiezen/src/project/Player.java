package project;

public class Player {
	
	private int number;
	private String name;
	private Game game;

	public Player (String name, int number, Game game) {
		this.setName(name);
		this.setNumber(number);
		this.setGame(game);
	}
	
	public Player (String name, int number) {
		this.setName(name);
		this.setNumber(number);
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

}
