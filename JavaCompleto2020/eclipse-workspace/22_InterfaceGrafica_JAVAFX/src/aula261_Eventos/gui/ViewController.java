package aula261_Eventos.gui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class ViewController {
	
	@FXML
	private Button btTeste; //declarar um atributo correspondente à View
	
	@FXML
	public void onBtTestAction() { //metodo para ser chamado quando botao é clicado - eventHandler
		System.out.println("Click");
	}
}
