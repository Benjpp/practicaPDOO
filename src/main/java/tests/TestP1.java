package tests;

import Irrgarten.Dice;
import Irrgarten.GameState;
import Irrgarten.Shield;
import Irrgarten.Weapon;

public class TestP1 {
    public static void main(String[] args) {
        //Creando escudos
    	Shield escudoMadera = new Shield(4.3f, 4);
        Shield escudoHierro = new Shield(7.5f, 5);
        
        //Probando escudos
        System.out.println(escudoMadera.toString() + "\n" + escudoHierro.toString());
        System.out.println("El escudo de madera me protege por: " + Float.toString(escudoMadera.protect()) + "\n" + 
        "El escudo de hierro me protege por: " + Float.toString(escudoHierro.protect()));     
        System.out.println(escudoMadera.toString() + "\n" + escudoHierro.toString());
        String discardEscudoMadera = escudoMadera.discard()? "He descartado el escudo de madera" : "No he descartado el escudo de madera";
        String discardEscudoHierro = escudoHierro.discard()? "He descartado el escudo de hierro" : "No he descartado el escudo de hierro";
        System.out.println(discardEscudoMadera + " y " + discardEscudoHierro);

        //Creando armas
        Weapon pistola = new Weapon(8.0f, 4);
        Weapon navaja = new Weapon(2.5f, 10);

        //Probando armas
        System.out.println(pistola.toString() + "\n" + navaja.toString());
        System.out.println("La psitola ataca por: " + Float.toString(pistola.attack()) + "\n" + 
        "La navaja ataca por: " + Float.toString(navaja.attack()));     
        System.out.println(escudoMadera.toString() + "\n" + escudoHierro.toString());
        String discardPistola = pistola.discard()? "He descartado el escudo de madera" : "No he descartado el escudo de madera";
        String discardNavaja = navaja.discard()? "He descartado el escudo de hierro" : "No he descartado el escudo de hierro";
        System.out.println(discardPistola + " y " + discardNavaja);
        
        //Probando dado
       
        for(int i = 101; i > 1; i--) {
        	String discardElement = Dice.discardElement(i)? "Elemento descartado" : "Elemento no descartado";
        	System.out.println("Probando discardElement(usesLeft): " + discardElement + " para " + Integer.toString(i) + " usos");
        }
        
        for(int i = 1; i < 101; i++) {
        	System.out.println("Probando healthReward(): " + Integer.toString(Dice.healthReward()));
        }
        
        for(int i = 1; i < 101; i++) {
        	System.out.println("Probando intensity(float competence): " + Float.toString(Dice.intensity(i)));
        }
        
        for(int i = 1; i < 101; i++) {
        	System.out.println("Probando randomIntelligence(): " + Float.toString(Dice.randomIntelligence()));
        }
        
        for(int i = 1; i < 101; i++) {
        	System.out.println("Probando randomStrength(): " +Float.toString(Dice.randomStrength()));
        }
        
        for(int i = 1; i < 101; i++) {
        	System.out.println("Probando randomPos(int max): " + Integer.toString(Dice.randomPos(i)));
        }
        
        for(int i = 1;i < 101; i++) {
        	System.out.println("Probando shieldPower(): " + Float.toString(Dice.shieldPower()));
        }
        
        for(int i = 1; i < 101; i++) {
        	System.out.println("Probando shieldsReward(): " +Integer.toString(Dice.shieldsReward()));
        }
        
        for(int i = 1; i < 101; i++) {
        	System.out.println("Probando usesLeft(): " +Integer.toString(Dice.usesLeft()));
        }
        
        for(int i = 1; i < 101; i++) {
        	System.out.println("Probando weaponPower(): " + Float.toString(Dice.weaponPower()));
        }
        
        for(int i = 1; i < 101; i++) {
        	System.out.println("Probando weaponsReward(): " +Integer.toString(Dice.weaponsReward()));
        }
        
        for(int i = 1; i < 101; i++) {
        	String resurrectPlayer = Dice.resurrectPlayer()? "Jugador ha sido resucitado" : "Jugador no ha sido resucitado";
        	System.out.println("Probando ressurectPlayer(): " + resurrectPlayer);
        }
        
        int nPlayers = 10;
        for(int i = 1; i < 101; i++) {
        	
        	System.out.println("Probando whoStart(nPlayers)" + Integer.toString(Dice.whoStart(nPlayers)));
        }
        
    }
}