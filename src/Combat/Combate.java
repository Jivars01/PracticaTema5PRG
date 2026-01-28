package Combat;

import Characters.Personaje;

import GameMap.Trampa;

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
    /**
     * Metodo Combate de la Clase Personaje que establece el combate entre dos personajes
     * que pueden ser de disintas clases, la velocidad indicara quien empieza el combate
     * incluyendo que si un personaje tiene el doble de velocidad que el otro
     * haga doble turno, y se podra indicar al personaje que haga una accion de cuatro disponibles,
     * atacar fisicamente, atacar magicamente, pasar turno o defenderte
     *
     * @param c1 De la clase personaje que crea al primer jugador
     * @param c2 De la clase personaje que crea al segundo jugador
     * @return devuelve quien es el ganador del combate
     */

    public static void combatir2(Personaje c1, Personaje c2) {
        /*
            REALIZARTURNO SOLO LO UTILIZA EL PERSONAJE JUGABLE
            Bucle do-while del combate
            0. Comprobar que personaje tiene más velocidad
            1. Ejecutar primera posibilidad
                1.1. Comprobar si el personaje más veloz tiene doble turno
                1.2. Realizar el turno adicional primero SI LO HUBIERA, utilizando defender con la cantidad de daño obtenida de realizarTurno
                1.3. Realizar el turno habitual, utilizando igual defender con la cantidad de la llamada a realizarTurno
                1.4. Realizar el turno del oponente
                1.* DESPUÉS DE CADA GOLPE HAY QUE COMPROBAR SI EL GOLPE HA MATADO Y EL COMBATE TERMINA
            2. Ejecutar segunda posibilidad
                2.1. Repetir los pasos 1.1. a 1.*. con c1 y c2 invertidos
            3. Declarar el ganador cuando se salga del bucle
         */


        do {
            System.out.println("Empieza el combate entre " + c1.getNombre() + " y " + c2.getNombre());
            if (c1.getVel() > c2.getVel()) { //1
                System.out.println("El personaje 1 empieza el combate ");
                if (c1.getVel() >= c2.getVel() * 2) { //1.1
                    c2.defender(c1.realizaTurno(), "fisico");
                    if (c2.getPv() <= 0) {
                        Imprimeganador(c1);
                    } else {
                        c2.defender(c1.realizaTurno(), "fisico");
                        if (c2.getPv() <= 0)
                            Imprimeganador(c1);
                        else
                            System.out.println("El combate continua");
                    }
                }

            } else //2
                System.out.println("El personaje rival empieza el combate");
            if (c1.getVel() >= c2.getVel() * 2) {
                c1.defender(c2.ataque(), "fisico");
                if (c2.getPv() <= 0) {
                    Imprimeganador(c2);
                } else {
                    c2.defender(c1.realizaTurno(), "fisico");
                    if (c2.getPv() <= 0)
                        Imprimeganador(c1);
                    else
                        System.out.println("El combate continua");
                }
            }
        } while (!c1.estarMuerto() && c2.estarMuerto());
    }

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
/*public void Activartrampa() {
        Personaje = new Personaje;
    if (trampa.activatrampa() != 0) {
        Personaje.caerTrampa(trampa);
    } else if (trampa.getCategoria().equals("Brea")) {
        Personaje.inspirar(trampa.getPerjuicio(), "def");
    }
} */
}

