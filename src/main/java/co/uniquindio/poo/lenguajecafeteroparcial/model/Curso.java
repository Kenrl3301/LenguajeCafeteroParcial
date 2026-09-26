package co.uniquindio.poo.lenguajecafeteroparcial.model;

import java.util.ArrayList;
import java.util.List;

public class Curso {
    private int codigo;
    private String nombre;
    private String descripcion;
    private int duracion;
    private double valorM;
    private Estado estado;
    private Idioma idioma;

    private List<ServicioAdicional> listServicioAdicionalCurso;
    private List<Beneficio> listBeneficioCurso;

    // Se agrega listBeneficioCurso al final del constructor
    public Curso(int codigo, Idioma idioma, Estado estado, double valorM, int duracion, String descripcion, String nombre, List<Beneficio> listBeneficioCurso) {
        this.codigo = codigo;
        this.idioma = idioma;
        this.estado = estado;
        this.valorM = valorM;
        this.duracion = duracion;
        this.descripcion = descripcion;
        this.nombre = nombre;
        this.listBeneficioCurso = listBeneficioCurso;
        this.listServicioAdicionalCurso = new ArrayList<>();
    }

    public Curso(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getDuracion() {
        return duracion;
    }
    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public double getValorM() {
        return valorM;
    }

    public void setValorM(double valorM) {
        this.valorM = valorM;
    }
    public List<Beneficio> getListBeneficioCurso() {
        return listBeneficioCurso;
    }

    public void setListBeneficioCurso(List<Beneficio> listBeneficioCurso) {
        this.listBeneficioCurso = listBeneficioCurso;
    }

    public List<ServicioAdicional> getListServicioAdicionalCurso() {
        return listServicioAdicionalCurso;
    }

    public void setListServicioAdicionalCurso(List<ServicioAdicional> listServicioAdicionalCurso) {
        this.listServicioAdicionalCurso = listServicioAdicionalCurso;
    }

}