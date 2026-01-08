package Misc;

import Characters.Personaje;

import java.util.Random;

public class GameTest {
    public static Personaje inicializarPersonaje(String nombre, int nivel, int pv, int atq, int def) {
        Personaje c1= new Personaje();
        c1.setNombre(nombre);
        c1.setNivel(nivel);
        c1.setPv(pv);
        c1.setAtq(atq);
        c1.setDef(def);
        return c1;
    }

    public static Personaje randomizarPersonaje(String nombre2) {
        Personaje c2=new Personaje();
        c2.setNombre(nombre2);
        c2.setNivel(1);
        Random r= new Random();
        c2.setPv(r.nextInt(1,33));
        c2.setAtq(r.nextInt(r.nextInt(1,33)));
        c2.setDef(r.nextInt(1,33));
        return c2;
    }
}
