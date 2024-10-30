package tests;

import equipment.Shield;
import equipment.Weapon;

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

        


    }
}