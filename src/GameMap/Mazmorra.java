package GameMap;

import Characters.Monstruo;

import java.util.ArrayList;

/**
 *  Crea una clase Mazmorra que permita representar un área con diversos monstruos.
 * La Mazmorra tiene un nombre propio, un conjunto de Monstruos no repetibles que
 * pueden aparecer para combatir con otros Personajes, y, además, también tiene un nivel
 * promedio. Los Monstruos de la Mazmorra solo pueden tener 3 niveles por encima o por
 * debajo del promedio de esta.
 * Agrega las siguientes funcionalidades a la clase:
 * ● Un constructor por defecto, con parámetros y de copia. El constructor de
 * parámetros inicializará sus datos a partir de un fichero.
 * ● Getters y setters para todos los atributos.
 * ● Un método combateAleatorio() que devuelve un Monstruo aleatorio del
 * conjunto de la Mazmorra.
 * ● Un método toString() que devuelva tanto los atributos como el conjunto de
 * monstruos
 */
public class Mazmorra {
    private ArrayList <Monstruo> monstruos;
    private String nombre;
    private int nivel;

    public Mazmorra(){
        nombre = "";
        nivel = -1;
        monstruos = null;
    }

    public Mazmorra(String nombre, int nivel, ArrayList<Monstruo> monstruos){
        setNombre(nombre);
        setNivel(nivel);
        setMonstruos(monstruos);
    }

    public Mazmorra(Mazmorra otro){
        this.nombre = otro.nombre;
        this.nivel = otro.nivel;
        this.monstruos = otro.monstruos;
    }

    public ArrayList<Monstruo> getMonstruos() {
        return monstruos;
    }

    public void setMonstruos(ArrayList<Monstruo> monstruos) {
        this.monstruos = monstruos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        //if(nivel + 3 >=  || nivel-3<=)
        this.nivel = nivel;
    }

    public void combateAleatorio(){

    }

    @Override
    public String toString() {
        return "Esta mazmorra llamada " + nombre + "posee un conjunto de monstruos llamados \n" + monstruos.toString() + "posee un nivel promedio de " + nivel ;
    }
}

