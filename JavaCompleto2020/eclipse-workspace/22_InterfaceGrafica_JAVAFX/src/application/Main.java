package application;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

//	@Override
//	public void start(Stage primaryStage) { //Stage(Palco) - criado automaticamente porque é abstrato
//		try {
//			BorderPane root = new BorderPane(); //criar um objeto de painel
//			Scene scene = new Scene(root,400,400); //criar um objeto de cena com o painel como argumento
//			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm()); //usar estilo de css
//			primaryStage.setScene(scene);
//			primaryStage.show(); //mostrar conteudo do palco
//		} catch(Exception e) {
//			e.printStackTrace();
//		}
//	}

	@Override
	public void start(Stage stage) {
		try {
			Parent parent = FXMLLoader.load(getClass().getResource("/gui/View.fxml")); //carregar a tela(chamando o ficheiro View.xml), num objeto tipo Parent 
			Scene scene = new Scene(parent); //criar cena com o View como Cena
			stage.setScene(scene); //Palco vai ter a Cena criada
			stage.show(); //Mostrar palco
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args); // metodo estatico quem tem na aplication para executar a aplicação
	}
}
