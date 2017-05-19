package Ozlympics;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

public class Athlete  {
	
	
	private String athleteID;
	private String athletename;
	private int athleteage;
	private String athletestate;
	private String athletetype;
	Athlete currentAthlete;
	private int athletepoints;
	private String athname;
	int time =0;
	// Athlete Constructor
	

	public int getTime() {
		return this.time;
	}

	// Athlete Constructor

	public Athlete(String athleteID, String athletetype, String athletename,int athleteage,String athletestate,int athletepoints) {
		this.athleteID = athleteID;
		this.athletename = athletename;
		this.athleteage = athleteage;
		this.athletestate = athletestate;
		this.athletetype=athletetype;
		this.athletepoints=athletepoints;
	}	

	public Athlete getCurrentAthlete() {
		return currentAthlete;
	}

	public int getAthletepoints() {
		return athletepoints;
	}
	
	public void setAthletepoints(int athletepoints) {
		this.athletepoints = athletepoints;
	}

	public String getAthleteID() {
		return athleteID;
	}

	public void setAthleteID(String athleteID) {
		this.athleteID = athleteID;
	}

	public String getAthletename() {
		return athletename;
	}

	public void setAthletename(String athletename) {
		this.athletename = athletename;
	}

	public int getAthleteage() {
		return athleteage;
	}

	public void setAthleteage(int athleteage) {
		this.athleteage = athleteage;
	}

	public String getAthletestate() {
		return athletestate;
	}

	public void setAthletestate(String athletestate) {
		this.athletestate = athletestate;
	}

	public String getAthletetype() {
		return athletetype;
	}

	public void setAthletetype(String athletetype) {
		this.athletetype = athletetype;
	}

	public void setCurrentAthlete(Athlete currentAthlete) {
		this.currentAthlete = currentAthlete;
	}

	public int setTime(int time) {
	return this.time=time;
		
	}

	
	
}


	

	
	



