package threads;

import javafx.application.Platform;
import ui.AlgorithmsRaceGUI;

public class CirclesThread extends Thread{
	
		
		private double change;
		private AlgorithmsRaceGUI arGUI;
		double circleOne;
		double circleTwo;
		
		public CirclesThread( AlgorithmsRaceGUI arGUI, double c1, double c2) {
			this.change = 0.8;
			this.arGUI = arGUI;
			this.circleOne = c1;
			this.circleTwo = c2;
		}
		
		public void run() {
			boolean startDecreacing = true;

			
			
	    	while (arGUI.isRunningRace()) {
	    		if (startDecreacing) {
	    			circleOne = circleOne - change;
	    			circleTwo = circleTwo + change;
	    		}else {
	    			circleOne = circleOne + change;
	    			circleTwo = circleTwo - change;
	    		}
	    		
	    		try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
	    		
	    		updateCircles(circleOne, circleTwo);
	    		if (circleOne < 10) {
	    			startDecreacing = false;
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
	    		}
	    		else if (circleTwo < 10) {
	    			startDecreacing = true;
	    			try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
	    		}
	    	}
		}
		
		private void updateCircles(double c1Radius, double c2Radius) {
			Platform.runLater(new Runnable(){
			
				@Override
				public void run() {
					arGUI.animateCircles(c1Radius, c2Radius);
				}
			});
			
		}
	

	

}
