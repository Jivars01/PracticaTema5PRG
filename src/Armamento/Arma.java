package Armamento;

import java.util.HashMap;
import java.util.Objects;

public class Arma extends Equipamiento{

    //Solo puede dar estadisticas de fuerza, magia, fe y velocidad
    //Para una mano, existen los siguientes tipos de arma: espada, maza,
    //hacha, cetro, daga. Para dos manos, pueden ser de los siguientes tipos:
    //espadón, martillo, arco y bastón.

    private int empuñadura;
    private String tipo;

    public Arma(){
        empuñadura = -1 ;
        tipo = "" ;
    }

    public Arma(int empuñadura, String tipo) {
        this.empuñadura = empuñadura;
        this.tipo = tipo;
    }

    public Arma(String nombre, String rareza, int valor, HashMap estadistica, String tipo) {
        super(nombre, rareza, valor, estadistica);
        this.empuñadura = empuñadura;
        this.tipo = tipo;
    }

    public Arma(Arma copia){
        super(copia);
        this.empuñadura = copia.empuñadura;
        this.tipo = copia.tipo;
    }

    @Override
    public Integer recuperaEstadistica(String recuperar) {
        switch (recuperar){
            case  "ataque", "velocidad" , "fe", "magia" :
                return super.recuperaEstadistica(recuperar);
            default : return null;
        }
    }

    public int getEmpuñadura() {
        return empuñadura;
    }

    public void setEmpuñadura(int empuñadura) {
        if (empuñadura < 0 || empuñadura > 2){
            this.empuñadura = empuñadura;
        }
        else this.empuñadura = -1;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
            if (tipo.equals("Espada") || tipo.equals("Maza") || tipo.equals("Hacha") || tipo.equals("Cetro") || tipo.equals("Daga")) {
                empuñadura = 1;
                this.tipo = tipo;
            } else
                if (tipo.equals("Espadon") || tipo.equals("Martillo") || tipo.equals("Arco") || tipo.equals("Baston")) {
                    empuñadura = 2;
                    this.tipo = tipo;
            } else this.tipo = "";
        }


    public boolean equals(Arma otro) {
        boolean res = true;
        if (this.empuñadura != (otro.empuñadura))
            res = false;

        if (!this.tipo.equals(otro.tipo))
            res = false;

        return res;
    }
}
