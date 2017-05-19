package Ozlympics;

/*
 * Harmanak Singh
 * 
 */


import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/*NoRefereeException
 * 			Exception throws when user selects No Referee for the Game
 */

public class NoRefereeException extends Exception{
	Stage NoRefreestage;
	Scene NoRefreeScene;
	FlowPane NoRefereePane;
	Label RefreeLabel;
	
	public NoRefereeException() {
		super("No Referee Present.");
		System.out.println("Please select an Referee for the Game and Click NEXT.");
	}
		
			
			
		
	
}
