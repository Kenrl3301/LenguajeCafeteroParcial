package co.uniquindio.poo.lenguajecafeteroparcial.model;

import java.util.ArrayList;
import java.util.List;

public class LenguajeCafetero {
    private String nit;
    private String direccion;
    private String correoE;
    private String url;

    private List<Matricula> listMatriculaLenguajeCafetero;
    private List<ServicioAdicional> listServicioAdicionalLenguajeCafetero;
    private List<Curso> listCursoLenguajeCafetero;
    private List<Persona> listPersonaLenguajeCafetero;


    public LenguajeCafetero(String nit, String url, String correoE, String direccion) {
        this.nit = nit;
        this.url = url;
        this.correoE = correoE;
        this.direccion = direccion;
        this.listMatriculaLenguajeCafetero = new ArrayList<>();
        this.listServicioAdicionalLenguajeCafetero = new ArrayList<>();
        this.listCursoLenguajeCafetero = new ArrayList<>();
        this.listPersonaLenguajeCafetero = new ArrayList<>();
    }

    public String agregarCurso(int codigo, Idioma idioma, Estado estado, double valorM, int duracion, String descripcion, String nombre){
        String mensaje = "";
        for(Curso c : listCursoLenguajeCafetero){
            if(c.getNombre().equals(nombre)){
                return "El curso con este nombre ya se encuentra registrado";
            }else{
                Curso curso = new Curso(codigo, idioma, estado, valorM, duracion, descripcion, nombre);
                listCursoLenguajeCafetero.add(curso);
                return "Curso registrado correctamente";
            }
        }
        return mensaje;
    }

    public boolean buscarEstudiante(int id){
        boolean encontrado = false;
        for(Persona e : listPersonaLenguajeCafetero){
            if(e.getId() == id){
                return encontrado;
            }else{
                encontrado = true;
            }
        }
        return encontrado;
    }

    public String agregarEstudiante(String nombre, int edad, int id, String telefono, String correo, double fechaIngreso){
        String mensaje = "";
        if(buscarEstudiante(id)){
            mensaje = "Estudiante ya se encuentra registrado";
        }else{
            Estudiante estudiante = new Estudiante(nombre, edad, id, telefono, correo, fechaIngreso);
            listPersonaLenguajeCafetero.add(estudiante);
            mensaje = "El estudiante se registro correctamente";
        }
        return mensaje;
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
