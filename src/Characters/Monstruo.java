package Characters;

import java.util.Random;
import java.util.Scanner;

/**
 * Clase Monstruo.
 * Representa un personaje de tipo monstruo dentro del juego.
 * Hereda de la clase Personaje y puede pertenecer a distintas categorías
 * como Bestia, No-Muerto o Gigante.
 */

public class Monstruo extends Personaje {
    private String Monstruo;  /** * Tipo de monstruo (Bestia, No-Muerto o Gigante) */

    /**
     * Constructor por defecto.
     * Inicializa los valores heredados de Personaje
     * y establece el tipo de monstruo como una cadena vacía.
     */

    public Monstruo() {
        super();
        Monstruo = "";
    }

    /**
     * Constructor parametrizado.
     * Inicializa los atributos heredados y el tipo de monstruo.
     *
     * @param nombre nombre del personaje
     * @param pv puntos de vida
     * @param atq valor de ataque
     * @param arm valor de armadura
     * @param nivel nivel del personaje
     * @param vel velocidad
     * @param res resistencia
     * @param Monstruo tipo de monstruo
     */

    public Monstruo(String nombre, int pv, int atq, int arm, int nivel, int vel, int res, String Monstruo) {
        super(nombre, pv, atq, arm, nivel, vel, res);
        setMonstruo(Monstruo);
    }

    /**
     * Aumenta el nivel del monstruo y mejora sus atributos
     * de forma aleatoria según el tipo de monstruo.
     */


    public void subirNivel() {
        int c;
        Random a = new Random();
        switch (Monstruo) {

            case "Bestia":
                c = a.nextInt(100);
                if (c < 50 && c > 0) {
                    setPv(getPv() + 1);
                }
                c = a.nextInt(100);
                if (c <= 80 && c > 0) {
                    setAtq(getAtq() + 2);

                }
                c = a.nextInt(100);
                if (c <= 15 && c > 0) {
                    setArm(getArm() + 1);
                }
                c = a.nextInt(100);
                if ((c <= 15 && c > 0)) {
                    setRes(getRes() + 1);
                }
                c = a.nextInt(100);
                if ((c <= 80 && c > 0)) {
                    setVel(getVel() + 2);
                }
                setNivel(getNivel() + 1);
                break;
            case "No-Muerto":

                c = a.nextInt(100);
                if (c < 30 && c > 0) {
                    setPv(getPv() + 1);
                }
                c = a.nextInt(100);
                if (c <= 50 && c > 0) {
                    setAtq(getAtq() + 1);
                }
                c = a.nextInt(100);
                if (c <= 30 && c > 0) {
                    setArm(getArm() + 1);
                }
                c = a.nextInt(100);
                if ((c <= 70 && c > 0)) {
                    setRes(getRes() + 4);
                }
                c = a.nextInt(100);
                if ((c <= 5 && c > 0)) {
                    setVel(getVel() + 1);
                }
                setNivel(getNivel() + 1);
                break;
            case "Gigante":

                c = a.nextInt(100);
                if (c < 50) {
                    setPv(getPv() + 2);
                } else setPv(getPv()+3);

                c = a.nextInt(100);
                if (c <= 50 && c > 0) {
                    setAtq(getAtq() + 1);

                }
                c = a.nextInt(100);
                if (c <= 50 && c > 0) {
                    setArm(getArm() + 1);
                }
                c = a.nextInt(100);
                if ((c <= 10 && c > 0)) {
                    setRes(getRes() + 4);
                }
                c = a.nextInt(100);
                if ((c <= 10 && c > 0)) {
                    setVel(getVel() + 1);
                }
                setNivel(getNivel() + 6);

        }
    }

    /**
     * Devuelve el tipo de monstruo.
     * @return tipo de monstruo
     */

    public String getMonstruo() {
        return Monstruo;
    }

    /**
     * Establece el tipo de monstruo.
     * @param monstruo tipo de monstruo
     */

    public void setMonstruo(String monstruo) {
        if (Monstruo.equals("No-Muerto,")|| Monstruo.equals("Gigante") || Monstruo.equals("Bestia"))
            this.Monstruo = monstruo;
        else this.Monstruo = "";
    }

    /**
     * Devuelve una descripción del monstruo.
     * @return cadena con la información del personaje
     */

    public String toString() {
        return super.toString() + "Es un Monstruo cuya raza es " + getMonstruo() ;
    }

    /**
     * Gestiona el turno del monstruo.
     * Permite atacar, defender o pasar turno.
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
                defender(ataque(),"Fisico");
                break;
            case "2":
                System.out.println("Un Monstruo no tiene un ataque especial");
                break;
            case "3":
                System.out.println("Has decidido defender");
                setRes((int) (getRes() * 1.20));

                setArm((int) ((getArm()) * 1.20));
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

}
