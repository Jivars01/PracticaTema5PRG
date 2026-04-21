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
 * Clase Mago.
 * Representa un personaje de tipo mago.
 * Hereda de la clase Personaje y se caracteriza por el uso de magia
 * para atacar o mejorar sus atributos.
 */

public class Mago extends Personaje {

    private int mag;/** * Cantidad de puntos de magia del mago */

    /**
     * Constructor por defecto.
     * Inicializa los valores heredados de Personaje
     * y establece la magia inicial en 10.
     */

    public Mago() {
        super();
        mag = 10;
    }

    /**
     * Constructor parametrizado.
     * Inicializa los atributos heredados y los puntos de magia.
     *
     * @param nombre nombre del personaje
     * @param pv     puntos de vida
     * @param atq    valor de ataque
     * @param arm    valor de armadura
     * @param nivel  nivel del personaje
     * @param vel    velocidad
     * @param res    resistencia
     * @param mag    puntos de magia
     */

    public Mago(String nombre, int pv, int atq, int arm, int nivel, int vel, int res, int mag) {
        super(nombre, pv, atq, arm, nivel, vel, res);
        setMag(mag);
    }

    /**
     * Aumenta el nivel del mago y mejora sus atributos
     * de forma aleatoria, priorizando el incremento de la magia.
     */

    public void subirNivel() {
        int c;
        Random a = new Random();
        c = a.nextInt(100);
        if (c < 85 && c > 0) {
            mag++;
        }

        c = a.nextInt(100);
        if (c < 35 && c > 0) {
            setPv(getPv() + 1);
        }
        c = a.nextInt(100);
        if (c <= 15 && c > 0) {
            setAtq(getAtq() + 1);
            ;
        }
        c = a.nextInt(100);
        if (c <= 35 && c > 0) {
            setArm(getArm() + 1);
        }
        c = a.nextInt(100);
        if ((c <= 80 && c > 0)) {
            setRes(getRes() + 1);
        }
        c = a.nextInt(100);
        if ((c <= 65 && c > 0)) {
            setVel(getVel() + 1);
        }
        setNivel(getNivel() + 1);
    }

    /**
     * Devuelve los puntos de magia del mago.
     *
     * @return puntos de magia
     */

    public int getMag() {
        return mag;
    }

    /**
     * Establece los puntos de magia del mago.
     *
     * @param mag nueva cantidad de magia
     */

    public void setMag(int mag) {
        this.mag = mag;
    }

    /**
     * Permite al mago lanzar un conjuro.
     * Dependiendo del conjuro elegido, puede causar daño
     * o mejorar atributos del personaje.
     *
     * @return daño mágico realizado (0 si no causa daño)
     */

    public double lanzarconjuro() {
        int opcion;
        double daño = 0;
        Scanner scan = new Scanner(System.in);
        opcion = scan.nextInt();
        System.out.println("¿Que conjuro quieres realizar?" +
                "\n 1 Bola de fuego \n 2 Escudo Arcano \n 3 Cefiro \n 4 Presteza mental");
        switch (opcion) {
            case 1:
                System.out.println("Has elegido bola de fuego");
                daño = mag * 0.70;
                break;
            case 2:
                System.out.println("Has elegido Escudo Arcano");
                mag *= 50;
                mag /= 100;
                setRes(getRes() + mag);
                setArm(getArm() + mag);
                break;
            case 3:
                System.out.println("Has elegido Cefiro");
                daño = mag * 0.30;
                break;
            case 4:
                System.out.println("Ha elegido Presteza mental");
                setVel(getVel() + mag);
                break;
            default:
                System.err.println("La opcion escogida no correspone a las especificadas");
        }
        return daño;
    }

    /**
     * Devuelve una descripción del mago.
     *
     * @return cadena con la información del personaje
     */

    public String toString() {
        return super.toString() + "Es un Mago que posee puntos de magia con los que realizar ataques magicos";
    }

    /**
     * Gestiona el turno del mago.
     * Permite atacar, lanzar conjuros, defender o pasar turno.
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
                System.out.println("Has decidido lanzar un conjuro");
                lanzarconjuro();
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
     * Basicamente hace lo mismo que el anterior pero para que se muestre en un fichero
     *
     * @param fichero File
     * @return Daño
     * @throws IOException
     */

    public int realizaTurnoALT(File fichero) throws IOException {
        PrintWriter pw;
        FileWriter fw = new FileWriter(fichero, true);
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
                daño = ataque();
                break;
            case "2":
                pw.println("Has decidido lanzar un conjuro");
                lanzarconjuro();
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
        pw.flush();
        pw.close();
        fw.close();
        return daño;
    }

    /**
     * Introduce a los datos basicos de personaje el atributo magia
     *
     * @return
     */
    public String devuelveDatos() {
        return super.devuelveDatos() +
                "Magia:" + getMag() + "\n"
                + "\n";
    }

    /**
     * Es un Mago
     *
     * @return Mago
     */

    public String getClase() {
        return "Mago";
    }

    public void equipaArma(Arma armaar) {
        if (getArma() != null) {
            System.err.println("Ya hay una arma escogida");
        }
        if(getArma().getTipo().equals("cetro") || getArma().getTipo().equals("baston"))
            setArma(armaar);

    }

    public void equipaArmadura(Armadura arm) {
        if (aseguraArmadura()) {
            for (Armadura dura : getArmadura()) {
                if (dura.getTipo().equals(arm.getTipo()) && !dura.getMaterial().equals("tela"))
                    return;
            }
            getArmadura().add(arm);
        }
    }
}
