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
	static Stage window = new Stage();
	
	
	public void show() {
	
		
			window.setTitle("Skidåkartävling");

			menu = new ComboBox<>();
			menu.getItems().addAll("Individuell Start", "Masstart", "Jaktstart");
			menu.setPromptText("Välj Din Start-Typ");

			selectMenuButton = new Button("Välj");
			selectMenuButton.setOnAction(e -> menuButtonClicked());

			BorderPane layout = new BorderPane();
			HBox menuLayout = new HBox(40);

			menuLayout.getChildren().addAll(menu, selectMenuButton);

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

	private static void menuButtonClicked() {
		menu.getValue();
		if (menu.getValue() == "Individuell Start") {
			individuellStart();
		} else if (menu.getValue() == "Jaktstart") {
			jaktStart();
		} else if (menu.getValue() == "Masstart") {
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


