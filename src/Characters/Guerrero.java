package Characters;

import java.util.Random;

public class Guerrero extends Personaje{

    private boolean furia;

    public Guerrero(){
        super();
        furia = false;
    }

    public Guerrero(String nombre, int pv, int atq, int arm, int nivel, int vel, int res, boolean furia){
        super(nombre,pv, atq, arm, nivel,  vel, res);
        setFuria(furia);
    }

    @Override
    public void subirNivel() {
        int c;
        Random a = new Random();
        c = a.nextInt(100);
        if (c < 75 && c > 0) {
            setPv(getPv()+1);
        }
        c = a.nextInt(100);
        if (c <= 80 && c > 0) {
            setAtq(getAtq()+1);;
        }
        c = a.nextInt(100);
        if (c <= 75 && c > 0) {
            setArm(getArm()+1);
        }
        c = a.nextInt(100);
        if ((c <= 20 && c > 0)) {
            setRes(getRes()+1);
        }
        c = a.nextInt(100);
        if ((c <= 50 && c > 0)) {
            setVel(getVel()+1);
        }
        setNivel(getNivel()+1);
    }

    public boolean isFuria() {
        return furia;
    }

    public void setFuria(boolean furia) {
        this.furia = furia;
    }

    public boolean modificaFuria(){
        if(furia = true){
            furia = false;
        } else furia = true;
        return furia;
    }

    @Override
    public int ataque() {
        if (furia = true)
            return super.ataque()*2;
        else return super.ataque();
    }

    @Override
    public void defender(int defefisico, String tipo) {
        if (furia == true)
             super.defender(defefisico * 2, tipo);
        else super.defender(defefisico,tipo);
    }

    @Override
    public String toString() {
        return super.toString() + "Es un Guerrero con la posiblidad de entrar en furia y duplicar su daño "+
                "\n Sin embargo este recibe el doble de daño durante dicho estado";
    }

}
