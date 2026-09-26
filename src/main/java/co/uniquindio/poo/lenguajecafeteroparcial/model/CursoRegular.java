package co.uniquindio.poo.lenguajecafeteroparcial.model;

import java.util.List;

public class CursoRegular extends Curso {
    public CursoRegular(int codigo, Idioma idioma, Estado estado, double valorM, int duracion, String descripcion, String nombre, List<Beneficio> listBeneficioCurso) {
        super(codigo, idioma, estado, valorM, duracion, descripcion, nombre, listBeneficioCurso);
    }
}