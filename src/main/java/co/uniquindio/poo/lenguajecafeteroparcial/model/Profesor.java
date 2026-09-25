package co.uniquindio.poo.lenguajecafeteroparcial.model;

public class Profesor extends Persona {

    private Idioma idioma;
    private int Sesiones;
    private double tarifaSesion;


    public Profesor(String nombre, int edad, String telefono, String correo, double tarifaSesion, int sesiones, Idioma idioma) {
        super(nombre, edad, telefono, correo);
        this.tarifaSesion = tarifaSesion;
        Sesiones = sesiones;
    }





    public Idioma getIdioma() {
        return idioma;
    }

    public void setIdioma(Idioma idioma) {
        this.idioma = idioma;
    }

    public double getTarifaSesion() {
        return tarifaSesion;
    }

    public void setTarifaSesion(double tarifaSesion) {
        this.tarifaSesion = tarifaSesion;
    }

    public int getSesiones() {
        return Sesiones;
    }

    public void setSesiones(int sesiones) {
        Sesiones = sesiones;
    }
}
