package application.controller;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

import application.Main;
import application.model.Profits;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class ProfitController implements Initializable {

	@FXML
	private TextField input_amount;

	@FXML
	private Label total_expense_label;

	@FXML
	private TextField input_frequency;

	@FXML
	private TextField input_name;

	@FXML
	private Button add_button;

	@FXML
	private Button remove_button;

	@FXML
	private TextField inputt_date;

	@FXML
	private Button expense_button;

	@FXML
	private Button profit_button;

	@FXML
	private Button expense_profit_button;

	@FXML
	public TableView<Profits> expense_profit_table;

	@FXML
	private Label username_label;
	
	public TableColumn<Profits, Integer> table_id;
    public TableColumn<Profits, String> table_name;
    public TableColumn<Profits, Integer> table_amount;
    public TableColumn<Profits, String> table_date;
    public TableColumn<Profits, Integer> table_freq;

    private int idCounter = 0;

	@FXML
	void expense_profit_button_clicked(ActionEvent event) {
		try {

			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("../view/main.fxml"));

			Scene scene = new Scene(loader.load());

			Main.stage.setScene(scene);
			Main.stage.show();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@FXML
	void expense_button_clicked(ActionEvent event) {
		try {

			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("../view/expense.fxml"));

			Scene scene = new Scene(loader.load());

			Main.stage.setScene(scene);
			Main.stage.show();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@FXML
	void profit_button_clicked(ActionEvent event) {

	}

	@FXML
	void add_button_clicked(ActionEvent event) {
		//CREATE A DATE LABEL
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");  
				LocalDateTime now = LocalDateTime.now();  
				
				//PARSE DATA FROM INPUT
				int id = idCounter;
				String name = input_name.getText();
				int amount = Integer.parseInt(input_amount.getText());
				String date = dtf.format(now);
				int freq = Integer.parseInt(input_frequency.getText());
				
				Profits profit = new Profits(id, name, amount, date, freq);
				expense_profit_table.getItems().add(profit);
				idCounter++;
				
				//WRITE TO A FILE
				try {
				      FileWriter myWriter = new FileWriter("data.csv", true); 
				      myWriter.write(id + "," + name + "," + amount + "," + date + "," + freq + "\n");
				      myWriter.close();
				    } catch (IOException e) {
				      System.out.println("An error occurred.");
				      e.printStackTrace();
				    }
				
	}

	@FXML
	void remove_button_clicked(ActionEvent event) {

	}

	public void initialize(URL location, ResourceBundle resources) {
		
		//CREATE THE CELLS TO LET DATA INPUT
		table_id.setCellValueFactory(new PropertyValueFactory<>("id"));
		table_name.setCellValueFactory(new PropertyValueFactory<>("name"));
		table_amount.setCellValueFactory(new PropertyValueFactory<>("amount"));
		table_date.setCellValueFactory(new PropertyValueFactory<>("date"));
		table_freq.setCellValueFactory(new PropertyValueFactory<>("freq"));
		expense_profit_table.setItems(observableList);
		
		}
	ObservableList<Profits> observableList = FXCollections.observableArrayList ();
		
	
}

