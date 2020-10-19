package aula262_Alert.gui;

import aula262_Alert.gui.util.Alerts;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Alert.AlertType;

public class ViewController {
	
	@FXML
	private Button btTeste; //declarar um atributo correspondente à View
	
	@FXML
	public void onBtTestAction() { //metodo para ser chamado quando botao é clicado - eventHandler
		//System.out.println("Click"); //na consola
		Alerts.showAlert("Alert title", "Alert header", "Hello", AlertType.INFORMATION);
	}
}
