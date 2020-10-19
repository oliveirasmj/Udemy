package aula264_LimitacoesTextField.gui;

import java.net.URL;
import java.util.ResourceBundle;

import aula262_Alert.gui.util.Alerts;
import aula264_LimitacoesTextField.gui.util.Constraints;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ViewController implements Initializable { //implements Initializable - para usar a classe Constraints

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

	@Override
	public void initialize(URL url, ResourceBundle rb) { //controlar valores das textFields
		Constraints.setTextFieldDouble(txtNumber1); //Assim já não deixa digitar letras em txtNumber1
		Constraints.setTextFieldDouble(txtNumber2); //Assim já não deixa digitar letras em txtNumber2
		Constraints.setTextFieldMaxLength(txtNumber1, 12); //Máximo de caracteres de txtNumber1 é 12
		Constraints.setTextFieldMaxLength(txtNumber2, 12); //Máximo de caracteres de txtNumber2 é 12
	}
}
