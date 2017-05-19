package Ozlympics;

/*
 * Seby Tom
 * 
 */



	/*		GameFullException
	 * 			Exception throws when user selects more than 8 Participants
	 */

public class GameFullException extends Exception{

		public GameFullException() {
			super("Sorry, Only 8 Participants can take part in the Game  ");
			System.out.println("The Game has 8 Participants already.");
		}

		

		
		
		
	}
	

