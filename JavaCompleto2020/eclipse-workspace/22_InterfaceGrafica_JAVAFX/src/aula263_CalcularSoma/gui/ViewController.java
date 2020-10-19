package aula263_CalcularSoma.gui;

import aula262_Alert.gui.util.Alerts;
import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ViewController {

	@FXML
	private TextField txtNumber1;

	@FXML
	private TextField txtNumber2;

	@FXML
	private Label labelResult;

	@FXML
	private Button btSum;

	@FXML
	public void onBtSumAction() { // metodo para ser chamado quando botao é clicado
		
		try {
			double number1 = Double.parseDouble(txtNumber1.getText()); // capturar valor da caixa1
			double number2 = Double.parseDouble(txtNumber2.getText()); // capturar valor da caixa2
			double sum = number1 + number2;
			labelResult.setText(String.format("%.2f", sum)); // apresentar a soma na label
			
		} catch (NumberFormatException e) { //caso introduza uma letra
			Alerts.showAlert("Error", "Parse error", e.getMessage(), AlertType.ERROR);
		}
	}
}
