package Characters;

import java.util.Random;

public class Monstruo extends Personaje {
    private String Monstruo;

    public Monstruo() {
        super();
        Monstruo = "";
    }

    public Monstruo(String nombre, int pv, int atq, int arm, int nivel, int vel, int res, String Monstruo) {
        super(nombre, pv, atq, arm, nivel, vel, res);
    }

    public void subirNivel() {
        int c;
        Random a = new Random();
        c = a.nextInt(100);
        if (c < 40 && c > 0) {
            setPv(getPv() + 1);
        }
        c = a.nextInt(100);
        if (c <= 60 && c > 0) {
            setAtq(getAtq() + 1);
            ;
        }
        c = a.nextInt(100);
        if (c <= 40 && c > 0) {
            setArm(getArm() + 1);
        }
        c = a.nextInt(100);
        if ((c <= 40 && c > 0)) {
            setRes(getRes() + 1);
        }
        c = a.nextInt(100);
        if ((c <= 85 && c > 0)) {
            setVel(getVel() + 1);
        }
        setNivel(getNivel() + 1);
    }

    public String getMonstruo() {
        return Monstruo;
    }

    public void setMonstruo(String monstruo) {
        if (Monstruo.isEmpty())
            Monstruo = "";
        else this.Monstruo = Monstruo;
    }

    public void categoriaMonstruo() {
        switch (Monstruo) {
            case "Bestia":

                break;
            case "No-Muerto":

                break;

            case "Gigante":

                break;

            default:
                System.err.println("La opcion escogida es erronea ");

        }
    }

}
