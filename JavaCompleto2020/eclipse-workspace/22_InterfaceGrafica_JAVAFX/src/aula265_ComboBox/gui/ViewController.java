package aula265_ComboBox.gui;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import aula265_ComboBox.model.entities.Person;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;

public class ViewController implements Initializable { // implements Initializable - para usar o metodo initialize

	@FXML
	private ComboBox<Person> comboBoxPerson; // referencia para a comboBox do View.xml

	private ObservableList<Person> obsList; // é um tipo especial que implementa um comportamento de interação entre o combobox e a lista
	
	@FXML
	private Button btAll; // referencia para o botão do View.xml

	@Override
	public void initialize(URL url, ResourceBundle rb) { // controlar valores das textFields através da Classe Constraints
		List<Person> list = new ArrayList<>(); // criar lista comum
		list.add(new Person(1, "Maria", "maria@gmail.com"));
		list.add(new Person(2, "Alex", "alex@gmail.com"));
		list.add(new Person(3, "Bob", "bob@gmail.com"));

		obsList = FXCollections.observableArrayList(list); // colocar a lista em obsList(interação entre comboBox e Lista)
		comboBoxPerson.setItems(obsList); // e por fim colocar para a comboBox

		
		//Escolher tipo de informação de Person que se deseja ver - neste caso apenas o nome (sem email e sem id)
		Callback<ListView<Person>, ListCell<Person>> factory = lv -> new ListCell<Person>() {
			@Override
			protected void updateItem(Person item, boolean empty) {
				super.updateItem(item, empty);
				setText(empty ? "" : item.getName());
			}
		};
		comboBoxPerson.setCellFactory(factory);
		comboBoxPerson.setButtonCell(factory.call(null));

	}
	
	@FXML
	public void onComboBoxPersonAction() { //quando seleccionar um item da comboBox imprimi-lo na consola
		Person person = comboBoxPerson.getSelectionModel().getSelectedItem();
		System.out.println(person);
	}
	
	@FXML
	public void onBtAllAction() { //quando clicar em All imprimir toda a lista na consola
		for(Person person : comboBoxPerson.getItems()) {
			System.out.println(person);
		}
	}
}
