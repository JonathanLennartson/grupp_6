package xCountrySkiingContest;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class MenyFlikar extends Application {
	public static void main(String[] args) {
		launch(args);
	}

	BorderPane jaktPane, massPane, individPane;
	Stage window;
	Scene mainScene, individScene, masScene, jaktScene;
	ComboBox<String> menu;
	Button selectMenuButton;

	@Override
	public void start(Stage primaryStage) {
		try {
			window = primaryStage;
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
			window.setOnCloseRequest(e -> {
				e.consume();
				closeProgram();
			});

			window.setScene(mainScene);
			window.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void closeProgram() {
		Boolean answer = ConfirmBox.display("Confirm Exit", "Are you sure you want to exit? ");
		if (answer) {
			window.close();
		}
	}

	private void menuButtonClicked() {
		menu.getValue();
		if (menu.getValue() == "Individuell Start") {
			individuellStart();
		} else if (menu.getValue() == "Jaktstart") {
			jaktStart();
		} else if (menu.getValue() == "Masstart") {
			masStart();
		}
	}

	private void masStart() {
	}

	private void individuellStart() {
	}

	private void jaktStart() {
	}

}
