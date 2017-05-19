package Ozlympics;

//Class Inherited to gameItem

public class Swimming extends GameItem {
	
	private int minTime = 100;
	private int maxTime = 200;

	public Swimming()
	{
		super();
	}

	public int getMinTime() {
		return minTime;
	}

	public int getMaxTime() {
		return maxTime;
	}

}
