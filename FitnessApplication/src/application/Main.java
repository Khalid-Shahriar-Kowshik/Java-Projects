package application;

import java.io.IOException;

import fitness.library.DataHandler;
import fitness.library.FitnessCenter;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
	static Stage myStage=null;
	static FitnessCenter adminUser = null;

    @Override
    public void start(Stage primaryStage) {
    	myStage=primaryStage;
        try {
            
            Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
            Scene scene = new Scene(root); 
            primaryStage.setTitle("Fitness Center");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
    	try{
    		adminUser=DataHandler.loadData();
    	}catch(ClassNotFoundException | IOException e){
    	
    		adminUser= new FitnessCenter("Admin Menu");
    	}
    	
        launch(args);
    }
}
