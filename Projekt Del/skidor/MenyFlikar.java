package skidor;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class MenyFlikar  {
	

	static BorderPane jaktPane, massPane, individPane;
	
	static Scene mainScene, individScene, masScene, jaktScene;
	static ComboBox<String> menu;
	static Button selectMenuButton;
	static Button addSkiier;
	static Stage window = new Stage();
	
	
	public void show() {
	
		
			window.setTitle("X skiing contest");

			menu = new ComboBox<>();
			menu.getItems().addAll("Individual Start", "Mass Start", "Pursuit");
			menu.setPromptText("Choose Race Type");

			selectMenuButton = new Button("Choose");
			selectMenuButton.setOnAction(e -> menuButtonClicked());
			addSkiier = new Button("Add Skiier");
			addSkiier.setOnAction(e -> addSkiierClicked());

			BorderPane layout = new BorderPane();
			HBox menuLayout = new HBox(40);

			menuLayout.getChildren().addAll(menu, selectMenuButton, addSkiier);

			menuLayout.setPadding(new Insets(20, 20, 20, 20));
			layout.setTop(menuLayout);

			mainScene = new Scene(layout, 500, 200);
			mainScene.getStylesheets().add(getClass().getResource("design.css").toExternalForm());
			window.setOnCloseRequest(e -> {
				e.consume();
				closeProgram();
			});
			
			
			window.setScene(mainScene);
			window.show();
		} 
	

	private static void closeProgram() {
		Boolean answer = ConfirmBox.display("Confirm Exit", "Are you sure you want to exit? ");
		if (answer) {
			window.close();
		}
	}
	
	private static void addSkiierClicked() {
		AddSkiier skiier = new AddSkiier();
		skiier.show();
	}

	private static void menuButtonClicked() {
		menu.getValue();
		if (menu.getValue() == "Individual Start") {
			individuellStart();
		} else if (menu.getValue() == "Pursuit") {
			jaktStart();
		} else if (menu.getValue() == "Mass Start") {
			masStart();
		}
	}

	private static void masStart() {
		MasStart mStart = new MasStart();
		mStart.show();
	}

	private static void individuellStart() {
		IndividuellStart start = new IndividuellStart();
		start.show();
	}

	private static void jaktStart() {
			JaktStart jStart = new JaktStart();
			jStart.show();
	}

}


