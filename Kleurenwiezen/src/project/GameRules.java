package project;

public class GameRules {

	public GameRules() {
		this.enableSmallMisery();
		this.setSmallMiseryPoints(12);
		
		this.enableMisery();
		this.setMiseryPoints(15);
		
		this.enableSmallOpenMisery();
		this.setSmallOpenMiseryPoints(24);
		
		this.enableOpenMisery();
		this.setOpenMiseryPoints(30);
		
		this.enablePiccolo();
		this.setPiccoloPoints(15);
		
		this.enablePiccolino();
		this.setPiccolinoPoints(15);
		
		this.enableAbundance();
		this.setabundancePoints(15);
		
		this.enableSolo();
		this.setSoloPoints(45);
		
		this.enableClosedTrull();
		this.setClosedTrullTricks(9);
		
		this.enableOpenTrull();
		this.setOpenTrullTricks(8);
		
		this.enableCarteBlanche();
		this.enableFullPass();
		this.enableTrumpFirstOpenTrullAce();
		this.enableImmediatelyElevenTricks();
		this.chooseFirstDealMethod();
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

	/***********Small Misery**********/
	public void enableSmallMisery() {
		this.smallMisery = true;
	}
	public void disableSmallMisery() {
		this.smallMisery = false;
	}
	public boolean smallMiseryAllowed() {
		return this.smallMisery;
	}
	public int getSmallMiseryPoints() {
		return this.smallMiseryPoints;
	}
	public void setSmallMiseryPoints(int points) {
		assert(9 <= points && points <= 45 && points % 3 == 0);
		this.smallMiseryPoints = points;
	}
	
	/*************Misery************/
	public void enableMisery() {
		this.misery = true;
	}
	public void disableMisery() {
		this.misery = false;
	}
	public boolean miseryAllowed() {
		return this.misery;
	}
	public int getMiseryPoints() {
		return miseryPoints;
	}
	public void setMiseryPoints(int points) {
		assert(12 <= points && points <= 45 && points % 3 == 0);
		this.miseryPoints = points;
	}
	
	/************Small Open Misery************/
	public void enableSmallOpenMisery () {
		this.smallOpenMisery = true;
	}
	public void disableSmallOpenMisery () {
		this.misery = false;
	}
	public boolean smallOpenMiseryAllowed () {
		return this.smallOpenMisery;
	}
	public int getSmallOpenMiseryPoints() {
		return smallOpenMiseryPoints;
	}
	public void setSmallOpenMiseryPoints(int points) {
		assert(9 <= points && points <= 45 && points % 3 == 0);
		this.smallOpenMiseryPoints = points;
	}
	
	/************Open Misery**************/
	public void enableOpenMisery() {
		this.openMisery = true;
	}
	public void disableOpenMisery () {
		this.openMisery = false;
	}
	public boolean openMiseryAllowed() {
		return this.openMisery;
	}
	public int getOpenMiseryPoints() {
		return this.openMiseryPoints;
	}
	public void setOpenMiseryPoints(int points) {
		assert(12 <= points && points <= 60 && points % 3 == 0);
		this.openMiseryPoints = points;
	}

	
	/***********Piccolo***************/
	public void enablePiccolo() {
		this.piccolo = true;
	}
	public void disablePiccolo() {
		this.piccolo = false;
	}
	public boolean piccoloAllowed() {
		return this.piccolo;
	}
	public int getPiccoloPoints() {
		return piccoloPoints;
	}
	public void setPiccoloPoints(int points) {
		assert(9 <= points && points <= 30 && points % 3 == 0);
		this.piccoloPoints = points;
	}
	
	/*************Piccolino***************/
	public void enablePiccolino() {
		this.piccolino = true;
	}
	public void disablePiccolino() {
		this.piccolino = false;
	}
	public boolean piccolinoAllowed() {
		return this.piccolino;
	}
	public int getPiccolinoPoints() {
		return piccolinoPoints;
	}
	public void setPiccolinoPoints(int points) {
		assert(9 <= points && points <= 30 && points % 3 == 0);
		this.piccolinoPoints = points;
	}
	
	/************Abundance************/
	public void enableAbundance() {
		this.abundance = true;
	}
	public void disableAbundance() {
		this.abundance = false;
	}
	public boolean abundanceAllowed() {
		return this.abundance;
	}
	public int getabundancePoints() {
		return abundancePoints;
	}
	public void setabundancePoints(int points) {
		assert(9 <= points && points <= 45 && points % 3 == 0);
		this.abundancePoints = points;
	}
	
	/**************Solo***************/
	public void enableSolo() {
		this.solo = true;
	}
	public void disableSolo() {
		this.solo = false;
	}
	public boolean soloAllowed() {
		return this.solo;
	}
	public int getSoloPoints() {
		return this.soloPoints;
	}
	public void setSoloPoints(int points) {
		assert(15 <= points && points <= 60 && points % 3 == 0);
		this.soloPoints = points;
	}
	
	/*************Closed Trull***************/
	public void enableClosedTrull() {
		this.closedTrull = true;
	}
	public void disableClosedTrull() {
		this.closedTrull = false;
	}
	public boolean closedTrullAllowed() {
		return this.closedTrull;
	}
	public int getClosedTrullTricks() {
		return closedTrullTricks;
	}
	public void setClosedTrullTricks(int tricks) {
		assert(8 <= tricks && tricks <= 10);
		this.closedTrullTricks = tricks;
	}
	
	/*************Open Trull************/
	public void enableOpenTrull() {
		this.openTrull = true;
	}
	
	public void disAbleOpenTrull() {
		this.openTrull = false;
	}
	
	public boolean openTrullAllowed() {
		return this.openTrull;
	}
	public int getOpenTrullTricks() {
		return openTrullTricks;
	}
	public void setOpenTrullTricks(int tricks) {
		assert(7 <= tricks && tricks <= 9);
		this.openTrullTricks = tricks;
	}
	
	/************Carte Blanche*************/
	public void enableCarteBlanche() {
		this.carteBlanche = true;
	}
	public void disableCarteBlanche() {
		this.carteBlanche = false;
	}
	public boolean carteBlancheAllowed() {
		return this.carteBlanche;
	}
	
	/***********Full Pass*************/
	public void enableFullPass() {
		this.fullPass = true;
	}
	public void disableFullPass() {
		this.fullPass = false;
	}
	public boolean fullPassAllowed() {
		return this.fullPass;
	}
	
	/***********Immediately Eleven Tricks***********/
	public void enableImmediatelyElevenTricks() {
		this.immediatelyElevenTricks = true;
	}
	
	public void disableImmediatelyElevenTricks() {
		this.immediatelyElevenTricks = false;
	}
	
	public boolean immediatelyElevenTricksAllowed() {
		return this.immediatelyElevenTricks;
	}
	
	/**********Trump First Open Trull Ace*********/
	public void enableTrumpFirstOpenTrullAce() {
		this.trumpFirstOpenTrullAce = true;
	}
	public void disableTrumpFirstOpenTrullAce() {
		this.trumpFirstOpenTrullAce = false;
	}
	public boolean trumpFirstOpenTrullAce() {
		return trumpFirstOpenTrullAce;
	}

	/********************************************/
	/******************Variables*****************/
	/********************************************/
	private int dealMethod;
	
	private boolean smallMisery;
	private int 	smallMiseryPoints;
	private boolean misery;
	private int 	miseryPoints;
	private boolean smallOpenMisery;
	private int 	smallOpenMiseryPoints;
	private boolean openMisery;
	private int 	openMiseryPoints;
	private boolean piccolo;
	private int 	piccoloPoints;
	private boolean piccolino;
	private int 	piccolinoPoints;
	private boolean abundance;
	private int 	abundancePoints;
	private boolean solo;
	private int 	soloPoints;
	private boolean closedTrull;
	private int 	closedTrullTricks;
	private boolean openTrull;
	private int 	openTrullTricks;
	private boolean carteBlanche;
	private boolean fullPass;
	private boolean immediatelyElevenTricks;
	private boolean trumpFirstOpenTrullAce;
	private int		exactAmountOfTricksPoints;
	private int		BiddingPoints;
	private boolean	doubleScoreIfThirteenTricks;
	private int		fullPassScoreMultiplication;
	// TODO Auto-generated method stub
	

}
