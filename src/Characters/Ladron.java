package Characters;

import java.util.Random;
import java.util.Scanner;

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
                defender(ataque(),"Fisico");
                break;
            case "2":
                System.out.println("El ladron se ha lanzado a robar");
                robar();
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
