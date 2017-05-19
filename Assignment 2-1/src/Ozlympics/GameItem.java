package Ozlympics;

/*
 * Harmanak Singh
 * 
 */
	
	public abstract class GameItem implements Game{

		
		private int minTime;
		private int maxTime;

		
		public GameItem() {
			// TODO Auto-generated constructor stub
		}

		public int getMin()
		{
			return minTime;
		}
		
		public int getMax()
		{
			return maxTime;
		}
		
		
	}

