package skidor;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class MenyFlikar  {	
	
	static Scene mainScene, individScene, masScene, jaktScene;
	static ComboBox<String> menu;
	static Button selectMenuButton;
	static Button addSkiier;
	static Stage window = new Stage();	
	
	public void show() {	
		
			window.setTitle("X Skiing Contest Timer");

			menu = new ComboBox<>();
			menu.getItems().addAll("Individual Start", "Mass Start", "Pursuit");
			menu.setPromptText("Choose Race Type");

			selectMenuButton = new Button("Choose");
			selectMenuButton.setOnAction(e -> menuButtonClicked());			

			StackPane layout = new StackPane();
			HBox menuLayout = new HBox(40);

			menuLayout.getChildren().addAll(menu, selectMenuButton);
			menuLayout.setAlignment(Pos.CENTER);
			layout.getChildren().add(menuLayout);

			mainScene = new Scene(layout, 400, 150);
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

