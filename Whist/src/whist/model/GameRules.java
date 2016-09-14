package whist.model;

public class GameRules {

	private int maximumPoints;
	private int dealMethod;
	private int	extraTrickPoints;
	
	public GameRules() {
		this.chooseFirstDealMethod();
		this.setExtraTrickPoints(1);
		this.setMaximumPoints(5);
	}
	

	/******Choose the deal method*******/
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
	
	/**********The Maximum amount of points a team can obtain.*********/
	private void setMaximumPoints(int maximumPoints) {
		assert(5 <= maximumPoints);
		this.maximumPoints = maximumPoints;
	}
	
	public int getMaximumPoints() {
		return this.maximumPoints;
	}



	

}
