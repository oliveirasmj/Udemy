package gui;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;

import db.DbException;
import gui.listeners.DataChangeListener;
import gui.util.Alerts;
import gui.util.Constraints;
import gui.util.Utils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.entities.Seller;
import model.exceptions.ValidationException;
import model.services.SellerService;

public class SellerFormController implements Initializable {

	private Seller entity;

	private SellerService service; // classe onde estao guardados os dados
	
	private List<DataChangeListener> dataChangeListeners = new ArrayList<>();

	@FXML
	private TextField txtId;

	@FXML
	private TextField txtName;

	@FXML
	private Label labelErrorName;

	@FXML
	private Button btSave;

	@FXML
	private Button btCancel;

	public void setSeller(Seller entity) {
		this.entity = entity;
	}

	public void setSellerService(SellerService service) {
		this.service = service;
	}
	
	public void subscriveDataChangeListener(DataChangeListener listener) {
		dataChangeListeners.add(listener);
	}

	@FXML
	public void onBtSaveAction(ActionEvent event) { // Ao clicar no Save - é preciso instanciar um departamento e guardar na BD
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
			
			//Dados foram inseridos com sucesso portanto ira ser preciso atualizar a tabela
			notifyDataChaneListeners();
			
			Utils.currentStage(event).close(); //fechar a janela de formulario
		}
		catch (ValidationException e) {
			setErrorMessages(e.getErrors());
		}
		catch (DbException e) {
			Alerts.showAlert("Error saving object", null, e.getMessage(), AlertType.ERROR);
		}
	}

	private void notifyDataChaneListeners() { //quando dados forem alterados - Atualizar tabela
		for(DataChangeListener listener : dataChangeListeners) {
			listener.onDataChanged(); //quando dados forem alterados - Atualizar tabela
		}
	}

	private Seller getFormData() { // metodo que guarda o que está nas txt do form e instancia um departamento
		Seller obj = new Seller(); // instanciar departamento
		
		ValidationException exception = new ValidationException("Validation error"); //instanciar excepcao - opcional
		
		obj.setId(Utils.tryParsetoInt(txtId.getText())); // GUARDAR OS DADOS DA TXT NO OBJETO
		
		if(txtName.getText() == null || txtName.getText().trim().equals("")) { //se for vazio,,,, trim=elimina espaços em branco
			exception.addError("name", "Field can't be empty");
		}
		
		obj.setName(txtName.getText()); // GUARDAR OS DADOS DA TXT NO OBJETO
		
		if(exception.getErrors().size() > 0) { //se tiver sido adicionado algum erro na coleção
			throw exception; //lançar excepcao
		}

		return obj; // retornar objeto
	}

	@FXML
	public void onBtCancelAction(ActionEvent event) {
		//System.out.println("onBtCancelAction");
		Utils.currentStage(event).close(); //fechar a janela de formulario
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		initializeNodes(); // chamar definicao de valores para as textFields
	}

	private void initializeNodes() { // definir valores para as textFields
		Constraints.setTextFieldInteger(txtId);
		Constraints.setTextFieldMaxLength(txtName, 30);
	}

	public void updateFormData() { // atualizar labels quando se edita
		if (entity == null) { // se o entity nao existir - Seller (declarado acima)
			throw new IllegalStateException("Entity was null");
		}

		txtId.setText(String.valueOf(entity.getId())); // definir novo valor na txt
		txtName.setText(String.valueOf(entity.getName())); // definir novo valor na txt
	}
	
	private void setErrorMessages(Map<String, String> errors) { //metodo responsavel por escrever a mensagem de erros nos campos do form
		Set<String> fields = errors.keySet();
		
		if(fields.contains("name")) {
			labelErrorName.setText(errors.get("name"));
		}
	}

}
