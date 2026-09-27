package co.uniquindio.poo.lenguajecafeteroparcial.controller;

import co.uniquindio.poo.lenguajecafeteroparcial.model.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class GestionController implements Initializable {


    @FXML private TextField txtNombreEstudiante;
    @FXML private TextField txtEdadEstudiante;
    @FXML private TextField txtIdEstudiante;
    @FXML private TextField txtTelefonoEstudiante;
    @FXML private TextField txtCorreoEstudiante;
    @FXML private DatePicker dpFechaIngreso;


    @FXML private ComboBox<String> cbTipoCurso;
    @FXML private TextField txtCodigoCurso;
    @FXML private TextField txtNombreCurso;
    @FXML private TextField txtValorCurso;
    @FXML private TextField txtDuracionCurso;
    @FXML private TextField txtDescripcionCurso;
    @FXML private ComboBox<Idioma> cbIdiomaCurso;
    @FXML private ComboBox<Estado> cbEstadoCurso;


    @FXML private TextField txtNombreProfesor;
    @FXML private TextField txtEdadProfesor;
    @FXML private TextField txtIdProfesor;
    @FXML private TextField txtTelefonoProfesor;
    @FXML private TextField txtCorreoProfesor;
    @FXML private TextField txtTarifaProfesor;
    @FXML private TextField txtSesionesProfesor;
    @FXML private ComboBox<NivelReferencia> cbNivelReferencia;
    @FXML private ComboBox<Idioma> cbIdiomaProfesor;


    @FXML private TextField txtCodigoServicio;
    @FXML private TextField txtNombreServicio;
    @FXML private TextField txtPrecioServicio;
    @FXML private TextField txtDescripcionServicio;
    @FXML private ComboBox<String> cbDisponibilidadServicio;

    // Instancia de nuestro Singleton (El jefe del backend)
    private LenguajeCafetero admin = LenguajeCafetero.getInstance("12345", "www.lenguajecafetero.com", "info@lenguajecafetero.com", "Armenia, Quindio");


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cbTipoCurso.getItems().addAll("Regular", "Intensivo", "Personalizado");
        cbDisponibilidadServicio.getItems().addAll("Disponible", "No Disponible");

        cbIdiomaCurso.getItems().addAll(Idioma.values());
        cbIdiomaProfesor.getItems().addAll(Idioma.values());
        cbEstadoCurso.getItems().addAll(Estado.values());
        cbNivelReferencia.getItems().addAll(NivelReferencia.values());
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
            mostrarMensaje("Gestión de Estudiantes", "Resultado", msj, Alert.AlertType.INFORMATION);

        } catch (NumberFormatException e) {
            mostrarMensaje("Error", "Datos inválidos", "Revisa que la edad y el ID sean números.", Alert.AlertType.ERROR);
        }
    }

    @FXML
    void registrarCurso(ActionEvent event) {
        try {
            int codigo = Integer.parseInt(txtCodigoCurso.getText());
            String nombre = txtNombreCurso.getText();
            double valor = Double.parseDouble(txtValorCurso.getText());
            int duracion = Integer.parseInt(txtDuracionCurso.getText());
            String descripcion = txtDescripcionCurso.getText();
            Idioma idioma = cbIdiomaCurso.getValue();
            Estado estado = cbEstadoCurso.getValue();

            String msj = admin.agregarCurso(codigo, idioma, estado, valor, duracion, descripcion, nombre, new ArrayList<>());
            mostrarMensaje("Gestión de Cursos", "Resultado", msj, Alert.AlertType.INFORMATION);

        } catch (Exception e) {
            mostrarMensaje("Error", "Faltan datos", "Revisa los campos del curso.", Alert.AlertType.ERROR);
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
            mostrarMensaje("Gestión de Profesores", "Resultado", msj, Alert.AlertType.INFORMATION);

        } catch (Exception e) {
            mostrarMensaje("Error", "Datos de profesor inválidos", "Verifica la tarifa y sesiones.", Alert.AlertType.ERROR);
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
            mostrarMensaje("Gestión de Servicios", "Resultado", msj, Alert.AlertType.INFORMATION);

        } catch (Exception e) {
            mostrarMensaje("Error", "Campos inválidos", "Verifica el precio y código.", Alert.AlertType.ERROR);
        }
    }

    @FXML
    void abrirPanelMatriculas(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/uniquindio/poo/lenguajecafeteroparcial/Matricula.fxml"));
            Parent root = loader.load();

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Panel de Matrículas");
            stage.show();

        } catch (IOException e) {
            mostrarMensaje("Error", "No se pudo abrir", "Verifica la ruta de Matricula.fxml", Alert.AlertType.ERROR);
            e.printStackTrace();
        }
    }

    private void mostrarMensaje(String titulo, String encabezado, String contenido, Alert.AlertType tipo) {
        Alert alerta = new Alert(tipo);
        alerta.setTitle(titulo);
        alerta.setHeaderText(encabezado);
        alerta.setContentText(contenido);
        alerta.showAndWait();
    }
}