package application;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import fitness.library.DataHandler;
import fitness.library.FitnessCenter;
import fitness.library.InvalidUserException;
import fitness.library.Trainer;
import fitness.library.Trainee;

public class AdminController implements Initializable{

    @FXML
    private TextField name, age, weight, height, yearOfExperience;
    @FXML
    private TextField trainerID,traineeID;
   
    @FXML
    private Label display;
    @FXML
    private ListView<String> trainerList;
    @FXML
    private ListView<String> traineeList;

    private String id;

    

    private Stage stage;
    private Scene scene;
    private Parent root;

    public void addTrainer(ActionEvent e) throws IOException  {
        
    	try {
          
            Parent root = FXMLLoader.load(getClass().getResource("AddTrainer.fxml"));
            Scene scene = new Scene(root); 
            Main.myStage.setTitle("Fitness Center");
            Main.myStage.setScene(scene);
            Main.myStage.show();
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }
           
    

    public void addTrainee(ActionEvent e) throws IOException{
    	try {
            
            Parent root = FXMLLoader.load(getClass().getResource("AddTrainee.fxml"));
            Scene scene = new Scene(root); 
            Main.myStage.setTitle("Fitness Center");
            Main.myStage.setScene(scene);
            Main.myStage.show();
        } catch (Exception e1) {
            e1.printStackTrace();
        }
      
    }
    public void viewListOfTrainees(ActionEvent e) {
		ArrayList<Trainee> allTrainees= Main.adminUser.getTrainees();
  
	    for (Trainee trainee : allTrainees) {
	    	traineeList.getItems().addAll("------------------\n");
	        traineeList.getItems().addAll(trainee.toString());
	        traineeList.getItems().addAll("------------------\n");
	    }
	
}
    

    public void viewListOfTrainers(ActionEvent e) {
    		ArrayList<Trainer> allTrainers= Main.adminUser.getTrainers();
      
    	    for (Trainer trainer : allTrainers) {
    	    	trainerList.getItems().addAll("------------------\n");
    	        trainerList.getItems().addAll(trainer.toString());
    	        trainerList.getItems().addAll("------------------\n");
    	    }
    	
    }
 
    
    public void submitTrainer(ActionEvent e) {
    	String trainerName = name.getText();
        int trainerAge = Integer.parseInt(age.getText());
        float trainerWeight = Float.parseFloat(weight.getText());
        float trainerHeight = Float.parseFloat(height.getText());
        int experience = Integer.parseInt(yearOfExperience.getText());
        
        id = Main.adminUser.addTrainer(trainerName, trainerAge, trainerWeight, trainerHeight, experience);
        System.out.println(id+" was added as a Trainer");
        DataHandler.saveData(Main.adminUser);
        
        name.clear();
        age.clear();
        weight.clear();
        height.clear();
        yearOfExperience.clear();
    }
    
    
    public void submitTrainee(ActionEvent e) {
    	String traineeName = name.getText();
        int traineeAge = Integer.parseInt(age.getText());
        float traineeWeight = Float.parseFloat(weight.getText());
        float traineeHeight = Float.parseFloat(height.getText());  
        id= Main.adminUser.addTrainee(traineeName, traineeAge, traineeWeight, traineeHeight);
        System.out.println(id+" was added as a Trainee");
        DataHandler.saveData(Main.adminUser);
        
        name.clear();
        age.clear();
        weight.clear();
        height.clear();
        }

    public void switchToAdminMenu(ActionEvent e) throws IOException {
       
        root = FXMLLoader.load(getClass().getResource("AdminMenu.fxml"));
        stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void logout(ActionEvent e) throws IOException {
        
        root = FXMLLoader.load(getClass().getResource("login.fxml"));
        stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void enrollUnderTrainer(ActionEvent e) throws InvalidUserException {
    	String trainerName = trainerID.getText();
    	String traineeName = traineeID.getText();
        
        
        Main.adminUser.enrollUnderTrainer(trainerName, traineeName);
        System.out.println("Was enrolled");
        DataHandler.saveData(Main.adminUser);
        
        traineeID.clear();
        trainerID.clear();
    }



	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	  
	}

}
