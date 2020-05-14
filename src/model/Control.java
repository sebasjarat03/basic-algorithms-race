package model;

import java.util.Random;

import threads.RaceThread;
import ui.AlgorithmsRaceGUI;

public class Control {
	
	private AlgorithmsRaceGUI gui;
	private Random gen;
	
	private AL al;
	private ABBHandler abb;
	private LEHandler le;
	
	private RaceThread alRace;
	private RaceThread abbRace;
	private RaceThread leRace;
	
	public Control(AlgorithmsRaceGUI alGUI) {
		gui = alGUI;
		gen = new Random(15);
		al = new AL();
		abb = new ABBHandler();
		le = new LEHandler();
	}
	
	
	public void startRace(long N, String mode, String algorithm) {
		boolean modeB = mode.equals("Iterative") ? true:false;
		int alg = 0;
		
		switch(algorithm) {
		case "Add":
			alg = 1;
			break;
		case "Search":
			alg = 2;
			break;
		case "Delete":
			alg = 3;
			break;
		}
		
		alRace = new RaceThread(gui, N, gen, modeB, alg, al);
		abbRace = new RaceThread(gui, N, gen, modeB, alg, abb);
		leRace = new RaceThread(gui, N, gen, modeB, alg, le);
		
		alRace.start();
		abbRace.start();
		leRace.start();
		
	}
	
	
	public boolean raceRunning() {
		return(alRace.isAlive() || abbRace.isAlive() || leRace.isAlive());
	}
	
	


}
