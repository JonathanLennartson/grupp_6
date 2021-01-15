package skidor;

import java.util.Comparator;

import javafx.beans.property.SimpleStringProperty;

public class Competitor {
	
	private int nr;
	private String name;
	private String lapTime;
	private String stopTime;
	private Double totalTimeSec;
	private Long headStart;
	private Timer theTimer = new Timer();
	private SimpleStringProperty timer = theTimer.getTimer();
	private Boolean stopButtonPressed;
	private Boolean lapButtonPressed;
	
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

	public String getStopTime() {
		return stopTime;
	}	

	public void setStopTime(String time) {
		this.stopTime = time;
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

	public Double getTotalTimeSec() {
		return totalTimeSec;
	}

	public void setTotalTimeSec(Double totalTimeSec) {
		this.totalTimeSec = totalTimeSec;
	}

	public Long getHeadStart() {
		return headStart;
	}

	public void setHeadStart(Long headStart) {
		this.headStart = headStart;
	}
	
	public Boolean getStopButtonPressed() {
		return stopButtonPressed;
	}

	public void setStopButtonPressed(Boolean stopButtonPressed) {
		this.stopButtonPressed = stopButtonPressed;
	}

	public Boolean getLapButtonPressed() {
		return lapButtonPressed;
	}

	public void setLapButtonPressed(Boolean lapButtonPressed) {
		this.lapButtonPressed = lapButtonPressed;
	}

	public static Comparator<Competitor> totalTimeSecComparator = new Comparator<Competitor>() {
		
		public int compare(Competitor c1, Competitor c2) {
			return c1.getTotalTimeSec().compareTo(c2.getTotalTimeSec());
		}		
		
	};

}
