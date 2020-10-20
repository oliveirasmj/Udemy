package aula266_Containers.gui.util;

import javafx.scene.control.TextField;

public class Constraints { //classe para controlar valores da TextField
	
	public static void setTextFieldInteger(TextField txt) { //verificação de número inteiro
		txt.textProperty().addListener((obs, oldValue, newValue) -> { //listener - é uma funcao que é chamada quando TextField sofrer alterações (referência para o controlador, valor antigo, valor mexido)
			if (newValue != null && !newValue.matches("\\d*")) { //se novo valor nao for nulo e diferente de inteiro
				txt.setText(oldValue); //colocar valor antigo
			}
		});
	}

	public static void setTextFieldMaxLength(TextField txt, int max) { //testar tamanho máximo do valor
		txt.textProperty().addListener((obs, oldValue, newValue) -> {
			if (newValue != null && newValue.length() > max) {
				txt.setText(oldValue);
			}
		});
	}

	public static void setTextFieldDouble(TextField txt) { //verificação de número double
		txt.textProperty().addListener((obs, oldValue, newValue) -> {
			if (newValue != null && !newValue.matches("\\d*([\\.]\\d*)?")) {
				txt.setText(oldValue);
			}
		});
	}
	
}