package Characters;

import java.util.Random;
import java.util.Scanner;

/**
 * Clase Clerigo.
 * Representa un personaje de tipo Clérigo que hereda de Creyente.
 * Está especializado en el uso de la fe para curar y apoyar al grupo.
 */

public class Clerigo extends Creyente {

    /**
     * Constructor por defecto del Clérigo.
     * Inicializa el personaje con los valores de la clase padre.
     */

    public Clerigo() {
        super();
    }

    /**
     * Constructor por parametros.
     *
     * @param nombre Nombre del personaje.
     * @param pv Puntos de vida.
     * @param atq Ataque.
     * @param arm Armadura.
     * @param nivel Nivel del personaje.
     * @param vel Velocidad.
     * @param res Resistencia.
     * @param fe Fe del Clérigo.
     */

    public Clerigo(String nombre, int pv, int atq, int arm, int nivel, int vel, int res, int fe) {
        super(nombre, pv, atq, arm, nivel, vel, res, fe);
    }

    /**
     * Aumenta el nivel del Clérigo y mejora sus atributos de forma aleatoria.
     * El Clérigo tiene mayor probabilidad de mejorar fe y resistencia.
     */

    public void subirNivel() {
        int c;
        Random a = new Random();
        c = a.nextInt(100);
        if (c < 20 && c > 0) {
            setPv(getPv() + 1);
        }
        c = a.nextInt(100);
        if (c <= 10 && c > 0) {
            setAtq(getAtq() + 1);
            ;
        }
        c = a.nextInt(100);
        if (c <= 20 && c > 0) {
            setArm(getArm() + 1);
        }
        c = a.nextInt(100);
        if ((c <= 80 && c > 0)) {
            setRes(getRes() + 2);
        }
        c = a.nextInt(100);
        if ((c <= 15 && c > 0)) {
            setVel(getVel() + 1);
        }
        c = a.nextInt(100);
        if ((c <= 80 && c > 0)) {
            setFe(getFe() + 2);
        }
        setNivel(getNivel() + 1);
    }

    /**
     * Permite al Clérigo realizar una plegaria.
     * Dependiendo de la elección puede:
     * 1. Sanar una gran cantidad de vida.
     * 2. Realizar una sanación menor.
     * 3. Usar una habilidad ofensiva basada en la fe.
     *
     * @param c2 Personaje objetivo de la plegaria.
     * @return int Devuelve 0, ya que no produce daño directo.
     */

    public int plegaria(Personaje c2) {
        int eleccion = 1;
        switch (eleccion) {
            case 1:
                System.out.println("Has elegido Sanacion");
                int cantidadSanacion = (int) (getFe() * 0.70);
                setPv(getPv() + cantidadSanacion);
                break;
            case 2:
                System.out.println("Has elegido Rezo Sagrado");
                int cantidadSanacion2 = (int) (getFe() * 0.30);
                setPv(getPv() + cantidadSanacion2);
                break;
            case 3:
                System.out.println("Has usado fogonazo sagrado");
                int dañodefe = (int) (getFe() * 0.55);

                break;
            default:
                return 0;
        }
        return 0;
    }

    /**
     * Permite al jugador realizar una acción durante su turno.
     * Muestra un menú por consola y ejecuta la acción seleccionada.
     *
     * @return Daño causado durante el turno
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
                System.out.println("El clerigo prepara su ataque especial");
                // No funcionaplegaria(Personaje c1)
                break;
            case "3":
                System.out.println("Has decidido defender");

                setRes((int) (getRes() / 0.80));

                setArm((int) ((getArm()) /0.80));

                daño = 0;
                daño = 0;
                break;
            case "4":
                System.out.println("Has decidido pasar el turno, tu personaje no hara ninguna accion");
                daño = 0;
                break;
            default:
                System.out.println("La opcion escogida no corresponde a las especificadas");
        }
        return daño;
    }
    /**
     * Devuelve una descripción del Clérigo junto con la información heredada.
     *
     * @return String con la descripción del personaje.
     */

    public String toString (){
        return super.toString() + "Es un Clerigo que usa su fe para hacer plegarias.\n" +
                "Entre ellas encontramos sanacion, rezo sagrado o fogonazo sagrado-";
    }


}

