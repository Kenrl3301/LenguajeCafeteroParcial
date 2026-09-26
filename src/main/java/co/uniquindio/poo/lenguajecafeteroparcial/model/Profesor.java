package co.uniquindio.poo.lenguajecafeteroparcial.model;

import java.util.List;

public class Profesor extends Persona {

    private Idioma idioma;
    private int Sesiones;
    private double tarifaSesion;
    private NivelReferencia nivelReferencia;

    private List<Curso> listCursoProfesor;

    public Profesor(String nombre, int edad, int id, String telefono, String correo, NivelReferencia nivelReferencia, double tarifaSesion, int sesiones, Idioma idioma) {
        super(nombre, edad, id, telefono, correo);
        this.nivelReferencia = nivelReferencia;
        this.tarifaSesion = tarifaSesion;
        Sesiones = sesiones;
        this.idioma = idioma;
        this.nivelReferencia = nivelReferencia;
    }



    public NivelReferencia getNivelReferencia() {
        return nivelReferencia;
    }

    public void setNivelReferencia(NivelReferencia nivelReferencia) {
        this.nivelReferencia = nivelReferencia;
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
