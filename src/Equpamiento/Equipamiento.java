package Equpamiento;

import Characters.Personaje;

import java.util.HashMap;

/**
 * (1,25) Crea una clase abstracta llamada Equipamiento. Cualquier pieza de equipo tiene
 * las siguientes características:
 * ● Un nombre. Este nombre no debe pasar de 20 caracteres.
 * ● Una o varias estadísticas asociadas. Los distintos tipos de Equipamiento
 * proporcionan estadísticas a los Personajes que las equipan. Representa las
 * estadísticas del Equipamiento como una Estructura de Datos.
 * ● Una rareza. La rareza garantiza que una pieza de Equipamiento proporcione
 * más estadísticas. Existen cuatro tipos de rareza: común, raro, épico y legendario.
 * ● Un valor económico. Cada pieza de equipo tiene un valor en piezas de oro. El
 * valor no puede ser inferior a 1.
 * Añade las siguientes funcionalidades a esta clase:
 * ● Un constructor por defecto, un constructor con parámetros y un constructor
 * de copia.
 * ● Getters y setters para todos los atributos.
 * ● Un método recuperaEstadistica(String) que solicite el valor de una estadística
 * concreta de la pieza de Equipamiento.
 * ● Métodos toString() e equals().
 */
public abstract class Equipamiento {
    private String nombre;
    private String rareza;
    private int valor;
    private HashMap<String, Integer> estadisticaAsociada = new HashMap<>();

    public Equipamiento (){
        nombre = rareza = "";
        valor = -1;
        estadisticaAsociada = new HashMap<>();
    }

    public Equipamiento (String nombre, String rareza, int valor, HashMap estadistica){
        setNombre(nombre);
        setRareza(rareza);
        setValor(valor);
        setEstadisticaAsociada(estadistica);
        estadisticaAsociada = new HashMap<>();
    }

    public Equipamiento(Equipamiento copia){
        this.nombre = copia.nombre;
        this.rareza = copia.rareza;
        this.valor = copia.valor;
        this.estadisticaAsociada = copia.estadisticaAsociada;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRareza() {
        return rareza;
    }

    public void setRareza(String rareza) {
        this.rareza = rareza;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public HashMap<String, Integer> getHashMap() {
        return estadisticaAsociada;
    }

    public void setEstadisticaAsociada(HashMap<String, Integer> hashMap) {
        this.estadisticaAsociada = hashMap;
    }

    public Integer recuperaEstadistica(String recuperar){
        return estadisticaAsociada.get(recuperar);

    }

    public String toString(){
        return "El equipamiento" + nombre + "tiene una rareza de" + rareza + "\n tiene un valor de" + valor + "y sube las siguientes estadiisticas" + estadisticaAsociada;
    }

    public boolean equals(Equipamiento otro) {
        boolean res = true;
        if (!this.nombre.equals((otro.nombre)))
            res = false;

        if (this.rareza != otro.rareza)
            res = false;

        if ((this.valor != otro.valor))
            res = false;

        if (this.estadisticaAsociada != otro.estadisticaAsociada)
            res = false;

        return res;
    }


}
