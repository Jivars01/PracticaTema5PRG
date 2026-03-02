package Misc;

public class Comentarios_Practicas_E_Ivan {

/*
  public static void exportarParty(Personaje[] party, String nombreFichero) {

        // Ordenar el array según los criterios indicados
        Arrays.sort(party, new Comparator<Personaje>() {
            @Override
            public int compare(Personaje p1, Personaje p2) {

                // Primero: velocidad descendente
                if (p2.getVelocidad() != p1.getVelocidad()) {
                    return Integer.compare(p2.getVelocidad(), p1.getVelocidad());
                }

                // Segundo: nivel descendente (si hay empate en velocidad)
                return Integer.compare(p2.getNivel(), p1.getNivel());
            }
        });
 */


}
/**-----------------------------------------------------------------------------------------------------------------------------------------------------------------*/
    /*

    Personajes -> p1, p2, p3, p4, p5
    p1.vel = 30;
    p2.vel = 50;
    p3.vel = 35;
    p4.vel = 55;
    p5.vel = 40;

    5 4 9 3 7
    3 4 9 5 7


public static void selectionSort(Personaje [] personajes) {
        int n = array.length;

        for (int i = 0; i < n - 1; i++) {
            int indiceMinimo = i;

            for (int j = i + 1; j < n; j++) {
                if (personajes[j].getVelocidad() > personajes[indiceMinimo].getVelocidad()) {
                    indiceMinimo = j;
                }
            }

            // Intercambiamos el mínimo encontrado con el elemento en i
            Personaje temp = array[indiceMinimo];
            array[indiceMinimo] = array[i];
            array[i] = temp;
        }
    }
}

     */

//RealizarTurno debería devolver la cantidad de daño a realizar -> atacar es el ataque estándar, la accion especial depende de la subclase y defender y pasar turno devuelven 0

   /*
            REALIZARTURNO SOLO LO UTILIZA EL PERSONAJE JUGABLE
            Bucle do-while del combate
            0. Comprobar que personaje tiene más velocidad
            1. Ejecutar primera posibilidad
                1.1. Comprobar si el personaje más veloz tiene doble turno
                1.2. Realizar el turno adicional primero SI LO HUBIERA, utilizando defender con la cantidad de daño obtenida de realizarTurno
                1.3. Realizar el turno habitual, utilizando igual defender con la cantidad de la llamada a realizarTurno
                1.4. Realizar el turno del oponente
                1.* DESPUÉS DE CADA GOLPE HAY QUE COMPROBAR SI EL GOLPE HA MATADO Y EL COMBATE TERMINA
            2. Ejecutar segunda posibilidad
                2.1. Repetir los pasos 1.1. a 1.*. con c1 y c2 invertidos
            3. Declarar el ganador cuando se salga del bucle
         */
