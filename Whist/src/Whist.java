import whist.gui.WhistGUI;
import whist.model.Facade;

public class Whist {

	public static void main(String[] args) {
		WhistGUI gui = new WhistGUI(new Facade());
		gui.start();
	}
}

