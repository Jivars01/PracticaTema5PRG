package Armamento;

import java.util.HashMap;

public class Artefacto extends Equipamiento{
    private String tipo;

    public Artefacto(){
        super();
        tipo = "";
    }

    public Artefacto(String nombre, String rareza, int valor, HashMap estadistica, String tipo, String material) {
        super(nombre, rareza, valor, estadistica);
        this.tipo = tipo;
    }

    public Artefacto(Artefacto copia) {
        super(copia);
        this.tipo = copia.tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        if(tipo == "anillos" || tipo == "amuletos")
            this.tipo = tipo;
        else this.tipo = "";
    }
}
