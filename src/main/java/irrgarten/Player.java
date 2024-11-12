package irrgarten;

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
	
	public Directions move(Directions direction, List<Directions> validMoves) {
		int size = validMoves.size();
		boolean contained = validMoves.contains(direction);
		if(size > 0 && !contained) {
			Directions firstElement = validMoves.get(0);
			return firstElement;
		}
		return direction;
	}
	
	public float attack() {
		return this.strength + this.sumWeapons();
	}
	
	public boolean defend(float receivedAttack) {
		return this.manageHit(receivedAttack);
	}
	
	public void receiveReward() {
		int wReward = Dice.weaponsReward();
		int sReward = Dice.shieldsReward();
		for(int i = 1; i <= wReward; i++) {
			Weapon wnew = new Weapon(Dice.weaponPower(), Dice.usesLeft());
			this.receiveWeapon(wnew);
		}
		for(int i = 1; i <= sReward; i++){
			Shield snew = new Shield(Dice.shieldPower(), Dice.usesLeft());
			this.receiveShield(snew);
		}
		int extraHealth = Dice.healthReward();
		this.health += extraHealth;
	}
	
	@Override
	public String toString() {
		return this.name + "| HP: " + this.health + "| Intellect: " + this.intelligence + "| Strength: " +this.strength;
	}
	
	private void receiveWeapon(Weapon w) {
		for(int i = 0; i < this.weapons.size() - 1; i++) {
			if(this.weapons.get(i).discard()) {
				this.weapons.remove(i);
			}
		}
		if(this.weapons.size()<maxWeapons) {
			this.weapons.add(w);
		}
	}
	
	private void receiveShield(Shield s) {
		for(int i = 0; i < this.shields.size() - 1; i++) {
			if(this.shields.get(i).discard()) {
				this.shields.remove(i);
			}
		}
		if(this.shields.size()<maxShields) {
			this.shields.add(s);
		}
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
		boolean lose;
		float defense  = this.defensiveEnergy();
		if(defense < receivedAttack) {
			this.gotWounded();
			this.incConsecutiveHits();
		}else {
			this.resetHits();
		}
		if(this.consecutiveHits == hits2Lose || this.dead()) {
			this.resetHits();
			lose=true;
		}else {
			lose=false;
		}
		return lose;
	}
	
	private void resetHits() {
		this.consecutiveHits = 0;
	}
	
	private void gotWounded() {
		this.health--;
	}
	
	private void incConsecutiveHits() {
		this.consecutiveHits++;
	}
	
}
