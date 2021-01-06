package skidor;

public class Competitor {
	
	private int nr;
	private String name;
	private int lapTime;
	private int time;
	
	public Competitor (int nr, String name) {
		this.nr = nr;
		this.name = name;
	}
	
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

	public int getLapTime() {
		return lapTime;
	}

	public void setLapTime(int lapTime) {
		this.lapTime = lapTime;
	}

	public int getTime() {
		return time;
	}
	

	public void setTime(int time) {
		this.time = time;
	}
	
	
	
	

}
