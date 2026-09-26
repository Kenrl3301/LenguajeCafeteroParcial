package co.uniquindio.poo.lenguajecafeteroparcial.model;

import java.util.List;

public class CursoFactory {

    public static Curso createCursoBasico(String tipoCurso, int codigo, Idioma idioma, Estado estado, double valorM, int duracion, String descripcion, String nombre, List<Beneficio> listBeneficioCurso) {


        if (tipoCurso.equals("REGULAR")) {
            return new CursoRegular(codigo, idioma, estado, valorM, duracion, descripcion, nombre, listBeneficioCurso);


        } else if (tipoCurso.equals("INTENSIVO")) {
            return new CursoIntensivo(codigo, idioma, estado, valorM, duracion, descripcion, nombre,listBeneficioCurso );
        }
        return null;
    }

    public static Curso createCursoPersonalizado(int codigo, Idioma idioma, Estado estado, double valorM, int duracion, String descripcion, String nombre, int cantidadSesiones, NivelReferencia nivelReferencia, String objetivos, List<Beneficio> listBeneficioCurso) {

        return new CursoPersonalizado(codigo, idioma, estado, valorM, duracion, descripcion, nombre, cantidadSesiones, nivelReferencia, objetivos, listBeneficioCurso);
    }
}