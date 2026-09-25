module co.uniquindio.poo.lenguajecafeteroparcial {
    requires javafx.controls;
    requires javafx.fxml;


    opens co.uniquindio.poo.lenguajecafeteroparcial to javafx.fxml;
    exports co.uniquindio.poo.lenguajecafeteroparcial;
}