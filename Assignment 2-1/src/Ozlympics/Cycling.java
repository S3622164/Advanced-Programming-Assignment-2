package Ozlympics;

public class  Cycling extends GameItem  {
	
	//Implementing Inheritance
	
	int minTime = 500;
	int maxTime = 800;

	public Cycling(){
		super();
	}
	
	public int getMinTime() {
		return minTime;
	}

	public int getMaxTime() {
		return maxTime;
	}
}
