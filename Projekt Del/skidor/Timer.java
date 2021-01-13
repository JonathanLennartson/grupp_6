package skidor;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.SimpleStringProperty;
import javafx.util.Duration;

public class Timer {

	private Double startTime;
	private Double stopTime;
	
	private int milliSec = 0;
	private int sec = 0;
	private int min = 0;
	private SimpleStringProperty timer = new SimpleStringProperty("00:00.000");
	private String lapTime; 

	
	
	Timeline timeline;

	public SimpleStringProperty startTimer() {
	
		timeline = new Timeline(new KeyFrame(Duration.millis(1), e -> {

			milliSec++;

			if (milliSec == 1000) {
				milliSec = 0;
				sec++;
			}

			if (sec == 60) {
				sec = 0;
				min++;

			}
			timer.set(String.format("%02d:%02d.%03d", min, sec, milliSec));
			
		})); 
		
		timeline.setCycleCount(Timeline.INDEFINITE);
		timeline.play();
		
		return timer;
		
	}

	public void stopTimer() {
		if (timeline != null) {
			timeline.stop();
		}
	}

	public Double getStartTime() {
		return startTime;
	}

	public void setStartTime(Double startTime) {
		this.startTime = startTime;
	}

	public Double getStopTime() {
		return stopTime;
	}

	public void setStopTime(Double stopTime) {
		this.stopTime = stopTime;
	}
	
	public SimpleStringProperty getTimer() {
		return timer;		
	}

	public String getLapTime() {
		return lapTime;
	}

	public void setLapTime(String lapTime) {
		this.lapTime = lapTime;
	}
	
	

}
