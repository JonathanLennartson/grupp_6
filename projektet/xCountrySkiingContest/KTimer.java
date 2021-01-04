package xCountrySkiingContest;

import java.text.SimpleDateFormat;
import java.util.Date;

import javafx.beans.property.SimpleStringProperty;

/**
 * @author Julio_Cesar Oliva_Herrera 12/28/2020
 *
 */
public class KTimer extends Thread {
	
	private Thread thread = null;
	private SimpleDateFormat sdf = new SimpleDateFormat("mm:ss:S");
	private String[] split;
	private SimpleStringProperty min, sec, millis, sspTime;
	private long time;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("CHRONOMETER for each competitor\n\n");
		KTimer t = new KTimer();
		t.startTimer(00);

	}

	/**
	 * 
	 * @param time To start the time
	 */
	public void startTimer(long time) {
		// TODO Auto-generated method stub
		this.time = time;
		thread = new Thread(this);
		thread.setPriority(Thread.MIN_PRIORITY);
		thread.start();
		
	}
	
	/**
	 * 
	 * @param time To stop the time.
	 */
	public void stopTimer(long time) {
	       if (thread != null) {
	           thread.interrupt();
	       }
	       this.time = time;
	       setTime(time);
	}
	
	/**
	 * 
	 * @param time To set the time.
	 */
	public void setTime(long time) {
	       this.time = time;
	       split = sdf.format(new Date(time)).split(":");
	       min.set(split[0]);
	       sec.set(split[1]);

	       if (split[2].length() == 1) {
	           split[2] = "0" + split[2];
	       }
	       millis.set(split[2].substring(0, 2));

	       sspTime.set(min.get() + ":" + sec.get() + ":" + millis.get());
	}

	public long getTime() {
	       return time;
	}

	public SimpleStringProperty getSspTime() {
	       return sspTime;
	}

	@Override
	public void run() {
	       try {
	           while (!thread.isInterrupted()) {
	               setTime(time);
	               sleep(10);
	               time = time + 10;
	           }
	       } catch (Exception e) {
	       }

	}
	//}//end of class

}
