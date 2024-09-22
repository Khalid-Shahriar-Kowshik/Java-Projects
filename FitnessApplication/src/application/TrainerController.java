package application;

import java.io.IOException;
import java.util.ArrayList;

import fitness.library.DataHandler;
import fitness.library.InvalidUserException;
import fitness.library.Trainee;
import fitness.library.Trainer;
import fitness.library.WorkOut;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TrainerController {

    private Stage stage;
    private Scene scene;
    private Parent root;
    
    @FXML
    private ListView<String> traineeList;
    @FXML
    public TextField traineeId;
    @FXML
    private TextField workoutName,workoutType;
    @FXML
    private Label rankLabel;
    @FXML
    private Label workoutAdd;
    
    public void logout(ActionEvent e) throws IOException {
        
        root = FXMLLoader.load(getClass().getResource("login.fxml"));
        stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    public void viewListOfTrainees(ActionEvent e) {
		ArrayList<Trainee> allTrainees= LoginController.currentTrainer.getTrainees();
  
	    for (Trainee trainee : allTrainees) {
	    	traineeList.getItems().addAll("------------------\n");
	        traineeList.getItems().addAll(trainee.toString());
	        traineeList.getItems().addAll("------------------\n");
	    }
	    
	   
	
    }
    public void addWorkOutItemToTrainee(ActionEvent e) throws InvalidUserException {
    	Trainee t=Main.adminUser.findTrainee(traineeId.getText());
    	String wn=workoutName.getText();
    	String wt=workoutType.getText();
    	
    	try {
    		
			LoginController.currentTrainer.addWorkOutItemToTrainee(t,  new WorkOut(wn,wt));
			workoutAdd.setText("workout Added");
			DataHandler.saveData(Main.adminUser);
		} catch (Exception e1) {
			workoutAdd.setText("invalid Input");
			e1.printStackTrace();
		}
    	
    }
    public void showRank(ActionEvent e) {
    	String rank= ""+ LoginController.currentTrainer.getRank();
    	rankLabel.setText(rank);
    	
    }
    public void updateRank(ActionEvent e) {
    	float r= LoginController.currentTrainer.getRank();
    	LoginController.currentTrainer.updateRank(r);
    	DataHandler.saveData(Main.adminUser);
    	System.out.println("Rank updated");
    	
    }
}
