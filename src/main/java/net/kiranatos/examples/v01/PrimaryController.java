package net.kiranatos.examples.v01;

import java.io.IOException;
import javafx.fxml.FXML;

public class PrimaryController {

    @FXML
    private void switchToSecondary() throws IOException {
        Option1.setRoot("secondary");
    }
}
