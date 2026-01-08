package GameMap;

import Characters.Personaje;

import java.util.Random;

public class Trampa {
    private String categoria;
    private int perjuicio;
    private double fracaso;
    public Trampa() {
        categoria = "";
        perjuicio = 0;
        fracaso = 0;
    }

    public Trampa(String categoria, int perjuicio){
        setCategoria(categoria);
        setPerjuicio(perjuicio);
        setFracaso();
    }

    public Trampa(String tipo){
        setCategoria(tipo);
        Random r = new Random();
        setPerjuicio(r.nextInt(0,21));
        setFracaso();
    }


    public Trampa(Trampa copia){
        this.categoria = copia.categoria;
        this.perjuicio = copia.perjuicio;
        this.fracaso = copia.fracaso;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String cat) {
        switch (cat) {
            case "Pinchos", "Brea", "Serpientes":
                System.out.println("Usted ha seleccionado la trampa " + cat);
                categoria = cat;
                break;
            default:
                System.err.println("La trampa seleccionada no existe, compruebe bien las mayusculas usadas");
        }
    }

    public int getPerjuicio() {
        return perjuicio;
    }

    public void setPerjuicio(int p) {
        if (p >= 5 && p <= 20) {
            perjuicio = p;
        } else {
            System.err.println("El número debe contenerse entre el 5 o el 20");
            p = 5;
            perjuicio = p;
        }
    }





    public double getFracaso() {
        return fracaso;
    }

    public void setFracaso() {
        Random b = new Random();
        fracaso = b.nextDouble(75);
    }

    public int activatrampa() {
        Random b = new Random();
        int activacion;
        activacion = b.nextInt(100);
        if (activacion < fracaso)
            return perjuicio;
        else return 0;
    }
    public double modificafracaso(double mf){
        fracaso += mf;
        return fracaso;
    }
    public boolean equals(Trampa otro){
        boolean res = true;
        if(!this.categoria.equals((otro.categoria)))
            res= false;

        if (this.perjuicio != otro.perjuicio)
            res=false;

        if ((this.fracaso!=otro.fracaso))
            res=false;

        return res;
    }
    public String toString(){
        String resultado = "La trampa " + getCategoria() + "con las un perjuicio de " + getPerjuicio() + "  con un nivel de fracaso de " + getFracaso() + "esta preparada para usarse";
        return resultado;
    }
}
