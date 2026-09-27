module co.uniquindio.poo.lenguajecafeteroparcial {
    requires javafx.controls;
    requires javafx.fxml;

    // Permisos para el paquete principal
    opens co.uniquindio.poo.lenguajecafeteroparcial to javafx.fxml;
    exports co.uniquindio.poo.lenguajecafeteroparcial;

    // Permisos obligatorios para que JavaFX pueda leer tus controladores
    opens co.uniquindio.poo.lenguajecafeteroparcial.controller to javafx.fxml;
    exports co.uniquindio.poo.lenguajecafeteroparcial.controller;
}