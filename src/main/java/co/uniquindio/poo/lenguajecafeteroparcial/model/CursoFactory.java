package co.uniquindio.poo.lenguajecafeteroparcial.model;

public class CursoFactory {

    public static Curso createCursoBasico(String tipoCurso, int codigo, Idioma idioma, Estado estado, double valorM, int duracion, String descripcion, String nombre) {


        if (tipoCurso.equals("REGULAR")) {
            return new CursoRegular(codigo, idioma, estado, valorM, duracion, descripcion, nombre);


        } else if (tipoCurso.equals("INTENSIVO")) {
            return new CursoIntensivo(codigo, idioma, estado, valorM, duracion, descripcion, nombre);
        }
        return null;
    }

    public static Curso createCursoPersonalizado(int codigo, Idioma idioma, Estado estado, double valorM, int duracion, String descripcion, String nombre, int cantidadSesiones, NivelReferencia nivelReferencia, String objetivos) {

        return new CursoPersonalizado(codigo, idioma, estado, valorM, duracion, descripcion, nombre, cantidadSesiones, nivelReferencia, objetivos);
    }
}