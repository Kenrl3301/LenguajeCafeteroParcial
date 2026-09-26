package co.uniquindio.poo.lenguajecafeteroparcial.model;

import java.util.ArrayList;
import java.util.List;

public class ServicioAdicional {

    private int codigo;
    private String nombre;
    private String descripcion;
    private double precio;
    private boolean disponibilidad;

    private List<Estudiante> listEstudianteServicioAdicional;
    private List<Curso> listCursoServicioAdicional;

    public ServicioAdicional(int codigo, boolean disponibilidad, double precio, String descripcion, String nombre) {
        this.codigo = codigo;
        this.disponibilidad = disponibilidad;
        this.precio = precio;
        this.descripcion = descripcion;
        this.nombre = nombre;
        this.listEstudianteServicioAdicional = new ArrayList<>();
        this.listCursoServicioAdicional = new ArrayList<>();
    }


    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public boolean isDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
