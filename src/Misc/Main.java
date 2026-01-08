package Misc;

import Characters.Personaje;

public class Main {
    public static void main(String[] args) {
        String nombre = "Jesus";
        Personaje hola = new Personaje(nombre, 5);
        System.out.println(hola.toString());
    }
}