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

    private static LenguajeCafetero instancia;

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

    public static LenguajeCafetero getInstance(String nit, String url, String correoE, String direccion) {
        if (instancia == null) {
            instancia = new LenguajeCafetero(nit, url, correoE, direccion);
        }
        return instancia;
    }

    // ----------------------------------------------------------------------CRUD CURSO----------------------------------------
    public String agregarCurso(String tipoCurso, int codigo, Idioma idioma, Estado estado,
                               double valorM, int duracion, String descripcion, String nombre,
                               Beneficio beneficio, Profesor profesor) {

        for (Curso c : listCursoLenguajeCafetero) {
            if (c.getCodigo() == codigo) {
                return "El curso con este codigo ya se encuentra registrado";
            }
        }

        if (tipoCurso.equals("Personalizado") && profesor == null) {
            return "Debe seleccionar un profesor para crear un curso personalizado.";
        }


        List<Beneficio> listaBeneficios = new ArrayList<>();
        if (beneficio != null) {
            listaBeneficios.add(beneficio);
        }

        Curso nuevoCurso = null;

        if (tipoCurso.equals("Personalizado")) {

            int sesionesProfe = profesor.getSesiones();
            nuevoCurso = CursoFactory.createCursoPersonalizado(codigo, idioma, estado, valorM, duracion, descripcion, nombre, sesionesProfe, NivelReferencia.A1, "General", profesor, listaBeneficios);
        } else {
            nuevoCurso = CursoFactory.createCursoBasico(tipoCurso, codigo, idioma, estado, valorM, duracion, descripcion, nombre, listaBeneficios);
        }

        if (nuevoCurso != null) {
            listCursoLenguajeCafetero.add(nuevoCurso);
            return "Curso registrado correctamente.";
        }

        return "Error: No se pudo generar el curso. Verifique el tipo seleccionado.";
    }


    public Curso obtenerCurso(String nombreCurso) {
        for (Curso c : listCursoLenguajeCafetero) {
            if (c.getNombre().equals(nombreCurso)) {
                return c;
            }
        }
        return null;
    }

    //------------------------------------------------- CRUD ESTUDIANTE-----------------------------------------------------------------------
    public boolean buscarEstudiante(int id) {
        for (Persona e : listPersonaLenguajeCafetero) {
            if (e.getId() == id && e instanceof Estudiante) {
                return true;
            }
        }
        return false;
    }

    public String agregarEstudiante(String nombre, int edad, int id, String telefono, String correo, LocalDate fechaIngreso) {
        String mensaje = "";
        if (buscarEstudiante(id)) {
            mensaje = "Estudiante ya se encuentra registrado";
        } else {
            Estudiante estudiante = new Estudiante(nombre, edad, id, telefono, correo, fechaIngreso);
            listPersonaLenguajeCafetero.add(estudiante);
            mensaje = "El estudiante se registro correctamente";
        }
        return mensaje;
    }

    public Estudiante obtenerEstudiante(int id) {
        for (Persona p : listPersonaLenguajeCafetero) {
            if (p.getId() == id && p instanceof Estudiante) {
                return (Estudiante) p;
            }
        }
        return null;
    }

    // ---------------------------------------------------CRUD PROFESOR-----------------------------------------------

    public boolean buscarProfesor(int id) {
        for (Persona p : listPersonaLenguajeCafetero) {
            if (p.getId() == id && p instanceof Profesor) {
                return true;
            }
        }
        return false;
    }

    public String agregarProfesor(String nombre, int edad, int id, String telefono, String correo, NivelReferencia nivelReferencia, double tarifaSesion, int sesiones, Idioma idioma) {
        String mensaje = "";
        if (buscarProfesor(id)) {
            mensaje = "Profesor ya se encuentra registrado";
        } else {
            Profesor profesor = new Profesor(nombre, edad, id, telefono, correo, nivelReferencia, tarifaSesion, sesiones, idioma);
            listPersonaLenguajeCafetero.add(profesor);
            mensaje = "El Profesor se registro correctamente";
        }
        return mensaje;
    }

    // --------------------------------------------------------------- CRUD SERVICIO ADICIONAL ------------------------------------------
    public boolean buscarServicioAdicional(int codigo) {
        boolean encontrado = false;
        for (ServicioAdicional s : listServicioAdicionalLenguajeCafetero) {
            if (s.getCodigo() == codigo)
                return encontrado;
        }

        return encontrado;
    }

    public String agregarServicioAdicional(int codigo, boolean disponibilidad, double precio, String descripcion, String nombre) {
        String mensaje = "";
        if (buscarServicioAdicional(codigo)) {
            mensaje = "EL servicio ya se encuentra registado";
        } else {
            ServicioAdicional servicio = new ServicioAdicional(codigo, disponibilidad, precio, descripcion, nombre);
            listServicioAdicionalLenguajeCafetero.add(servicio);
            mensaje = "El Servicio Adicional se registro correctamente";
        }
        return mensaje;
    }


// --------------------------------------------- CRUD MATRICULA ----------------------------------------------------------

    public String agregarMatricula(LocalDate fechaInicio, LocalDate fechaFin, double descuento, double valorFinal,
                                   int idEstudiante, String nombreCurso, List<ServicioAdicional> serviciosSeleccionados) {

        Estudiante estudiante = obtenerEstudiante(idEstudiante);
        if (estudiante == null) {
            return "Estudiante no encontrado";
        }

        Curso curso = obtenerCurso(nombreCurso);
        if (curso == null) {
            return "Curso no encontrado";
        }


        Matricula nuevaMatricula = new Matricula.Builder()
                .fechaInicio(fechaInicio)
                .fechaFin(fechaFin)
                .descuento(descuento)
                .valorFinal(valorFinal)
                .theEstudianteMatricula(estudiante)
                .theCursoMatricula(curso)
                .listServiciosAdicionales(serviciosSeleccionados)
                .build();

        nuevaMatricula.calcularMatricula();

        listMatriculaLenguajeCafetero.add(nuevaMatricula);
        return "Matrícula registrada correctamente. Total $" + nuevaMatricula.getValorFinal();
    }

    public double calcularIngresos(LocalDate fechaInicialBusqueda, LocalDate fechaFinalBusqueda) {
        double totalIngresos = 0.0;
        for (Matricula m : listMatriculaLenguajeCafetero) {
            LocalDate fechaMat = m.getFechaInicio();
            if (!fechaMat.isBefore(fechaInicialBusqueda) && !fechaMat.isAfter(fechaFinalBusqueda)) {
                totalIngresos += m.getValorFinal();
            }
        }
        return totalIngresos;
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

    public List<Curso> getListCursoLenguajeCafetero() {
        return listCursoLenguajeCafetero;
    }

    public List<ServicioAdicional> getListServicioAdicionalLenguajeCafetero() {
        return listServicioAdicionalLenguajeCafetero;
    }

    public List<Persona> getListPersonaLenguajeCafetero() {
        return listPersonaLenguajeCafetero;
    }

}