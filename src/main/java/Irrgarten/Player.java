package Irrgarten;

import java.util.ArrayList;
import java.util.List;

public class Player {
	private static int 
				maxWeapons = 2, 
				maxShields = 3,
				initialHealth = 10, 
				hits2Lose = 3;
	
	private String name;
	private char number;
	private float 
				intelligence, 
				strength,
				health;
	
	private int 
				row,
				col,
				consecutiveHits = 0;
	
	private List<Weapon> weapons;

	private List<Shield> shields;
	
	public Player(char number, float intelligence, float strength) {
		this.intelligence = intelligence;
		this.number = number;
		this.strength = strength;
		this.weapons = new ArrayList<Weapon>();
		this.shields = new ArrayList<Shield>();
	}
	
	public void resurrect() {
		if(Dice.resurrectPlayer()) {
			
			this.health = initialHealth;
			this.weapons = new ArrayList<Weapon>();
			this.shields = new ArrayList<Shield>();
			this.resetHits();
			
		}
	}
	
	public void setPos(int row, int col) {
		this.row = row;
		this.col = col;
	}
	
	public int getRow() {
		return this.row;
	}
	
	public int getCol() {
		return this.col;
	}
	
	public char getNumber() {
		return this.number;
	}
	
	public boolean dead() {
		return this.health == 0;
	}
	
	public Directions move(Directions direction, Directions[] validMoves) {
		
	}
	
	public float attack() {
		return this.strength + this.sumWeapons();
	}
	
	public boolean defend(float receivedAttack) {
		
	}
	
	public void receiveReward() {
		
	}
	
	@Override
	public String toString() {
		return this.name + "| HP: " + this.health + "| Intellect: " + this.intelligence + "| Strength: " +this.strength;
	}
	
	private void receiveWeapon(Weapon w) {
		
	}
	
	private void receiveShield(Shield s) {
		
	}
	
	private Weapon newWeapon() {
		return new Weapon(Dice.weaponPower(), Dice.usesLeft());
	}
	
	private Shield newShield() {
		return new Shield(Dice.shieldPower(), Dice.usesLeft());
	}
	
	private float sumWeapons() {
		float suma = 0;
		for (Weapon w : this.weapons) {
			
			suma += w.attack();
			
		}
		return suma;
	}
	
	private float sumShields() {
		float sum = 0;
		for(Shield s : this.shields) {
			
			sum += s.protect();
			
		}
		return sum;
	}
	
	private float defensiveEnergy() {
		return this.intelligence + this.sumShields();
	}
	
	private boolean manageHit(float receivedAttack) {
		
	}
	
	private void resetHits() {
		this.consecutiveHits = 0;
	}
	
	private void gotWounded() {
		this.health--;
	}
	
	private void incConsecutive() {
		this.consecutiveHits++;
	}
	
}
