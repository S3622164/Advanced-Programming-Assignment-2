/*
 * Seby Tom
 * 
 */


package Ozlympics;

import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Point2D;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Tooltip;
import javafx.scene.control.cell.ComboBoxListCell;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;

public class Ozlympics extends Application {
	
	//	Object Declarations
	public static Set<Athlete> selectedPlayers = new HashSet<Athlete>();
	FileConnection fileconn = new FileConnection();
	SqliteConnection sqldb=new SqliteConnection();
 
    TableView table = new TableView();
	Random ran=new Random();
	Swimming swim=new Swimming();
	Running run=new Running();
	Cycling cycle=new Cycling();
	Athlete arraname;
	Set<Athlete> gameList;
	NoRefereeException Noref = new NoRefereeException();
	
	//GUI Properties and Elements
	 Button buttonscene1, buttonscene2,buttonscene3,buttonscene4,buttonscene5;
	 Button selecButton,playerselectedButton,officialButton,officialSelectButton;
	 
	 //Labels Declarations
	 Label mainLabel, eventLabel,officialLabel,eventSelection;
	 Label RefreeLabel,GameFullLabel,GameFewLabel;
	 
	 // Scene Declaration
	 Scene mainScene, eventScene,athleteScene,athleteSelecScene,WinnerScene,scene;
	 Scene NoRefreeScene,GameFullScene,GameFewScene;
	 Scene officialScene = new Scene(new Group());
	 //Pane Declaration
	 FlowPane mainPage, EventPage;
	 FlowPane NoRefereePane,GameFullPane,GameFewPane;
	 
	// List View Declarations
	 ObservableList<String> candidates;
	 ObservableList<String> candidatesSelectionCheck;
	 ObservableList<String> officialCandidates;
	 ObservableList<String> winnersTable;
	 ArrayList <Athlete> athletedetails;
	 ObservableList<String> selected = FXCollections.observableArrayList();
	 ListView<String> playerListView;
	 ArrayList<Athlete> SelectedPlayerlistView = new ArrayList<Athlete>();
	 ArrayList<String> name=new ArrayList<String>();
	 ListView<String> listView;
	 ListView listView1 = new ListView();
	 ListView listView2 = new ListView();
	  ListView<String> candidatesListView;
	  ArrayList <Athlete>athleteSelectedforGame;
	 
	
	  
	  //Declaration of Stages
	  Stage thestage;
	  Node GameFullstage;
	
	  int gameFinishArrayLength;
	  String potential;
	  Rectangle rect = new Rectangle(150, 30);
	  StringBuilder AthleteEverything;
	  int  timeFinishAthlete;
	  int	time;
	  int counter =0;
	  int submitbutton =0;
	  String namepass = " ";
	  String selectedPerson = " ";

	     
	   // Database Credentail Declaration
	  
	   	String urllink = "jdbc:sqlite:/Users/sebytom/Sqlite/OzlympicsDB.db";
	   	Connection dbconnection = null;
	   	@Override
	    
	    //Setting up the primary stage
	   	
	   	public void start(Stage primaryStage) throws IOException, SQLException  {

	    // 	Checking if the Database exist at the specified Location
	   		
	     	File dbFile = new File("/Users/sebytom/Sqlite/OzlympicsDB.db");
			if(!dbFile.exists()){
				System.out.println("DB EXISTS!");
				sqldb.DBflag = 1;
				DBHandle();									//Method call for Database Handling
				
			}else{
				System.out.println("DB NOT EXISTS!");
				sqldb.DBflag = 1;
				FileConnection.filehandle();				// Method call for File Handling
			}

	    	
			/*
			 *   Graphical User Interface for Ozlympics
			 Primary Stage - Start Screen					
			 *
			 */
	        thestage=primaryStage;
	        buttonscene1=new Button("START");
	        buttonscene1.setPrefSize(250,100);
	        mainPage.setMargin(buttonscene1, new Insets(250, 0, 20, 50));
	        mainLabel=new Label("OZLYMPICS");
	        mainLabel.setTranslateX(230);
	        mainLabel.setTranslateY(-50);
	        mainLabel.setTextFill(Color.WHITE);
	        mainLabel.setStyle("-fx-font: 24 TimesNewRoman;");
	        mainPage=new FlowPane();
	        mainPage.setVgap(10);
	        mainPage.setStyle("-fx-background-color: black;-fx-padding: 10px;");
	        mainScene = new Scene(mainPage, 600, 400);
	        mainPage.getChildren().addAll(mainLabel, buttonscene1);
	        
	        // Event Selection Screen
	        
	        buttonscene2=new Button("BACK");
	        buttonscene2.setTranslateX(-90);
	        buttonscene2.setTranslateY(-5);
	        buttonscene3=new Button("SWIMMING");
	        buttonscene3.setPrefSize(100,50);
	        buttonscene4=new Button("CYCLING");
	        buttonscene4.setPrefSize(100,50);
	        buttonscene5=new Button("RUNNING");
	        buttonscene5.setPrefSize(100,50);
	        buttonscene1.setOnAction(e-> ButtonClicked(e));
	        buttonscene2.setOnAction(e-> ButtonClicked(e));
	        buttonscene3.setOnAction(e-> swimmingButtonClicked(e));
	        buttonscene4.setOnAction(e-> cyclingButtonClicked(e));
	        buttonscene5.setOnAction(e-> runningButtonClicked(e));
	                
	        eventLabel=new Label("EVENTS :");
	        eventLabel.setTextFill(Color.WHITE);
	        eventLabel.setStyle("-fx-font: 20 TimesNewRoman;");
	        eventLabel.setTranslateX(160);
	        eventLabel.setTranslateY(-90);
	        eventSelection=new Label("Please select one :");
	        eventSelection.setTextFill(Color.WHITE);
	        eventSelection.setStyle("-fx-font: 17 TimesNewRoman;");
	        eventSelection.setTranslateX(60);
	        eventSelection.setTranslateY(-60);
	        EventPage=new FlowPane();
	        EventPage.setVgap(10);
	        EventPage.setMargin(buttonscene2, new Insets(350,0, 20, -150));
	        EventPage.setStyle("-fx-background-color: black;-fx-padding: 10px;");
	        EventPage.getChildren().addAll(eventLabel,eventSelection, buttonscene2,buttonscene3,buttonscene4,buttonscene5);
	        eventScene = new Scene(EventPage, 600, 400);	        
		        
		        primaryStage.setTitle("Ozlympics!");
		        primaryStage.setScene(mainScene);
		        primaryStage.show();
	    
		} 
	
	   	// Method call for checking TABLE existence in Database
	   	
 	    public void DBHandle() throws IOException{
 	    	try{
     	   	dbconnection = DriverManager.getConnection(urllink);
           	DatabaseMetaData datmet=dbconnection.getMetaData();
           	ResultSet cb=datmet.getTables(null, null, "OZParticipants", null);
           	if (cb.next()) {
                System.out.println("Table exists"); 
                sqldb.dbflag = 1;
    			SqliteConnection.DbConnector();					// Method for Database call
                dbconnection.close();
              } else {
                System.out.println("Table does not exist"); 
                sqldb.dbflag = 0;
                SqliteConnection.DbConnector();					// Method for Database call
                dbconnection.close();
              }
 	    	}catch (SQLException e) {

     	    }
 	    }

 	    	/*
 	    	 * Assigning actions to buttons
 	    	 *The START button action	*/
 	    
	 public void ButtonClicked(ActionEvent e){
	        if (e.getSource()==buttonscene1)
	            thestage.setScene(eventScene);
	        else
	            thestage.setScene(mainScene);
	    }
	 
	 		/*Assigning actions to buttons
	 		 	*The START button action	*/
	 
	  public void athleteSelecbuttonClicked(ActionEvent e){
	        String message = "";
	        ObservableList<String> athletes;
	        athletes = listView.getSelectionModel().getSelectedItems();
	        for(String m: athletes)
	            message += m + "\n";
	        
	        System.out.println(message);
	    }
	
	  
	  /*Assigning actions to buttons
	 	*The Swimming button action	*/
	  
	 public void swimmingButtonClicked(ActionEvent e){
		 sqldb.typeAthlete = "swimmer";
		 if(e.getSource() == buttonscene3) {
			sqldb.athleteDBAdd();
			 listViewDisplay(sqldb.typeAthlete);	// Method for Athlete List View is called
			 thestage.setScene(athleteScene);
			 }
			 else{
				 thestage.setScene(eventScene);}	
		 }
	 
	 /*Assigning actions to buttons
	 	*The Cycling button action	*/
	 
	public void cyclingButtonClicked(ActionEvent e){
		sqldb.typeAthlete = "cyclist";
		 if(e.getSource() == buttonscene4) {
			sqldb.athleteDBAdd();
			 listViewDisplay(sqldb.typeAthlete);		// Method for Athlete List View is called
			 thestage.setScene(athleteScene);
			 }
			 else{
				 thestage.setScene(eventScene);}
		 }
	
	/*Assigning actions to buttons
 	*The Cycling button action	*/
	
	 public void runningButtonClicked(ActionEvent e){
		 sqldb.typeAthlete = "sprinter";
		 if(e.getSource() == buttonscene5) {
			sqldb.athleteDBAdd();
			 listViewDisplay(sqldb.typeAthlete);		// Method for Athlete List View is called
			 thestage.setScene(athleteScene);
			 }
			 else{
				 thestage.setScene(eventScene);}
		 }

	 /*Assigning actions to buttons
	 	*The LOAD button action for loading Athletes for the Game	*/
	 
	 public void SubmitButtonClicked(ActionEvent e){				 
		 if(e.getSource() == playerselectedButton) {
				officialselect();							// Method for officials select called
				thestage.setScene(officialScene);	
		 }
	 }
	 
	 /*Assigning actions to buttons
	 	*The NEXT button in the Official's Screen for selecting the official for the Game
	 	*
	 	*The Game Starts 
	 	*Winners of the Game are displayed
	 	*The result shown on Console and DB/File
	 	*											*/
	 
	 public void OfficialNextButton(ActionEvent e) throws IOException{
		 if(e.getSource() == officialSelectButton) {
			 startGame();									//Method for Starting Game
			 WinnerListView();								//Method for Winners Display
			 sqldb.resultConnCheck();						//Method for writing results to Database
			thestage.setScene(WinnerScene); 
		 }
			else{
				thestage.setScene(athleteScene);
			}}
			
	 		//Initialise the game
		 public void startGame(){
			 
				
				for(Athlete Athlete:sqldb.athleteSelectedforGame){
					time = randomTimeGeneration();
					Athlete.setTime(time);			
					sqldb.finishtime.add(Athlete);
				}
				Collections.sort(
						sqldb.finishtime,Collections.reverseOrder((Athlete1, Athlete2) -> Athlete1.getTime()
		                        - Athlete2.getTime()));

				if(sqldb.finishtime.size()<3){
					for(int i =0;i<sqldb.finishtime.size();i++){
						sqldb.WinnerList.add(sqldb.finishtime.get(i));
						fileconn.fileAthleteWrite.add(sqldb.finishtime.get(i));
					}	
				}
				else{
				for(int i =0;i<3;i++){
					sqldb.WinnerList.add(sqldb.finishtime.get(i));
					fileconn.fileAthleteWrite.add(sqldb.finishtime.get(i));
					
					}
				}
			}
		 
		 		// Table view to print the Winner List
		 
		 public void WinnerListView(){
			int winnerCount=0;
			int firstPlace =0;
			int secondPlace =0;
			int thirdPlace=0;
			

			 String WinnerPoints="Points of the Players";
			 String line = "---------------------------";
			 listView2.getItems().add(WinnerPoints);
			 listView2.getItems().add(line);
			 for(int i=0;i<sqldb.WinnerList.size();i++){
				 
				 sqldb.WinnerPoints.add(sqldb.WinnerList.get(i));
				 if(winnerCount==0){
					 firstPlace = sqldb.WinnerList.get(i).getAthletepoints()+5;
					 String details = sqldb.WinnerList.get(i).getAthleteID() + " " +sqldb.WinnerList.get(i).getAthletename() + " ->  " + firstPlace;
					 listView2.getItems().add(details);
					 
				 }
				 if(winnerCount==1){
					 secondPlace = sqldb.WinnerList.get(i).getAthletepoints()+2;
					 String details = sqldb.WinnerList.get(i).getAthleteID() + " " +sqldb.WinnerList.get(i).getAthletename() + " ->  " + secondPlace;
					 listView2.getItems().add(details);
						 }
				 if(winnerCount==2){
					 thirdPlace = sqldb.WinnerList.get(i).getAthletepoints()+1;
					 String details = sqldb.WinnerList.get(i).getAthleteID() + " " +sqldb.WinnerList.get(i).getAthletename() + " ->  " + thirdPlace;
					listView2.getItems().add(details);
						 }
				 winnerCount++;
			 }
			 
			 String Winners="Winners of The Game";
			 String lines = "---------------------------";
			 listView1.getItems().add(Winners);
			 listView1.getItems().add(lines);
			 listView1.getItems().add("Referee is :");
			 listView1.getItems().add(sqldb.officialSelection);
			 listView1.getItems().add("Players are :");
			 for(int i=0;i<sqldb.WinnerList.size();i++){
				 String every = sqldb.WinnerList.get(i).getAthletetype() +" " + sqldb.WinnerList.get(i).getAthleteID() + " " + sqldb.WinnerList.get(i).getAthletename() + " " + sqldb.WinnerList.get(i).getAthleteage() + " " + sqldb.WinnerList.get(i).getAthletestate() ;
				 listView1.getItems().add(every);
				 
			 }

			 System.out.println(AthleteEverything);
			 HBox hbox = new HBox(listView1,listView2);
		     WinnerScene = new Scene(hbox, 600, 400);
		 }

		 			// Random Number Generation corresponding in Events
		 
		 public int randomTimeGeneration(){
			String randomplayertype = sqldb.typeAthlete; 
			
			if(randomplayertype.equals("swimmer")){
				int maxTime = swim.getMaxTime();							// Max time of Swimming retrieved
				int minTime = swim.getMinTime();							// Min time of Swimming retrieved
				  timeFinishAthlete= ran.nextInt((maxTime-minTime)+1)+minTime; //random number generated
				  System.out.println(maxTime);
				  System.out.println(minTime);
				  System.out.println(timeFinishAthlete);

			}
			if(randomplayertype.equals("sprinter")){
				int maxTime = run.getMaxTime();								// Max time of Running retrieved
				int minTime = run.getMinTime();								// Min time of Running retrieved
				  timeFinishAthlete= ran.nextInt((maxTime-minTime)+1)+minTime;//random number generated
			}
			if(randomplayertype.equals("cyclist")){
				int maxTime = cycle.getMaxTime();							// Max time of Cycling retrieved
				int minTime = cycle.getMinTime();							// Min time of Cycling retrieved
				  timeFinishAthlete= ran.nextInt((maxTime-minTime)+1)+minTime;//random number generated
			}
			 return timeFinishAthlete;
		}
		 
		 			// Method for Selecting Officials
		 
	 public void officialselect(){
		 
		 			System.out.println("");
		 			System.out.println("Selecting Official Method Reached");
		 			sqldb.StringtoObjectSelectedPlayers();
		 			sqldb.AddOfficials();									//Official Add method
		 			officialCandidates = FXCollections.observableArrayList(); 
		 
		 			for(Athlete Athlete: sqldb.official){
		 				System.out.println(Athlete.getAthletename());
		 				officialCandidates.add(Athlete.getAthletename().toString());
		 				}
		 		
		      ChoiceBox<String> choiceBox = new ChoiceBox<String>(officialCandidates);
		      choiceBox.setPrefSize(200, 30);
		      choiceBox.setTranslateY(50);
		      
		      choiceBox.setItems(officialCandidates);
		      officialLabel=new Label("OFFICIAL SELECT");
		      officialLabel.setTranslateX(40);
		      officialLabel.setTranslateY(-60);
		      officialLabel.setTextFill(Color.WHITE);
		      officialLabel.setStyle("-fx-font: 16 TimesNewRoman;");
		      sqldb.officialSelected.add(sqldb.officialSelection);
		      
		      officialSelectButton =new Button("NEXT");
		      officialSelectButton.setTranslateX(320);
		      officialSelectButton.setTranslateY(200);
		      
		      // No Referee Exception Handled
		      
		      officialSelectButton.setOnAction(e-> {
		    	  sqldb.officialSelection = choiceBox.getSelectionModel().getSelectedItem();
		    	  if(sqldb.officialSelection != null){
		    			try {
							OfficialNextButton(e);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
		    	  }
		    	  else{
		    		  NoReferee();
		    		  thestage.setScene(NoRefreeScene);			// No Referee Exception
		    		  try {
		 					throw new NoRefereeException();
		 					}catch(NoRefereeException r) {
		 					}
		 		 }});
		      System.out.println("The Official is: "+ sqldb.officialSelection); 
		      VBox box = new VBox();
		      box.setPadding(new Insets(100, 50, 50, 200));
		      box.setSpacing(10);
		      box.setStyle("-fx-background-color: BLACK;");
		      
		      box.getChildren().addAll(choiceBox,officialSelectButton,officialLabel);
		       officialScene = new Scene(box,600, 400);
		       officialScene.setFill(null);
	 } 
	 
	// Method for pop up window for No Referee Exception
	 
	 
	 public void NoReferee(){

			RefreeLabel=new Label("NO REFREE, PLEASE ADD REFREE");
			RefreeLabel.setTranslateX(150);
			RefreeLabel.setTranslateY(150);
			RefreeLabel.setTextFill(Color.BLACK);
			RefreeLabel.setStyle("-fx-font: 20 TimesNewRoman;");
			
			
		NoRefereePane=new FlowPane();
		NoRefereePane.setStyle("-fx-background-color: RED;");
		NoRefereePane.getChildren().add(RefreeLabel);
		NoRefreeScene = new Scene(NoRefereePane, 600, 400);

		}
	 
	 public String candidateValueCheck(String potential2){

			 String[] candidatesToString = potential2.split("-");
			 String name=candidatesToString[0];
			 String type=candidatesToString[1];
			 System.out.println(name);
			 System.out.println(type);
			 for(Athlete Athlete: sqldb.gameList){
				 if(Athlete.getAthletename().equals(name) && Athlete.getAthletetype().equals(sqldb.typeAthlete ) || 
						 Athlete.getAthletename().equals(name) && Athlete.getAthletetype().equals("super")){
					 selected.add(name);
					 sqldb.athleteSelected.add(name);  
				 }
			 }

	        this.name.add(namepass);
			 return name;		
	 }
	 	 
	 
	 	/*List view
	 	 * //TooFewAthleteException Handled
	 	 * GameFullException Handles	 	 */
	 
	 private void listViewDisplay(String type) {
	 		
	 		String typeOfAthlete = type;   
	 	    BorderPane root = new BorderPane();	     
	 	    playerselectedButton=new Button("LOAD");
	 	    playerselectedButton.setTranslateX(535); 
	 	    playerselectedButton.setOnAction(e-> {
	 	    int size =sqldb.athleteSelected.size();
	 	    	  if(size>=4 && size<=8){
	 	    		 submitbutton =1;
	 	    	  	}
	 	    	  if(size>=0 && size< 4){
	 	    		 try {
		 	    			GameFew();
			 	    		thestage.setScene(GameFewScene);
		 	 					throw new TooFewAthleteException();//TooFewAthleteException Handled
		 	 					}catch(TooFewAthleteException g) {
		 	 					} 
	 	    	  			}
	 	    	  
	 	    	  if(size>8){
	 	    		 try {
			 	    		GameFull();
			 	    		thestage.setScene(GameFullScene);
			 					throw new GameFullException();// GameFullException Handled
			 					}catch(GameFullException g) {
			 					}
	 	    	  			}
	 	   
	 	      if(submitbutton==1){
	 	    	 SubmitButtonClicked(e);
	 	      		}});
	 	    
	 			    GridPane gridpane = new GridPane();
	 			    gridpane.setPadding(new Insets(5));
	 			    gridpane.setHgap(10);
	 			    gridpane.setVgap(10);
	 			    ColumnConstraints column1 = new ColumnConstraints(150, 150,
	 			        Double.MAX_VALUE);
	 			    ColumnConstraints column2 = new ColumnConstraints(50);
	 			    ColumnConstraints column3 = new ColumnConstraints(150, 150,
	 			        Double.MAX_VALUE);
	 			    column1.setHgrow(Priority.ALWAYS);
	 			    column3.setHgrow(Priority.ALWAYS);
	 			    gridpane.getColumnConstraints().addAll(column1, column2, column3);

	 			    Label candidatesLbl = new Label("Athletes");
	 			    GridPane.setHalignment(candidatesLbl, HPos.CENTER);
	 			    gridpane.add(candidatesLbl, 0, 0);

	 			    Label selectedLbl = new Label("Players");
	 			    gridpane.add(selectedLbl, 2, 0);
	 			    GridPane.setHalignment(selectedLbl, HPos.CENTER);

	 			    System.out.println("reached here 3");
	 			    candidates = FXCollections.observableArrayList();
	 			  
	 			    for(Athlete Athlete: sqldb.gameList){
	 			        System.out.println(Athlete.getAthletename());
	 			        candidates.add(Athlete.getAthletename().toString()+"-"+Athlete.getAthletetype().toString());
	 			    }

	 			     candidatesListView = new ListView<>(candidates);
	 			     gridpane.add(candidatesListView, 0, 1);
	 			     Button sendRightButton = new Button(" > ");
	 			     sendRightButton.setOnAction((ActionEvent event) -> {
	 			    	
	 			  potential = candidatesListView.getSelectionModel().getSelectedItem();
	 			  System.out.println("Value of potential is "+potential);
	 			  selectedPerson =candidateValueCheck(potential);
	 			      if (selectedPerson != null) {
	 			    	 System.out.println("VALUE IS "+selectedPerson);
 			    		 candidates.remove(potential);
	 			      }
	 			      else{
	 			    	System.out.println("Please select some Player to move forward");	 	 			    
		 			    		  }});
	 			     playerListView = new ListView<String>(selected); 
	 			     gridpane.add(playerListView, 2, 1);
	 			   
	 			    VBox vbox = new VBox(5);
	 			    vbox.getChildren().addAll(sendRightButton);
	 			    gridpane.add(vbox, 1, 1);
	 			    root.setCenter(gridpane);
	 			    root.setBottom(playerselectedButton);
	 			    GridPane.setVgrow(root, Priority.ALWAYS);
	 			    athleteScene = new Scene(root, 600, 400, Color.BLACK);
	 	}
	 
	 	//Method for pop up window for GameFullException 
	 
	 public void GameFull(){

			GameFullLabel=new Label("THE GAME HAS MORE THAN 8 PARTICIPANTS");
			GameFullLabel.setTranslateX(100);
			GameFullLabel.setTranslateY(150);
			GameFullLabel.setTextFill(Color.BLACK);
			GameFullLabel.setStyle("-fx-font: 20 TimesNewRoman;");
					
			GameFullPane=new FlowPane();
			GameFullPane.setStyle("-fx-background-color: RED;");
			GameFullPane.getChildren().add(GameFullLabel);
			GameFullScene = new Scene(GameFullPane, 600, 400);	
				}
	 
	 	// Method for pop up window for TooFewAthleteException 

	 public void GameFew(){

			GameFewLabel=new Label("PARTICIPANTS LIMIT ABOVE 4");
			GameFewLabel.setTranslateX(100);
			GameFewLabel.setTranslateY(150);
			GameFewLabel.setTextFill(Color.BLACK);
			GameFewLabel.setStyle("-fx-font: 20 TimesNewRoman;");
	
			GameFewPane=new FlowPane();
			GameFewPane.setStyle("-fx-background-color: RED;");
			GameFewPane.getChildren().add(GameFewLabel);
			GameFewScene = new Scene(GameFewPane, 600, 400);					
				}
	
	public static void main(String[] args) {
		launch(args);
	}
}
