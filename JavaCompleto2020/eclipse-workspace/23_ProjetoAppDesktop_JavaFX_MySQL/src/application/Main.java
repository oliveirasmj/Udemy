package application;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.stage.Stage;

public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/MainView.fxml")); //instanciar um objeto do tipo FXMLLoader com caminho da View
			ScrollPane scrollPane = loader.load(); //chamar a View
			//OU
			//ScrollPane scrollPane = FXMLLoader.load(getClass().getResource("/gui/MainView.fxml"));
			
			scrollPane.setFitToHeight(true); //ajustar janela verticalmente
			scrollPane.setFitToWidth(true); //ajustar janela horizontalmente
			
			Scene mainScene = new Scene(scrollPane); //Criar uma cena
			primaryStage.setScene(mainScene); //instanciar a cena do palco com argumento da View
			primaryStage.setTitle("Sample JavaFX application"); //Titulo do palco
			primaryStage.show(); //Mostrar
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
