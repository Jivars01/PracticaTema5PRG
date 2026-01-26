package Characters;

import java.util.Random;
import java.util.Scanner;

public class Mago extends Personaje {
    private int mag;

    public Mago() {
        super();
        mag = 10;
    }

    public Mago(String nombre, int pv, int atq, int arm, int nivel, int vel, int res, int mag) {
        super(nombre, pv, atq, arm, nivel, vel, res);
        setMag(mag);
    }

    public void subirNivel() {
        int c;
        Random a = new Random();
        c = a.nextInt(100);
        if (c < 85 && c > 0) {
            mag++;
        }

        c = a.nextInt(100);
        if (c < 35 && c > 0) {
            setPv(getPv() + 1);
        }
        c = a.nextInt(100);
        if (c <= 15 && c > 0) {
            setAtq(getAtq() + 1);
            ;
        }
        c = a.nextInt(100);
        if (c <= 35 && c > 0) {
            setArm(getArm() + 1);
        }
        c = a.nextInt(100);
        if ((c <= 80 && c > 0)) {
            setRes(getRes() + 1);
        }
        c = a.nextInt(100);
        if ((c <= 65 && c > 0)) {
            setVel(getVel() + 1);
        }
        setNivel(getNivel() + 1);
    }

    public int getMag() {
        return mag;
    }

    public void setMag(int mag) {
        this.mag = mag;
    }

    public double lanzarconjuro() {
        int opcion;
        double daño = 0;
        Scanner scan = new Scanner(System.in);
        opcion = scan.nextInt();
        System.out.println("¿Que conjuro quieres realizar?" +
                "\n 1 Bola de fuego \n 2 Escudo Arcano \n 3 Cefiro \n 4 Presteza mental");
        switch (opcion) {
            case 1:
                System.out.println("Has elegido bola de fuego");
                daño = mag * 0.70;
                break;
            case 2:
                System.out.println("Has elegido Escudo Arcano");
                mag *= 50;
                mag /= 100;
                setRes(getRes() + mag);
                setArm(getArm() + mag);
                break;
            case 3:
                System.out.println("Has elegido Cefiro");
                daño = mag * 0.30;
                break;
            case 4:
                System.out.println("Ha elegido Presteza mental");
                setVel(getVel() + mag);
                break;
            default:
                System.err.println("La opcion escogida no correspone a las especificadas");
        }
        return daño;
    }

    public String toString() {
        return super.toString() + "Es un Mago que posee puntos de magia que puede realizar ataque magicos";
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
                System.out.println("Has decidido lanzar un conjuro");
                lanzarconjuro();
                break;
            case "3":
                System.out.println("Has decidido defender");
                setRes((int) (getRes() * 1.20));

                setArm((int) ((getArm()) * 1.20));
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
