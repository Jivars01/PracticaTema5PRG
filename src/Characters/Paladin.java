package Characters;

import java.util.Random;
import java.util.Scanner;

/**
 * Clase Paladin.
 * Representa un personaje de tipo Paladín que hereda de Creyente.
 * Utiliza la fe para potenciar sus habilidades ofensivas y defensivas.
 */

public class Paladin extends Creyente{

    /**
     * Constructor por defecto del Paladín.
     * Inicializa el objeto usando el constructor de la clase padre.
     */

    public Paladin(){
        super();
    }

    /**
     * Constructor parametrizado del Paladín.
     *
     * @param nombre Nombre del personaje.
     * @param pv Puntos de vida.
     * @param atq Ataque.
     * @param arm Armadura.
     * @param nivel Nivel del personaje.
     * @param vel Velocidad.
     * @param res Resistencia.
     * @param fe Fe del Paladín.
     */

    public Paladin(String nombre, int pv, int atq, int arm, int nivel, int vel, int res,int fe){
        super(nombre, pv, atq, arm, nivel, vel, res, fe);
    }

    /**
     * Permite al Paladín realizar una plegaria especial.
     * Dependiendo de la elección, puede:
     * 1. Aumentar el ataque en función de la fe.
     * 2. Incrementar la armadura.
     * 3. Reducir la velocidad y resistencia del enemigo.
     *
     * @param c2 Personaje objetivo de la plegaria.
     * @return int Devuelve 0 (no causa daño directo).
     */

    public int plegaria(Personaje c2) {
        int eleccion = 1;
        switch (eleccion){
            case 1:
                System.out.println("Has elegido imbuir tu arma de fe");
                setAtq((int) (getAtq() + (getFe() * 0.80)));
                break;
            case 2:
                System.out.println("Has elegido Baluarte de fe ");
                setArm((int)(getArm() * 1.3));
                break;
            case 3 :
                System.out.println("Has usado fogonazo sagrado");
                c2.setVel((int) (c2.getVel() * 0.40 ));
                c2.setRes((int) (c2.getRes() * 0.40 ));
                break;
            default:
                return 0;
        }
        return 0;
    }

    /**
     * Aumenta el nivel del Paladín y mejora sus atributos de forma aleatoria.
     * Cada estadística tiene una probabilidad distinta de aumentar.
     */

    public void subirNivel() {
        int c;
        Random a = new Random();
        c = a.nextInt(100);
        if (c < 50 && c > 0) {
            setPv(getPv() + (int)(getPv() * 0.05));
        }
        c = a.nextInt(100);
        if (c <= 60 && c > 0) {
            setAtq(getAtq()+1);;
        }
        c = a.nextInt(100);
        if (c <= 70 && c > 0) {
            setArm(getArm()+2);
        }
        c = a.nextInt(100);
        if ((c <= 40 && c > 0)) {
            setRes(getRes()+1);
        }
        c = a.nextInt(100);
        if ((c <= 15 && c > 0)) {
            setVel(getVel()+1);
        }
        c= a.nextInt(100);
        if ((c <= 30 && c > 0)){
            setFe(getFe()+1);
        }
        setNivel(getNivel()+1);
    }

    /**
     * Devuelve una descripción del Paladín junto con la información heredada.
     *
     * @return String con la descripción del personaje.
     */

    public String toString() {
        return super.toString() + "\n Es un valeroso Paladin que usa su fe para aumentar su fuerza, su defensa o para cegar al oponente";
    }

    /**
     * Gestiona el turno del Paladín.
     * Permite atacar, usar plegaria, defenderse o pasar el turno.
     *
     * @return int Daño causado durante el turno (0 si no hay ataque).
     */

    public int realizaTurno(Personaje c2) {
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
                defender(ataque(), "Fisico");
                break;
            case "2":
                System.out.println("El paladin se dispone a usar su plegaria");
                plegaria(c2);
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

}
