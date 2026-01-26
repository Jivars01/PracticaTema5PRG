package Characters;

import java.util.Scanner;

public abstract class Creyente extends Personaje{
    private int fe;

    public Creyente(){
        super();
        fe =0;
    }

    public int getFe() {
        return fe;
    }

    public void setFe(int fe) {
        this.fe = fe;
    }

    public Creyente (String nombre, int pv, int atq, int arm, int nivel, int vel, int res,int fe){
        super(nombre,pv, atq, arm, nivel,  vel, res);
        setFe(fe);
    }
    public abstract int plegaria(Personaje c2);
    public String toString() {
        return super.toString() + "Es un Creyente con la habilidad de efectuar milagros con su fe";
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
                System.out.println("Un personaje creyente no tiene ataque especial");
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
