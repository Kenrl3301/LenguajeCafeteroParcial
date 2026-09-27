package co.uniquindio.poo.lenguajecafeteroparcial.controller;

import co.uniquindio.poo.lenguajecafeteroparcial.model.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class GestionController implements Initializable {

    // --- ESTUDIANTES ---
    @FXML private TextField txtNombreEstudiante, txtEdadEstudiante, txtIdEstudiante, txtTelefonoEstudiante, txtCorreoEstudiante;
    @FXML private DatePicker dpFechaIngreso;

    // --- CURSOS ---
    @FXML private ComboBox<String> cbTipoCurso;
    @FXML private TextField txtCodigoCurso, txtNombreCurso, txtValorCurso, txtDuracionCurso, txtDescripcionCurso;
    @FXML private ComboBox<Idioma> cbIdiomaCurso;
    @FXML private ComboBox<Estado> cbEstadoCurso;

    @FXML private ComboBox<Beneficio> cbBeneficiosCurso;
    @FXML private ComboBox<Profesor> cbProfesorCurso;

    // --- PROFESORES ---
    @FXML private TextField txtNombreProfesor, txtEdadProfesor, txtIdProfesor, txtTelefonoProfesor, txtCorreoProfesor, txtTarifaProfesor, txtSesionesProfesor;
    @FXML private ComboBox<NivelReferencia> cbNivelReferencia;
    @FXML private ComboBox<Idioma> cbIdiomaProfesor;

    // --- SERVICIOS ---
    @FXML private TextField txtCodigoServicio, txtNombreServicio, txtPrecioServicio, txtDescripcionServicio;
    @FXML private ComboBox<String> cbDisponibilidadServicio;

    private LenguajeCafetero admin = LenguajeCafetero.getInstance("12345", "www.lenguajecafetero.com", "info@lenguajecafetero.com", "Armenia, Quindio");

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cbTipoCurso.getItems().addAll("Regular", "Intensivo", "Personalizado");
        cbDisponibilidadServicio.getItems().addAll("Disponible", "No Disponible");

        cbIdiomaCurso.getItems().addAll(Idioma.values());
        cbIdiomaProfesor.getItems().addAll(Idioma.values());
        cbEstadoCurso.getItems().addAll(Estado.values());
        cbNivelReferencia.getItems().addAll(NivelReferencia.values());

        // Cargamos las opciones del Enum Beneficio en el ComboBox
        cbBeneficiosCurso.getItems().addAll(Beneficio.values());

        cargarProfesoresEnComboBox();
    }

    private void cargarProfesoresEnComboBox() {
        cbProfesorCurso.getItems().clear();
        if (admin.getListPersonaLenguajeCafetero() != null) {
            for (Persona p : admin.getListPersonaLenguajeCafetero()) {
                if (p instanceof Profesor) {
                    cbProfesorCurso.getItems().add((Profesor) p);
                }
            }
        }
    }

    @FXML
    void registrarEstudiante(ActionEvent event) {
        try {
            String nombre = txtNombreEstudiante.getText();
            int edad = Integer.parseInt(txtEdadEstudiante.getText());
            int id = Integer.parseInt(txtIdEstudiante.getText());
            String telefono = txtTelefonoEstudiante.getText();
            String correo = txtCorreoEstudiante.getText();
            LocalDate fecha = dpFechaIngreso.getValue();

            String msj = admin.agregarEstudiante(nombre, edad, id, telefono, correo, fecha);
            mostrarMensaje("Estudiantes", msj, Alert.AlertType.INFORMATION);
        } catch (Exception e) {
            mostrarMensaje("Error", "Verifica que los datos numéricos y fechas sean correctos.", Alert.AlertType.ERROR);
        }
    }

    @FXML
    void registrarCurso(ActionEvent event) {
        try {
            String tipo = cbTipoCurso.getValue();
            int codigo = Integer.parseInt(txtCodigoCurso.getText());
            String nombre = txtNombreCurso.getText();
            double valor = Double.parseDouble(txtValorCurso.getText());
            int duracion = Integer.parseInt(txtDuracionCurso.getText());
            String descripcion = txtDescripcionCurso.getText();
            Idioma idioma = cbIdiomaCurso.getValue();
            Estado estado = cbEstadoCurso.getValue();

            Beneficio beneficioSeleccionado = cbBeneficiosCurso.getValue();
            Profesor profe = cbProfesorCurso.getValue();

            if (tipo == null || idioma == null || estado == null) {
                mostrarMensaje("Error", "Debe seleccionar tipo de curso, idioma y estado.", Alert.AlertType.WARNING);
                return;
            }

            String msj = admin.agregarCurso(tipo, codigo, idioma, estado, valor, duracion, descripcion, nombre, beneficioSeleccionado, profe);
            mostrarMensaje("Cursos", msj, Alert.AlertType.INFORMATION);
        } catch (Exception e) {
            mostrarMensaje("Error", "Verifica los datos del curso.", Alert.AlertType.ERROR);
        }
    }

    @FXML
    void registrarProfesor(ActionEvent event) {
        try {
            String nombre = txtNombreProfesor.getText();
            int edad = Integer.parseInt(txtEdadProfesor.getText());
            int id = Integer.parseInt(txtIdProfesor.getText());
            String telefono = txtTelefonoProfesor.getText();
            String correo = txtCorreoProfesor.getText();
            double tarifa = Double.parseDouble(txtTarifaProfesor.getText());
            int sesiones = Integer.parseInt(txtSesionesProfesor.getText());
            NivelReferencia nivel = cbNivelReferencia.getValue();
            Idioma idioma = cbIdiomaProfesor.getValue();

            String msj = admin.agregarProfesor(nombre, edad, id, telefono, correo, nivel, tarifa, sesiones, idioma);
            mostrarMensaje("Profesores", msj, Alert.AlertType.INFORMATION);

            cargarProfesoresEnComboBox();
        } catch (Exception e) {
            mostrarMensaje("Error", "Verifica los datos del profesor.", Alert.AlertType.ERROR);
        }
    }

    @FXML
    void registrarServicio(ActionEvent event) {
        try {
            int codigo = Integer.parseInt(txtCodigoServicio.getText());
            String nombre = txtNombreServicio.getText();
            double precio = Double.parseDouble(txtPrecioServicio.getText());
            String descripcion = txtDescripcionServicio.getText();
            boolean disponible = cbDisponibilidadServicio.getValue().equals("Disponible");

            String msj = admin.agregarServicioAdicional(codigo, disponible, precio, descripcion, nombre);
            mostrarMensaje("Servicios", msj, Alert.AlertType.INFORMATION);
        } catch (Exception e) {
            mostrarMensaje("Error", "Verifica los datos del servicio.", Alert.AlertType.ERROR);
        }
    }

    @FXML
    void abrirPanelMatriculas(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/uniquindio/poo/lenguajecafeteroparcial/Matricula.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Gestión de Matrículas");
            stage.show();
        } catch (IOException e) {
            mostrarMensaje("Error", "No se pudo cargar la ventana de matrículas.", Alert.AlertType.ERROR);
            e.printStackTrace();
        }
    }

    private void mostrarMensaje(String titulo, String contenido, Alert.AlertType tipo) {
        Alert alerta = new Alert(tipo);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(contenido);
        alerta.showAndWait();
    }
}