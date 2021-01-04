package xCountrySkiingContest;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class StopWatches extends Application {

	Stage window;
	Scene scene;

	HBox hBox;
	VBox vBox;
	Button sButton, rButton, cButton, clearButton;
	Text text;
	Timeline timeline;

	int mins = 0, secs = 0, millis = 0;
	boolean sos = true;

	public static void main(String[] args) {
		launch(args);
	}

	void change(Text text) {
		if (millis == 1000) {
			secs++;
			millis = 0;
		}
		if (secs == 60) {
			mins++;
			secs = 0;
		}
		text.setText((((mins / 10) == 0) ? "0" : "") + mins + ":" + (((secs / 10) == 0) ? "0" : "") + secs + ":"
				+ (((millis / 10) == 0) ? "00" : (((millis / 100) == 0) ? "0" : "")) + millis++);
	}

	/////////////////////////////////////////////////
	Text text1;

	int mins1 = 0, secs1 = 0, millis1 = 0;
	boolean sos1 = true;

	void change1(Text text1) {
		if (millis1 == 1000) {
			secs1++;
			millis1 = 0;
		}
		if (secs1 == 60) {
			mins1++;
			secs1 = 0;
		}
		text1.setText((((mins1 / 10) == 0) ? "0" : "") + mins1 + ":" + (((secs1 / 10) == 0) ? "0" : "") + secs1 + ":"
				+ (((millis1 / 10) == 0) ? "00" : (((millis1 / 100) == 0) ? "0" : "")) + millis1++);
	}

	/////////////////////////////////////////////////

	@Override
	public void start(Stage primaryStage) throws Exception {
		window = primaryStage;
		window.setTitle("StopWatch");

		text = new Text("00:00:000");
		text.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 25));
		timeline = new Timeline(new KeyFrame(Duration.millis(1), new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event3) {

				change(text);

			}
		}));
		timeline.setCycleCount(Timeline.INDEFINITE);
		timeline.setAutoReverse(false);
		sButton = new Button("Start");
		sButton.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 12));
		sButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event1) {
				if (sos) {
					timeline.play();
					sos = false;
					sButton.setText("Stop");
				} else {
					timeline.pause();
					sos = true;
					sButton.setText("Start");

				}
			}
		});
		rButton = new Button("Reset");
		rButton.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 12));
		rButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event2) {
				mins = 0;
				secs = 0;
				millis = 0;
				timeline.pause();
				text.setText("00:00:000");
				if (!sos) {
					sos = true;
					sButton.setText("Start");
				}
			}
		});

		/////////////////////////////////////////////////

		text1 = new Text("00:00:000");
		text1.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 25));
		Timeline timeline1 = new Timeline(new KeyFrame(Duration.millis(1), new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event3) {

				change1(text1);

			}
		}));
		timeline1.setCycleCount(Timeline.INDEFINITE);
		timeline1.setAutoReverse(false);
		Button sButton1 = new Button("Start");
		sButton1.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 12));
		sButton1.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event1) {
				if (sos1) {
					timeline1.play();
					sos1 = false;
					sButton1.setText("Stop");
				} else {
					timeline1.pause();
					sos1 = true;
					sButton1.setText("Start");

				}
			}
		});
		Button rButton1 = new Button("Reset");
		rButton1.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 12));
		rButton1.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event2) {
				mins1 = 0;
				secs1 = 0;
				millis1 = 0;
				timeline1.pause();
				text1.setText("00:00:000");
				if (!sos1) {
					sos1 = true;
					sButton1.setText("Start");
				}
			}
		});

		/////////////////////////////////////////////////

		hBox = new HBox(30);
		hBox.setAlignment(Pos.CENTER);
		hBox.getChildren().addAll(sButton, text, rButton);

		HBox hBox1 = new HBox(30);
		hBox1.setAlignment(Pos.CENTER);
		hBox1.getChildren().addAll(sButton1, text1, rButton1);

		BorderPane borderPane = new BorderPane();
		borderPane.setTop(hBox);
		borderPane.setCenter(hBox1);
		borderPane.setStyle("-fx-background-color: grey; -fx-text-fill: black;");

		scene = new Scene(borderPane, 800, 600);
		window.setScene(scene);
		window.show();
	}

}
