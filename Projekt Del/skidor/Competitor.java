package skidor;

public class Competitor {
	
	private int nr;
	private String name;
	private String lapTime;
	private String time;
	private ChronoMeter cM;
	
	
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

	public ChronoMeter getcM() {
		cM = new ChronoMeter();
		return cM;
	}	

}
