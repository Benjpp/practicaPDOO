import java.util.Random;

public class dice {

    private int maxUses = 5;           // (número máximo de usos de armas y escudos)

    private float maxIntelligence = 10.0;// (valor máximo para la inteligencia de jugadores y monstruos)

    private float maxStrength = 10.0;   // (valor máximo para la fuerza de jugadores y monstruos)
    
    private float resurrectProb = 0.3;   // (probabilidad de que un jugador sea resucitado en cada turno)
    
    private int weaponsReward = 2;    // (numero máximo de armas recibidas al ganar un combate)
    
    private int shieldsReward = 3;     // (numero máximo de escudos recibidos al ganar un combate)
    
    private int healthReward = 5;      // (numero máximo de unidades de salud recibidas al ganar un combate)
    
    private int maxAttack = 3;         // (máxima potencia de las armas)
    
    private int maxShield = 2;         // (máxima potencia de los escudos)

    public int randomPos (int max){
        Random rand = new Random();
        return rand.nextInt(0, max);
    }

    public int whoStart (int nPlayers){
        Random rand = new Random();
        return rand.nextInt(0, nPlayers);
    }

    public float maxIntelligence (){
        Random rand = new Random();
        return rand.nextFloat(0, maxIntelligence);
    }
    
    public float maxStrength (){
        Random rand = new Random();
        return rand.nextFloat(0, maxStrength);
    }

    public boolean resurrectPlayer(){
        Random  rand = new Random();
        return rand.nextFloat(0, 1) <= 0.3;
    }

    public int weaponsReward(){
        Random rand = new Random();
        return rand.nextInt(0, weaponsReward);
    }

    public int healthReward(){
        Random rand = new Random();
        return rand.nextInt(0, healthReward);
    }

    public int shieldsReward(){
        Random rand = new Random();
        return rand.nextInt(0, shieldsReward);
    }

    public float weaponPower(){
        Random rand = new Random();
        return rand.nextFloat(0, maxAttack);
    }



    

}