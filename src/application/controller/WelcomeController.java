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

public class WelcomeController {

	
	
	
	
	@FXML
	private Button enter_button;

	@FXML
	void enter_button_clicked(ActionEvent event) {
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
		
		 try {
		      File myObj = new File("data.csv");
		      if (myObj.createNewFile()) {
		        System.out.println("File created: " + myObj.getName());
		      } else {
		        System.out.println("File already exists.");
		      }
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
		
		
		
		
		
	}

//    @FXML
//    void 2667ff(ActionEvent event) {
//
//    }

}
