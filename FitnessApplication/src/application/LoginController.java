package application;

import java.io.IOException;
import java.util.ArrayList;

import fitness.library.InvalidUserException;
import fitness.library.Trainee;
import fitness.library.Trainer;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController {
	 public TextField userid, password;
	 static Trainee currentTrainee ;
	 static Trainer currentTrainer;
	 public Label invalidID;
	 
	 public void login(ActionEvent e) throws IOException, InvalidUserException {
		    String user = userid.getText();

		    if (user.equals("admin")) {
		        try {
		            Parent root = FXMLLoader.load(getClass().getResource("AdminMenu.fxml"));
		            Scene scene = new Scene(root);
		            Main.myStage.setTitle("Fitness Center");
		            Main.myStage.setScene(scene);
		            Main.myStage.show();
		            invalidID.setText(null);
		        } catch (Exception e1) {
		            e1.printStackTrace();
		        }
		    }
		    else {
		    	invalidID.setText("ID is not valid!");
		    }
		}
	 public void loginAsTrainee(ActionEvent e) throws IOException, InvalidUserException {
		    String user = userid.getText();
		    try {
		    currentTrainee = Main.adminUser.findTrainee(user);

		    if (currentTrainee != null) {
		       
		            Parent root = FXMLLoader.load(getClass().getResource("traineeMenu.fxml"));
		            Scene scene = new Scene(root);
		            Main.myStage.setTitle("Fitness Center");
		            Main.myStage.setScene(scene);
		            Main.myStage.show();
		            invalidID.setText(null);
		        }
		    }
		    catch (Exception e1) {
	        	invalidID.setText("ID is not valid!");
	        } 
		}
	 public void loginAsTrainer(ActionEvent e) throws IOException, InvalidUserException{
		 String user = userid.getText();
		 	try {
	        currentTrainer = Main.adminUser.findTrainer(user);
	        
	        
	        if (currentTrainer!= null ) {
	            
                Parent root = FXMLLoader.load(getClass().getResource("trainerMenu.fxml"));
	                Scene scene = new Scene(root);
	                Main.myStage.setTitle("Fitness Center");
	                Main.myStage.setScene(scene);
	                Main.myStage.show();
	                invalidID.setText(null);
	               
	            }
		 	}
	        catch(Exception e1){
	        invalidID.setText("ID is not valid!");
	        }
		 	
	        } 
	        
	        	
	    }
		 
		 
	 




