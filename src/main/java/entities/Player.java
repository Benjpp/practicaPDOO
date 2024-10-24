package entities;

import equipment.Shield;
import equipment.Weapon;
import irrgartenEnums.Directions;

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
	
	public Player(char number, float intelligence, float strength) {
		this.intelligence = intelligence;
		this.number = number;
		this.strength = strength;
	}
	
	public void resurrect() {
		
	}
	
	public int getRow() {
		
	}
	
	public int getCol() {
		
	}
	
	public char getNumber() {
		
	}
	
	public void setPos(int row, int col) {
		
	}
	
	public boolean dead() {
		
	}
	
	public Directions move(Directions direction, Directions[] validMoves) {
		
	}
	
	public float attack() {
		
	}
	
	public boolean defend(float receivedAttack) {
		
	}
	
	public void receiveReward() {
		
	}
	
	@Override
	public String toString() {
		
	}
	
	private void receiveWeapon(Weapon w) {
		
	}
	
	private void receiveShield(Shield s) {
		
	}
	
	private Weapon newWeapon() {
		
	}
	
	private Shield newShield() {
		
	}
	
	private float sumWeapons() {
		
	}
	
	private float sumShields() {
		
	}
	
	private float defensiveEnergy() {
		
	}
	
	private boolean manageHit(float receivedAttack) {
		
	}
	
	private void resetHits() {
		
	}
	
	private void gotWounded() {
		
	}
	
	private void incConsecutive() {
		
	}
}
