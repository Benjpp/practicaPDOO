package Irrgarten;
import java.util.ArrayList;
import java.util.List;


public class Labyrinth {
	
	static final char BLOCK_CHAR = 'X';
	
	static final char EMPTY_CHAR = '-';
	
	static final char MONSTER_CHAR = 'M';
	
	static final char COMBAT_CHAR = 'C';
	
	static final char EXIT_CHAR = 'E';
	
	static final int ROW = 0;
	
	static final int COL = 1;
	
	private int nRows,
				nCols,
				exitRow,
				exitCol;
	//arr1.Pos(fila).Pos(Columna)
	
	private Monster[][] monsters;
	private Player[][] players;
	private char[][] labyrinth;
	
	public Labyrinth(int nRows, int nCols, int exitRow, int exitCol) {
		
		this.exitCol = exitCol;
		this.exitRow = exitRow;
		this.nCols = nCols;
		this.nRows = nRows;
		
		this.labyrinth = new char[nRows][nCols];
		this.monsters = new Monster[nRows][nCols];
		this.players = new Player[nRows][nCols];
		
		for(int i = 0; i < nRows; i++) {
			for(int j = 0; j < nCols; i++) {
				if((j == 0) || (j == nCols - 1)) {
					this.labyrinth[i][j] = BLOCK_CHAR;
				}
			}
		}
		
		this.labyrinth[exitRow][exitCol] = EXIT_CHAR;
		
	}
	
	public boolean haveAWinner() {
		if(players[this.exitRow][this.exitCol] != null) {
			return true;
		}
		return false;
	}
	
	@Override
	public String toString() {
		String lab = "";
		for(int i = 0; i < nRows; i++) {
			for (int j = 0; j < nCols; j++) {
				lab += this.labyrinth[i][j] +"|"; 
			}
			lab += "\n";
		}
		return lab;
	}
	
	public void addMonster(int row, int col, Monster monster) {
		if (this.posOK(row, col) && this.emptyPos(row, col)) {
			this.monsters[row][col]=monster;
		}
	}
	
	public void spreadPlayers(Player[] players) {
		
	}
	
	public Monster putPlayer(Directions direction, Player player) {
		
	}
	
	public void addBlock(Orientation orientation, int startRow, int startCol, int length) {
		
	}
	
	public Directions validMoves(int row, int col) {
		
	}
	
	private boolean posOK(int row, int col) {
		return ((row < this.nRows) && (col < this.nCols));
	}
	
	private boolean emptyPos(int row, int col) {
		return this.labyrinth[row][col] == EMPTY_CHAR;
	}
	
	private boolean monsterPos(int row, int col) {
		return this.labyrinth[row][col] == MONSTER_CHAR;
	}
		
	
	private boolean exitPos(int row, int col) {
		return this.labyrinth[row][col] == EXIT_CHAR;
	}
	
	private boolean combatPos(int row, int col) {
		return this.labyrinth[row][col] == COMBAT_CHAR;
	}
	
	private boolean canStepOn(int row, int col) {
		return this.posOK(row, col) && (this.emptyPos(row, col) ||
				this.monsterPos(row, col) || this.exitPos(row, col));
	}
	
	private void updateOldPos(int row, int col) {
		if(this.posOK(row, col)){
			if(this.labyrinth[row][col] == COMBAT_CHAR) {
				this.labyrinth[row][col] = MONSTER_CHAR;
			}else {
				this.labyrinth[row][col] = EMPTY_CHAR;
			}
		}
	}

	private int[] dir2Pos(int row, int col, Directions direction) {
		int[] newDir = new int[2];
		switch (direction) {
		case left:
			newDir[0] = row - 1;
			newDir[1] = col;
			break;
		
		case right:
			newDir[0] = row + 1;
			newDir[1] = col;
			break;
			
		case up:
			newDir[0] = row;
			newDir[1] = col + 1;
			break;
			
		case down:
			newDir[0] = row;
			newDir[1] = col - 1;
			break;
		}
		
		return newDir;
			
	}
	
	private int[] randomEmptyPos() {
		int[] randomPos = new int[2];
		do {
			randomPos[0] = Dice.randomPos(this.nRows);
			randomPos[1] = Dice.randomPos(this.nCols);
		}while(!this.emptyPos(randomPos[0],randomPos[1]));
		
		return randomPos;
	}
	
	
	
}
