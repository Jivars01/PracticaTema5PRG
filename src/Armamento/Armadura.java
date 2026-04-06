package Armamento;

import java.util.HashMap;

public class Armadura extends Equipamiento{
    private String tipo;
    private String material;

    public Armadura(){
        super();
        tipo = material = "";
    }

    public Armadura(String nombre, String rareza, int valor, HashMap estadistica, String tipo, String material) {
        super(nombre, rareza, valor, estadistica);
        this.tipo = tipo;
        this.material = material;
    }

    public Armadura(Armadura copia) {
        super(copia);
        this.tipo = copia.tipo;
        this.material = copia.material;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        if(this.material.equals("tela") || this.material.equals("cuero") || this.material.equals("metal") )
            this.material = material;
        else this.material = "";
    }
}
