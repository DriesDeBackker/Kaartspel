package whist.model;

import java.util.ArrayList;

public class AINode {
	
	private double winrate;
	private int visits;
	private AINode parent;
	private ArrayList<AINode> children;
	private Card card;
	
	public AINode(AINode parent) {
		this.setParent(parent);
		this.setWinrate(0);
		this.setVisits(1);
	}
	
	public double getSelectionValue() {
		double selectionValue = this.getWinrate() / this.getVisits();
		if (this.hasParent()) {
			selectionValue += AINode.selectionConstant*Math.sqrt(Math.log(this.getParent().getVisits()) / this.getVisits());
		}
		return selectionValue;
	}
	
	public boolean hasParent() {
		return this.parent != null;
	}
	public AINode getParent() {
		return parent;
	}

	private void setParent(AINode parent) {
		this.parent = parent;
	}

	public ArrayList<AINode> getChildren() {
		return children;
	}

	public void setChildren(ArrayList<AINode> children) {
		this.children = children;
	}

	public double getWinrate() {
		return this.winrate;
	}

	public void setWinrate(double winrate) {
		this.winrate = winrate;
	}

	public float getVisits() {
		return visits;
	}

	private void setVisits(int visits) {
		this.visits = visits;
	}

	public Card getCard() {
		return card;
	}

	public void setCard(Card card) {
		this.card = card;
	}
	
	public static double selectionConstant = 0.70;

}
