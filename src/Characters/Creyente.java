package Characters;

public abstract class Creyente extends Personaje{
    private int fe;

    public Creyente(){
        super();
        fe =0;
    }

    public Creyente (String nombre, int pv, int atq, int arm, int nivel, int vel, int res){
        super(nombre,pv, atq, arm, nivel,  vel, res);
    }
    public abstract int plegaria();
    public String toString() {
        return super.toString() + "Es un Creyente con la habilidad de efectuar milagros con su fe";
    }
}
