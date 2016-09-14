package project;

public class GameRules {

	public GameRules() {
		this.chooseFirstDealMethod();
		this.setExtraTrickPoints(1);
		this.setMaximumPoints(5);
	}
	
	
	/***********************************************************/
	/******Getters and setters for rules and their points*******/
	/***********************************************************/
	
	public void chooseFirstDealMethod() {
		this.setDealMethod(1);
	}
	
	public void chooseSecondDealMethod() {
		this.setDealMethod(2);
	}
	
	public void setDealMethod(int methodNumber) {
		assert (methodNumber <=2 && methodNumber > 0);
		this.dealMethod = methodNumber;
	}
	
	public int getDealMethod() {
		return dealMethod;
	}
	
	/**********Extra Points for each extra trick obtained above 6 tricks*********/
	public int getExtraTrickPoints() {
		return this.extraTrickPoints;
	}

	public void setExtraTrickPoints(int extraTrickPoints) {
		assert(1 <= extraTrickPoints && extraTrickPoints <= 5);
		this.extraTrickPoints = extraTrickPoints;
	}

	/********************************************/
	/******************Variables*****************/
	/********************************************/
	private int dealMethod;
	private int	extraTrickPoints;

	

}
