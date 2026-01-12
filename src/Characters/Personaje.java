package Characters;

import java.util.Random;

import GameMap.Trampa;

public class Personaje {
    private String nombre;
    private int pv;
    private int atq;
    private int arm;
    private int nivel;
    private int res;
    private int vel;

    public Personaje() {
        nombre = "";
        pv = 100;
        atq = 10;
        arm = 10;
        nivel = 1;
        res = 10;
        vel = 10;
    }


    public Personaje(String nombre, int pv, int atq, int arm, int nivel, int vel, int res) {
        setNombre(nombre);
        setPv(pv);
        setAtq(atq);
        setArm(arm);
        setNivel(nivel);
        setRes(res);
        setVel(vel);
    }

    public Personaje(Personaje copia) {
        this.nombre = copia.nombre;
        this.pv = copia.pv;
        this.atq = copia.atq;
        this.arm = copia.arm;
        this.nivel = copia.nivel;
        this.vel = copia.vel;
        this.res = copia.res;
    }

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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String n) {
        if (n.equals("")) {
            System.err.println("Error. El nombre debe tener caracteres válidos.");
        } else if (n.contains("GM")) {
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

    public void setNivel(int level) {
        if (level < 1 || level > 100) {
            System.err.println("Lo siento, no puedo poner un valor menor a 1.");
        } else {
            nivel = level;
        }
    }

    public int getRes() {
        return res;
    }

    public void setRes(int res) {
        if (res <= 0) {
            this.res = 0;
        }
    }

    public int getVel() {
        return vel;
    }

    public void setVel(int vel) {
        if (vel <= 0) {
            this.vel = 0;
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
                arm += cantidad;
                break;
        }
    }

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
        String resultado = "El personaje " + getNombre() + " con las estadisticas de " + getAtq() + " de ataque, " + getArm() + " de defensa, " + getPv() + " de vida, "
                + "con el nivel " + getNivel() + " esta creado.";
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

    public int ataque() {
        return getAtq();
    }

    public int defender(int defefisico,String tipo) {

        switch (tipo){
            case "Fisico":
                defefisico = arm;
            case "Magico":
                defefisico = res;
        }

        defefisico -= atq;
        if (defefisico <= 0) {
            defefisico = 0;
        }
        return defefisico;
    }
    public void RealizaTurno(String tipo){
            switch (tipo){
                case "1":

            }
    }


}