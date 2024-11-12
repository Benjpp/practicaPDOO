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
		this.log = "";
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
		boolean dead = currentPlayer.dead();
		if(!dead) {
			Directions direction = this.actualDirection(preferredDirection);
			if(direction != preferredDirection) {
				this.logPlayerNoOrders();
			}
			Monster monster = this.labyrinth.putPlayer(direction, currentPlayer);
			if(monster == null) {
				this.logNoMonster();
			}else {
				GameCharacter winner = this.combat(monster);
				this.manageReward(winner);
			}
		}else {
			this.manageResurrection();
		}
		boolean endGame = this.finished();
		if(!endGame) {
			this.nextPlayer();
		}
		return endGame;
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
		int currentRow = this.currentPlayer.getRow();
		int currentCol = this.currentPlayer.getCol();
		List<Directions> validMoves = new ArrayList<>();
		validMoves = this.labyrinth.validMoves(currentRow, currentCol);
		return this.currentPlayer.move(preferredDirection,validMoves);
	}
	
	private GameCharacter combat(Monster monster) {
		int rounds = 0;
		GameCharacter winner = GameCharacter.player;
		float playerAttack = this.currentPlayer.attack();
		boolean lose = monster.defend(playerAttack);
		while(!lose && rounds < MAX_ROUNDS) {
			winner = GameCharacter.monster;
			rounds++;
			float monsterAttack = monster.attack();
			lose = this.currentPlayer.defend(monsterAttack);
			if(!lose) {
				playerAttack = this.currentPlayer.attack();
				winner = GameCharacter.player;
				lose = monster.defend(playerAttack);
			}
		}
		this.logRounds(rounds, MAX_ROUNDS);
		return winner;
	}
	
	private void manageReward(GameCharacter winner) {
		if(winner == GameCharacter.player) {
			this.currentPlayer.receiveReward();
			this.logPlayerWon();
		}else {
			this.logMonsterWon();
		}
	}
	
	private void manageResurrection() {
		boolean resurrect = Dice.resurrectPlayer();
		if(resurrect) {
			this.currentPlayer.resurrect();
			this.logResurrected();
		}else {
			this.logPlayerSkipTurn();
		}
	}
	
	private void logPlayerWon() {
		this.log += "Jugador " + this.currentPlayerIndex + " ha ganado el combate \n";
	}
	
	private void logMonsterWon() {
		this.log += "El monstruo ha ganado contra el jugador " + this.currentPlayerIndex + "\n";
	}
	
	private void logResurrected() {
		this.log += "El jugador " + this.currentPlayerIndex+ " ha sido resucitado\n";
	}
	
	private void logPlayerSkipTurn() {
		this.log += "El jugador  " + this.currentPlayerIndex + "no puede usar su turno, está muerto\n";
	}
	
	private void logPlayerNoOrders() {
		this.log += "El jugador " + this.currentPlayerIndex + " no ha seguido las intstrucciones del"
				+ " jugador humano\n";
	}
	
	private void logNoMonster() {
		this.log += "El jugador " + this.currentPlayerIndex + "r se ha movido a una celda vacía o no le ha sido posible moverse\n";
	}
	
	private void logRounds(int rounds, int max) {
		this.log += "Se han producido ya " + rounds + " de " + max + " rondas";
	}
}
