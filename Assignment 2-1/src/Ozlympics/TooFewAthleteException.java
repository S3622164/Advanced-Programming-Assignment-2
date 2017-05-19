package Ozlympics;

/*		TooFewAthleteException
 * 			Exception throws when user selects less than 4 Participants
 */

public class TooFewAthleteException extends Exception {

	public TooFewAthleteException() {
		super("Sorry, Not Enough Players for the Game  ");
		System.out.println("The Game should have minimum of 4 Players.");
	}
}
