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
            if (campos[0].equals("Raza") && clase.equals(campos[1])){
                ver = false;
            }
        }
        return ver;
    }

    public static void CombatirGameLogger(Personaje c1, Personaje c2, File fichero)throws IOException{
        PrintWriter pw;
        FileWriter fw = new FileWriter(fichero);
        pw = new PrintWriter(fw);
        do {
            pw.println("Empieza el combate entre " + c1.getNombre() + " y " + c2.getNombre());
            if (c1.getVel() > c2.getVel()) { //1
                pw.println("El personaje 1 empieza el combate ");
                if (c1.getVel() >= c2.getVel() * 2) {
                    c2.defender(c1.realizaTurnoALT(fichero), "fisico");
                    if (c2.getPv() <= 0) {
                        pw.println("El personaje " + c1.getNombre() + "es el ganador");
                    } else {
                        c2.defender(c1.realizaTurnoALT(fichero), "fisico");
                        if (c2.getPv() <= 0)
                            pw.println("El personaje " + c1.getNombre() + "es el ganador");
                        else
                            pw.println("El combate continua");
                    }
                }
            } else //2
               pw.println("El personaje rival empieza el combate");
            if (c1.getVel() >= c2.getVel() * 2) {
                c1.defender(c2.ataque(), "fisico");
                if (c2.getPv() <= 0) {
                    pw.println("El personaje " + c2.getNombre() + "es el ganador");
                } else {
                    c2.defender(c1.realizaTurnoALT(fichero), "fisico");
                    if (c2.getPv() <= 0)
                        pw.println("El personaje " + c2.getNombre() + "es el ganador");
                    else
                        pw.println("El combate continua");
                }
            }
        } while (!c1.estarMuerto() && c2.estarMuerto());
        pw.flush();
        pw.close();
        fw.close();
    }

    private void nivelCombate(Personaje [] personajes, File ficha) throws IOException {


    }

}