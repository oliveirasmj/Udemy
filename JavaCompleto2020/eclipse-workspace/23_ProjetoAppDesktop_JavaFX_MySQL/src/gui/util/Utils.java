package gui.util;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.stage.Stage;

public class Utils {
	
	public static Stage currentStage(ActionEvent event) { //funcao para acessar o Stage onde o evento está - associado a um botao
		return (Stage) ((Node) event.getSource()).getScene().getWindow();
	}
	
	public static Integer tryParsetoInt(String str) { //Converter String para Inteiro
		try {
			return Integer.parseInt(str); //retornar conversao
		}
		catch (NumberFormatException e) {
			return null; //caso dê erro retornar nulo
		}
	}
}
