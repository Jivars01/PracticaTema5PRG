package Combat;

import Armamento.Equipamiento;
import Characters.Personaje;

import GameMap.Trampa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

/**
 * Clase Combate que crea un combate entre dos personajes que usaran el objeto de la
 * clase personaje para establecer sus valores y asi pelearse entre ellos e indicar
 * quien gana o pierde el combate ademas se crearan dos atributos que son la trampa
 * de la clase Trampa y un string para indicar el turno admeas de un scanner que
 * usaremos para poder indicar el turno por teclado
 *
 * @author Jesús Ivars
 * @version 2.0
 */

public class Combate {
    private static ArrayList<Equipamiento> tesoros;

    /**
     * Metodo Estatico Combatir de la Clase Personaje que establece el combate entre dos personajes
     * que pueden ser de disintas clases, la velocidad indicara quien empieza el combate
     * incluyendo que si un personaje tiene el doble de velocidad que el otro
     * haga doble turno, y se podra indicar al personaje que haga una accion de cuatro disponibles,
     * atacar fisicamente, atacar magicamente, pasar turno o defenderte
     *
     * @param c1 De la clase personaje que crea al primer jugador
     * @param c2 De la clase personaje que crea al segundo jugador
     * @return devuelve quien es el ganador del combate
     */


    /**
     * Metodo que se usa para imprimir un mesaje segun el ganador del combate
     *
     * @param p Recibe el personaje ganador por parametro
     */
    public static void Imprimeganador(Personaje p) {
        System.out.println("El personaje " + p.getNombre() + "es el ganador");
    }

    /**
     * Metodo que establece una trampa dentro del combate qe ademas
     * variara algunos valores segun la trampa este en un bioma indicado
     *
     * @return La trampa establecida al combate
     */

    public static Trampa inicializaTrampa() {
        Trampa trampa = new Trampa();
        trampa.setFracaso();

        int per;
        Random p = new Random();
        per = p.nextInt(5, 26);
        trampa.setPerjuicio(per);

        Random t = new Random();
        int pa = t.nextInt(0, 3);
        String ver;
        if (pa == 1) {
            ver = "Pinchos";
        } else if (pa == 2) {
            ver = "Brea";
        } else {
            ver = "Serpientes";
        }
        trampa.setCategoria(ver);
        return trampa;
    }

    /**
     * Metodo Estatico Combatir de la Clase Personaje que establece el combate entre dos personajes
     * que pueden ser de disintas clases, la velocidad indicara quien empieza el combate
     * incluyendo que si un personaje tiene el doble de velocidad que el otro
     * haga doble turno, y se podra indicar al personaje que haga una accion de cuatro disponibles,
     * atacar fisicamente, atacar magicamente, pasar turno o defenderte
     *
     * @param p1 De la clase personaje que crea al primer jugador
     * @param p2 De la clase personaje que crea al segundo jugador
     * @return devuelve quien es el ganador del combate
     */

    public static void combatir(Personaje p1, Personaje p2) {
        Personaje primero, segundo;
        if (comprobarPrimero(p1, p2)) {
            primero = p1;
            segundo = p2;
        } else {
            primero = p2;
            segundo = p1;
        }
        //Empieza el combate
        do {
            System.out.println("Empieza el combate entre " + p1.getNombre() + " y " + p2.getNombre() + ".");
            muestraCombate(primero, segundo);
            if (!hayMuertos(primero, segundo) && golpeaDosVeces(primero, segundo)) {
                segundo.defender(primero.realizaTurno(), "Fisico"); //(Golpe doble)
                muestraCombate(primero, segundo);
            }
            if (!hayMuertos(primero, segundo)) {
                segundo.defender(primero.realizaTurno(), "Fisico"); //Golpe estándar
                muestraCombate(primero, segundo);
            }
            if (!hayMuertos(primero, segundo)) {
                primero.defender(segundo.realizaTurno(), "Fisico");
                muestraCombate(primero, segundo);
            }
        } while (!p1.estarMuerto() && !p2.estarMuerto());

        if (p1.estarMuerto())
            System.out.println("El ganador es p2");
        else System.out.println("El ganador es p1");
    }

    private static boolean comprobarPrimero(Personaje p1, Personaje p2) {
        return p1.getVel() > p2.getVel();
    }

    private static boolean golpeaDosVeces(Personaje p1, Personaje p2) {
        return (p1.getVel() > (p2.getVel() * 2));
    }

    private static boolean hayMuertos(Personaje p1, Personaje p2) {
        return (p1.estarMuerto() || p2.estarMuerto());
    }

    private static void muestraCombate(Personaje p1, Personaje p2) {
        System.out.println(p1.getNombre() + ": " + p1.getPv());
        System.out.println(p2.getNombre() + ": " + p2.getPv());
    }
    /**
     * . (1) Añade un atributo estático en la clase Combate que permita almacenar una colección
     * de Equipamiento llamado tesoros. Esta colección de tesoros se ofrecerá como premio
     * al jugador si gana un Combate, por lo que deberás modificar el método combatir() para
     * que se proporcione al ganador una pieza de Equipamiento aleatoria de la colección. Una
     * vez otorgado como premio por la victoria, deberá eliminarse dicho tesoro de la
     * colección.
     * Los tesoros se encuentran en los ficheros armas.csv, armaduras.csv y artefactos.csv
     * adjuntos a la práctica. La lista de tesoros no se restablece durante combates, sino que
     * se inicializa al comenzar la ejecución del programa y sus cambios persisten entre
     * Combates
     */

    /**
     * 5. (1) Modifica el método combatir() de la clase Combate para que se tengan en cuenta
     * los nuevos atributos añadidos a la clase Personaje. Para ello, asegúrate de que en cada
     * intercambio de golpes entre los dos Personajes, se suman correctamente los valores de
     * las estadísticas de su Equipamiento a sus estadísticas propias.
     */
}




