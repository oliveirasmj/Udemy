package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import gui.util.Alerts;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import model.services.DepartmentService;


public class MainViewController implements Initializable{

	@FXML
	private MenuItem menuItemSeller;
	
	@FXML
	private MenuItem menuItemDepartment;
	
	@FXML
	private MenuItem menuItemAbout;
	
	@FXML
	public void onMenuItemSellerAction() {
		System.out.println("onMenuItemSellerAction"); 
		//Chamar View Seller
	}
	
	@FXML
	public void onMenuItemDepartmentAction() {
		//System.out.println("onMenuItemDepartmentAction");
		loadView2("/gui/DepartmentList.fxml"); //Chamar View DepartmentList
	}
	
	@FXML
	public void onMenuItemAboutAction() {
		//System.out.println("onMenuItemAboutAction");
		loadView("/gui/About.fxml"); //Chamar View About
	}
	
	@Override
	public void initialize(URL uri, ResourceBundle rb) { //Método para iniciar um controlador
		
	}
	
	private synchronized void loadView(String absoluteName) { //Carregar nova View dentro de VBox
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(absoluteName)); //Carregar nova View
			VBox newVBox = loader.load(); //Criar nova VBox
			Scene mainScene = Main.getMainScene(); //Captar Cena principal criada no Main
			
			// Objetivo agora é pegar no MenuBar da MainView.xml que está dentro de: ScroolPane - Content - VBox - Children - MenuBar
			// E inserir os filhos da VBox de About.xml - que são as labels
			
			// Pegar no MenuBar de mainScene para colocar na nova VBox --> o MenuBar está dentro de Content da MainView.xml
			VBox mainVBox = (VBox)((ScrollPane) mainScene.getRoot()).getContent();
			//  mainScene.getRoot()) -> pega primeiro elemento da View que é um ScroolPane com o cast
			// .getContent() -> acessar o content
			
			//Pegar no rimeiro filho de Main.xml - que é o MenuBar
			Node mainMenu = mainVBox.getChildren().get(0);
			
			mainVBox.getChildren().clear(); //Limpar todos os filhos da nova VBox
			mainVBox.getChildren().add(mainMenu); //Adicionar o mainMenu
			mainVBox.getChildren().addAll(newVBox.getChildren()); //Adicionar todos os filhos da nova VBox - labels
			
		} catch (IOException e) {
			Alerts.showAlert("IO Exception", "Error loading view", e.getMessage(), AlertType.ERROR); //Caso haja erro emitir alert
		}
	}
	
	private synchronized void loadView2(String absoluteName) { //Carregar nova View dentro de VBox
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(absoluteName)); //Carregar nova View
			VBox newVBox = loader.load(); //Criar nova VBox
			Scene mainScene = Main.getMainScene(); //Captar Cena principal criada no Main
			
			// Objetivo agora é pegar no MenuBar da MainView.xml que está dentro de: ScroolPane - Content - VBox - Children - MenuBar
			// E inserir os filhos da VBox de About.xml - que são as labels
			
			// Pegar no MenuBar de mainScene para colocar na nova VBox --> o MenuBar está dentro de Content da MainView.xml
			VBox mainVBox = (VBox)((ScrollPane) mainScene.getRoot()).getContent();
			//  mainScene.getRoot()) -> pega primeiro elemento da View que é um ScroolPane com o cast
			// .getContent() -> acessar o content
			
			//Pegar no rimeiro filho de Main.xml - que é o MenuBar
			Node mainMenu = mainVBox.getChildren().get(0);
			
			mainVBox.getChildren().clear(); //Limpar todos os filhos da nova VBox
			mainVBox.getChildren().add(mainMenu); //Adicionar o mainMenu
			mainVBox.getChildren().addAll(newVBox.getChildren()); //Adicionar todos os filhos da nova VBox - labels
			
			//Atualizar os dados na tela da TableView
			DepartmentListController controller = loader.getController(); //criar o DepartmentListController
			controller.setDepartmentService(new DepartmentService()); //definir já quem é o DepartmentService --> private DepartmentService service (esta na classe)
			controller.updateTableView(); //atualizar os dados
			
		} catch (IOException e) {
			Alerts.showAlert("IO Exception", "Error loading view", e.getMessage(), AlertType.ERROR); //Caso haja erro emitir alert
		}
	}
}
