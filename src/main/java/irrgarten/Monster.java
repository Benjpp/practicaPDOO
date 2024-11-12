package irrgarten;

public class Monster {
	private int row,col;
	private String name;
	private float intelligence, health, strength;
	private static int initialHealth = 5;
	
	public Monster(String name, float intelligence, float strength) {
		this.name = name;
		this.intelligence = intelligence;
		this.strength = strength;
		this.health = initialHealth;
	}
	
	public boolean dead() {
		return this.initialHealth > 0;
	}
	
	public float attack() {
		return Dice.intensity(this.strength);
	}
	
	public void setPos(int row, int col) {
		this.row = row; 
		this.col = col;
	}
	
	@Override
	public String toString() {
		return this.name + ": " + this.initialHealth + " HP";
	}
	
	public void gotWounded() {
		this.initialHealth--;
	}
	
	public boolean defend(float receivedAttack) {
		boolean isDead = this.dead();
		if(!isDead) {
			float defensiveEnergy = Dice.intensity(this.intelligence);
			if(defensiveEnergy < receivedAttack) {
				this.gotWounded();
				isDead = this.dead();
			}
		}
		return isDead;
	}
}
