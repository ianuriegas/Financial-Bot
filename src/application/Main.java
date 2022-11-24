/** 
 * 
 * The goal of this lab is to create a javafx program that outputs a gui
 * of the info from trivia csv
 * 
 * @author Ian Uriegas (NSW307)
 * UTSA CS 3443 - Lab 4
 * Fall 2022
 */

package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class Main extends Application {
	public static Stage stage;
    @Override
    public void start(Stage primaryStage) {

    	stage = primaryStage;

		try {

			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("view/welcome.fxml"));

			AnchorPane layout = (AnchorPane) loader.load();

			Scene scene = new Scene(layout);

			primaryStage.setScene(scene);
			primaryStage.show();
			
			
		} catch(Exception e) {
			primaryStage.show();
			e.printStackTrace();
		}
		

    }

    public static void main(String[] args) {
        launch(args);
    }
}