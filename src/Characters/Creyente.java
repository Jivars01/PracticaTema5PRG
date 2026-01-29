package Characters;

import java.util.Scanner;

/**
 * Clase abstracta Creyente.
 * Representa un tipo de personaje que posee fe y puede realizar plegarias.
 * Hereda de la clase Personaje.
 */

public abstract class Creyente extends Personaje{
    private int fe;  /** * Cantidad de fe del personaje creyente */

    /**
     * Constructor por defecto.
     * Inicializa el personaje con los valores por defecto de Personaje
     * y establece la fe en 0.
     */

    public Creyente(){
        super();
        fe =0;
    }

    /**
     * Constructor con parametros.
     * Inicializa todos los atributos del personaje, incluidos los heredados
     * de Personaje y la fe, propia del Creyente.
     *
     * @param nombre nombre del personaje
     * @param pv puntos de vida
     * @param atq valor de ataque
     * @param arm valor de armadura
     * @param nivel nivel del personaje
     * @param vel velocidad
     * @param res resistencia
     * @param fe cantidad de fe
     */

    public Creyente (String nombre, int pv, int atq, int arm, int nivel, int vel, int res,int fe){
        super(nombre,pv, atq, arm, nivel,  vel, res);
        setFe(fe);
    }

    /**
     * Devuelve la cantidad de fe del creyente.
     * @return valor de fe
     */

    public int getFe() {
        return fe;
    }

    /**
     * Establece la cantidad de fe del creyente.
     * @param fe nueva cantidad de fe
     */

    public void setFe(int fe) {
        if(fe <= 0){
            this.fe = 0;
        } else
            this.fe = fe;
    }

    /**
     * Metodo abstracto que representa una plegaria.
     * Cada subclase deberá implementar su propio comportamiento.
     *
     * @param c2 personaje objetivo de la plegaria
     * @return valor entero que representa el efecto o daño de la plegaria
     */

    public abstract int plegaria (Personaje c2);

    /**
     * Devuelve una descripción del personaje.
     * @return cadena de texto con la información del personaje
     */

    public String toString() {
        return super.toString() + "Es un Creyente con la habilidad de efectuar milagros con su fe";
    }

    /**
     * Gestiona el turno del personaje creyente.
     * Permite al usuario elegir una acción:
     * atacar, defender o pasar turno.
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
                System.out.println("Un personaje creyente no tiene ataque especial");
                break;
            case "3":
                System.out.println("Has decidido defender");
                setRes((int) (getRes() * 1.20));

                setArm((int) ((getArm()) * 1.20));
                break;
            case "4":
                System.out.println("Has decidido pasar el turno tu personaje no hara ninguna accion");
                break;
            default:
                System.out.println("La opcion escogida no corresponde a las especificadas");
        }
        return daño;
    }

}
