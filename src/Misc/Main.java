package Misc;

import Characters.Creyente;
import Characters.Mago;
import Characters.Paladin;
import Characters.Personaje;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Paladin P1 = new Paladin("Jesus1",2,2,2,2,2,2,2);
        Paladin P2 = new Paladin("Jesus2",3,3,3,3,3,3,3);
        Paladin P3 = new Paladin("Jesus3",4,4,4,4,4,4,4);
        Paladin P4 = new Paladin("Jesus4",34,34,34,34,34,34,34);
        Paladin P5 = new Paladin("Jesus5",5,5,5,5,5,5,5);
        Personaje [] party = {P1, P2, P3, P4, P5};
        Paladin Joseador = new Paladin();
       // GameLogger.ArraysFicheros(party);
        //GameLogger.Escribeenfichero(Joseador);
        GameLogger.CombatirGameLogger(P4,P5, new File("./Ficheros/Combate.txt"));
    }
}