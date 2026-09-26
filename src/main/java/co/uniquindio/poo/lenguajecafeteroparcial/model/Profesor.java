package co.uniquindio.poo.lenguajecafeteroparcial.model;

public class Profesor extends Persona {

    private Idioma idioma;
    private int Sesiones;
    private double tarifaSesion;


    public Profesor(String nombre, int edad, int id, String telefono, String correo, Idioma idioma, double tarifaSesion, int sesiones) {
        super(nombre, edad, id, telefono, correo);
        this.idioma = idioma;
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
