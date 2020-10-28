package gui;

import java.net.URL;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;

import db.DbException;
import gui.listeners.DataChangeListener;
import gui.util.Alerts;
import gui.util.Constraints;
import gui.util.Utils;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.util.Callback;
import model.entities.Department;
import model.entities.Seller;
import model.exceptions.ValidationException;
import model.services.DepartmentService;
import model.services.SellerService;

public class SellerFormController implements Initializable {

	private Seller entity;

	private SellerService service; // classe onde estao guardados os dados

	private DepartmentService departmentService;

	private List<DataChangeListener> dataChangeListeners = new ArrayList<>();

	@FXML
	private TextField txtId;

	@FXML
	private TextField txtName;

	@FXML
	private TextField txtEmail;

	@FXML
	private DatePicker dpBirthDate;

	@FXML
	private TextField txtBaseSalary;

	@FXML
	private ComboBox<Department> comboBoxDepartment;

	@FXML
	private Label labelErrorName;

	@FXML
	private Label labelErrorEmail;

	@FXML
	private Label labelErrorBirthDate;

	@FXML
	private Label labelErrorBaseSalary;

	@FXML
	private Button btSave;

	@FXML
	private Button btCancel;

	private ObservableList<Department> obsList;

	public void setSeller(Seller entity) {
		this.entity = entity;
	}

	public void setServices(SellerService service, DepartmentService departmentService) {
		this.service = service;
		this.departmentService = departmentService;
	}

	public void subscriveDataChangeListener(DataChangeListener listener) {
		dataChangeListeners.add(listener);
	}

	@FXML
	public void onBtSaveAction(ActionEvent event) { // Ao clicar no Save - é preciso instanciar um departamento e
													// guardar na BD
		// System.out.println("onBtSaveAction");
		if (entity == null) {
			throw new IllegalStateException("Entity was null");
		}
		if (service == null) {
			throw new IllegalStateException("Service was null");
		}

		try {
			entity = getFormData(); // metodo que guarda o que está nas txt do form e instancia um departamento
			service.saveOrUpdate(entity); // salvar na BD

			// Dados foram inseridos com sucesso portanto ira ser preciso atualizar a tabela
			notifyDataChaneListeners();

			Utils.currentStage(event).close(); // fechar a janela de formulario
		} catch (ValidationException e) {
			setErrorMessages(e.getErrors());
		} catch (DbException e) {
			Alerts.showAlert("Error saving object", null, e.getMessage(), AlertType.ERROR);
		}
	}

	private void notifyDataChaneListeners() { // quando dados forem alterados - Atualizar tabela
		for (DataChangeListener listener : dataChangeListeners) {
			listener.onDataChanged(); // quando dados forem alterados - Atualizar tabela
		}
	}

	private Seller getFormData() { // metodo que guarda o que está nas txt do form e instancia um departamento
		Seller obj = new Seller(); // instanciar departamento

		ValidationException exception = new ValidationException("Validation error"); // instanciar excepcao - opcional

		obj.setId(Utils.tryParsetoInt(txtId.getText())); // GUARDAR OS DADOS DA TXT NO OBJETO

		if (txtName.getText() == null || txtName.getText().trim().equals("")) { // se for vazio,,,, trim=elimina espaços em branco
			exception.addError("name", "Field can't be empty");
		}
		obj.setName(txtName.getText()); // GUARDAR OS DADOS DA TXT NO OBJETO

		if (txtEmail.getText() == null || txtEmail.getText().trim().equals("")) { // se for vazio,,,, trim=elimina espaços em branco
			exception.addError("email", "Field can't be empty");
		}
		obj.setEmail(txtEmail.getText()); // GUARDAR OS DADOS DA TXT NO OBJETO
		
		//DATE
		if(dpBirthDate.getValue() == null) {
			exception.addError("birthDate", "Field can't be empty");
		}
		else {
			Instant instant = Instant.from(dpBirthDate.getValue().atStartOfDay(ZoneId.systemDefault()));
			obj.setBirthDate(Date.from(instant));
		}
		
		//SALARIO
		if (txtBaseSalary.getText() == null || txtBaseSalary.getText().trim().equals("")) { // se for vazio,,,, trim=elimina espaços em branco
			exception.addError("baseSalary", "Field can't be empty");
		}
		obj.setBaseSalary(Utils.tryParsetoDouble(txtBaseSalary.getText())); // GUARDAR OS DADOS DA TXT NO OBJETO

		if (exception.getErrors().size() > 0) { // se tiver sido adicionado algum erro na coleção
			throw exception; // lançar excepcao
		}
		
		//DEPARTAMENTO
		obj.setDepartment(comboBoxDepartment.getValue());

		return obj; // retornar objeto
	}

	@FXML
	public void onBtCancelAction(ActionEvent event) {
		// System.out.println("onBtCancelAction");
		Utils.currentStage(event).close(); // fechar a janela de formulario
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		initializeNodes(); // chamar definicao de valores para as textFields
	}

	private void initializeNodes() { // definir valores para as textFields
		Constraints.setTextFieldInteger(txtId);
		Constraints.setTextFieldMaxLength(txtName, 70);
		Constraints.setTextFieldDouble(txtBaseSalary);
		Constraints.setTextFieldMaxLength(txtEmail, 60);
		Utils.formatDatePicker(dpBirthDate, "dd/MM/yyyy");

		initializeComboBoxDepartment();
	}

	public void updateFormData() { // atualizar labels quando se edita
		if (entity == null) { // se o entity nao existir - Seller (declarado acima)
			throw new IllegalStateException("Entity was null");
		}

		txtId.setText(String.valueOf(entity.getId())); // definir novo valor na txt
		txtName.setText(entity.getName()); // definir novo valor na txt
		txtEmail.setText(entity.getEmail());

		Locale.setDefault(Locale.US);
		txtBaseSalary.setText(String.format("%.2f", entity.getBaseSalary()));

		if (entity.getBirthDate() != null) {
			dpBirthDate.setValue(LocalDate.ofInstant(entity.getBirthDate().toInstant(), ZoneId.systemDefault()));
		}

		if (entity.getDepartment() == null) { // se for um vendedor novo
			comboBoxDepartment.getSelectionModel().selectFirst();
		} else {
			comboBoxDepartment.setValue(entity.getDepartment());
		}
	}

	public void loadAssociatedObjects() { // carregar objetos associados - Departamento do Seller
		if (departmentService == null) {
			throw new IllegalStateException("DepartmentService was null");
		}
		List<Department> list = departmentService.findAll();
		obsList = FXCollections.observableArrayList(list);
		comboBoxDepartment.setItems(obsList);
	}

	private void setErrorMessages(Map<String, String> errors) { // metodo responsavel por escrever a mensagem de erros nos campos do form
		Set<String> fields = errors.keySet();

		if (fields.contains("name")) {
			labelErrorName.setText(errors.get("name"));
		}
		else {
			labelErrorName.setText(""); //limpar o erro do form
		}
		
		if (fields.contains("email")) {
			labelErrorEmail.setText(errors.get("email"));
		}
		else {
			labelErrorEmail.setText(""); //limpar o erro do form
		}
		
		if (fields.contains("baseSalary")) {
			labelErrorBaseSalary.setText(errors.get("baseSalary"));
		}
		else {
			labelErrorBaseSalary.setText(""); //limpar o erro do form
		}
		
		if (fields.contains("birthDate")) {
			labelErrorBirthDate.setText(errors.get("birthDate"));
		}
		else {
			labelErrorBirthDate.setText(""); //limpar o erro do form
		}
	}

	private void initializeComboBoxDepartment() { // iniciar a ComboBox dos Departamentos
		Callback<ListView<Department>, ListCell<Department>> factory = lv -> new ListCell<Department>() {
			@Override
			protected void updateItem(Department item, boolean empty) {
				super.updateItem(item, empty);
				setText(empty ? "" : item.getName());
			}
		};
		comboBoxDepartment.setCellFactory(factory);
		comboBoxDepartment.setButtonCell(factory.call(null));
	}

}
