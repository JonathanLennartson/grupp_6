package skidor;

import java.util.ArrayList;

public class PursuitStartTime {

	public void setTotalTimeSec() {

		double min;
		double sec;
		double totalTimeSec;

		for (Competitor competitor : XMLhandler.list) {
			String[] parts = competitor.getStopTime().split(":");
			min = Double.valueOf(parts[0]);
			sec = Double.valueOf(parts[1]);
			System.out.println(min + ":" + sec);
			totalTimeSec = (min * 60) + sec;
			competitor.setTotalTimeSec(totalTimeSec);
		}

	}

	public void setPursuitStartTime() {
		
		double fastestTime = 100000000;
		String headStart;
		double previousTime;
		
		for (Competitor competitor : XMLhandler.list) {
			
//			previousTime = competitor.getTotalTimeSec();			
			
			if (fastestTime > competitor.getTotalTimeSec()) {
				fastestTime = competitor.getTotalTimeSec();
			}
		}

		for (Competitor competitor : XMLhandler.list) {			
			headStart = String.valueOf((competitor.getTotalTimeSec() - fastestTime) * 1000);
			
			
			try {
				headStart = headStart.substring(0, 4);
			} catch (IndexOutOfBoundsException e) {
			
			}
			
			if (headStart.contains(".")) {
				headStart = headStart.replace(".", "");
			}
				competitor.setHeadStart(Long.valueOf(headStart));
				System.out.println("HeadStart: " + headStart);
			
		}
		
	}
}
