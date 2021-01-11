package skidor;

import javafx.beans.property.SimpleStringProperty;

public class Competitor {
	
	private int nr;
	private String name;
	private String lapTime;
	private String time;
	private Timer theTimer = new Timer();
	private SimpleStringProperty timer = theTimer.getTimer();
	
	public int getNr() {
		return nr;
	}
	
	public void setNr(int nr) {
		this.nr = nr;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public String getLapTime() {
		return lapTime;
	}

	public void setLapTime(String lapTime) {
		this.lapTime = lapTime;
	}

	public String getTime() {
		return time;
	}	

	public void setTime(String time) {
		this.time = time;
	}

	public String getTimer() {
		return timer.get();
	}
	
	public SimpleStringProperty getTimerProperty() {
		return timer;
		
	}
	
	public void startTimer() {
		theTimer.startTimer();
	}
	
	public void stopTimer() {
		theTimer.stopTimer();
	}

}
