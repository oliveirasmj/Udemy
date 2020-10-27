package gui;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import application.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.entities.Department;
import model.services.DepartmentService;

public class DepartmentListController implements Initializable{

	private DepartmentService service; //onde estao guardados os dados
	
	@FXML
	private TableView<Department> tableViewDepartment;
	
	@FXML
	private TableColumn<Department, Integer> tableColumnId;
	
	@FXML
	private TableColumn<Department, String> tableColumnName;
	
	@FXML
	private Button btNew;
	
	private ObservableList<Department> obsList; //lista onde dados vao ficar carregados na View
	
	@FXML
	public void onBtNewAction() {
		System.out.println("onBtNewAction");
	}
	
	public void setDepartmentService(DepartmentService service) {
		this.service = service;
	}
	
	@Override
	public void initialize(URL url, ResourceBundle rb) { //Método para iniciar um controlador
		initializeNodes(); //metodo auxiliar para iniciar componentes da tabela
	}

	private void initializeNodes() {
		//iniciar o comportamento das colunas
		tableColumnId.setCellValueFactory(new PropertyValueFactory<>("id"));
		tableColumnName.setCellValueFactory(new PropertyValueFactory<>("name"));
		
		Stage stage = (Stage) Main.getMainScene().getWindow(); //Captar o palco do Main
		tableViewDepartment.prefHeightProperty().bind(stage.heightProperty()); //fazer com que tabela acompanhe a altura da janela
	}
	
	public void updateTableView() { //operacao de atualizar dados da tabela
		if(service == null) { //se o service nao existir - DepartmentService (declarado acima)
			throw new IllegalStateException("Service is null");
		}
		
		List<Department> list = service.findAll(); //ir buscar os dados ao Service
		obsList = FXCollections.observableArrayList(list); //colocar os dados em obsList
		tableViewDepartment.setItems(obsList); //carregar os items na TableView
	}
}
