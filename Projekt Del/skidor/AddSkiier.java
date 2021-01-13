package skidor;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class AddSkiier {
	
	static GridPane gridPane;
	static Scene scene;
	static Button submit;
	static Stage window = new Stage();
	
	
	public void show() {
		window.setTitle("Add Skiier");
		
		gridPane = createRegistrationFormPane();
		
		addUIControls(gridPane);
		
		scene = new Scene(gridPane, 800, 500);
		
		window.setScene(scene);
		window.show();
	}
	
	private GridPane createRegistrationFormPane() {
		gridPane = new GridPane();
		
		gridPane.setAlignment(Pos.CENTER);
		
		gridPane.setPadding(new Insets(40, 40, 40, 40));
		
		gridPane.setHgap(10);
		
		gridPane.setVgap(10);
		
		
		ColumnConstraints columnOneConstraints = new ColumnConstraints(100, 100, Double.MAX_VALUE);
		columnOneConstraints.setHalignment(HPos.RIGHT);
		
		ColumnConstraints columnTwoConstraints = new ColumnConstraints(200, 200, Double.MAX_VALUE);
		columnTwoConstraints.setHgrow(Priority.ALWAYS);
		
		gridPane.getColumnConstraints().addAll(columnOneConstraints, columnTwoConstraints);
		
		return gridPane;
	}
	
	private void addUIControls(GridPane gridPane) {
		
		Label headerLabel = new Label("New skiier");
		headerLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
		gridPane.add(headerLabel, 0, 0, 2, 1);
		GridPane.setHalignment(headerLabel, HPos.CENTER);
		GridPane.setMargin(headerLabel, new Insets(20, 0, 20, 0));
		
		Label nameLabel = new Label("Full Name");
		gridPane.add(nameLabel, 0, 1);
		
		TextField nameField = new TextField();
		nameField.setPrefHeight(40);
		gridPane.add(nameField, 1, 1);
		
		Label startNummer = new Label("StartNummer");
		gridPane.add(startNummer, 0, 2);
		
		TextField startField = new TextField();
		startField.setPrefHeight(40);
		gridPane.add(startField, 1, 2);
		
		submit = new Button("Submit");
		submit.setPrefHeight(40);
		submit.setDefaultButton(true);
		submit.setPrefWidth(100);
		gridPane.add(submit, 0, 4, 2, 1);
		GridPane.setHalignment(submit, HPos.CENTER);
		GridPane.setMargin(submit, new Insets(20, 0, 20, 0));
	}
	
}
	
	