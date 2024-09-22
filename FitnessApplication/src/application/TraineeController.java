package application;

import java.io.IOException;
import java.util.ArrayList;

import fitness.library.DataHandler;
import fitness.library.Trainee;
import fitness.library.WorkOut;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class TraineeController {

    private Stage stage;
    private Scene scene;
    private Parent root;
    
    @FXML
    private ListView<String> workoutList;
    @FXML
    public TextField workoutName,workoutType,rank;
    @FXML
    private Label status;
   

	 public void logout(ActionEvent e) throws IOException {
	        
	        root = FXMLLoader.load(getClass().getResource("login.fxml"));
	        stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
	        scene = new Scene(root);
	        stage.setScene(scene);
	        stage.show();
	    }
	 public void viewListOfWorkOuts(ActionEvent e) {
			ArrayList<WorkOut> allWorkOut= LoginController.currentTrainee.getWorkOutPlan();
	  
		    for (WorkOut workout : allWorkOut) {
		    	workoutList.getItems().addAll("------------------\n");
		    	workoutList.getItems().addAll(workout.toString());
		    	workoutList.getItems().addAll("------------------\n");
		    }
	 }
	 public void startWorkout(ActionEvent e) {
		 String name= workoutName.getText();
		 String type= workoutType.getText();
		 
		 LoginController.currentTrainee.startWorkOut(name,type);
		 status.setText("Started Workout!");
		 DataHandler.saveData(Main.adminUser);
	 }
	 public void completeWorkout(ActionEvent e) {
		 String name= workoutName.getText();
		 String type= workoutType.getText();
		 
		 LoginController.currentTrainee.completeWorkOut(name, type);
		 status.setText("Completed Workout!");
		 DataHandler.saveData(Main.adminUser);
	 }
	 public void evalualteTrainer(ActionEvent e) {
		 float ranking=Float.parseFloat(rank.getText());
		 
		 LoginController.currentTrainee.rankTheTrainer(ranking);;
		 DataHandler.saveData(Main.adminUser);
		 
	 }

}