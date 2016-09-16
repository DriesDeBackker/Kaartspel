package whist.gui;
import whist.model.Facade;

public class WhistGUI {
	
	Facade facade;
	
	public WhistGUI (Facade facade) {
		this.setFacade(facade);
	}

	private void setFacade(Facade facade) {
		this.facade = facade;
	}
	
	public void start() {
		
	}

}
