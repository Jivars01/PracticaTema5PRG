package Characters;

import Armamento.Arma;
import Armamento.Armadura;
import Armamento.Artefacto;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

/**
 * Clase Ladron.
 * Representa un personaje de tipo ladrón.
 * Hereda de la clase Personaje y se caracteriza por su alta velocidad
 * y su habilidad especial para robar.
 */

public class Ladron extends Personaje {
    /**
     * Constructor por defecto.
     * Inicializa los valores por defecto del personaje.
     */

    public Ladron() {
        super();
    }

    /**
     * Constructor parametrizado.
     * Inicializa todos los atributos heredados de Personaje.
     *
     * @param nombre nombre del personaje
     * @param pv     puntos de vida
     * @param atq    valor de ataque
     * @param arm    valor de armadura
     * @param nivel  nivel del personaje
     * @param vel    velocidad
     * @param res    resistencia
     */

    public Ladron(String nombre, int pv, int atq, int arm, int nivel, int vel, int res) {
        super(nombre, pv, atq, arm, nivel, vel, res);
    }

    /**
     * Aumenta el nivel del ladrón y mejora sus atributos
     * de forma aleatoria, con prioridad en la velocidad.
     */

    public void subirNivel() {
        int c;
        Random a = new Random();
        c = a.nextInt(100);
        if (c < 40 && c > 0) {
            setPv(getPv() + 1);
        }
        c = a.nextInt(100);
        if (c <= 60 && c > 0) {
            setAtq(getAtq() + 1);
            ;
        }
        c = a.nextInt(100);
        if (c <= 40 && c > 0) {
            setArm(getArm() + 1);
        }
        c = a.nextInt(100);
        if ((c <= 40 && c > 0)) {
            setRes(getRes() + 1);
        }
        c = a.nextInt(100);
        if ((c <= 85 && c > 0)) {
            setVel(getVel() + 1);
        }
        setNivel(getNivel() + 1);
    }

    /**
     * Habilidad especial del ladrón.
     * Devuelve un valor basado en su velocidad,
     * que puede representar la eficacia del robo.
     *
     * @return valor de velocidad del ladrón
     */

    public int robar() {
        return getVel();
    }

    /**
     * Devuelve una descripción del ladrón.
     * @return cadena con la información del personaje
     */

    public String toString() {
        return super.toString() + "Es un Ladron con la habilidad de robar";
    }

    /**
     * Gestiona el turno del ladrón.
     * Permite atacar, robar, defender o pasar turno.
     *
     * @return daño realizado durante el turno
     */

    public int realizaTurno() {
        int daño = 0;
        String tipo;
        Scanner scan = new Scanner(System.in);
        System.out.println("Introduzca por teclado que es lo que vas a hacer:" +
                "\n1.Atacar" +
                "\n2.Ataque especial (Solo algunos categorias pueden hacerlo)" +
                "\n3.Defender" +
                "\n4.Pasar turno");
        tipo = scan.nextLine();
        switch (tipo) {
            case "1":
                System.out.println("Has decidido atacar");
                daño = ataque();
                break;
            case "2":
                System.out.println("El ladron se ha lanzado a robar");
                robar();
                break;
            case "3":
                System.out.println("Has decidido defender");
                setRes((int) (getRes() / 0.80));

                setArm((int) ((getArm()) / 0.80));
                daño = 0;
                break;
            case "4":
                System.out.println("Has decidido pasar el turno tu personaje no hara ninguna accion");
                daño = 0;
                break;
            default:
                System.out.println("La opcion escogida no corresponde a las especificadas");
        }
        return daño;
    }

    /**
     * Me quedan tres mas por documentar ruina
     * Que esto muestra el combate en ficheroooooooooooo
     * @param fichero File
     * @param c2 Un Personaje
     * @return daño
     * @throws IOException
     */

    public int realizaTurnoALT(File fichero, Personaje c2) throws IOException {
        PrintWriter pw;
        FileWriter fw = new FileWriter(fichero,true);
        pw = new PrintWriter(fw);
        int daño = 0;
        String tipo;
        Scanner scan = new Scanner(System.in);
        pw.println("Introduzca por teclado que es lo que vas a hacer:" +
                "\n1.Atacar" +
                "\n2.Ataque especial (Solo algunos categorias pueden hacerlo)" +
                "\n3.Defender" +
                "\n4.Pasar turno");
        tipo = scan.nextLine();
        switch (tipo) {
            case "1":
                pw.println("Has decidido atacar");
                daño = ataque();break;
            case "2":
                pw.println("El ladron se ha lanzado a robar");
                robar();
                break;
            case "3":
                pw.println("Has decidido defender");
                setRes((int) (getRes() / 0.80));

                setArm((int) ((getArm()) / 0.80));
                daño = 0;
                break;
            case "4":
                pw.println("Has decidido pasar el turno, tu personaje no hara ninguna accion");
                daño = 0;
                break;
            default:
                pw.println("La opcion escogida no corresponde a las especificadas");
        }

        return daño;
    }

    /**
     * Este te distrae te deja sin nada
     * @return Ladron
     */
    public String getClase() {
        return "Ladron";
    }
//Los Ladrones pueden empuñar espadas y dagas. Pueden equiparse Armadura
//de cuero o de tela.
    public void equipaArma(Arma armaar) {
        if(getArma() != null){

            System.err.println("Ya hay una arma escogida");
        } else if(getArma().getTipo() == "espadas" || getArma().getTipo() == "dagas" )
            setArma(armaar);
    }

    public void equipaArmadura(Armadura arm) {
        if(aseguraArmadura()) {
            for (Armadura dura : getArmadura()) {
                if(dura.getTipo().equals(arm.getTipo()) && dura.getMaterial() == "metal")
                    return;
            }
            getArmadura().add(arm);
        }
    }

    public void equipaArtefacto(Artefacto artefact) {
        if(aseguraArtefacto()){
            for (Artefacto art : getArtefacto()) {
                if(art.getTipo() == "Amuletos"){
                    return;
                }
            }
            getArtefacto().add(artefact);
        }
    }

}
