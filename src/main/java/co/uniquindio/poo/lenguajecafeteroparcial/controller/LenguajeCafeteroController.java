package co.uniquindio.poo.lenguajecafeteroparcial.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class LenguajeCafeteroController {


    @FXML
    private TextField txtNombreEstudiante;
    @FXML
    private TextField txtEdadEstudiante;
    @FXML
    private TextField txtIdEstudiante;
    @FXML
    private TextField txtTelefonoEstudiante;
    @FXML
    private TextField txtCorreoEstudiante;
    @FXML
    private DatePicker dpFechaIngreso;



    @FXML
    private ComboBox<String> cbTipoCurso;
    @FXML
    private TextField txtCodigoCurso;
    @FXML
    private TextField txtNombreCurso;
    @FXML
    private TextField txtValorCurso;
    @FXML
    private TextField txtDuracionCurso;
    @FXML
    private TextField txtDescripcionCurso;
    @FXML
    private ComboBox<String> cbIdiomaCurso;
    @FXML
    private ComboBox<String> cbEstadoCurso;



    @FXML
    private TextField txtNombreProfesor;
    @FXML
    private TextField txtEdadProfesor;
    @FXML
    private TextField txtIdProfesor;
    @FXML
    private TextField txtTelefonoProfesor;
    @FXML
    private TextField txtCorreoProfesor;
    @FXML
    private TextField txtTarifaProfesor;
    @FXML
    private TextField txtSesionesProfesor;
    @FXML
    private ComboBox<String> cbNivelReferencia;
    @FXML
    private ComboBox<String> cbIdiomaProfesor;



    @FXML
    private TextField txtCodigoServicio;
    @FXML
    private TextField txtNombreServicio;
    @FXML
    private TextField txtPrecioServicio;
    @FXML
    private TextField txtDescripcionServicio;
    @FXML
    private ComboBox<String> cbDisponibilidadServicio;




    @FXML
    void registrarEstudiante(ActionEvent event) {
        // Lógica para enviar los datos a LenguajeCafetero.getInstance().agregarEstudiante(...)
    }

    @FXML
    void registrarCurso(ActionEvent event) {
        // Lógica para enviar los datos a LenguajeCafetero.getInstance().agregarCurso(...)
    }

    @FXML
    void registrarProfesor(ActionEvent event) {
        // Lógica para enviar los datos a LenguajeCafetero.getInstance().agregarProfesor(...)
    }

    @FXML
    void registrarServicio(ActionEvent event) {
        // Lógica para enviar los datos a LenguajeCafetero.getInstance().agregarServicioAdicional(...)
    }

    @FXML
    void abrirPanelMatriculas(ActionEvent event) {
        // Lógica para cerrar esta ventana y abrir el FXML de Matricula
    }

}