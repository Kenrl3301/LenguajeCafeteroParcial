package co.uniquindio.poo.lenguajecafeteroparcial.model;

public class Curso {
    int codigo;
    String nombre;
    String descripcion;
    int duracion;
    double valorM;

    public Curso(int codigo, String nombre, String descripcion, int duracion, double valorM) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.duracion = duracion;
        this.valorM = valorM;
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


}