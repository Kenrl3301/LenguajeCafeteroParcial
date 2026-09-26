package co.uniquindio.poo.lenguajecafeteroparcial.model;

import java.time.LocalDate;

public class Estudiante extends Persona{
    private LocalDate fechaIngreso;
    private Matricula theMatriculaEstudiante;
    private ServicioAdicional theServicioAdicionalPersona;

    public Estudiante(String nombre, int edad, int id, String telefono, String correo, LocalDate fechaIngreso) {
        super(nombre, edad, id, telefono, correo);
        this.fechaIngreso = fechaIngreso;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }
}
