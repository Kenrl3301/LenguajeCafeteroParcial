package co.uniquindio.poo.lenguajecafeteroparcial.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Matricula {

    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private double descuento;
    private double valorFinal;
    private Estudiante theEstudianteMatricula;
    private Curso theCursoMatricula;
    private List<ServicioAdicional> listServiciosAdicionales;

    private Matricula(Builder builder) {
        this.fechaInicio = builder.fechaInicio;
        this.fechaFin = builder.fechaFin;
        this.descuento = builder.descuento;
        this.valorFinal = builder.valorFinal;
        this.theEstudianteMatricula = builder.theEstudianteMatricula;
        this.theCursoMatricula = builder.theCursoMatricula;
        this.listServiciosAdicionales = builder.listServiciosAdicionales;
    }
    public void calcularMatricula() {
        double costoTotal = 0.0;


        if (this.theCursoMatricula instanceof CursoPersonalizado) {

            CursoPersonalizado cursoPers = (CursoPersonalizado) this.theCursoMatricula;

            costoTotal += cursoPers.getProfesor().getTarifaSesion() * cursoPers.getCantidadSesiones();

        } else {

            costoTotal += this.theCursoMatricula.getValorM();
        }
        if (this.listServiciosAdicionales != null) {
            for (ServicioAdicional servicio : this.listServiciosAdicionales) {
                costoTotal += servicio.getPrecio();
            }
        }
        double valorDescuento = costoTotal * (this.descuento / 100.0);

        this.valorFinal = costoTotal - valorDescuento;
    }

    public LocalDate getFechaInicio() { return fechaInicio; }
    public LocalDate getFechaFin() { return fechaFin; }
    public double getDescuento() { return descuento; }
    public double getValorFinal() { return valorFinal; }
    public Estudiante getTheEstudianteMatricula() { return theEstudianteMatricula; }
    public Curso getTheCursoMatricula() { return theCursoMatricula; }
    public List<ServicioAdicional> getListServiciosAdicionales() { return listServiciosAdicionales; }

    public static class Builder {
        private LocalDate fechaInicio;
        private LocalDate fechaFin;
        private double descuento;
        private double valorFinal;
        private Estudiante theEstudianteMatricula;
        private Curso theCursoMatricula;
        private List<ServicioAdicional> listServiciosAdicionales = new ArrayList<>();



        public Builder fechaInicio(LocalDate fechaInicio) {
            this.fechaInicio = fechaInicio;
            return this;
        }

        public Builder fechaFin(LocalDate fechaFin) {
            this.fechaFin = fechaFin;
            return this;
        }

        public Builder descuento(double descuento) {
            this.descuento = descuento;
            return this;
        }

        public Builder valorFinal(double valorFinal) {
            this.valorFinal = valorFinal;
            return this;
        }

        public Builder theEstudianteMatricula(Estudiante theEstudianteMatricula) {
            this.theEstudianteMatricula = theEstudianteMatricula;
            return this;
        }

        public Builder theCursoMatricula(Curso theCursoMatricula) {
            this.theCursoMatricula = theCursoMatricula;
            return this;
        }

        public Builder listServiciosAdicionales(List<ServicioAdicional> servicios) {
            this.listServiciosAdicionales = servicios;
            return this;
        }

        public Matricula build() {
            return new Matricula(this);
        }
    }
}