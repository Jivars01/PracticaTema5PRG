package Characters;

import java.util.Random;
import java.util.Scanner;

import GameMap.Trampa;

/**
 * Esta clase personaje sirve para poder crear a un personaje que tiene varias estadisticas
 * de numeros enteros que son vida, ataque , armadura (daño fisico), nivel , resistencia magica
 * (daño magico), velocidad y un string con el nombre
 *
 * @author Jesús Ivars
 * Version 2.0
 */

public class Personaje {
    private String nombre;
    private int pv;
    private int atq;
    private int arm;
    private int nivel;
    private int res;
    private int vel;

    /**
     * Constructor por defecto que establece el valor de nombre con cadena vacia, la vida con 100
     * y el resto de estadisticas a 10 menos el nivel que se establece a 1
     */

    public Personaje() {
        nombre = "";
        pv = 100;
        atq = 10;
        arm = 10;
        nivel = 1;
        res = 10;
        vel = 10;
    }

    /**
     * Constructor por parametros que establece el valor que recibe y pasa por los setters para asegurar
     * que cumple con lo establecido
     *
     * @param nombre String con el nombre del personaje
     * @param pv     Int para la vida
     * @param atq    Int para el ataque
     * @param arm    Int para la armadura
     * @param nivel  Int para el nivel
     * @param vel    Int para la velocidad
     * @param res    Int para la resistencia magica
     */


    public Personaje(String nombre, int pv, int atq, int arm, int nivel, int vel, int res) {
        setNombre(nombre);
        setPv(pv);
        setAtq(atq);
        setArm(arm);
        setNivel(nivel);
        setRes(res);
        setVel(vel);
    }

    /**
     * Constructor de copia que copia los atributos
     *
     * @param copia de Personaje que copia todos los atributos dihos anteriormente
     */

    public Personaje(Personaje copia) {
        this.nombre = copia.nombre;
        this.pv = copia.pv;
        this.atq = copia.atq;
        this.arm = copia.arm;
        this.nivel = copia.nivel;
        this.vel = copia.vel;
        this.res = copia.res;
    }

    /**
     * Sobrecarga de constructor que recibe el nombre por parametro y establece los atributos
     * entre el 1 y el 32 y establece el nivel a 1
     *
     * @param name String que establece el nombre por parametro
     */

    public Personaje(String name) { //Ejercicio 4.1
        setNombre(name);
        setNivel(1);
        Random r = new Random();
        pv = (r.nextInt(1, 33));
        atq = (r.nextInt(r.nextInt(1, 33)));
        arm = (r.nextInt(1, 33));
        vel = r.nextInt(1, 33);
        res = r.nextInt(1, 33);
    }

    /**
     * Sobrecarga de constructor que recibe un string para el nombre y un int
     * para el nivel, usando el metodo subir nivel para subir una estadistica aleatoria
     *
     * @param nomm  String para el nombre
     * @param level Int para el nivel
     */

    public Personaje(String nomm, int level) { //Ejercicio4.2
        setNombre(nomm);
        setNivel(1);
        Random r = new Random();
        pv = (r.nextInt(1, 33));
        atq = (r.nextInt(r.nextInt(1, 33)));
        arm = (r.nextInt(1, 33));
        res = (r.nextInt(1, 33));
        vel = (r.nextInt(1, 33));
        subirNivel();
        for (int i = 1; i < level; i++) {
            subirNivel();
        }
    }

    /**
     * Getter de nombre que devuelve el nombre
     *
     * @return devuelve el nombre
     */

    public String getNombre() {
        return nombre;
    }

    /**
     * Setter de nobre que establece que el nombre del personaje no pueda estar en vacio,
     * No puede tener menos de dos digitos y no puede contener el caracter GM
     *
     * @param n String que recibe por parametro el nombre
     */

    public void setNombre(String n) {
        if (n.equals("")) {
            System.err.println("Error. El nombre debe tener caracteres válidos.");
            nombre = "";
        } else if (n.contains("GM")) {
            System.err.println("Error. El nombre no puede contener GM");
            nombre = "";
        } else if (n.length() < 2) {
            System.err.println("Error. El nombre debe tener mas de dos caracteres");
            nombre = "";
        } else nombre = n;
    }

    /**
     * Getter de vida que devuelve la vida
     *
     * @return devuelve la vida
     */


    public int getPv() {
        return pv;
    }

    /**
     * Setter de vida que establece que la vida no puede ser menor a 1 y debe de cumplir con el metodo
     * checkAtributossino se establece a  1 directamente
     *
     * @param vida representa la vida del personaje que se recibe por parametros
     */

    public void setPv(int vida) {
        if (vida < 1 && checkAtributos(vida, "pv")) {
            System.out.println("Perfecto, la vida se econtrara en  uno");
            vida = 1;
            pv = vida;
        } else pv = vida;
    }

    /**
     * Getter de ataque que devuelve el ataque
     *
     * @return devuelve el ataque
     */

    public int getAtq() {
        return atq;
    }

    /**
     * Setter de ataque para limitar que sea mayor a 1 y la suma
     * de sus estadisticas no sean mayor a 100, sino se establece
     * el ataque a 1
     *
     * @param ataque donde se coloca el ataque deseado
     */

    public void setAtq(int ataque) {
        if (ataque < 1 && checkAtributos(ataque, "atq")) {
            System.out.println("Perfecto, el ataque se econtrara en  uno");
            atq = 1;
            atq = ataque;
        } else atq = ataque;
    }

    /**
     * Getter de armadura que devuelve la armadura
     *
     * @return devuelve la armadura
     */

    public int getArm() {
        return arm;
    }


    public void setArm(int defensa) {
        if (defensa < 1 && checkAtributos(defensa, "def")) {
            System.out.println("Perfecto, la defensa se econtrara en  uno");
            arm = 1;
            arm = defensa;
        } else arm = defensa;
    }

    public int getNivel() {
        return nivel;
    }

    /**
     * Metodo checkAtributos para limitar que la suma del atq, def y pv
     * no sean superiores a 100 y cumpla con lo establecido
     *
     * @return devuelve True si la suma supera el 100 y si no se devuelve false
     */

    public boolean checkAtributos(int nuevoValor, String atributo) {
        boolean res = false;
        switch (atributo) {
            case "pv":
                if ((nuevoValor + arm + atq) > 100)
                    res = true;
                break;
            case "atq":
                if ((pv + nuevoValor + arm) > 100)
                    res = true;
                break;
            case "def":
                if ((pv + atq + nuevoValor) > 100)
                    res = true;
                break;
        }
        return res;
    }

    /**
     * Setter del nivel que limita que sea mayor a 1 y menor a 100
     *
     * @param level donde se coloca el nivel deseado
     */

    public void setNivel(int level) {
        if (level < 1 || level > 100) {
            System.err.println("Lo siento, no puedo poner un valor menor a 1.");
        } else {
            nivel = level;
        }
    }

    /**
     * Getter de resistencia magica que devuelve su valor
     *
     * @return el valor de la resistencia magica
     */

    public int getRes() {
        return res;
    }

    /**
     * Setter de resistencia que establece que la resistencia noi puede ser <= a 0
     *
     * @param res Int que se recibe por parametros representa la resistencia magica
     */

    public void setRes(int res) {
        if (res <= 0) {
            this.res = 0;
        }
    }

    /**
     * Getter de velocidad que devuelve la velocidad del personaje
     *
     * @return Valor de la velocidad (INT)
     */

    public int getVel() {
        return vel;
    }

    /**
     * Setter de velocidad que establece que la velocidad no puede ser <=0
     *
     * @param vel Recibe un entero de la velocidad del personaje
     */

    public void setVel(int vel) {
        if (vel <= 0) {
            this.vel = 0;
        }
    }

    /**
     * Metodo beberpocion que permite devolver vida al personaje si su vida es menor o igual a 30
     *
     * @param pocion Entero que recibe un numero que se usara para devolver la vida al personaje
     */

    public void beberPocion(int pocion) {
        if (pv <= 30) {
            pv += pocion;
        }
    }

    /**
     * Metodo inspirar que se encarga de recuperar ataque o defensa (segun se indica) cada vez
     * que la trampa falle y este aumente alguna de las dos estadisticas
     *
     * @param cantidad Establece la cantidad de ataque/defensa que recupera
     * @param tipo     Indica el tipo de atributo que recupera/aumenta
     */

    public void inspirar(int cantidad, String tipo) {
        switch (tipo) {
            case ("Ataque"):
                atq += cantidad;
                break;
            case ("Defensa"):
                arm += cantidad;
                break;
        }
    }

    /**
     * Metodo subirNivel que se encarga de subir estadisticas con un 50% de posibilidad por cada atributo
     * cada vez que el personaje suba de nivel.
     */
    public void subirNivel() {
        int c;
        Random a = new Random();
        c = a.nextInt(100);
        if (c < 50 && c > 0) {
            pv++;
        }
        c = a.nextInt(100);
        if (c <= 50 && c > 0) {
            atq++;
        }
        c = a.nextInt(100);
        if (c <= 50 && c > 0) {
            arm++;
        }
        c = a.nextInt(100);
        if ((c <= 50 && c > 0)) {
            res++;
        }
        c = a.nextInt(100);
        if ((c <= 50 && c > 0)) {
            vel++;
        }
        nivel++;
    }

    /**
     * Metodo estarMuerto que se encarga de asegurar si el personaje esta a una vida menor o igual a 0
     *
     * @return True si su vida es menor o igual a 0 o false si la vida es mayor a 0
     */

    public boolean estarMuerto() {
        boolean muerto;
        if (pv <= 0) {
            muerto = true;
        } else {
            muerto = false;
        }
        return muerto;
    }

    /**
     * Metodo caerTrampa que se encarga de colocar el daño que realiza la trampa sobre el personaje cuando
     * la trampa se activa, se usa un switch para establecer un mensaje distinto segun la trampa activada
     *
     * @param t Objeto Trampa que establece los valores de dicha clase
     */

    public void caerTrampa(Trampa t) {
        String tipo = "";
        t.activatrampa();
        switch (tipo) {
            case "Pinchos":
                System.out.println("Estacas afiladas salen de las superficies cercanas y atraviesan a" + getNombre() + "por " + t.getPerjuicio() + " puntos de daño");
                int nuevavida;
                nuevavida = getPv() - t.getPerjuicio();
                setPv(nuevavida);
                break;
            case "Brea":
                System.out.println("Aceite viscoso cae de pronto sobre " + getNombre() + ", impidiéndole moverse con libertad. La defensa del personaje ha bajado");
                int nuevadefensa;
                nuevadefensa = getArm() - t.getPerjuicio();
                setArm(nuevadefensa);
                break;
            case "Serpientes":
                System.out.println("Un nido de víboras y culebras aparece frente a " + getNombre() + "La visión es tan terrorífica que pierde las ganas de continuar. Se reduce" + t.getPerjuicio() + " puntos el atq del Characters.Personaje.");
                int nuevoatq;
                nuevoatq = getAtq() - t.getPerjuicio();
                setAtq(nuevoatq);
            default:
                System.out.println("Afortunadamente" + getNombre() + "escapó indemne");
        }
    }

    public String toString() {
        String resultado = "El personaje " + getNombre() + " con las estadisticas: " + getAtq() + " de ataque, " + getArm() + " de defensa, " + getPv() + " de vida,  \n"
                + getRes() + "de resistencia magica, " + getVel() + "de velocidad " + "de nivel " + getNivel() + " esta creado.";
        return resultado;
    }

    public Personaje clone() {
        Personaje clon = new Personaje(this.nombre, this.atq, this.arm, this.pv, this.nivel, this.vel, this.res);
        return clon;
    }

    public boolean equals(Personaje otro) {
        boolean res = true;
        if (!this.nombre.equals((otro.nombre)))
            res = false;

        if (this.atq != otro.atq)
            res = false;

        if ((this.arm != otro.arm))
            res = false;

        if (this.pv != otro.pv)
            res = false;

        if (this.nivel != otro.nivel)
            res = false;

        return res;
    }
//Ataque esta bien implementada _Jesus
    public int ataque() {
        return getAtq();
    }
    //Si mantienes esta implementación defender debería devolver void
    public void defender(int daño, String tipo) {
        //this.pv = (daño - arm)
        switch (tipo) {
            case "Fisico":
                //Si el daño - la armadura será menor que 0
                if (daño - arm <= 0) {
                    daño = 0;
                }
                this.pv = daño - arm;
                break;
            case "Magico":
                //Aquí igual pero con la RM
                if (daño-res <= 0) {
                    daño = 0;
                }
                this.pv = daño - res;
                break;

            default:
                daño = 0;
        }
    }

    //RealizarTurno debería devolver la cantidad de daño a realizar -> atacar es el ataque estándar, la accion especial depende de la subclase y defender y pasar turno devuelven 0
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
                System.out.println("Un personaje generico no tiene ataque especial");
                break;
            case "3":
                System.out.println("Has decidido defender");
                res += (res*0.20);
                arm *= (arm*0.20);
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