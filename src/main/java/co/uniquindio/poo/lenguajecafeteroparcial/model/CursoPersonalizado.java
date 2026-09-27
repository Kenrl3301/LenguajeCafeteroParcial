package co.uniquindio.poo.lenguajecafeteroparcial.model;

import java.util.List;

public class CursoPersonalizado extends Curso {

    private int cantidadSesiones;
    private NivelReferencia nivelReferencia;
    private String objetivos;
    private Profesor profesor;

    public CursoPersonalizado(int codigo, Idioma idioma, Estado estado, double valorM, int duracion, String descripcion, String nombre, int cantidadSesiones, NivelReferencia nivelReferencia, String objetivos, List<Beneficio> ListBeneficioCurso) {
        super(codigo, idioma, estado, valorM, duracion, descripcion, nombre, ListBeneficioCurso);
        this.cantidadSesiones = cantidadSesiones;
        this.nivelReferencia = nivelReferencia;
        this.objetivos = objetivos;
    }

    public int getCantidadSesiones() {
        return cantidadSesiones;
    }

    public void setCantidadSesiones(int cantidadSesiones) {
        this.cantidadSesiones = cantidadSesiones;
    }

    public NivelReferencia getNivelReferencia() {
        return nivelReferencia;
    }

    public void setNivelReferencia(NivelReferencia nivelReferencia) {
        this.nivelReferencia = nivelReferencia;
    }

    public String getObjetivos() {
        return objetivos;
    }

    public void setObjetivos(String objetivos) {
        this.objetivos = objetivos;
    }

    public Profesor getProfesor() { return profesor;
    }

    public void setProfesor(Profesor profesor) { this.profesor = profesor;
    }
}