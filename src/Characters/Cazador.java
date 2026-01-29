package Characters;

import java.util.Random;
import java.util.Scanner;

/**
 * Clase Cazador.
 * Representa un tipo de personaje que puede tener una mascota
 * que le ayuda en combate y evoluciona junto a él.
 */

public class Cazador extends Personaje {

    private Mascota mascota; /** Mascota asociada al cazador */

    /**
     * Constructor por defecto.
     */

    public Cazador() {
        super();
    }

    /**
     * Constructor por parametros.
     *
     * @param nombre Nombre del cazador
     * @param pv     Puntos de vida
     * @param atq    Ataque
     * @param arm    Armadura
     * @param nivel  Nivel del personaje
     * @param vel    Velocidad
     * @param res    Resistencia
     */

    public Cazador(String nombre, int pv, int atq, int arm, int nivel, int vel, int res) {
        super(nombre, pv, atq, arm, nivel, vel, res);
    }

    /**
     * Calcula el ataque total del cazador sumando
     * su ataque base y el de su mascota.
     *
     * @return daño total de ataque
     */

    public int ataque() {
        return (getAtq() + mascota.getAtq());
    }

    /**
     * Devuelve una descripción del cazador.
     *
     * @return información del cazador
     */

    public String toString() {
        return super.toString() + "Es un Cazador con la habilidad de tener una mascota.";
    }

    /**
     * Incrementa el nivel del cazador.
     * Las estadísticas suben de forma aleatoria según probabilidades.
     * Además, la mascota también sube de nivel.
     */

    public void subirNivel() {
        int c;
        Random a = new Random();
        c = a.nextInt(100);
        if (c < 75 && c > 0) {
            setPv(getPv() + 1);
        }
        c = a.nextInt(100);
        if (c <= 50 && c > 0) {
            setAtq(getAtq() + 2);
        }
        c = a.nextInt(100);
        if (c <= 50 && c > 0) {
            setArm(getArm() + 1);
        }
        c = a.nextInt(100);
        if ((c <= 50 && c > 0)) {
            setRes(getRes() + 1);
        }
        c = a.nextInt(100);
        if ((c <= 50 && c > 0)) {
            setVel(getVel() + 1);
        }
        setNivel(getNivel() + 1);
        mascota.subirNivel();
    }

    /**
     * Clase Mascota.
     * Representa una mascota que acompaña al Cazador.
     * Hereda de Personaje y sus estadísticas dependen de la raza y del cazador.
     */

    public class Mascota extends Personaje {

        private String Raza; /** * Raza de la mascota */
        private String nombresMascota; /** Nombre de la mascota */

        /**
         * Constructor por defecto.
         */

        public Mascota() {
            Raza = nombresMascota = "";
        }


        /**
         * Constructor por parametros.
         *
         * @param rareza Raza de la mascota
         * @param nombre Nombre de la mascota
         */

        public Mascota(String rareza, String nombre) {
            setNombresMascota(nombre);
            setRaza(rareza);
        }

        /**
         * Devuelve la información de la mascota.
         *
         * @return descripción de la mascota
         */

        public String toString() {
            return super.toString() + "\nEs una mascota cuya raza es " + getRaza() + " de nombre " + getNombresMascota();
        }

        /**
         * Asigna estadísticas a la mascota según su raza,
         * basándose en un porcentaje de las estadísticas del cazador.
         *
         * @param raza Raza de la mascota
         * @return raza seleccionada
         */

        public String seleccionarRareza(String raza) {
            if (raza.equals("Canido")) {

                setPv((int) (Cazador.this.getPv() * 0.20));
                setRes((int) (Cazador.this.getRes() * 0.20));
                setVel((int) (Cazador.this.getVel() * 0.20));
                setAtq((int) (Cazador.this.getAtq() * 0.20));
                setArm((int) (Cazador.this.getArm() * 0.20));

            } else if (raza.equals("Rapaz")) {

                setPv((int) (Cazador.this.getPv() * 0.15));
                setRes((int) (Cazador.this.getRes() * 0.15));
                setVel((int) (Cazador.this.getVel() * 0.30));
                setAtq((int) (Cazador.this.getAtq() * 0.30));
                setArm((int) (Cazador.this.getArm() * 0.15));

            } else if (raza.equals("Felino")) {

                setPv((int) (Cazador.this.getPv() * 0.05));
                setRes((int) (Cazador.this.getRes() * 0.25));
                setVel((int) (Cazador.this.getVel() * 0.35));
                setAtq((int) (Cazador.this.getAtq() * 0.15));
                setArm((int) (Cazador.this.getArm() * 0.05));
            }
            return raza;
        }

        /**
         * Sube de nivel la mascota.
         * Dependiendo de la raza, mejora estadísticas del cazador.
         */

        public void subirNivel() {
            int c;
            Random a = new Random();
            switch (Raza) {
                case "Canido":

                    Cazador.this.setPv((int) (Cazador.this.getPv() * 0.20));
                    Cazador.this.setAtq((int) (Cazador.this.getAtq() * 0.20));
                    Cazador.this.setArm((int) (Cazador.this.getArm() * 0.20));
                    Cazador.this.setRes((int) (Cazador.this.getRes() * 0.20));
                    Cazador.this.setVel((int) (Cazador.this.getVel() * 0.20));
                    setNivel(getNivel() + 1);

                    break;

                case "Felino":

                    Cazador.this.setPv((int) (Cazador.this.getPv() * 0.15));
                    Cazador.this.setAtq((int) (Cazador.this.getAtq() * 0.30));
                    Cazador.this.setArm((int) (Cazador.this.getArm() * 0.15));
                    Cazador.this.setRes((int) (Cazador.this.getRes() * 0.15));
                    Cazador.this.setVel((int) (Cazador.this.getVel() * 0.30));
                    setNivel(getNivel() + 1);
                    break;

                case "Rapaz":

                    Cazador.this.setPv((int) (Cazador.this.getPv() * 0.05));
                    Cazador.this.setAtq((int) (Cazador.this.getAtq() * 0.15));
                    Cazador.this.setArm((int) (Cazador.this.getArm() * 0.05));
                    Cazador.this.setRes((int) (Cazador.this.getRes() * 0.25));
                    Cazador.this.setVel((int) (Cazador.this.getVel() * 0.35));
                    setNivel(getNivel() + 1);

            }
        }

        /**
         * @return raza de la mascota
         */
        public String getRaza() {
            return Raza;
        }

        /**
         * Setter de raza
         *
         * @return raza de la mascota si coincide con lo pedido
         * o Godofredo en caso de lo que no ponga el nombre adecuadamente
         */

        public void setRaza(String raza) {
            if (raza.equals("Canido") || raza.equals("Rapaz") || raza.equals("Felino"))
                this.Raza = raza;
            else
                Raza = raza;
        }

        /**
         * Devuelve el nombre de la mascota.
         *
         * @return String con el nombre actual de la mascota.
         */

        public String getNombresMascota() {
            return nombresMascota;
        }

        /**
         * Establece el nombre de la mascota.
         * Si el nombre recibido está vacío, se asigna un nombre por defecto ("Godofredo").
         *
         * @param nombresMascota Nombre que se desea asignar a la mascota.
         */

        public void setNombresMascota(String nombresMascota) {
            if (!nombresMascota.isEmpty())
                this.nombresMascota = nombresMascota;
            else this.nombresMascota = "Godofredo";
        }
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
                System.out.println("El cazador no tiene una habilidad especial");
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
