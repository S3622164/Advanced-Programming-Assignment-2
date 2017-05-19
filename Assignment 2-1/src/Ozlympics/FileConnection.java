package Ozlympics;

/*
 * Harmanak Singh
 * 
 */

import java.io.*;
import java.util.ArrayList;
public class FileConnection {
	
	
	
	ArrayList<String> athleteList = new ArrayList<String>();
	static SqliteConnection sqldb = new SqliteConnection();
	ArrayList<Athlete> fileAthleteWrite = new ArrayList<Athlete>();
	static Athlete person;
	static int points=0;
		public static void filehandle() throws IOException{
			System.out.println("This is from File");
			FileReader fr=new FileReader("/Users/sebytom/Desktop/Participants.txt");
			BufferedReader br=new BufferedReader(fr);
			String line = "";
			
			// Reading each line in the File
			try{
			 while ((line = br.readLine()) != null) {
				 String[] values  = line.split("\\,+");
			      String id=values[0];
			      String type =values[1];
			      String name = values[2];
			      String fage = values[3];
			      String state = values[4];
			
			      // Data Entry Conditions Check     
			      
			     String statecheck = checkstate(state);   // Check condition for State
			     String typecheck = checktype(type);	  // Check condition for Type
			     boolean isInteger = isInteger(fage);	  // Check condition for Age
		         if (isInteger) {
		            System.out.println(fage+" is an integer");
		         } else {
		            System.out.println(fage+" is not an integer");
		         }
		         System.out.println("");
		         int age = Integer.parseInt(fage);
		         person = new Athlete(id, type, name, age, state,points);
		         sqldb.athletedetails.add(person);
			    
			 }
			}catch(Exception e){
				System.out.println("PLease insert values for the nulls");
			}
		}
		
		// Method to check for NULL values
		private static Boolean checkdetails(String checkid,String checktype,String checkname,String checkage,String checkstate){
			Boolean IsValid = true;
			if((checkid != null) || (checktype != null) || (checkname != null) || (checkage != null) || (checkstate != null)){
				IsValid = true;
			}
			else{
				System.out.println("Please enter valid details at the NULL places");
				IsValid = false;
			}
			return IsValid;
		}
		
		// Method to checking for State conditions
		private static String checkstate(String checkthestate) {
			String playerstate = checkthestate;
			if(playerstate != null){
				if(playerstate.equals("WA") || playerstate.equals("VIC") || playerstate.equals("NSW") || playerstate.equals("TAS") ){
				System.out.println("The State is Valid");
			}
				else{
					System.out.println("The State is NOT valid");
				}
			}
			else{
				System.out.println("Please enter a valid state for the Player");
			}
			return playerstate;
		}
		
		// Method to check for Type conditions
		private static String checktype(String checkthetype) {
			String playertype = checkthetype;
			if(playertype != null){
				
			if(checkthetype.equals("swimmer") || checkthetype.equals("officer") || checkthetype.equals("sprinter") || checkthetype.equals("cyclist") || checkthetype.equals("super")){
				System.out.println("The Event Type of the Player is Valid");
			}
			else{
				try{
				System.out.println("The Event Type of the Player is NOT valid");
				throw new WrongTypeException();
				}catch(WrongTypeException w) {
				} 
				
			}
			}
			else{
				System.out.println("Please enter a valid Event Type for the Player");
			}
			return checkthetype;
		}
		
		//Method to check for age conditions
		
			  public static boolean isInteger(String chechtheage) {
			      boolean isValid = false;
			      try
			      {
			         Integer.parseInt(chechtheage);
			 
			         // chechtheage is a valid integer
			 
			         isValid = true;
			      }
			      catch (NumberFormatException ex)
			      {
			         // chechtheage is not an integer
			      }
			 
			      return isValid;
			   }	
			  
			  
	}

	

