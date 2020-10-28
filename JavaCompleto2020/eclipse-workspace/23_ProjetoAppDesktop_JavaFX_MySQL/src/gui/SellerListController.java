package gui;

import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import application.Main;
import db.DbIntegrityException;
import gui.listeners.DataChangeListener;
import gui.util.Alerts;
import gui.util.Utils;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.entities.Seller;
import model.services.DepartmentService;
import model.services.SellerService;

public class SellerListController implements Initializable, DataChangeListener {

	private SellerService service; // classe onde estao guardados os dados

	@FXML
	private TableView<Seller> tableViewSeller;

	@FXML
	private TableColumn<Seller, Integer> tableColumnId;

	@FXML
	private TableColumn<Seller, String> tableColumnName;
	
	@FXML
	private TableColumn<Seller, String> tableColumnEmail;
	
	@FXML
	private TableColumn<Seller, Date> tableColumnBirthDate;
	
	@FXML
	private TableColumn<Seller, Double> tableColumnBaseSalary;

	@FXML
	private TableColumn<Seller, Seller> tableColumnEDIT;

	@FXML
	private TableColumn<Seller, Seller> tableColumnREMOVE;

	@FXML
	private Button btNew;

	private ObservableList<Seller> obsList; // lista onde dados vao ficar carregados na View

	@FXML
	public void onBtNewAction(ActionEvent event) { // recebe um argumento para ter um controlo de quem é o pai e o filho
													// ao abrir nova janela
		// System.out.println("onBtNewAction");
		Stage parentStage = Utils.currentStage(event); // descobrir quem é o pai
		Seller obj = new Seller();
		createDialogForm(obj, "/gui/SellerForm.fxml", parentStage);
	}

	public void setSellerService(SellerService service) {
		this.service = service;
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) { // Método para iniciar um controlador
		initializeNodes(); // metodo auxiliar para iniciar componentes da tabela
	}

	private void initializeNodes() {
		// iniciar o comportamento das colunas
		tableColumnId.setCellValueFactory(new PropertyValueFactory<>("id")); //igual aos campos da classe Seller
		tableColumnName.setCellValueFactory(new PropertyValueFactory<>("name"));
		tableColumnEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
		tableColumnBirthDate.setCellValueFactory(new PropertyValueFactory<>("birthDate"));
		Utils.formatTableColumnDate(tableColumnBirthDate, "dd/MM/yyyy"); //formatar campo da Data
		tableColumnBaseSalary.setCellValueFactory(new PropertyValueFactory<>("baseSalary"));
		Utils.formatTableColumnDouble(tableColumnBaseSalary, 2); //formatar campo do Double

		Stage stage = (Stage) Main.getMainScene().getWindow(); // Captar o palco do Main
		tableViewSeller.prefHeightProperty().bind(stage.heightProperty()); // fazer com que tabela acompanhe a
																				// altura da janela
	}

	public void updateTableView() { // operacao de atualizar dados da tabela
		if (service == null) { // se o service nao existir - SellerService (declarado acima)
			throw new IllegalStateException("Service is null");
		}

		List<Seller> list = service.findAll(); // ir buscar os dados ao Service
		obsList = FXCollections.observableArrayList(list); // colocar os dados em obsList
		tableViewSeller.setItems(obsList); // carregar os items na TableView

		initEditButtons(); // chamar metodo para criar cada botao de editar por linha
		initRemoveButtons();  // chamar metodo para criar cada botao de remover por linha
	}

	private void createDialogForm(Seller obj, String absoluteName, Stage parentStage) { // Criar janela para registar Seller ou Editar
		// recebendo como 3o argumento uma referencia para o stage que criou a janela de
		// dialogo
		// recebendo como 1o elemento o Deparment - caso se clique em editar - se clicar
		// em New passa vazio
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(absoluteName)); // Carregar nova View
			Pane pane = loader.load(); // Criar novo Pane

			SellerFormController controller = loader.getController(); // pegar o controlador do form para poder
																			// alterar os seus valores
			controller.setSeller(obj); // atualizar os dados de Seller
			controller.setServices(new SellerService(), new DepartmentService()); // atualizar os dados de SellerService
			controller.loadAssociatedObjects(); //carregar objetos associados - Departamento do Seller
			controller.subscriveDataChangeListener(this); // quando dados forem alterados - Atualizar tabela
			controller.updateFormData(); // aparecer escrito os valores nas txt do formulario

			// Carregar um novo palco na frente
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Enter Seller data");
			dialogStage.setScene(new Scene(pane));
			dialogStage.setResizable(false); // janela nao redimensionada
			dialogStage.initOwner(parentStage); // dizer quem é o pai da nova janela
			dialogStage.initModality(Modality.WINDOW_MODAL); // janela fica travada enquanto não fechar a nova
			dialogStage.showAndWait();
		} catch (IOException e) {
			e.printStackTrace();
			Alerts.showAlert("IO Exception", "Error loading view", e.getMessage(), AlertType.ERROR);
		}
	}

	@Override
	public void onDataChanged() { // quando dados forem alterados - Atualizar tabela
		updateTableView();
	}

	private void initEditButtons() { // metodo para criar cada botao de editar por linha
		tableColumnEDIT.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue()));
		tableColumnEDIT.setCellFactory(param -> new TableCell<Seller, Seller>() {
			private final Button button = new Button("edit");

			@Override
			protected void updateItem(Seller obj, boolean empty) {
				super.updateItem(obj, empty);
				if (obj == null) {
					setGraphic(null);
					return;
				}
				setGraphic(button);
				button.setOnAction(
						event -> createDialogForm(obj, "/gui/SellerForm.fxml", Utils.currentStage(event)));
			}
		});
	}

	private void initRemoveButtons() { // metodo para criar cada botao de remover por linha
		tableColumnREMOVE.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue()));
		tableColumnREMOVE.setCellFactory(param -> new TableCell<Seller, Seller>() {
			private final Button button = new Button("remove");

			@Override
			protected void updateItem(Seller obj, boolean empty) {
				super.updateItem(obj, empty);
				if (obj == null) {
					setGraphic(null);
					return;
				}
				setGraphic(button);
				button.setOnAction(event -> removeEntity(obj)); // chamar metodo para remover departamento
			}
		});
	}

	protected void removeEntity(Seller obj) { //metodo para remover departamento
		Optional<ButtonType> result = Alerts.showConfirmation("Confirmation", "Are you sure to delete?"); //result = resposta da opcao
		
		if(result.get() == ButtonType.OK) { //se utilizador clicou em OK
			if(service == null) {
				throw new IllegalStateException("Service was null");
			}
			
			try {
				service.remove(obj); //remover
				updateTableView(); //atualizar tabela
			}
			catch (DbIntegrityException e) {
				Alerts.showAlert("Error removing object", null, e.getMessage(), AlertType.ERROR);
			}
		}
	}
}
