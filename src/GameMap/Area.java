package GameMap;


import Characters.Personaje;

import java.security.PublicKey;
import java.util.Random;

/**
 * Clase Area basada en un area para un nivel que contiene un String nombre,un string bioma,
 * un int dificultad y un objeto Trampa de la clase trampa.
 *
 * @author Jesús Ivars
 * @version 2.0
 * @see Trampa se referencia y se usa la clase trampa
 */


public class Area {
    private String nombre;
    private String bioma;
    private int dificultad;
    private Trampa trampa;

    /**
     * Constructor por defecto que estable el sting nombre con tres interrogaciones
     * el bioma se estbalece como pradera por defecto y la dificultad a 1 ademas
     * de establecer una trampa de la clase trampa
     * @see Trampa que se usa para crear trampa
     */
    public Area() {
        nombre = "???";
        bioma = "Pradera";
        dificultad = 1;
        trampa = new Trampa();
    }

    /**
     * Constructor por parametros que establece los valores que recibe y pasa por sus
     * respectivos setters para onfirmar que cumple con la condicion
     * @param nombre String para el nombre
     * @param bioma String para el bioma
     * @param dificultad int para la dificultad
     * @param trampa Trampa para establecert la trampa
     */

    public Area(String nombre, String bioma, int dificultad, Trampa trampa) {
        setNombre(nombre);
        setBioma(bioma);
        this.dificultad = dificultad;
        setTrampa(trampa);
    }

    /**
     * Constructor que recibe por parametros el nombre y el bioma que establece el nivel
     * automaticamente segun el bioma escogido entre los niveles que pueden ser los biomas
     * @param name String para el nombre del nivel
     * @param bio String para el nombre del bioma
     */

    public Area(String name, String bio) {
        setNombre(name);
        setBioma(bio);
        Random r = new Random();
        switch (bio) {
            case "Pradera":
                asignarNivel(r.nextInt(0, 11));
                break;
            case "Jungla":
                asignarNivel(r.nextInt(10, 31));
                break;
            case "Desiero":
                asignarNivel(r.nextInt(30, 61));
                break;
            case "Montaña":
                asignarNivel(r.nextInt(60, 91));
                break;
            case "Mazmorra":
                asignarNivel(r.nextInt(90, 105));
                break;
        }
    }

    /**
     * Constructor de copia
     * @param copia
     */


    public Area(Area copia) {
        this.nombre = copia.nombre;
        this.bioma = copia.bioma;
        this.dificultad = copia.dificultad;
        this.trampa = copia.trampa;
    }

    /**
     * Getter de nombre que devuelve el nombre
     * @return
     */

    public String getNombre() {
        return nombre;
    }

    /**
     * Getter de bioma
     * @return
     */

    public String getBioma() {
        return bioma;
    }

    /**
     * Getter de dificultad
     * @return
     */

    public int getDificultad() {
        return dificultad;
    }

    /**
     * setter de trampa
     * @param trampa
     */

    public void setTrampa(Trampa trampa) {
        this.trampa = new Trampa(trampa);
    }

    /**
     * Setter de nombre que limita a que el nombre no puede estar vacio,
     * ni contener espacios en el nombre y se debera cambiar por guiones
     * aunque se puede cambiar y establecer que los espacios se cambien por _
     * @param n2 coloca el string del nombre deseado
     */

    public void setNombre(String n2) {
        if (n2.equals("")) {
            System.err.println("Error. El nombre debe tener caracteres válidos.");
        } else if (n2.contains("")) {
            System.err.println("Lo siento, su nombre no puede contener espacios, sustituyalos por _");
        } else {
            nombre = n2;
        }
    }

    /**
     * Setter de bioma que limita a que el bioma solo pueda ser "Pradera", "Jungla",
     * "Desierto", "Montaña", "Mazmorra" y sino se establece por defecto un mensaje de error
     *
     * @param bio
     */

    public void setBioma(String bio) {
        switch (bio) {
            case "Pradera", "Jungla", "Desierto", "Montaña", "Mazmorra":
                System.out.println("Perfeco, usted ha seleccionado el bioma " + bioma);
                bioma = bio;
                break;
            default:
                System.out.println("Lo siento, pero el bioma no concluye con los especificado, compruebe las mayusculas");
        }
    }

    /**
     * Metodo  asignarNivel que se encarga de asignar un nivel limitando la dificultad
     * dependiendo del bioma escogido y que si se pasa del nivel posible saldra un mesaje de error.
     * Usamos un switch para las distintas categorias de Bioma
     * @param dif referencia un entero que coloca la dificultad deseada
     */

    public void asignarNivel(int dif) {
        switch (bioma) {
            case "Pradera":
                if (dif > 10) {
                    System.err.println("La dificultad escogida no coincide con el nivel");
                } else {
                    dificultad = dif;
                }
                break;
            case "Jungla":
                if (dif < 10 || dif > 30) {
                    System.err.println("La dificultad escogida no coincide con el nivel");
                } else {
                    dificultad = dif;
                }
                break;
            case "Desierto":
                if (dif < 30 || dif > 60) {
                    System.err.println("La dificultad escogida no coincide con el nivel");
                } else {
                    dificultad = dif;
                }
            case "Montaña":
                if (dif < 60 || dif > 90) {
                    System.err.println("La dificultad escogida no coincide con el nivel");
                } else {
                    dificultad = dif;
                }
            case "Mazmorra":
                if (dif < 90 || dif > 105) {
                    System.err.println("La dificultad escogida no coincide con el nivel");
                } else {
                    dificultad = dif;
                }
        }
    }

    /**
     * Metodo generar pocion que sirve para curar la vida pero depende del bioma
     * escogido ya que cada bioma tiene distinto comportamienbto
     *
     * @param cura indica la vida que se quiere recuperar
     * @return devuelve la cantidad de vida que se va a recuperar
     */

    public int generarPocion(int cura) {
        if (bioma.equals("Pradera")) {
            cura = 15;
        } else if (bioma.equals("Jungla")) {
            Random a = new Random();
            cura = a.nextInt(15, 25 + 1);

        } else if (bioma.equals("Desierto")) {
            int c;
            Random a = new Random();
            cura = a.nextInt(1, 30 + 1);
        } else if (bioma.equals("Montaña")) {
            cura = 30;
        } else if (bioma.equals("Mazmorra")) {
            Random a = new Random();
            int c;
            c = a.nextInt(100);
            if (c < 20 && c > 0) {
                cura = -10;
            } else cura = +20;
        } else System.out.println("El nivel concuerda con el bioma");
        return cura;
    }

    /**
     * Metodo generarTrampa para que la trampa se establezca segun el bioma escogido
     * variando su daño o probabilidad que suceda en x biomas especificos.
     * Este recibe por prametro la categoria y el perjuicio ademas que establece el
     * Fracaso pero al ser por azar no depende de parametros
     * @param t String que indica la categoria escogida
     * @param p int que indica el perjuicio escogido
     * @return Devuelve la trampa establecida
     */

    public static Trampa generarTrampa(String t, int p) {
        Trampa trampa = new Trampa();
        trampa.setCategoria(t);
        trampa.setFracaso();
        trampa.setPerjuicio(p);
        return trampa;
    }

    public Area clone() {
        Area clon = new Area(this.nombre, this.bioma, this.dificultad, this.trampa);
        return clon;
    }

    /**
     * Metodo equals que se encarga de asegurar si el objeto que recibe por parametros es igual a
     * el areas establecida
     * @param otro Objeto de la clase Area que asegura si es igual al area creada
     * @return True si son todos iguales o flase si falla alguna coincidencia
     */
    public boolean equals(Area otro) {
        boolean res = true;
        if (!this.nombre.equals((otro.nombre)))
            res = false;

        if (!this.bioma.equals((otro.bioma)))
            res = false;

        if ((this.dificultad != otro.dificultad))
            res = false;
        if (!this.trampa.equals(otro.trampa))
            res = false;

        return res;
    }

    /**
     * Metodo toString que indica el estado en el que se encuentra la clase Area
     * @return Devuelve el estado del Area
     */

    public String toString() {
        String resultado = "El area" + getNombre() + " con un bioma de " + getNombre() + "  con una dificultad de "
                + getDificultad() + "esta preparada para usarse";
        return resultado;
    }
}
