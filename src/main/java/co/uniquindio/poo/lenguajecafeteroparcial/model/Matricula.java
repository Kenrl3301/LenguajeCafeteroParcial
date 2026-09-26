package co.uniquindio.poo.lenguajecafeteroparcial.model;

import java.util.ArrayList;
import java.util.List;

public class Matricula {

    private double fechaInicio;
    private double fechaFin;
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

    public static class Builder {
        private double fechaInicio;
        private double fechaFin;
        private double descuento;
        private double valorFinal;
        private Estudiante theEstudianteMatricula;
        private Curso theCursoMatricula;
        private List<ServicioAdicional> listServiciosAdicionales = new ArrayList<>();

        public Builder fechaInicio(double fechaInicio) {
            this.fechaInicio = fechaInicio;
            return this;
        }

        public Builder fechaFin(double fechaFin) {
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
            // Aquí puedes agregar tu propia lógica matemática más adelante si lo necesitas
            return new Matricula(this);
        }
    }
}