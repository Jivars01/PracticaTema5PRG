package Characters;

import java.util.Random;

public class Ladron extends Personaje{
    public Ladron(){
        super();
    }

    public Ladron (String nombre, int pv, int atq, int arm, int nivel, int vel, int res){
        super(nombre,pv, atq, arm, nivel,  vel, res);
    }
    public void subirNivel() {
        int c;
        Random a = new Random();
        c = a.nextInt(100);
        if (c < 40 && c > 0) {
            setPv(getPv()+1);
        }
        c = a.nextInt(100);
        if (c <= 60 && c > 0) {
            setAtq(getAtq()+1);;
        }
        c = a.nextInt(100);
        if (c <= 40 && c > 0) {
            setArm(getArm()+1);
        }
        c = a.nextInt(100);
        if ((c <= 40 && c > 0)) {
            setRes(getRes()+1);
        }
        c = a.nextInt(100);
        if ((c <= 85 && c > 0)) {
            setVel(getVel()+1);
        }
        setNivel(getNivel()+1);
    }
    public int robar(){
        return getVel();
    }
    public String toString() {
        return super.toString() + "Es un Ladron con la habilidad de robar";
    }
}
