package skidor;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Timer2 {

	private static final Integer STARTTIME = 5;
	private static Timeline timeline;
	private static Label timerLabel = new Label();
	private static IntegerProperty timeSeconds = new SimpleIntegerProperty(STARTTIME);

	public static void show() {
		Stage primaryStage = new Stage();
		primaryStage.setTitle("Timer");
		Group root = new Group();
		Scene scene = new Scene(root, 300, 250);

		timerLabel.textProperty().bind(timeSeconds.asString());
		timerLabel.setTextFill(Color.GREEN);
		timerLabel.setStyle("-fx-font-size: 6em;");

		Button button = new Button();
		button.setText("Start Timer");
		button.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {
				if (timeline != null) {
					timeline.stop();
				}
				timeSeconds.set(STARTTIME);
				timeline = new Timeline();
				timeline.getKeyFrames().add(new KeyFrame(Duration.seconds(5), new KeyValue(timeSeconds, 0)));
				timeline.playFromStart();
				
			}

		});
		VBox vb = new VBox(20);
		vb.setAlignment(Pos.CENTER);

		vb.setPrefWidth(scene.getWidth());
		vb.getChildren().addAll(button, timerLabel);
		vb.setLayoutY(30);

		root.getChildren().add(vb);

		primaryStage.setScene(scene);
		primaryStage.show();
	}

}
