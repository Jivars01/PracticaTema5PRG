package GameMap;

import Characters.Personaje;

import java.util.ArrayList;

/**
 *  Crea una clase Aventura. La Aventura es una clase en la que un grupo de
 * Personajes recorre una Mazmorra. Para completar la Aventura, deberán superar 10
 * combates consecutivos en el interior de ésta. Cada vez que encuentren algo de
 * Equipamiento en cada Combate, deberá equipárselo el Personaje que sea compatible.
 * Toda Aventura tiene las siguientes características:
 * ● Cada Combate tiene lugar entre todos los integrantes del grupo, y de 1 a 3
 * Monstruos propios de la Mazmorra según las reglas establecidas en el ejercicio
 * 6.
 * ● Si todos los integrantes del grupo de Personajes terminan muertos, no superan
 * la Aventura. Se considerará una derrota.
 * ● Si, por el contrario, al menos un Personaje del grupo sobrevive, entonces habrán
 * superado la Aventura. Se considerará una victoria.
 * ● Cuando un Personaje del grupo muere, su equipo se pierde y no se puede
 * aprovechar.
 */
public class Aventura {
    private ArrayList<Personaje> Grupo;

}
