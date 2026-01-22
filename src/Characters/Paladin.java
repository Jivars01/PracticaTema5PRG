package Characters;

import java.util.Random;

public class Paladin extends Creyente{

    public Paladin(){
        super();
    }

    public Paladin(String nombre, int pv, int atq, int arm, int nivel, int vel, int res,int fe){
        super(nombre, pv, atq, arm, nivel, vel, res, fe);
    }

    @Override
    public int plegaria() {
        int eleccion = 1;
        switch (eleccion){
            case 1:
                System.out.println("Has elegido imbuir tu arma de fe");

                ataque();

                break;
        }
        return 0;
    }
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
}
