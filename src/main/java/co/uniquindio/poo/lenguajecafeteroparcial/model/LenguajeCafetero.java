package co.uniquindio.poo.lenguajecafeteroparcial.model;

import java.util.List;

public class LenguajeCafetero {
    private String nit;
    private String direccion;
    private String correoE;
    private String url;

    private List<Matricula> listMatriculaLenguajeCafetero;
    private List<ServicioAdicional> listServicioAdicionalLenguajeCafetero;
    private List<Curso> lisrCursoLenguajeCafetero;
    private List<Persona> listPersonaLenguajeCafetero;


    public LenguajeCafetero(String nit, String url, String correoE, String direccion) {
        this.nit = nit;
        this.url = url;
        this.correoE = correoE;
        this.direccion = direccion;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCorreoE() {
        return correoE;
    }

    public void setCorreoE(String correoE) {
        this.correoE = correoE;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
