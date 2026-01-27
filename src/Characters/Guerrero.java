package Characters;

import java.util.Random;
import java.util.Scanner;

public class Guerrero extends Personaje {

    private boolean furia;

    public Guerrero() {
        super();
        furia = false;
    }

    public Guerrero(String nombre, int pv, int atq, int arm, int nivel, int vel, int res, boolean furia) {
        super(nombre, pv, atq, arm, nivel, vel, res);
        setFuria(furia);
    }

    @Override
    public void subirNivel() {
        int c;
        Random a = new Random();
        c = a.nextInt(100);
        if (c < 75 && c > 0) {
            setPv(getPv() + 1);
        }
        c = a.nextInt(100);
        if (c <= 80 && c > 0) {
            setAtq(getAtq() + 2);
        }
        c = a.nextInt(100);
        if (c <= 75 && c > 0) {
            setArm(getArm() + 1);
        }
        c = a.nextInt(100);
        if ((c <= 20 && c > 0)) {
            setRes(getRes() + 1);
        }
        c = a.nextInt(100);
        if ((c <= 50 && c > 0)) {
            setVel(getVel() + 1);
        }
        setNivel(getNivel() + 1);
    }

    public boolean isFuria() {
        return furia;
    }

    public void setFuria(boolean furia) {
        this.furia = furia;
    }

    public boolean modificaFuria() {
        if (furia = true) {
            furia = false;
        } else furia = true;
        return furia;
    }

    @Override
    public int ataque() {
        if (furia = true)
            return super.ataque() * 2;
        else return super.ataque();
    }

    public void defender(int defefisico, String tipo) {
        if (furia == true)
            super.defender(defefisico * 2, tipo);
        else super.defender(defefisico, tipo);
    }

    @Override
    public String toString() {
        return super.toString() + "Es un Guerrero con la posiblidad de entrar en furia y duplicar su daño " +
                "\n Sin embargo este recibe el doble de daño durante dicho estado";
    }

    public int realizaTurno() {
        int daño = 0;
        String tipo;
        Scanner scan = new Scanner(System.in);
        System.out.println("Introduzca por teclado que es lo que vas a hacer:" +
                "\n1.Atacar" +
                "\n2.Ataque especial (Solo algunos categorias pueden hacerlo)" +
                "\n3.Defender" +
                "\n4.Pasar turno");
        tipo = scan.nextLine();
        switch (tipo) {
            case "1":
                System.out.println("Has decidido atacar");
                daño = ataque();
                defender(ataque(), "Fisico");
                break;
            case "2":
                if (furia = false) {
                    System.out.println("El guerrero se enfada y activa su furia");
                    modificaFuria();
                } else System.out.println("El guerrero se relaja y desactiva su furia");
                modificaFuria();
                break;

            case "3":
                System.out.println("Has decidido defender");

                setRes((int) (getRes() / 0.80));

                setArm((int) ((getArm()) /0.80));

                daño = 0;
                break;
            case "4":
                System.out.println("Has decidido pasar el turno tu personaje no hara ninguna accion");
                daño = 0;
                break;
            default:
                System.out.println("La opcion escogida no corresponde a las especificadas");
        }
        return daño;
    }

}
