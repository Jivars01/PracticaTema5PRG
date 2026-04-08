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

    public Integer recuperaEstadistica(String recuperar) {
        switch (recuperar) {
            case "vida", "armadura", "resistencia", "velocidad":
                return super.recuperaEstadistica(recuperar);
            default:
                return null;
        }
    }

    public String getTipo() {
        return tipo;
    }

    //yelmos, pecheras, hombreras, guanteletes, grebas y botas
    public void setTipo(String tipo) {
        if (tipo.equals("yelmos") || tipo.equals("pecheras") || tipo.equals("hombreras") || tipo.equals("guanteletes") || tipo.equals("grebas") || tipo.equals("botas"))
            this.tipo = tipo;
        else  this.tipo = "";
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
