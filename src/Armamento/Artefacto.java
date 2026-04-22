package Armamento;

import java.util.HashMap;

public class Artefacto extends Equipamiento{
    private String tipo;

    public Artefacto(){
        super();
        tipo = "";
    }

    public Artefacto(String nombre, String rareza, int valor, HashMap estadistica, String tipo) {
        super(nombre, rareza, valor, estadistica);
        this.tipo = tipo;
    }

    public Artefacto(Artefacto copia) {
        super(copia);
        this.tipo = copia.tipo;
    }

    public Integer recuperaEstadistica(String recuperar) {
        switch (recuperar) {
            case "Vida", "Ataque", "Armadura", "Resistencia", "Velocidad", "Fe", "Magia":
                return super.recuperaEstadistica(recuperar);
            default:
                return null;
        }
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        if(tipo == "Anillo" || tipo == "Amuleto")
            this.tipo = tipo;
        else this.tipo = "";
    }
}
