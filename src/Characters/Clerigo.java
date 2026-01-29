package Characters;

import java.util.Random;

public class Clerigo extends Creyente {

    public Clerigo() {
        super();
    }

    public Clerigo(String nombre, int pv, int atq, int arm, int nivel, int vel, int res, int fe) {
        super(nombre, pv, atq, arm, nivel, vel, res, fe);
    }

    public void subirNivel() {
        int c;
        Random a = new Random();
        c = a.nextInt(100);
        if (c < 20 && c > 0) {
            setPv(getPv() + (int) (getPv() * 0.05));
        }
        c = a.nextInt(100);
        if (c <= 10 && c > 0) {
            setAtq(getAtq() + 1);
            ;
        }
        c = a.nextInt(100);
        if (c <= 20 && c > 0) {
            setArm(getArm() + 2);
        }
        c = a.nextInt(100);
        if ((c <= 80 && c > 0)) {
            setRes(getRes() + 1);
        }
        c = a.nextInt(100);
        if ((c <= 15 && c > 0)) {
            setVel(getVel() + 1);
        }
        c = a.nextInt(100);
        if ((c <= 80 && c > 0)) {
            setFe(getFe() + 1);
        }
        setNivel(getNivel() + 1);
    }

    public int plegaria(Personaje c2) {
        int eleccion = 1;
        switch (eleccion) {
            case 1:
                System.out.println("Has elegido Sanacion");
                int cantidadSanacion = (int) (getFe() * 0.70);
                setPv(getPv() + cantidadSanacion);
                break;
            case 2:
                System.out.println("Has elegido Rezo Sagrado");
                int cantidadSanacion2 = (int) (getFe() * 0.30);
                setPv(getPv() + cantidadSanacion2);
                break;
            case 3:
                System.out.println("Has usado fogonazo sagrado");
                int dañodefe = (int) (getFe() * 0.55);

                break;
            default:
                return 0;
        }
        return 0;
    }
}

