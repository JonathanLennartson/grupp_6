/**
 * This file is only to test 'ChronoMeter' file working after
 * you can delete it.
 */
package xCountrySkiingContest;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * @author Julio_Cesar Oliva_Herrera 1/06/2021
 *
 */
public class RunChronometer extends Application {

	Stage window;
	boolean startad = true;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		window = primaryStage;

		/**
		 * This is object 'chronometer' to call the 'ChronoMeter' class.
		 */
		ChronoMeter chronometer = new ChronoMeter();

		Button startStoppKnapp = new Button("START");
		Button resetKnapp = new Button("RESET");

		HBox hBoxKnappar = new HBox();
		hBoxKnappar.setSpacing(20);
		hBoxKnappar.getChildren().addAll(startStoppKnapp, resetKnapp);

		startStoppKnapp.setStyle("-fx-font: normal bold 20px 'serif'");
		startStoppKnapp.setPrefSize(100, 20);
		startStoppKnapp.setStyle("-fx-background-color: lightgreen;");

		startStoppKnapp.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {

				if (startad == false) {
					chronometer.stopp();
					startStoppKnapp.setText("START");
					startStoppKnapp.setStyle("-fx-background-color: lightgreen;");
					startad = true;
					resetKnapp.setDisable(false);
					resetKnapp.setStyle("-fx-background-color: yellow;");

				} else {
					chronometer.start();
					startStoppKnapp.setText("STOPP");
					startStoppKnapp.setStyle("-fx-background-color: red;");
					startad = false;
					resetKnapp.setDisable(true);

				}

			}

		});

		// TODO
		resetKnapp.setStyle("-fx-font: normal bold 20px 'serif'");
		resetKnapp.setPrefSize(100, 20);
		resetKnapp.setStyle("-fx-background-color: darkgrey;");
		resetKnapp.setTextFill(Color.BLACK);
		resetKnapp.setDisable(true);

		// TODO resetKnapp
		resetKnapp.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				ChronoMeter.reset();
			}

		});

		// TODO
		GridPane gridPaneLayout = new GridPane();
		gridPaneLayout.setStyle("fx-background-color: SILVER;");
		gridPaneLayout.setAlignment(Pos.CENTER);
		gridPaneLayout.setVgap(10);
		gridPaneLayout.setHgap(10);
		gridPaneLayout.add(chronometer, 0, 0);
		gridPaneLayout.add(hBoxKnappar, 0, 1);

		window.setResizable(false);
		window.setScene(new Scene(gridPaneLayout, 355, 500));
		window.setTitle("                           CHRONOMETER");
		window.show();

	}

}