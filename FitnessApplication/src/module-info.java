module FitnessApplication {
	requires javafx.controls;
	requires javafx.graphics;
	requires javafx.fxml;
	requires javafx.base;
	requires FitnessCenter;
	
	opens application to javafx.graphics, javafx.fxml;
}
