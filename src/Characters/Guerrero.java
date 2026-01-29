package Characters;

import java.util.Random;
import java.util.Scanner;

/**
 * La clase Guerrero representa un tipo de personaje que puede entrar en estado de furia.
 * Cuando el guerrero está en furia, su ataque se duplica, pero también recibe el doble de daño.
 * @link Personaje Esta clase hereda de Personaje y redefine algunos de sus comportamientos.
 *
 * @author Jivars
 */

public class Guerrero extends Personaje {

    private boolean furia; /** Indica si el guerrero se encuentra en estado de furia*/

    /**
     * Constructor por defecto.
     * Inicializa el guerrero con los valores por defecto del personaje
     * y con la furia desactivada.
     */

    public Guerrero() {
        super();
        furia = false;
    }

    /**
     * Constructor con parámetros.
     *
     * @param nombre Nombre del guerrero
     * @param pv Puntos de vida
     * @param atq Ataque base
     * @param arm Armadura
     * @param nivel Nivel del personaje
     * @param vel Velocidad
     * @param res Resistencia Magica
     * @param furia Estado inicial de la furia
     */

    public Guerrero(String nombre, int pv, int atq, int arm, int nivel, int vel, int res, boolean furia) {
        super(nombre, pv, atq, arm, nivel, vel, res);
        setFuria(furia);
    }
    /**
     * Aumenta el nivel del guerrero y mejora sus estadísticas
     * de forma aleatoria según diferentes probabilidades.
     */

    @Override
    public void subirNivel() {
        int c;
        Random a = new Random();
        c = a.nextInt(100);
        if (c < 75 && c > 0) {
            setPv(getPv() + 1);
        }
        c = a.nextInt(100);
        if (c <= 80 && c > 0) {
            setAtq(getAtq() + 2);
        }
        c = a.nextInt(100);
        if (c <= 75 && c > 0) {
            setArm(getArm() + 1);
        }
        c = a.nextInt(100);
        if ((c <= 20 && c > 0)) {
            setRes(getRes() + 1);
        }
        c = a.nextInt(100);
        if ((c <= 50 && c > 0)) {
            setVel(getVel() + 1);
        }
        setNivel(getNivel() + 1);
    }

    /**
     * Devuelve el estado actual de la furia.
     *
     * @return true si el guerrero está en furia, false en caso contrario
     */

    public boolean isFuria() {
        return furia;
    }

    /**
     * Establece el estado de la furia.
     *
     * @param furia Nuevo estado de la furia
     */

    public void setFuria(boolean furia) {
        this.furia = furia;
    }

    /**
     * Cambia el estado de la furia.
     * Si estaba activa, la desactiva, y viceversa.
     *
     * @return El nuevo estado de la furia
     */

    public boolean modificaFuria() {
        if (furia = true) {
            furia = false;
        } else furia = true;
        return furia;
    }

    /**
     * Realiza un ataque.
     * Si el guerrero está en furia, el daño se duplica.
     *
     * @return Daño total infligido
     */

    public int ataque() {
        if (furia = true)
            return super.ataque() * 2;
        else return super.ataque();
    }

    /**
     * Defiende al guerrero frente a un ataque.
     * Si está en furia, recibe el doble de daño.
     *
     * @param defefisico Daño físico recibido
     * @param tipo Tipo de daño que recibe (magico o fisico)
     */

    public void defender(int defefisico, String tipo) {
        if (furia == true)
            super.defender(defefisico * 2, tipo);
        else super.defender(defefisico, tipo);
    }

    /**
     * Devuelve una descripción textual del guerrero.
     *
     * @return Cadena con la información del guerrero
     */

    @Override
    public String toString() {
        return super.toString() + "\nEs un Guerrero con la posiblidad de entrar en furia y duplicar su daño. " +
                "\n Sin embargo este recibe el doble de daño durante dicho estado";
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
                defender(ataque(), "Fisico");
                break;
            case "2":
                if (furia = false) {
                    System.out.println("El guerrero se enfada y activa su furia");
                    modificaFuria();
                } else System.out.println("El guerrero se relaja y desactiva su furia");
                modificaFuria();
                break;

            case "3":
                System.out.println("Has decidido defender");

                setRes((int) (getRes() / 0.80));

                setArm((int) ((getArm()) /0.80));

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
