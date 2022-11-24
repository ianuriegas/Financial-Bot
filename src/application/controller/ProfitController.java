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

public class ProfitController {

    @FXML
    private Label total_expense_label;

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

}
