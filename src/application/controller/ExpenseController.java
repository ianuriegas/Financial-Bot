package application.controller;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class ExpenseController implements Initializable{

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
	
    @FXML
    private TextField id_input;
	
	public TableColumn<Profits, Integer> table_id;
    public TableColumn<Profits, String> table_name;
    public TableColumn<Profits, Integer> table_amount;
    public TableColumn<Profits, String> table_date;
    public TableColumn<Profits, Integer> table_freq;
	
    private int idCounter = 1;
    
    public int expenseTotal = 0;
    
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

	@FXML
	void add_button_clicked(ActionEvent event) {
		//CREATE A DATE LABEL
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");  
		LocalDateTime now = LocalDateTime.now();  
		
		//PARSE DATA FROM INPUT
		int id = idCounter;
		String name = input_name.getText();
		int amount = Integer.parseInt(input_amount.getText());
		String date = dtf.format(now);
		int freq = Integer.parseInt(input_frequency.getText());
		
		Profits profit = new Profits(id, name, amount, date, freq);
		expense_profit_table.getItems().add(profit);
		expenseTotal += (amount * freq);
		total_expense_label.setText("Total Expense: $" + expenseTotal);
		idCounter++;
		
		//WRITE TO A FILE
		try {
		      FileWriter myWriter = new FileWriter("data_expense.csv", true); 
		      myWriter.write(name + "," + amount + "," + date + "," + freq + "\n");
		      myWriter.close();
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
		
	}

	@FXML
	void remove_button_clicked(ActionEvent event) {
		
		int id = Integer.parseInt(id_input.getText()) - 1;
		// Item here is the table view type:
	    Profits item = expense_profit_table.getItems().get(id);

	    TableColumn col = expense_profit_table.getColumns().get(1);

	    // this gives the value in the selected cell:
	    String data = (String) col.getCellObservableValue(item).getValue();
		System.out.println(data);

		try {
		File myObj = new File("data_expense_backup.csv");
		if (myObj.createNewFile()) {
	        System.out.println("File created: " + myObj.getName());
	      } else {
	        System.out.println("File already exists.");
	      }
	    } catch (IOException e) {
	      System.out.println("An error occurred.");
	      e.printStackTrace();
	    }
		
		
		idCounter = 0;
		Scanner scan = null;
		try {
		scan = new Scanner(new File("data_expense.csv")); //Opens the file.
		while (scan.hasNextLine()) { //Scan until ever line has been extracted
			if (scan.hasNext()) { 
				String line = scan.nextLine();
				String[] data2 = line.split(","); //CSV, use commas to seperate the data and add to data array
				if(!(data2[0].equals(data))) {
					try {
					      FileWriter myWriter = new FileWriter("data_expense_backup.csv", true); 
					      myWriter.write(data2[0] + "," + data2[1] + "," + data2[2] + "," + data2[3] + "\n");
					      myWriter.close();
					    } catch (IOException e) {
					      System.out.println("An error occurred.");
					      e.printStackTrace();
					    }
				}
		}
		
		
	} 
		scan.close();
		
		} catch (IOException e1) { //If error, print error.
			e1.printStackTrace();
		}
		File old = new File("data_expense.csv");
		old.delete();
		File new2 = new File("data_expense_backup.csv");
		new2.renameTo(old);
		
		expense_profit_table.refresh();
		expense_profit_table.getItems().remove(Integer.parseInt(id_input.getText())-1);
	}


	public void initialize(URL location, ResourceBundle resources) {
		table_amount.setStyle("-fx-text-fill: red");
		//CREATE THE CELLS TO LET DATA INPUT
		table_id.setCellValueFactory(new PropertyValueFactory<>("id"));
		table_name.setCellValueFactory(new PropertyValueFactory<>("name"));
		table_amount.setCellValueFactory(new PropertyValueFactory<>("amount"));
		table_date.setCellValueFactory(new PropertyValueFactory<>("date"));
		table_freq.setCellValueFactory(new PropertyValueFactory<>("freq"));
		expense_profit_table.setItems(observableList);
		
		
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
				expenseTotal += (Integer.parseInt(data[1]) * Integer.parseInt(data[3]));
				idCounter++;
				
			}
	}
		scan.close();
	} catch (IOException e1) { //If error, print error.
		e1.printStackTrace();
	}
		
	total_expense_label.setText("Total Expense: $" + expenseTotal);
	total_expense_label.setStyle("-fx-text-fill:RED");
	
	username_label.setText("Welcome: " +WelcomeController.username);
		}
	ObservableList<Profits> observableList = FXCollections.observableArrayList ();
	
	
		
	
}
