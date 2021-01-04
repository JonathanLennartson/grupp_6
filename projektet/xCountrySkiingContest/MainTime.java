package xCountrySkiingContest;

public class MainTime extends Thread{

	private int hours = 10;
	private int minutes = 0;
	private int seconds;

	public void startCounting() {
		for (seconds = 0; seconds <= 60; seconds++) {
			if (seconds == 60) {
				minutes++;	
				minutes++;
				seconds = 0;
			} else if (minutes == 60) {
				minutes = 0;
				hours++;

			} else if (hours == 24) {
				hours = 0;
			}

			System.out.println(hours + ":" + minutes + ":" + seconds);

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
