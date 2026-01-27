package Characters;

import java.util.Random;

public class Cazador extends Personaje {

    private Cazador Mascota;

    public Cazador(){
        super();
    }


    public Cazador (String nombre,int pv, int atq, int arm, int nivel, int vel, int res){
        super(nombre, pv, atq, arm, nivel, vel, res);
    }

    public void subirNivel() {
        int c;
        Random a = new Random();
        c = a.nextInt(100);
        if (c < 75 && c > 0) {
            setPv(getPv() + 1);
        }
        c = a.nextInt(100);
        if (c <= 50 && c > 0) {
            setAtq(getAtq() + 2);
        }
        c = a.nextInt(100);
        if (c <= 50 && c > 0) {
            setArm(getArm() + 1);
        }
        c = a.nextInt(100);
        if ((c <= 50 && c > 0)) {
            setRes(getRes() + 1);
        }
        c = a.nextInt(100);
        if ((c <= 50 && c > 0)) {
            setVel(getVel() + 1);
        }
        setNivel(getNivel() + 1);
    }
    /*
    Externa objetoexterno = new Externa();
Externa.Interna objetoInterno = objetoexterno.new Interna();
     */
    public class Animal{
        private String Rareza;


        public void subirNivel() {
        int c;
        Random a = new Random();
        switch (Rareza) {

            case "Canido":
                c = a.nextInt(100);
                if (c < 50 && c > 0) {
                    setPv(getPv() + 1);
                }
                c = a.nextInt(100);
                if (c <= 80 && c > 0) {
                    setAtq(getAtq() + 2);

                }
                c = a.nextInt(100);
                if (c <= 15 && c > 0) {
                    setArm(getArm() + 1);
                }
                c = a.nextInt(100);
                if ((c <= 15 && c > 0)) {
                    setRes(getRes() + 1);
                }
                c = a.nextInt(100);
                if ((c <= 80 && c > 0)) {
                    setVel(getVel() + 2);
                }
                setNivel(getNivel() + 1);
                break;
            case "Felino":

                c = a.nextInt(100);
                if (c < 30 && c > 0) {
                    setPv(getPv() + 1);
                }
                c = a.nextInt(100);
                if (c <= 50 && c > 0) {
                    setAtq(getAtq() + 1);
                }
                c = a.nextInt(100);
                if (c <= 30 && c > 0) {
                    setArm(getArm() + 1);
                }
                c = a.nextInt(100);
                if ((c <= 70 && c > 0)) {
                    setRes(getRes() + 4);
                }
                c = a.nextInt(100);
                if ((c <= 5 && c > 0)) {
                    setVel(getVel() + 1);
                }
                setNivel(getNivel() + 1);
                break;
            case "Rapaz":

                c = a.nextInt(100);
                if (c < 50) {
                    setPv(getPv() + 2);
                } else setPv(getPv()+3);

                c = a.nextInt(100);
                if (c <= 50 && c > 0) {
                    setAtq(getAtq() + 1);

                }
                c = a.nextInt(100);
                if (c <= 50 && c > 0) {
                    setArm(getArm() + 1);
                }
                c = a.nextInt(100);
                if ((c <= 10 && c > 0)) {
                    setRes(getRes() + 4);
                }
                c = a.nextInt(100);
                if ((c <= 10 && c > 0)) {
                    setVel(getVel() + 1);
                }
                setNivel(getNivel() + 6);

        }
    }


    }
}
