package equipment;

import java.util.Random;

public class Dice {

	private static int maxUses = 5;           // (número máximo de usos de armas y escudos)

	private static float maxIntelligence = 10.0f; // (valor máximo para la inteligencia de jugadores y monstruos)

	private static float maxStrength = 10.0f;   // (valor máximo para la fuerza de jugadores y monstruos)

	private static float resurrectProb = 0.3f;   // (probabilidad de que un jugador sea resucitado en cada turno)

	private static int weaponsReward = 2;    // (numero máximo de armas recibidas al ganar un combate)

	private static int shieldsReward = 3;     // (numero máximo de escudos recibidos al ganar un combate)

	private static int healthReward = 5;      // (numero máximo de unidades de salud recibidas al ganar un combate)

	private static int maxAttack = 3;         // (máxima potencia de las armas)

	private static int maxShield = 2;         // (máxima potencia de los escudos)

	private static Random generator = new Random();

	public static int randomPos (int max){
	    return generator.nextInt(0, max);
	}

	public static int whoStart (int nPlayers){
	    return generator.nextInt(0, nPlayers);
	}

	public static float randomIntelligence (){
	    return generator.nextFloat(0, maxIntelligence);
	}

	public static float randomStrength (){
	    return generator.nextFloat(0, maxStrength);
	}

	public static boolean resurrectPlayer(){
	    return generator.nextFloat(0, 1) <= resurrectProb;
	}

	public static int weaponsReward(){
	    return generator.nextInt(0, weaponsReward);
	}

	public static int healthReward(){
	    return generator.nextInt(0, healthReward);
	}

	public static int shieldsReward(){
	    return generator.nextInt(0, shieldsReward);
	}

	public static float weaponPower(){
	    return generator.nextFloat(0, maxAttack);
	}

	public static float shieldPower() {
	    return generator.nextFloat(0, maxShield);
	}

	public static int usesLeft() {
	    return generator.nextInt(0, maxUses);
	}

	public static float intensity(float competence) {
	    return generator.nextFloat(0, competence);
	}

	public static boolean discardElement(int usesLeft) {
	    float usesLeftAPorcentaje = (float)usesLeft / maxUses ;
	    return generator.nextFloat(0, 1) >= usesLeftAPorcentaje ;
	}

    
}
