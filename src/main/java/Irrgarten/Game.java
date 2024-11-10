package Irrgarten;

import java.util.ArrayList;
import java.util.List;

public class Game {
	private final int nRows=10,
					nCols=10,
					exitRow=9,
					exitCol=4;
	
	private final static int MAX_ROUNDS = 10;
	
	private int currentPlayerIndex;
	
	private String log;
	
	private Player currentPlayer;
	
	private Labyrinth labyrinth;
	
	private List<Player> jugadores;
	
	private List<Monster> monstruos;
	
	public Game(int nplayers) {
		this.log = null;
		this.jugadores = new ArrayList<>();
		this.monstruos = new ArrayList<>();
		for (int i = 0; i < nplayers; i++) {
			this.jugadores.add(new Player(Integer.toString(i).charAt(0),Dice.randomIntelligence(), Dice.randomStrength()));
		}
		currentPlayerIndex = Dice.whoStart(nplayers);
		this.labyrinth = new Labyrinth(nRows,nCols,exitRow,exitCol);
		this.configureLbayrinth();
		this.labyrinth.spreadPlayers(null);
	}
	
	public boolean finished() {
		return this.labyrinth.haveAWinner();
	}
	
	public boolean nextStep(Directions preferredDirection) {
		
	}
	
	public GameState getGameState() {
		String players = "";
		String monsters = "";
		for (Player p: this.jugadores) {
			players += p.toString() + " ";		
		}
		for(Monster m: this.monstruos) {
			monsters += m.toString() + " ";
		}
		return new GameState(this.labyrinth.toString(), players, monsters, currentPlayerIndex, this.finished(), this.log);
	}
	
	private void configureLbayrinth() {
		labyrinth.addBlock(Orientation.vertical, 3, 5, 5);
        labyrinth.addBlock(Orientation.vertical, 1, 2, 7);
        labyrinth.addBlock(Orientation.horizontal, 5, 3, 1);
        //int newpos[] = labyrinth.randomEmptyPos();
        int newpos1[] = {4,4};
        Monster monstruo1 = new Monster ("monstruo1", Dice.randomIntelligence(), Dice.randomStrength());
        this.monstruos.add(monstruo1);
        labyrinth.addMonster(newpos1[0], newpos1[1], monstruos.get(0));
        int newpos2[] = {1,0};
        Monster monstruo2 = new Monster ("monstruo2", Dice.randomIntelligence(), Dice.randomStrength());
        this.monstruos.add(monstruo2);
        labyrinth.addMonster(newpos2[0], newpos2[1], monstruos.get(1));
	}
	
	private void nextPlayer() {
		if(this.currentPlayerIndex == this.jugadores.size() - 1) {
			this.currentPlayerIndex = 0;
		}else {
			this.currentPlayer = jugadores.get(++this.currentPlayerIndex);
		}
	}
	
	private Directions actualDirection(Directions preferredDirection) {
		
	}
	
	private GameCharacter combat(Monster monster) {
		
	}
	
	private void manageReward(GameCharacter winner) {
		
	}
	
	private void manageResurrection() {
		
	}
	
	private void logPlayerWon() {
		
	}
	
	private void logResurrected() {
		
	}
	
	private void logPlayerSkipTurn() {
		
	}
	
	private void logPlayerNoOrders() {
		
	}
	
	private void logNoMonster() {
		
	}
	
	private void logRounds(int rounds, int max) {
		
	}
}
