package Combat;

import Characters.Personaje;

import GameMap.Trampa;

import java.util.Random;
import java.util.Scanner;

public class Combate {


    private Trampa trampa;
    private String turno;
    Scanner scan = new Scanner (System.in);
    /**
     *Para implementar la trampa:
     *-> Crear un objeto de la clase GameMap.Trampa como variable local dentro del método combatir
     *-> Para cada ronda de cada personaje (dos veces por turno) comprobar si la trampa se activa. USAR METODO DE TRAMPA
     *-> Aplicar efecto de la trampa si procede
     *-> Si la trampa se activa (activarTrampa() != 0): aplicar perjuicio según tipo de trampa
     *-> Si la trampa no se activa (activarTrampa() == 0): inspirar usando el método de la clase Characters.Personaje con el valor del perjuicio obtenido de activarTrampa()
     */
    public static Personaje combatir(Personaje c1, Personaje c2) {
        Personaje resultado = new Personaje();
        System.out.println("Empieza el combate entre " + c1.getNombre() + " y " + c2.getNombre());
        Trampa trampa = new Trampa(inicializaTrampa());

        do {
            if (c1.getVel() > c2.getVel()) {
                System.out.println(c1.getNombre() + "Empieza el combate");
                if(c1.getVel() > c2.getVel()*2){
                    c1.RealizaTurno();
                }
               c1.RealizaTurno();

                if (trampa.activatrampa() != 0) {
                    c1.caerTrampa(trampa);
                } else if (trampa.getCategoria().equals("Brea")) {
                    c1.inspirar(trampa.getPerjuicio(), "def");
                }
                if (c1.getVel()>c2.getVel()*2){
                    System.out.println("El personaje realiza doble turno debido a su gran velocidad");
                    int nuevaVida = 0;

                    c1.ataque();
                    c2.defender(c2.getArm(),"Fisico");
                    nuevaVida = c2.getPv() - c1.ataque();
                    c2.setPv(nuevaVida);

                    System.out.println("Daño total causado: " + c1.ataque() + " puntos.");

                    System.out.println("El personaje 2 posee ahora mismo " + c2.getPv() + " puntos de vida");
                    if (c2.getPv() <= 0) {
                        System.out.println("Characters.Personaje 1 gana.");
                        break;
                    }
                }
            }

            int nuevaVida = 0;

            c1.ataque();
            c2.defender(c2.getArm(),"Fisico");
            nuevaVida = c2.getPv() - c1.ataque();
            c2.setPv(nuevaVida);

            System.out.println("Daño total causado: " + c1.ataque() + " puntos.");

            System.out.println("El personaje 2 posee ahora mismo " + c2.getPv() + " puntos de vida");
            if (c2.getPv() <= 0) {
                System.out.println("Characters.Personaje 1 gana.");
                break;
            }

            System.out.println("Ha continuación el personaje 2 atacara al personaje 1 según las estadísticas predefinidas");
            if (trampa.activatrampa() != 0) {
                c2.caerTrampa(trampa);
            } else if (trampa.getCategoria().equals("Brea")) {
                c2.inspirar(trampa.getPerjuicio(), "def");
            }
            int nuevaVida2 = 0;
            c2.ataque();
            c1.defender(c1.getArm(),"Magico");
            nuevaVida2 = c1.getPv() - c2.ataque();
            c1.setPv(nuevaVida2);

            System.out.println("Daño total causado: " + c2.ataque() + " puntos.");

            System.out.println("El personaje 1 posee ahora mismo posee " + c1.getPv() + " puntos de vida");
            if (c1.getPv() <= 0) {
                System.out.println("Characters.Personaje 2 gana.");
                resultado = c2;
            } else {
                System.out.println(c2.getNombre() + " Empieza el combate");
                nuevaVida2 = 0;
                if (trampa.activatrampa() != 0) {
                    c2.caerTrampa(trampa);
                } else if (trampa.getCategoria().equals("Brea")) {
                    c2.inspirar(trampa.getPerjuicio(),"def");
                }
                c2.ataque();
                c2.defender(c1.getArm(),"Fisico");

                nuevaVida2 = c1.getPv() - c2.defender(c2.getArm(),"Magico");
                c1.setPv(nuevaVida2);

                System.out.println("Daño total causado: " + c2.ataque() + " puntos.");

                System.out.println("El personaje 1 ahora mismo posee " + c1.getPv() + " puntos de vida");
                if (c1.getPv() <= 0) {
                    System.out.println("Characters.Personaje 2 gana.");
                }

                nuevaVida = 0;

                if (trampa.activatrampa() != 0) {
                    c1.caerTrampa(trampa);
                } else if (trampa.getCategoria().equals("Brea")) {
                    c1.inspirar(trampa.getPerjuicio(),"def");
                }

                c1.ataque();
                c2.defender(c2.getArm(),"Fisico");
                nuevaVida = c2.getPv() - c1.ataque();
                c2.setPv(nuevaVida);

                System.out.println("Daño total causado: " + c1.ataque() + " puntos.");

                System.out.println("El personaje 2 posee ahora mismo " + c2.getPv() + " puntos de vida");
                if (c2.getPv() <= 0) {
                    resultado = c1;
                    System.out.println("Characters.Personaje 1 gana.");
                }
            }
        } while (!c1.estarMuerto() && !c2.estarMuerto());
        Imprimeganador(resultado);
        return resultado;
    }

    public static void Imprimeganador(Personaje p) {
        System.out.println("El personaje " + p.getNombre() + "es el ganador");
    }

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

