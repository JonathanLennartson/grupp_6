package skidor;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.util.Duration;

public class ChronoMeter extends Pane {

	private int milliSekunder = 0;
	private int sekunder = 0;
	private int minuter = 0;
	private Timeline timeline;
	private String tidString = "";

	private String tidFormat = String.format("%02d:%02d:%03d", minuter, sekunder, milliSekunder);
	private Label label = new Label(tidFormat);

	public ChronoMeter() {

		label.setFont(new Font("Comic Sans MS", 40));

		getChildren().add(label);

		timeline = new Timeline(new KeyFrame(Duration.millis(1), e -> timelabel()));
		timeline.setCycleCount(Timeline.INDEFINITE);

	}

	private void timelabel() {
		milliSekunder++;

		if (milliSekunder == 1000) {
			milliSekunder = 0;
			sekunder++;
		}

		if (sekunder == 60) {
			sekunder = 0;
			minuter++;
		}

		tidString = String.format("%02d:%02d.%03d", minuter, sekunder, milliSekunder);
		label.setText(tidString);
	}

	public void start() {
		timeline.play();

	}

	public void stopp() {
		timeline.stop();

	}

	public void reset() {
		milliSekunder = 0;
		sekunder = 0;
		minuter = 0;

		label.setText(tidFormat);

	}

	public String getTimerTid() {
		return label.getText();

	}

	public void setTimerTid() {
		label.getText();

	}

}