package co.uniquindio.poo.lenguajecafeteroparcial.model;

public class CursoPersonalizado extends Curso {

    private int cantidadSesiones;
    private NivelReferencia nivelReferencia;
    private String objetivos;

    public CursoPersonalizado(int codigo, Idioma idioma, Estado estado, double valorM, int duracion, String descripcion, String nombre, int cantidadSesiones, NivelReferencia nivelReferencia, String objetivos) {
        super(codigo, idioma, estado, valorM, duracion, descripcion, nombre);
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
}