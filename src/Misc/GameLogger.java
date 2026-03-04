package Misc;

import Characters.Personaje;
import Combat.Combate;

import java.io.*;
import java.util.Scanner;

public class GameLogger {

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

        do {
            pw.println("Empieza el combate entre " + p1.getNombre() + " y " + p2.getNombre() + ".");
            muestraCombate(primero, segundo);
            if (!hayMuertos(primero, segundo) && golpeaDosVeces(primero, segundo)) {
                segundo.defender(primero.realizaTurno(), "Fisico"); //(Golpe doble)
                muestraCombate(primero, segundo);
            }
            if (!hayMuertos(primero, segundo)) {
                segundo.defender(primero.realizaTurno(), "Fisico"); //Golpe estándar
                muestraCombate(primero, segundo);
            }
            if (!hayMuertos(primero, segundo)) {
                primero.defender(segundo.realizaTurno(), "Fisico");
                muestraCombate(primero, segundo);
            }

        } while (!p1.estarMuerto() && !p2.estarMuerto());
        pw.flush();
        pw.close();
        fw.close();

        if (p1.estarMuerto())
            pw.println("El ganador es p2");
        else pw.println("El ganador es p1");

    }

    private static boolean comprobarPrimero(Personaje p1, Personaje p2) {
        return p1.getVel() > p2.getVel();
    }

    private static boolean golpeaDosVeces(Personaje p1, Personaje p2) {
        return (p1.getVel() > (p2.getVel() * 2));
    }

    private static boolean hayMuertos(Personaje p1, Personaje p2) {
        return (p1.estarMuerto() || p2.estarMuerto());
    }

    private static void muestraCombate(Personaje p1, Personaje p2) throws IOException{
        PrintWriter pw;
        FileWriter fw = new FileWriter(new File("./Ficheros/" + p1.getNombre() + "vs" + p2.getNombre() + ".txt"), true);
        pw = new PrintWriter(fw);
        pw.println(p1.getNombre() + ": " + p1.getPv());
        pw.println(p2.getNombre() + ": " + p2.getPv());
        pw.flush();
        pw.close();
        fw.close();
    }

    private void nivelCombate(Personaje[] personajes, File ficha) throws IOException {
    }

}