package tests;

import irrgarten.*;
import irrgarten.UI.TextUI;
import irrgarten.controller.Controller;


public class MainUI {
	public static void main(String[] args) {
		
	
		TextUI vista = new TextUI();
		Game game = new Game(3);	

	
	
		Controller controller= new Controller(game, vista);
		controller.play();
	}	
}
