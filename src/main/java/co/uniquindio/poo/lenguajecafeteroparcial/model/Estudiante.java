package co.uniquindio.poo.lenguajecafeteroparcial.model;

public class Estudiante extends Persona{
    double fechaIngreso;
    public Estudiante(double fechaIngreso) {
        super(nombre,edad,id,telefono,correo);
        this.fechaIngreso = fechaIngreso;

    }
public double getFechaIngreso() {
        return fechaIngreso;
}
public void setFechaIngreso(double fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
}
}
