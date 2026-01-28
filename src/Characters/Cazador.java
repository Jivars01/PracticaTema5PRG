package Characters;

import java.util.Random;

public class Cazador extends Personaje {

    private Mascota mascota;

    public Cazador() {
        super();
    }

    public Cazador(String nombre, int pv, int atq, int arm, int nivel, int vel, int res) {
        super(nombre, pv, atq, arm, nivel, vel, res);
    }

    public int ataque() {
        return (getAtq() + mascota.getAtq()) ;
    }

    public void subirNivel() {
        int c;
        Random a = new Random();
        c = a.nextInt(100);
        if (c < 75 && c > 0) {
            setPv(getPv() + 1);
        }
        c = a.nextInt(100);
        if (c <= 50 && c > 0) {
            setAtq(getAtq() + 2);
        }
        c = a.nextInt(100);
        if (c <= 50 && c > 0) {
            setArm(getArm() + 1);
        }
        c = a.nextInt(100);
        if ((c <= 50 && c > 0)) {
            setRes(getRes() + 1);
        }
        c = a.nextInt(100);
        if ((c <= 50 && c > 0)) {
            setVel(getVel() + 1);
        }
        setNivel(getNivel() + 1);
        mascota.subirNivel();
    }


    public class Mascota extends Personaje {

        private String Rareza;
        private String nombresMascota;

        public Mascota (){
            Rareza = nombresMascota = "";
        }
        public Mascota (String rareza, String nombre){
            setNombresMascota(nombre);
            setRareza(rareza);
        }

        public String seleccionarRareza(String raza) {
            if (raza.equals("Canido")) {

                setPv((int) (Cazador.this.getPv() * 0.20));
                setRes((int) (Cazador.this.getRes() * 0.20));
                setVel((int) (Cazador.this.getVel() * 0.20));
                setAtq((int) (Cazador.this.getAtq() * 0.20));
                setArm((int) (Cazador.this.getArm() * 0.20));

            } else if (raza.equals("Rapaz")) {

                setPv((int) (Cazador.this.getPv() * 0.15));
                setRes((int) (Cazador.this.getRes() * 0.15));
                setVel((int) (Cazador.this.getVel() * 0.30));
                setAtq((int) (Cazador.this.getAtq() * 0.30));
                setArm((int) (Cazador.this.getArm() * 0.15));

            } else if (raza.equals("Felino")) {

                setPv((int) (Cazador.this.getPv() * 0.05));
                setRes((int) (Cazador.this.getRes() * 0.25));
                setVel((int) (Cazador.this.getVel() * 0.35));
                setAtq((int) (Cazador.this.getAtq() * 0.15));
                setArm((int) (Cazador.this.getArm() * 0.05));
            }
            return raza;
        }

        public void subirNivel() {
            int c;
            Random a = new Random();
            switch (Rareza) {
                case "Canido":

                    Cazador.this.setPv((int) (Cazador.this.getPv() * 0.20));
                    Cazador.this.setAtq((int) (Cazador.this.getAtq() * 0.20));
                    Cazador.this.setArm((int) (Cazador.this.getArm() * 0.20));
                    Cazador.this.setRes((int) (Cazador.this.getRes() * 0.20));
                    Cazador.this.setVel((int) (Cazador.this.getVel() * 0.20));
                    setNivel(getNivel() + 1);

                    break;

                case "Felino":

                    Cazador.this.setPv((int) (Cazador.this.getPv() * 0.15));
                    Cazador.this.setAtq((int) (Cazador.this.getAtq() * 0.30));
                    Cazador.this.setArm((int) (Cazador.this.getArm() * 0.15));
                    Cazador.this.setRes((int) (Cazador.this.getRes() * 0.15));
                    Cazador.this.setVel((int) (Cazador.this.getVel() * 0.30));
                    setNivel(getNivel() + 1);
                    setNivel(getNivel() + 1);
                    break;
                case "Rapaz":

                    Cazador.this.setPv((int) (Cazador.this.getPv() * 0.05));
                    Cazador.this.setAtq((int) (Cazador.this.getAtq() * 0.15));
                    Cazador.this.setArm((int) (Cazador.this.getArm() * 0.05));
                    Cazador.this.setRes((int) (Cazador.this.getRes() * 0.25));
                    Cazador.this.setVel((int) (Cazador.this.getVel() * 0.35));
                    setNivel(getNivel() + 1);
                    setNivel(getNivel() + 6);

            }
        }

        public String getRareza() {
            return Rareza;
        }

        public void setRareza(String rareza) {
            if (rareza.equals("Canino") || rareza.equals("Rapaz") || rareza.equals("Felino"))
                this.Rareza = rareza;
            else
                Rareza = rareza;
        }

        public String getNombresMascota() {
            return nombresMascota;
        }

        public void setNombresMascota(String nombresMascota) {
            if (!nombresMascota.isEmpty())
                this.nombresMascota = nombresMascota;
            else this.nombresMascota = "Godofredo";
        }
    }
}
