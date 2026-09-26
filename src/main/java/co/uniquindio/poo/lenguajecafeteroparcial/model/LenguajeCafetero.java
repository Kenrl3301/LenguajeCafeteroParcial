package co.uniquindio.poo.lenguajecafeteroparcial.model;

import java.time.LocalDate;
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


    //------------------------------------------------- CRUD ESTUDIANTE-----------------------------------------------------------------------
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

    public String agregarEstudiante(String nombre, int edad, int id, String telefono, String correo, LocalDate fechaIngreso){
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

    ///  ///////////////////////////////////////////////////////////////////////////////////////////////

    public boolean buscarProfesor(int id){
        boolean encontrado = false;
        for(Persona p : listPersonaLenguajeCafetero){
            if(p.getId()==id){
                if(p instanceof Profesor){
                    encontrado = true;
                }
            }else{
                return encontrado;
            }
        }

        return encontrado;
    }

    public String agregarProfesor(String nombre, int edad, int id, String telefono, String correo, NivelReferencia nivelReferencia, double tarifaSesion, int sesiones, Idioma idioma){
        String mensaje = "";
        if(buscarProfesor(id)){
            mensaje = "Profesor ya se encuentra registrado";
        }else{
            Profesor profesor = new Profesor(nombre, edad, id, telefono, correo, nivelReferencia, tarifaSesion, sesiones, idioma);
            listPersonaLenguajeCafetero.add(profesor);
            mensaje = "El Profesor se registro correctamente";
        }
        return mensaje;
    }

    public boolean buscarServicioAdicional(int codigo){
        boolean encontrado = false;
        for(ServicioAdicional s : listServicioAdicionalLenguajeCafetero){
            if(s.getCodigo()==codigo){
                encontrado = true;
            }else{
                return encontrado;
            }
        }

        return encontrado;
    }

    public String agregarServicioAdicional(int codigo, boolean disponibilidad, double precio, String descripcion, String nombre){
        String mensaje = "";
        if(buscarServicioAdicional(codigo)){
            mensaje = "EL servicio ya se encuentra registado";
        }else{
            ServicioAdicional servicio = new ServicioAdicional(codigo, disponibilidad, precio, descripcion, nombre);
            listServicioAdicionalLenguajeCafetero.add(servicio);
            mensaje = "El Servicio Adicional se registro correctamente";
        }
        return mensaje;
    }


// --------------------------------------------- CRUD MATRICULA ----------------------------------------------------------

    Matricula nuevaMatricula = new Matricula.Builder()
            .fechaInicio()
            .fechaFin()
            .descuento()
            .valorFinal()                 // Todavia faltan metodos pa empezar a hacer esta vaina
            .theEstudianteMatricula()
            .theCursoMatricula()
            .listServiciosAdicionales()
            .build();

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
