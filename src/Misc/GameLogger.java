package Misc;

import Characters.Personaje;

import java.io.*;

public class GameLogger {

    public static void Escribeenfichero(Personaje p) {
        try {
            FileWriter fw = new FileWriter("./Ficheros/" + p.getNombre() + ".txt");
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write("Nombre :" + p.getNombre());
            bw.newLine();
            bw.write("Nivel : " + p.getNivel());
            bw.newLine();
            bw.write(p.devuelveDatos());
            bw.close();
            fw.close();
        } catch (IOException ioe) {
            System.err.println(ioe);
        }
    }


    public static void ArraysFicheros(Personaje[] grupo) throws IOException {
        ordenaVelocidad(grupo);
        FileWriter fw = new FileWriter("./Ficheros/" + grupo[0].getNombre() + ".txt");
        BufferedWriter Bw = new BufferedWriter(fw);
        for(int i = 0; i< grupo.length; i++){
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write("Nombre :" + grupo[i].getNombre());
            bw.newLine();
            bw.write("Nivel : " + grupo[i].getNivel());
            bw.newLine();
            bw.write(grupo[i].devuelveDatos());
            bw.close();
            fw.close();
        }
    }

    private static Personaje[] ordenaVelocidad(Personaje[] personajes) {
        int n = personajes.length;
        for (int i = 0; i < n - 1; i++) {
            int indiceMinimo = i;

            for (int j = i + 1; j < n; j++) {
                if (personajes[j].getVel() > personajes[indiceMinimo].getVel()) {
                    indiceMinimo = j;
                }
            }

            Personaje temp = personajes[indiceMinimo];
            personajes[indiceMinimo] = personajes[i];
            personajes[i] = temp;
        }
        return personajes;
    }

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
