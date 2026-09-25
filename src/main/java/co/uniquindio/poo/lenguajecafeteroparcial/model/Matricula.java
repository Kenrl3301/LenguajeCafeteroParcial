package co.uniquindio.poo.lenguajecafeteroparcial.model;

public class Matricula {

    private double fechaInicio;
    private double fechaFin;
    private double descuento;
    private double valorFinal;

    public Matricula(double fechaInicio, double fechaFin, double descuento, double valorFinal){
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.descuento = descuento;
        this.valorFinal = valorFinal;
    }



    public double getValorFinal() {
        return valorFinal;
    }

    public void setValorFinal(double valorFinal) {
        this.valorFinal = valorFinal;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public double getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(double fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public double getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(double fechaFin) {
        this.fechaFin = fechaFin;
    }
}
