package application.controller;


import java.io.File;
import java.io.IOException;

import javax.swing.text.html.ListView;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class WelcomeController {

	
	
	
	
	@FXML
	private Button enter_button;
	
    @FXML
    private TextField username_label;
    
    public static String username;

	@FXML
	void enter_button_clicked(ActionEvent event) {
		try {

			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("../view/main.fxml"));

			Scene scene = new Scene(loader.load());
			//scene.getStylesheets().add("/CSS/mycss.css");
			Main.stage.setScene(scene);
			Main.stage.show();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 try {
		      File myObj = new File("data_expense.csv");
		      if (myObj.createNewFile()) {
		        System.out.println("File created: " + myObj.getName());
		      } else {
		        System.out.println("File already exists.");
		      }
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
		 
		 try {
		      File myObj = new File("data_profits.csv");
		      if (myObj.createNewFile()) {
		        System.out.println("File created: " + myObj.getName());
		      } else {
		        System.out.println("File already exists.");
		      }
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
		 username = username_label.getText();
		
		
		
		
	}

//    @FXML
//    void 2667ff(ActionEvent event) {
//
//    }

}
