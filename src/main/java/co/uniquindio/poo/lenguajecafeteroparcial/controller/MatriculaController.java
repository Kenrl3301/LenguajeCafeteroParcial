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
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class MatriculaController implements Initializable {

    @FXML private TextField txtIdEstudiante;
    @FXML private ComboBox<Curso> cbCursoMatricula;
    @FXML private DatePicker dpFechaInicio;
    @FXML private DatePicker dpFechaFin;
    @FXML private TextField txtDescuento;

    @FXML private ComboBox<ServicioAdicional> cbServicios;
    @FXML private TextArea txtAreaServiciosSeleccionados;

    @FXML private DatePicker dpFechaInicialBusqueda;
    @FXML private DatePicker dpFechaFinalBusqueda;
    @FXML private TextField txtTotalIngresos;

    private LenguajeCafetero admin = LenguajeCafetero.getInstance("12345", "www.lenguajecafetero.com", "info@lenguajecafetero.com", "Armenia, Quindio");
    private List<ServicioAdicional> serviciosSeleccionadosTemp = new ArrayList<>();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // NOTA: Asegúrate de tener los getters para estas listas en LenguajeCafetero.java
        if (admin.getListCursoLenguajeCafetero() != null) {
            cbCursoMatricula.getItems().addAll(admin.getListCursoLenguajeCafetero());
        }
        if (admin.getListServicioAdicionalLenguajeCafetero() != null) {
            cbServicios.getItems().addAll(admin.getListServicioAdicionalLenguajeCafetero());
        }
    }

    @FXML
    void agregarServicioAMatricula(ActionEvent event) {
        ServicioAdicional servicio = cbServicios.getValue();
        if (servicio != null && !serviciosSeleccionadosTemp.contains(servicio)) {
            serviciosSeleccionadosTemp.add(servicio);
            txtAreaServiciosSeleccionados.appendText("- " + servicio.getNombre() + " ($" + servicio.getPrecio() + ")\n");
        }
    }

    @FXML
    void registrarMatricula(ActionEvent event) {
        try {
            int idEstudiante = Integer.parseInt(txtIdEstudiante.getText());
            Curso curso = cbCursoMatricula.getValue();
            LocalDate fechaInicio = dpFechaInicio.getValue();
            LocalDate fechaFin = dpFechaFin.getValue();
            double descuento = txtDescuento.getText().isEmpty() ? 0.0 : Double.parseDouble(txtDescuento.getText());

            if (curso == null || fechaInicio == null || fechaFin == null) {
                mostrarMensaje("Campos incompletos", "Por favor selecciona un curso y las fechas.", Alert.AlertType.WARNING);
                return;
            }

            // El valor final inicial se manda en 0.0 porque se recalcula por dentro con Builder
            String msj = admin.agregarMatricula(fechaInicio, fechaFin, descuento, 0.0, idEstudiante, curso.getNombre(), new ArrayList<>(serviciosSeleccionadosTemp));
            mostrarMensaje("Matrícula", msj, Alert.AlertType.INFORMATION);

            // Limpiar la vista temporal
            serviciosSeleccionadosTemp.clear();
            txtAreaServiciosSeleccionados.clear();

        } catch (Exception e) {
            mostrarMensaje("Error", "Verifica el formato del ID o el descuento.", Alert.AlertType.ERROR);
        }
    }

    @FXML
    void calcularIngresos(ActionEvent event) {
        try {
            LocalDate inicio = dpFechaInicialBusqueda.getValue();
            LocalDate fin = dpFechaFinalBusqueda.getValue();

            if (inicio != null && fin != null) {
                double total = admin.calcularIngresos(inicio, fin);
                txtTotalIngresos.setText(String.format("$%.2f", total));
            } else {
                mostrarMensaje("Fechas faltantes", "Selecciona ambas fechas para consultar.", Alert.AlertType.WARNING);
            }
        } catch (Exception e) {
            mostrarMensaje("Error", "Error al calcular ingresos.", Alert.AlertType.ERROR);
        }
    }

    @FXML
    void volverMenuPrincipal(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/uniquindio/poo/lenguajecafeteroparcial/Gestion.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Gestión Principal");
            stage.show();
        } catch (IOException e) {
            mostrarMensaje("Error", "No se pudo regresar al menú principal.", Alert.AlertType.ERROR);
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