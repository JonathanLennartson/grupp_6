/**
 * This is Chronometer for individual timekeeping. 
 */
package xCountrySkiingContest;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.util.Duration;

/**
 * @author Julio_Cesar Oliva_Herrera	1/06/2021
 *
 */
public class ChronoMeter extends Pane {
	
	//TODO
	static private int milliSekunder = 0;
	static private int sekunder = 0;
	static private int minuter = 0;
	private Timeline timeline;
	private static String tidString = "";
	private boolean aktiv = false;
	
	static String tidFormat = String.format("%02d:%02d:%03d", minuter, sekunder, milliSekunder);
	
	static Label label = new Label(tidFormat);			// ???
	
	public ChronoMeter() {
		
		// TODO
		label.setFont(new Font("Algerian", 75));
		getChildren().add(label);
		
		timeline = new Timeline(new KeyFrame(Duration.millis(1), e -> timelabel()));
		timeline.setCycleCount(Timeline.INDEFINITE);
		
	}

	private void timelabel() {
		
		if (aktiv == true) {
			
			milliSekunder++;
			
			if (milliSekunder == 1000) {
				milliSekunder = 0;
				sekunder++;
				
			}
			
			if (sekunder  == 60) {
				sekunder = 0;
				minuter++;
				
			}
						
		}
		
		tidString = String.format("%02d:%02d:%03d", minuter, sekunder, milliSekunder);
		label.setText(tidString);
		
	}
	
	public void start() {
		
		timeline.play();
		aktiv = true;
		
	}
	
	public void stopp() {
		
		timeline.stop();
		aktiv = false;
		
	}
	
	public static void reset() {
		
		milliSekunder = 0;
		sekunder = 0;
		minuter = 0;
		
		label.setText(tidFormat);
		
	}
	
	public static String getTimerTid() {
		
		return label.getText();
		
	}
	
	public static void setTimerTid() {
		
		label.getText();
		
	}
	
}
