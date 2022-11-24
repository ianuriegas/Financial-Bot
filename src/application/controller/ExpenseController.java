package application.controller;

import java.io.IOException;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class ExpenseController {

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
	private TableView<?> expense_profit_table;

	@FXML
	private Label username_label;

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

	}

	@FXML
	void remove_button_clicked(ActionEvent event) {

	}

}
