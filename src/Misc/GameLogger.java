package Misc;

import Characters.Personaje;
import Combat.Combate;

import java.io.*;
import java.util.Scanner;

/**
 * Clse creada en la practica 6 para el uso de ficheros
 * Como crear un personaje en un fichero, ealizar un combate por ficheros etc..
 */

public class GameLogger {

    /**
     * Metodo estático que escribe un personaje en un fichero
     * Se usa un metodo de la clase personaje que obtiene los atributos simples de un personaje
     * @param p
     */

    public static void Escribeenfichero(Personaje p) {
        try {
            FileWriter fw = new FileWriter("./Ficheros/" + p.getNombre() + ".txt");
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write("Nombre:" + p.getNombre());
            bw.newLine();
            bw.write("Clase:" + p.getClase());
            bw.newLine();
            bw.write("Nivel:" + p.getNivel());
            bw.newLine();
            bw.write(p.devuelveDatos());
            bw.close();
            fw.close();
        } catch (IOException ioe) {
            System.err.println(ioe);
        }
    }

    /**
     * Metodo estatico que crea a varios personajes en un fichero
     * @param grupo array de personajes
     * @throws IOException
     */


    public static void ArraysFicheros(Personaje[] grupo) throws IOException {
        ordenaVelocidad(grupo);
        FileWriter fw = new FileWriter("./Ficheros/" + grupo[0].getNombre() + ".txt");
        BufferedWriter bw = new BufferedWriter(fw);
        for (int i = 0; i < grupo.length; i++) {
            bw.write("Nombre:" + grupo[i].getNombre());
            bw.newLine();
            bw.write("Clase:" + grupo[i].getClase());
            bw.newLine();
            bw.write("Nivel:" + grupo[i].getNivel());
            bw.newLine();
            bw.write(grupo[i].devuelveDatos());
            bw.newLine();

        }
        bw.close();
        fw.close();
    }

    /**
     * Metodo privado que se usa para que en el anterior metodo
     * aquel que tenga mas velocidad sea el primero en el fichero
     * y se coloce su nombre
     * @param personajes array de Personajes
     * @return
     */

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

    /**
     * Metodo que asegura al personaje
     * @param paths array de Files
     * @param nombre Strind del nombre de personaje
     * @return
     * @throws IOException
     */

    public static boolean Asegurapersonajes(File[] paths, String nombre) throws IOException {
        boolean ver = true;
        for (int i = 0; i < paths.length; i++) {
            FileReader fr = new FileReader(paths[i]);
            BufferedReader br = new BufferedReader(fr);
            String linea = "";
            String[] campos = new String[2];
            campos = linea.split(":");
            if (campos[0].equals("Nombre") && nombre.equals(campos[1])) {
                ver = false;
            }
        }
        return ver;
    }

    /**
     * Comprobas si su clase es correcta
     * @param paths Array ficheros
     * @param nombre personaje
     * @param clase su clase
     * @return
     * @throws IOException
     */

    public static boolean AseguraClase(File[] paths, String nombre, String clase) throws IOException {
        boolean ver = true;
        for (int i = 0; i < paths.length; i++) {
            FileReader fr = new FileReader(paths[i]);
            BufferedReader br = new BufferedReader(fr);
            String linea = "";
            String[] campos = new String[2];
            campos = linea.split(":");
            if (campos[0].equals("Nombre") && nombre.equals(campos[1])) {
                ver = false;
            }
            if (campos[0].equals("Raza") && clase.equals(campos[1])) {
                ver = false;
            }
        }
        return ver;
    }

    /**
     * Metodo combatir que se mostrara en un fichero
     * @param p1 luchador 1
     * @param p2 luchador 2
     * Ivan esta da mucha pereza ayuda SOS
     * @throws IOException
     */


    public static void Combatir(Personaje p1, Personaje p2) throws IOException {
        PrintWriter pw;
        File fichero = new File("./Ficheros/" + p1.getNombre() + "vs" + p2.getNombre() + ".txt");
        FileWriter fw = new FileWriter(fichero);
        pw = new PrintWriter(fw);
        Personaje primero, segundo;

        if (comprobarPrimero(p1, p2)) {

            primero = p1;
            segundo = p2;

        } else {

            primero = p2;
            segundo = p1;
        }

        //Empieza el combate
        pw.println("Empieza el combate entre " + p1.getNombre() + " y " + p2.getNombre() + ".");
        do {
            muestraCombate(primero, segundo);
            if (!hayMuertos(primero, segundo) && golpeaDosVeces(primero, segundo)) {
                segundo.defender(primero.realizaTurnoALT(fichero), "Fisico"); //(Golpe doble)
                muestraCombate(primero, segundo);
            }
            if (!hayMuertos(primero, segundo)) {
                segundo.defender(primero.realizaTurnoALT(fichero), "Fisico"); //Golpe estándar
                muestraCombate(primero, segundo);
            }
            if (!hayMuertos(primero, segundo)) {
                primero.defender(segundo.realizaTurno(), "Fisico");
                muestraCombate(primero, segundo);
            }

        } while (!p1.estarMuerto() && !p2.estarMuerto());

        if (p1.estarMuerto())
            pw.println("El ganador es " + p2.getNombre());
        else pw.println("El ganador es " + p1.getNombre());
        pw.flush();
        pw.close();
        fw.close();
    }

    /**
     * Metodo  que comprueba quien es mas veloz
     * @param p1 L1
     * @param p2 L2
     * @return El mas rapido
     */

    private static boolean comprobarPrimero(Personaje p1, Personaje p2) {
        return p1.getVel() > p2.getVel();
    }

    /**
     * Metodo que comprueba si se hace un doble turno o nooooo
     * @param p1 L1
     * @param p2 L2
     * @return
     */

    private static boolean golpeaDosVeces(Personaje p1, Personaje p2) {
        return (p1.getVel() > (p2.getVel() * 2));
    }

    /**
     * Han muerto o no? Esa es la cuestion
     * @param p1 L1
     * @param p2 L2
     * @return
     */

    private static boolean hayMuertos(Personaje p1, Personaje p2) {
        return (p1.estarMuerto() || p2.estarMuerto());
    }

    /**
     * Para que se vean los nombres y la vida y se pueda seguir el combate con calma
     * @param p1 L1
     * @param p2 L2
     * @throws IOException
     */

    private static void muestraCombate(Personaje p1, Personaje p2) throws IOException {
        PrintWriter pw;
        FileWriter fw = new FileWriter(new File("./Ficheros/" + p1.getNombre() + "vs" + p2.getNombre() + ".txt"), true);
        pw = new PrintWriter(fw);
        pw.println(p1.getNombre() + ": " + p1.getPv());
        pw.println(p2.getNombre() + ": " + p2.getPv());
    }

    /**
     * Metodo que quien gane el combate sube de nivel LOL
     * @param personajes Array de los lchadores
     * @param ficha Fichero donde esta el Ganador
     * @throws IOException
     */

    public static void SubirnivelCombate(Personaje[] personajes, File ficha) throws IOException {
        if (!ficha.canRead())
            return;
        FileReader fr = new FileReader(ficha);
        BufferedReader br = new BufferedReader(fr);
        br.readLine();
        String a = br.readLine();
        for(int i = 0; i < personajes.length; i++){
            if(personajes[i].getNombre().equals(a.split("El ganador es ")[1]) ){
                System.out.println("Se ha subido de nivel a " + personajes[i].getNombre());
                personajes[i].subirNivel();
            }
        }
        br.close();
        fr.close();
    }

}