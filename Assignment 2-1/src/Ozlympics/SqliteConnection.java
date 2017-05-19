package Ozlympics;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/*
 * Seby Tom
 * 
 */

public class SqliteConnection {
	
	// ArrayList Declarations
	public static ArrayList<Athlete>athletedetails = new ArrayList<Athlete>();
	public static Set<Athlete> gameList = new HashSet<Athlete>();
	ArrayList <Athlete>athleteSelectedforGame = new ArrayList<Athlete>();
	ArrayList <Athlete>finishtime = new ArrayList<Athlete>();
	ArrayList <Athlete>official =new ArrayList<Athlete>();
	ArrayList <String>officialSelected =new ArrayList<String>();
	ArrayList <String>athleteSelected = new ArrayList<String>();
	ArrayList <Athlete>WinnerList = new ArrayList<Athlete>();
	ArrayList <String>WinnerListString = new ArrayList<String>();
	ArrayList <Athlete>WinnerPoints = new ArrayList<Athlete>();
	ArrayList <Athlete>output = new ArrayList<Athlete>();
	ArrayList <String> idList;
	ArrayList <String> nameList;
	ArrayList <String> playerPoints;
	ArrayList <String> playerTime;
	
	int winnerPoints = 0;
	String Time = " "; 
	String Points = " ";
	int winnerCounter =0;
	String gametype = "";
	String playerName = "";
	String officertype = "officer";
	public String winnerId = "None";
	public String winnerType = "None";
	public String winnerName = "None";
	public int winnerAge = 0;
	public String winnerState = "None";
	public int winnerTime = 0;
	public String officialSelection =" ";
	static Athlete person;
	  static Connection dbconnection = null;  // to check the connection with the Database
      static Statement stmt = null;
      static int result = 0;
     static int resultdrop = 0;
     static int resultinsert = 0;
     static String urllink = "jdbc:sqlite:/Users/sebytom/Sqlite/OzlympicsDB.db";
     public static int dbflag=0;
     public static int Resultflag =0;
     public static int DBflag=0;
     public String typeAthlete;
     
     /*
      * Method checks if the Source table exist in the Database 
      * 	 if then, continue to insert data into the table
      * 		 or if it already exist, drop the table and create it again followed by insertion of data
      */
     
    public static void DbConnector() throws IOException, SQLException {
    	dbconnection = DriverManager.getConnection(urllink);
    	  if(dbflag==1){
    		  stmt = dbconnection.createStatement();
          	resultdrop =stmt.executeUpdate("DROP TABLE OZParticipants;");
          	 result = stmt.executeUpdate("CREATE TABLE OZParticipants (id varchar(10) NOT NULL, type varchar(10) NOT NULL,name varchar(20) NOT NULL,age INT NOT NULL,state varchar(10), PRIMARY KEY(id))");
          	DbConnect();					//Method call for Database
          }
          else{
        	  stmt = dbconnection.createStatement();
        	  result = stmt.executeUpdate("CREATE TABLE OZParticipants (id varchar(10) NOT NULL, type varchar(10) NOT NULL,name varchar(20) NOT NULL,age INT NOT NULL,state varchar(10), PRIMARY KEY(id))");
        	  DbConnect();					//Method call for Database
          }
    }
    
    
    		// Method for Insertion of Data into the source table.
    
        	  public static void DbConnect(){
       	try {
      	  

            int resultview = 0;
            Boolean dbresult = false;
            System.out.println("Connection to SQLite Database has been established.");
      
            resultinsert = stmt.executeUpdate("INSERT INTO OzParticipants values ('Oz0001','swimmer','SebyTom',26,'VIC')");
            resultinsert = stmt.executeUpdate("INSERT INTO OzParticipants values ('Oz0002','swimmer','HarmanakSingh',23,'WA')");
            resultinsert = stmt.executeUpdate("INSERT INTO OzParticipants values ('Oz0003','swimmer','MarkDiner',24,'WA')");
            resultinsert = stmt.executeUpdate("INSERT INTO OzParticipants values ('Oz0004','swimmer','SteveWough',24,'TAS')");
            resultinsert = stmt.executeUpdate("INSERT INTO OzParticipants values ('Oz0005','swimmer','GillChrist',24,'NSW')");
            resultinsert = stmt.executeUpdate("INSERT INTO OzParticipants values ('Oz0006','swimmer','Gillespe',28,'WA')");
            resultinsert = stmt.executeUpdate("INSERT INTO OzParticipants values ('Oz0007','swimmer','Tim',30,'WA')");
            resultinsert = stmt.executeUpdate("INSERT INTO OzParticipants values ('Oz0008','swimmer','Tom',21,'TAS')");
            resultinsert = stmt.executeUpdate("INSERT INTO OzParticipants values ('Oz0009','swimmer','Thomas',25,'VIC')");
            resultinsert = stmt.executeUpdate("INSERT INTO OzParticipants values ('Oz0010','swimmer','Mathew',26,'VIC')");
            resultinsert = stmt.executeUpdate("INSERT INTO OzParticipants values ('Oz0011','sprinter','Nishanth',27,'WA')");
            resultinsert = stmt.executeUpdate("INSERT INTO OzParticipants values ('Oz0012','sprinter','Harris',28,'TAS')");
            resultinsert = stmt.executeUpdate("INSERT INTO OzParticipants values ('Oz0013','sprinter','Don',29,'NSW')");
            resultinsert = stmt.executeUpdate("INSERT INTO OzParticipants values ('Oz0014','sprinter','Kiran',26,'WA')");
            resultinsert = stmt.executeUpdate("INSERT INTO OzParticipants values ('Oz0015','sprinter','Kris',21,'VIC')");
            resultinsert = stmt.executeUpdate("INSERT INTO OzParticipants values ('Oz0016','sprinter','Scott',22,'WA')");
            resultinsert = stmt.executeUpdate("INSERT INTO OzParticipants values ('Oz0017','sprinter','Brian',23,'TAS')");
            resultinsert = stmt.executeUpdate("INSERT INTO OzParticipants values ('Oz0018','sprinter','Ching',24,'NSW')");
            resultinsert = stmt.executeUpdate("INSERT INTO OzParticipants values ('Oz0019','sprinter','Bradley',26,'VIC')");
            resultinsert = stmt.executeUpdate("INSERT INTO OzParticipants values ('Oz0020','sprinter','Cooper',25,'WA')");
            resultinsert = stmt.executeUpdate("INSERT INTO OzParticipants values ('Oz0021','cyclist','Vineeth',26,'TAS')");
            resultinsert = stmt.executeUpdate("INSERT INTO OzParticipants values ('Oz0022','cyclist','Krate',28,'VIC')");
            resultinsert = stmt.executeUpdate("INSERT INTO OzParticipants values ('Oz0023','cyclist','Johney',27,'WA')");
            resultinsert = stmt.executeUpdate("INSERT INTO OzParticipants values ('Oz0024','cyclist','Jean',20,'TAS')");
            resultinsert = stmt.executeUpdate("INSERT INTO OzParticipants values ('Oz0025','cyclist','Fox',23,'NSW')");
            resultinsert = stmt.executeUpdate("INSERT INTO OzParticipants values ('Oz0026','cyclist','Jazz',24,'NSW')");
            resultinsert = stmt.executeUpdate("INSERT INTO OzParticipants values ('Oz0027','cyclist','Johan',25,'NSW')");
            resultinsert = stmt.executeUpdate("INSERT INTO OzParticipants values ('Oz0028','cyclist','Richu',19,'VIC')");
            resultinsert = stmt.executeUpdate("INSERT INTO OzParticipants values ('Oz0029','cyclist','Timber',17,'WA')");
            resultinsert = stmt.executeUpdate("INSERT INTO OzParticipants values ('Oz0030','cyclist','Drake',31,'TAS')");
            resultinsert = stmt.executeUpdate("INSERT INTO OzParticipants values ('Oz0031','super','Justin',22,'NSW')");
            resultinsert = stmt.executeUpdate("INSERT INTO OzParticipants values ('Oz0032','super','Bieber',23,'WA')");
            resultinsert = stmt.executeUpdate("INSERT INTO OzParticipants values ('Oz0033','super','Bob',35,'NSW')");
            resultinsert = stmt.executeUpdate("INSERT INTO OzParticipants values ('Oz0034','super','Marley',36,'TAS')");
            resultinsert = stmt.executeUpdate("INSERT INTO OzParticipants values ('Oz0035','super','West',34,'VIC')");
            resultinsert = stmt.executeUpdate("INSERT INTO OzParticipants values ('Oz0036','super','Kayne',35,'WA')");
            resultinsert = stmt.executeUpdate("INSERT INTO OzParticipants values ('Oz0037','super','Nick',22,'NSW')");
            resultinsert = stmt.executeUpdate("INSERT INTO OzParticipants values ('Oz0038','super','Ham',23,'TAS')");
            resultinsert = stmt.executeUpdate("INSERT INTO OzParticipants values ('Oz0039','super','Brooke',28,'VIC')");
            resultinsert = stmt.executeUpdate("INSERT INTO OzParticipants values ('Oz0040','officer','Boney',40,'VIC')");
            resultinsert = stmt.executeUpdate("INSERT INTO OzParticipants values ('Oz0041','officer','Markooney',39,'NSW')");
            resultinsert = stmt.executeUpdate("INSERT INTO OzParticipants values ('Oz0042','officer','Batista',36,'WA')");
            resultinsert = stmt.executeUpdate("INSERT INTO OzParticipants values ('Oz0043','officer','Cena',34,'NSW')");
            ResultSet rs = stmt.executeQuery( "SELECT * FROM OZParticipants;" );
            while ( rs.next() ) {
               String id = rs.getString("id");
               String  type = rs.getString("type");
               String  name = rs.getString("name");
               int age  = rs.getInt("age");
               String  state = rs.getString("state");
               int points =0; 
                person = new Athlete(id, type, name, age, state, age);
               athletedetails.add(person);
            	}
            }
            
         catch (SQLException e) {
            System.out.println(e.getMessage());
            } 
        	  }
    
        	  // Method to add Player to the GameList Hash Set
    public void athleteDBAdd(){
    	for(int i=0;i<athletedetails.size();i++){
				gameList.add(athletedetails.get(i));
				}
    }
    
    	
 	/*
 	 * Wrting the results to the Database
 	 * Setting up connection with the Database
 	 * Table Creation if does not exist
 	 * Method call for insertion of data
 	 */
	 
	 public void WinnerDBView() throws IOException, SQLException{
		 dbconnection = DriverManager.getConnection(urllink);
		 if(Resultflag==1){
   		  stmt = dbconnection.createStatement();
         	resultdrop =stmt.executeUpdate("DROP TABLE GameResult;");
         	result = stmt.executeUpdate("CREATE TABLE GameResult (wid varchar(10) NOT NULL, wtype varchar(10),wname varchar(20),wage INT,wstate varchar(10), PRIMARY KEY(wid))");
         	DBGameInsert();				// Method call for Insertion of Game Result
         }
         else{
       	  stmt = dbconnection.createStatement();
       	result = stmt.executeUpdate("CREATE TABLE GameResult (wid varchar(10) NOT NULL, wtype varchar(10),wname varchar(20),wage INT,wstate varchar(10), PRIMARY KEY(wid))");
       	DBGameInsert();					// Method call for Insertion of Game Result
         }
   }
	 
	// Method for Insertion of Game Result
	 
	 public void DBGameInsert() throws IOException{
		 try{
			
			 for(int i=0;i<WinnerList.size();i++)
		 {
				 
		 winnerId=WinnerList.get(i).getAthleteID().toString();
		 winnerTime= WinnerList.get(i).getTime();
		 winnerPoints = WinnerList.get(i).getAthletepoints();
		 Time = winnerTime + " ";
		 Points = winnerPoints + " ";
		 
		 PreparedStatement pstmt = dbconnection.prepareStatement("INSERT INTO GameResult (wid,wtype,wname,wage,wstate) values (?,?,?,?,?)");	
	     pstmt.setString(1, WinnerList.get(i).getAthleteID().toString());
	     pstmt.setString(2, Time);
	     pstmt.setString(3, Points);
	     pstmt.execute();	            	                
		 }
		  } catch (SQLException e) {
	            System.out.println(e.getMessage());
	            
	        } 
	 finally {
         try {
             if (dbconnection == null) {
             	dbconnection.close();
             }
             
         } catch (SQLException ex) {
             System.out.println(ex.getMessage());
         }
     }
	 }
	 
		
					// Method for Adding Officials 
	
	 public void AddOfficials(){									
		 
		 System.out.println("Adding Official Method");
		 for(int i=0;i<athletedetails.size();i++){
			 if(athletedetails.get(i).getAthletetype().equals(officertype))
			 {
				 official.add(athletedetails.get(i));
			 }
		 }

	 }
	 
	 //Method for Converting String to Object PLayers
	public void StringtoObjectSelectedPlayers(){
			for(int i=0;i<athleteSelected.size();i++){
				playerName = athleteSelected.get(i);			
				ToCheckObject(playerName);						// Method to convert back to Object
				}
		}
	 
	// Method for conversion from String to Object
	 public void ToCheckObject(String playerNameObj){
		 System.out.println("The conversion Happens");
		 for(Athlete Athlete:gameList){
				 if(Athlete.getAthletename().contentEquals(playerNameObj) && Athlete.getAthletetype().equals(typeAthlete ) || 
						 Athlete.getAthletename().equals(playerNameObj) && Athlete.getAthletetype().equals("super")){
				 
				 athleteSelectedforGame.add(Athlete);
				 System.out.println("Found the name of Player from gameList"+Athlete.getAthletename());
				 } 
		 	}
	 }
	 
	   public ArrayList<Athlete> getFinishtime() {
			return finishtime;
		}

		public void setFinishtime(ArrayList<Athlete> finishtime) {
			this.finishtime = finishtime;
		}

		public static Set<Athlete> getGameList() {
			return gameList;
		}

		public static void setGameList(Set<Athlete> gameList) {
			SqliteConnection.gameList = gameList;
		}
		
		
		//Method to check for table existence of GameResult in the Database
		public void resultConnCheck() throws IOException{
			try{
 	     		dbconnection = DriverManager.getConnection(urllink);
	           	DatabaseMetaData datmet=dbconnection.getMetaData();
	           	ResultSet cb=datmet.getTables(null, null, "GameResult", null);
	           	if (cb.next()) {
	                System.out.println("Table exists"); 
	                Resultflag = 1;
	                dbconnection.close();
	              } else {
	                System.out.println("Table does not exist"); 
	                Resultflag = 0;
	                dbconnection.close();
	              }
	        
	           	WinnerDBView();
	           	fileWrite(); 
			}catch (SQLException e) {
	                System.out.println(e.getMessage());
	                
	            }
		}
		
		//Method for Writing File using File Writer in a specific location
		
		public void fileWrite(){
			  try {
			//	  DateFormat df = new SimpleDateFormat("yyyy/MM/dd/ : hh-mm-ss"); // add S if you need milliseconds
				//  	Date date = new Date();
				    BufferedWriter out = new BufferedWriter(new FileWriter("/Users/sebytom/Desktop/GameResult.txt"));
				   
					 for(int i=0;i<WinnerList.size();i++)
					 {
						 
					 winnerId=WinnerList.get(i).getAthleteID().toString();
					 winnerTime= WinnerList.get(i).getTime();
					 
					 Time = winnerTime + " ";
					
					 
					 if(i==0){
						 winnerPoints = WinnerList.get(i).getAthletepoints() + 5; 
						 Points = winnerPoints + " ";
					 }
					 if(i==1){
						 winnerPoints = WinnerList.get(i).getAthletepoints() + 2; 
						 Points = winnerPoints + " ";
					 }
					 if(i==2){
						 winnerPoints = WinnerList.get(i).getAthletepoints() + 1; 
						 Points = winnerPoints + " "; 
					 }
					 
				    String everything = winnerId+","+Time+ "," + Points;
				    	
				    	out.write(everything);
				    	out.write("\n");
				    	
				    }
				                                             //you are trying to write  
				    out.close();
				}
				catch (IOException e)
				{
				    System.out.println("Exception ");

				}
		  }
		
		}


        

        
 
    
