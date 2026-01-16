package Misc;

import Characters.Personaje;

import java.util.Random;

/**
 * La clase GameTest sirve para crear a los personajes que usaremos en el combate
 * y recibe los parametros que usamos en la clase personaje:
 * nombre,ataque, armadura, resistencia magica, vida y nivel.
 *
 * @author Jesús Ivars
 * @version 2.0
 */

public class GameTest {

    /**
     * Esta constructor por parametros estatico Personaje sirve para poder establecer
     * un personaje por parametros con todos los atributos correspondientes
     * @param nombre String para el nombre
     * @param nivel Int para el nivel
     * @param pv Int para la vida
     * @param atq Int para el ataque
     * @param def Int para la defenda fisica
     * @param mag Int para la resistencia magica
     * @return El personaje creado
     */

    public static Personaje inicializarPersonaje(String nombre, int nivel, int pv, int atq, int def, int mag) {
        Personaje c1= new Personaje();
        c1.setNombre(nombre);
        c1.setNivel(nivel);
        c1.setPv(pv);
        c1.setAtq(atq);
        c1.setArm(def);
        c1.setRes(mag);
        return c1;
    }

    /**
     * Metodo estatico de personaje que solo recibe por parametros el nombre
     * y establece el resto de valores poir azar a traves de un randomizador
     * menos el nivel que se establece a 1 automaticamente
     * @param nombre2 String para el nombre de personaje
     * @return El personaje creado
     */

    public static Personaje randomizarPersonaje(String nombre2) {
        Personaje c2=new Personaje();
        c2.setNombre(nombre2);
        c2.setNivel(1);
        Random r= new Random();
        c2.setPv(r.nextInt(1,33));
        c2.setAtq(r.nextInt(r.nextInt(1,33)));
        c2.setArm(r.nextInt(1,33));
        c2.setRes(r.nextInt(1,33));
        return c2;
    }
}
