package application.controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

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
import javafx.scene.control.cell.PropertyValueFactory;

public class MainController implements Initializable{

    @FXML
    public Label total_expense_label;

    @FXML
    private Button expense_button;

    @FXML
    private Button profit_button;

    @FXML
    private Button expense_profit_button;

    @FXML
    private TableView<Profits> expense_profit_table;
    
	public TableColumn<Profits, Integer> table_id;
    public TableColumn<Profits, String> table_name;
    public TableColumn<Profits, Integer> table_amount;
    public TableColumn<Profits, String> table_date;
    public TableColumn<Profits, Integer> table_freq;
	
    private int idCounter = 1;
    
    private int profitsT;
    private int expT;

    @FXML
    private Label username_label;

    private String name = WelcomeController.username;
    
    
    
    @FXML
    void expense_profit_button_clicked(ActionEvent event) {
    	
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
    	try {

			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("../view/profit.fxml"));

			Scene scene = new Scene(loader.load());
			
			Main.stage.setScene(scene);
			Main.stage.show();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
public void initialize(URL location, ResourceBundle resources) {
		
		//CREATE THE CELLS TO LET DATA INPUT
		table_id.setCellValueFactory(new PropertyValueFactory<>("id"));
		table_name.setCellValueFactory(new PropertyValueFactory<>("name"));
		table_amount.setCellValueFactory(new PropertyValueFactory<>("amount"));
		table_date.setCellValueFactory(new PropertyValueFactory<>("date"));
		table_freq.setCellValueFactory(new PropertyValueFactory<>("freq"));
		expense_profit_table.setItems(observableList);
		
		
		Profits temp = new Profits(000000000 , "EXPENSE", 000000000 , "EXPENSE", 000000000);
		expense_profit_table.getItems().add(temp);
		
		Scanner scan = null;
		//Scan current data:
	try {
		scan = new Scanner(new File("data_expense.csv")); //Opens the file.
		while (scan.hasNextLine()) { //Scan until ever line has been extracted
			if (scan.hasNext()) { 
				String line = scan.nextLine();
				String[] data = line.split(","); //CSV, use commas to seperate the data and add to data array
				//Add answer choices to answer class file
				Profits profit = new Profits(idCounter, data[0], Integer.parseInt(data[1]), data[2], Integer.parseInt(data[3]));
				expense_profit_table.getItems().add(profit);
				expT += (Integer.parseInt(data[1]) * Integer.parseInt(data[3]));
				idCounter++;
				
			}
	}
		scan.close();
	} catch (IOException e1) { //If error, print error.
		e1.printStackTrace();
	}
	
	temp = new Profits(000000000 , "PROFITS", 000000000 , "PROFITS", 000000000);
	expense_profit_table.getItems().add(temp);
	
	//SCAN PROFITS NOW:
	try {
		scan = new Scanner(new File("data_profits.csv")); //Opens the file.
		while (scan.hasNextLine()) { //Scan until ever line has been extracted
			if (scan.hasNext()) { 
				String line = scan.nextLine();
				String[] data = line.split(","); //CSV, use commas to seperate the data and add to data array
				//Add answer choices to answer class file
				Profits profit = new Profits(idCounter, data[0], Integer.parseInt(data[1]), data[2], Integer.parseInt(data[3]));
				expense_profit_table.getItems().add(profit);
				profitsT += (Integer.parseInt(data[1]) * Integer.parseInt(data[3]));
				idCounter++;
				
			}
	}
		scan.close();
	} catch (IOException e1) { //If error, print error.
		e1.printStackTrace();
	}
		
	int totalMon = profitsT-expT;
	if(totalMon <= 0) {
		total_expense_label.setStyle("-fx-text-fill:RED");
	}
	else if(totalMon > 0) {
		total_expense_label.setStyle("-fx-text-fill:GREEN");
	}
	total_expense_label.setText("Total Income: $" + totalMon);
	
	if(name != null && !name.equals("")) {
		username_label.setText("Welcome: " + name);
	}
	else {
		username_label.setText("Welcome!!!");
	}
		}
	ObservableList<Profits> observableList = FXCollections.observableArrayList ();
	
    

}

