package irrgarten;

import irrgarten.UI.TextUI;
import irrgarten.controller.Controller;

public class MainUI {
	public static void main(String[] args) {
		TextUI vista = null;
		Game game = new Game(2);
		Controller controller = new Controller(game, vista);
		controller.play();
		
	}
}
