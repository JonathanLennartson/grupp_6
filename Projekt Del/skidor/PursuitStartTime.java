package skidor;

public class PursuitStartTime {

	public void setTotalTimeSec() {

		double min;
		double sec;

		for (Competitor competitor : XMLhandler.list) {
			String[] parts = competitor.getStopTime().split(":");
			min = Double.valueOf(parts[0]);
			sec = Double.valueOf(parts[1]);
			competitor.setTotalTimeSec((min * 60) + sec);
		}

	}

	public void setPursuitStartTime() {

		double time;
		int index = -1;

		for (Competitor competitor : XMLhandler.list) {

			try {
				time = (competitor.getTotalTimeSec() - XMLhandler.list.get(index).getTotalTimeSec()) * 1000;
			} catch (IndexOutOfBoundsException e) {
				time = 0;
			}

			index++;
			competitor.setHeadStart(Double.valueOf(time).longValue());

		}

	}
}
