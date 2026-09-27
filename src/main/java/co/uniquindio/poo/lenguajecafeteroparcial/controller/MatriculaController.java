package co.uniquindio.poo.lenguajecafeteroparcial.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class MatriculaController {


    // --- Sección de Nueva Matrícula ---
    @FXML
    private TextField txtIdEstudiante;

    @FXML
    private ComboBox<String> cbCursoMatricula;

    @FXML
    private DatePicker dpFechaInicio;

    @FXML
    private DatePicker dpFechaFin;

    @FXML
    private TextField txtDescuento;

    @FXML
    private ComboBox<String> cbServicios;

    @FXML
    private TextArea txtAreaServiciosSeleccionados;


    // --- Sección de Reporte de Ingresos ---
    @FXML
    private DatePicker dpFechaInicialBusqueda;

    @FXML
    private DatePicker dpFechaFinalBusqueda;

    @FXML
    private TextField txtTotalIngresos;



    @FXML
    void agregarServicioAMatricula(ActionEvent event) {
        // Aquí programaremos la lógica para añadir el servicio elegido al TextArea
    }

    @FXML
    void registrarMatricula(ActionEvent event) {
        // Aquí atraparemos todos los datos y llamaremos a LenguajeCafetero.getInstance().agregarMatricula(...)
    }

    @FXML
    void calcularIngresos(ActionEvent event) {
        // Aquí llamaremos a LenguajeCafetero.getInstance().calcularIngresos(...) y lo mostraremos en txtTotalIngresos
    }

    @FXML
    void volverMenuPrincipal(ActionEvent event) {
        // Aquí programaremos el cambio de pantalla para volver atrás
    }

}