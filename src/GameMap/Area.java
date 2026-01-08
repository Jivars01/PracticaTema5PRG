package GameMap;


import Characters.Personaje;

import java.security.PublicKey;
import java.util.Random;

public class Area {
    private String nombre;
    private String bioma;
    private int dificultad;
    private Trampa trampa;

    public Area() {
        nombre = "???";
        bioma = "Pradera";
        dificultad = 1;
        trampa = new Trampa();
    }

    public Area(String nombre, String bioma, int dificultad, Trampa trampa) {
        setNombre(nombre);
        setBioma(bioma);
        this.dificultad = dificultad;
        setTrampa(trampa);
    }

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


    public Area(Area copia) {
        this.nombre = copia.nombre;
        this.bioma = copia.bioma;
        this.dificultad = copia.dificultad;
        this.trampa = copia.trampa;
    }

    public String getNombre() {
        return nombre;
    }

    public String getBioma() {
        return bioma;
    }

    public int getDificultad() {
        return dificultad;
    }

    public void setTrampa(Trampa trampa) {
        this.trampa = new Trampa(trampa);
    }

    public void setNombre(String n2) {
        if (n2.equals("")) {
            System.err.println("Error. El nombre debe tener caracteres válidos.");
        } else if (n2.contains("")) {
            System.err.println("Lo siento, su nombre no puede contener espacios, sustituyalos por _");
        } else {
            nombre = n2;
        }
    }

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

    public String toString() {
        String resultado = "El area" + getNombre() + " con un bioma de " + getNombre() + "  con una dificultad de "
                + getDificultad() + "esta preparada para usarse";
        return resultado;
    }
}
