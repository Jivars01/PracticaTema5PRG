package GameMap;

import Characters.Personaje;

import java.util.Random;

/**
 * Esto es una clase trampa en la que se establece un tipo trampa, su daño
 * y la posibilidad  de que esta fracase, pose un string con la categoria de la trampa,
 * un entero para el perjuicio y un double para el fracaso como porcentaje
 *
 * @author Jesús Ivars
 * @version 2.0
 */


public class Trampa {
    private String categoria;
    private int perjuicio;
    private double fracaso;

    /**
     * Constructor por defecto de trampa qe inicia los valores a 0 en
     * los valores numericos y vacio en los strings.
     */

    public Trampa() {
        categoria = "";
        perjuicio = 0;
        fracaso = 0;
    }

    /**
     * Constructor de Trampa por parametros que recibe Un string para
     * la categoria y un int para el perjuicio ademas de establecer
     * un setter para el fracaso
     *
     * @param categoria String que indica que indica el tipo de trampa
     * @param perjuicio Entero que indica el daño que produce
     */

    public Trampa(String categoria, int perjuicio) {
        setCategoria(categoria);
        setPerjuicio(perjuicio);
        setFracaso();
    }

    /**
     * Constructor que recibe por parametro la categoria de la trampa
     * ademas de usar un randomizador que estable el perjuicio entre el 1 y el 20
     * y estable el fracaso por setter
     *
     * @param tipo String para indicar el tipo de trampa
     */

    public Trampa(String tipo) {
        setCategoria(tipo);
        Random r = new Random();
        setPerjuicio(r.nextInt(0, 21));
        setFracaso();
    }


    public Trampa(Trampa copia) {
        this.categoria = copia.categoria;
        this.perjuicio = copia.perjuicio;
        this.fracaso = copia.fracaso;
    }

    /**
     * Es un getter que devuleve el valor de la categoria de la trampa
     *
     * @return devuelve el valor de categoría
     */

    public String getCategoria() {
        return categoria;
    }

    /**
     * Setter de categoria para establecer las limitaciones que tiene la categoria
     * Solo puede ser Pinchos , Brea y Serpientes
     *
     * @param cat es el parametro que le asignamos a la categoria
     */

    public void setCategoria(String cat) {
        switch (cat) {
            case "Pinchos", "Brea", "Serpientes":
                System.out.println("Usted ha seleccionado la trampa " + cat);
                categoria = cat;
                break;
            default:
                System.err.println("La trampa seleccionada no existe, compruebe bien las mayusculas usadas");
        }
    }

    /**
     * Getter de perjuicio para devolver su valor
     *
     * @return devuelve el valor del prejuicio
     */

    public int getPerjuicio() {
        return perjuicio;
    }

    /**
     * Setter perjuicio donde debe ser un numero entre el 5 y el veinte y
     * sino se asignara el valor 5 por defecto
     *
     * @param p para establecre un entero de que valor es el perjuicio
     */

    public void setPerjuicio(int p) {
        if (p >= 5 && p <= 20) {
            perjuicio = p;
        } else {
            System.err.println("El número debe contenerse entre el 5 o el 20");
            p = 5;
            perjuicio = p;
        }
    }

    /**
     * Getter de fracaso que devuelve el valor establecido
     *
     * @return devuelve el valor fracaso
     */

    public double getFracaso() {
        return fracaso;
    }

    /**
     * Setter de fracaso para establecer su valor
     * Usa un random con un numero del 0 al 75
     */

    public void setFracaso() {
        Random b = new Random();
        fracaso = b.nextDouble(75);
    }

    /**
     * Metodo activatrampa para que la trampa se active segun si la activacion es mayor que el fracaso
     * La activacion es un randomizador que va del 0 al 100
     *
     * @return devuelve el valor del perjuicio si el fracaso es mayor y sino devuelve 0.
     */

    public int activatrampa() {
        Random b = new Random();
        int activacion;
        activacion = b.nextInt(100);
        if (activacion < fracaso)
            return perjuicio;
        else return 0;
    }

    /**
     * Metodo modifica fracaso para usarlo en un metodo de la trampa dentro de la clase Area
     *
     * @param mf es el parametro que establece lo que se debe de sumar al fracaso
     * @return el valor de fracaso sumado al parametro
     */

    public double modificafracaso(double mf) {
        fracaso += mf;
        return fracaso;
    }

    public boolean equals(Trampa otro) {
        boolean res = true;
        if (!this.categoria.equals((otro.categoria)))
            res = false;

        if (this.perjuicio != otro.perjuicio)
            res = false;

        if ((this.fracaso != otro.fracaso))
            res = false;

        return res;
    }

    public String toString() {
        String resultado = "La trampa " + getCategoria() + "con las un perjuicio de " + getPerjuicio() + "  con un nivel de fracaso de " + getFracaso() + "esta preparada para usarse";
        return resultado;
    }

}
