package Characters;

import java.util.Objects;
import java.util.Random;

import GameMap.Trampa;

public class Personaje {
    private String nombre;
    private int pv;
    private int atq;
    private int def;
    private int nivel;

    public Personaje() {
        nombre = "";
        pv = 0;
        atq = 0;
        def = 0;
        nivel = 0;
    }


    public Personaje(String nombre, int pv, int atq, int def, int nivel) {
        setNombre(nombre);
        setPv(pv);
        setAtq(atq);
        setDef(def);
        setNivel(nivel);
    }

    public Personaje(Personaje copia) {
        this.nombre = copia.nombre;
        this.pv = copia.pv;
        this.atq = copia.atq;
        this.def = copia.def;
        this.nivel = copia.nivel;
    }

    public Personaje(String name) { //Ejercicio 4.1
        setNombre(name);
        setNivel(1);
        Random r = new Random();
        pv = (r.nextInt(1, 33));
        atq = (r.nextInt(r.nextInt(1, 33)));
        def = (r.nextInt(1, 33));

    }

    public Personaje(String nomm, int level) { //Ejercicio4.2
        setNombre(nomm);
        setNivel(1);
        Random r = new Random();
        pv = (r.nextInt(1, 33));
        atq = (r.nextInt(r.nextInt(1, 33)));
        def = (r.nextInt(1, 33));
        subirNivel();
        for (int i = 1; i < level; i++) {
            subirNivel();
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String n) {
        if (n.equals("")) {
            System.err.println("Error. El nombre debe tener caracteres válidos.");
        } else if (n.contains("GM")) { //contains
            System.err.println("Error. El nombre no puede contener GM");
        } else if (n.length() < 2) {
            System.err.println("Error. El nombre debe tener mas de dos caracteres");
        } else nombre = n;
    }

    public int getPv() {
        return pv;
    }

    public void setPv(int vida) {
        if (vida < 1 && checkAtributos(vida, "pv")) {
            System.out.println("Perfecto, la vida se econtrara en  uno");
            vida = 1;
            pv = vida;
        } else pv = vida;
    }

    public int getAtq() {
        return atq;
    }

    public void setAtq(int ataque) {
        if (ataque < 1 && checkAtributos(ataque, "atq")) {
            System.out.println("Perfecto, el ataque se econtrara en  uno");
            atq = 1;
            atq = ataque;
        } else atq = ataque;
    }

    public int getDef() {
        return def;
    }

    public void setDef(int defensa) {
        if (defensa < 1 && checkAtributos(defensa, "def")) {
            System.out.println("Perfecto, la defensa se econtrara en  uno");
            def = 1;
            def = defensa;
        } else def = defensa;
    }

    public int getNivel() {
        return nivel;
    }

    public boolean checkAtributos(int nuevoValor, String atributo) {
        boolean res = false;
        switch (atributo) {
            case "pv":
                if ((nuevoValor + def + atq) > 100)
                    res = true;
                break;
            case "atq":
                if ((pv + nuevoValor + def) > 100)
                    res = true;
                break;
            case "def":
                if ((pv + atq + nuevoValor) > 100)
                    res = true;
                break;
        }
        return res;
    }

    public void setNivel(int level) {
        if (level < 1 || level > 100) {
            System.err.println("Lo siento, no puedo poner un valor menor a 1.");
        } else {
            nivel = level;
        }
    }

    public void beberPocion(int pocion) {
        if (pv <= 30) {
            pv += pocion;
        }
    }

    public void inspirar(int cantidad, String tipo) {
        switch (tipo) {
            case ("Ataque"):
                atq += cantidad;
                break;
            case ("Defensa"):
                def += cantidad;
                break;
        }
    }

    public void subirNivel() {
        int c;
        Random a = new Random();
        c = a.nextInt(100);
        if (c < 33 && c > 0) {
            pv++;
        } else if (c <= 66 && c > 33) {
            atq++;
        } else {
            def++;
        }
        nivel++;
    }

    public boolean estarMuerto() {
        boolean muerto;
        if (pv <= 0) {
            muerto = true;
        } else {
            muerto = false;
        }
        return muerto;
    }

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
                nuevadefensa = getDef() - t.getPerjuicio();
                setDef(nuevadefensa);
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
        String resultado = "El personaje " + getNombre() + " con las estadisticas de " + getAtq() + " de ataque, " + getDef() + " de defensa, " + getPv() + " de vida, "
                + "con el nivel " + getNivel() + " esta creado.";
        return resultado;
    }

    public Personaje clone() {
        Personaje clon = new Personaje(this.nombre, this.atq, this.def, this.pv, this.nivel);
        return clon;
    }

    public boolean equals(Personaje otro) {
        boolean res = true;
        if (!this.nombre.equals((otro.nombre)))
            res = false;

        if (this.atq != otro.atq)
            res = false;

        if ((this.def != otro.def))
            res = false;

        if (this.pv != otro.pv)
            res = false;

        if (this.nivel != otro.nivel)
            res = false;

        return res;
    }

    public int ataque(){
        getAtq();
        return atq;
    }

    public int defender(int defe){

        defe -= atq;
        if (defe <= 0) {
            defe = 0;
        }

        return defe;
    }

}