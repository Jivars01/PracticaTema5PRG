package Characters;

import java.util.Random;

public class Paladin extends Creyente{

    public Paladin(){
        super();
    }

    public Paladin(String nombre, int pv, int atq, int arm, int nivel, int vel, int res,int fe){
        super(nombre, pv, atq, arm, nivel, vel, res, fe);
    }

    /*
    Imbuir arma (1): el paladín añade el 80% de sus puntos de fe a sus puntos
de ataque.
★ Baluarte de fe (2): el paladín aumenta su propia armadura un 30% de sus
puntos de su fe.
★ Fogonazo sagrado (3): el paladín ciega a su oponente, reduciendo su
velocidad y resistencia mágica un 40% de sus puntos de fe.
     */
    public int plegaria() {
        int eleccion = 1;
        switch (eleccion){
            case 1:
                System.out.println("Has elegido imbuir tu arma de fe");
                setAtq((int) (getAtq() + (getFe() * 0.80)));

                break;
            case 2:
                System.out.println("Has elegido Baluarte de fe ");
                setArm((int)(getArm() * 1.3));

                break;
            case 3 :
                System.out.println("Has usado fogonazo sagrado");

                break;
            default:
                return 0;
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
