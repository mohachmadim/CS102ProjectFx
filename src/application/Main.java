package application;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Date;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;


public class Main extends Application {
	
	/*
	 * //Creating Text Filed for email        
	 * TextField textField1 = new TextField();    
	 * (0, 0)	(1, 0)	(2, 0)
	 * (0, 1)   (1, 1)  (2, 1)		
	 * (0, 2)	(1, 2)	(2, 2)
	 */
	/******************************************** GUI ********************************************/
	@Override
	public void start(Stage primaryStage) {
		try {
		    //Creating a scene objects without initializing where we will put our different layouts
			Scene homeScene, newMemberScene, newStaffScene, newClassScene, newCoachScene, memberViewScene, staffViewScene;
			
			/******************************************** creating the nodes which will be added to each page(layout)  ********************************************/

			
			//creating Texts and Buttons for the home Page
			Text homeText = new Text("Gym Manager Home Page");
			Button newMember = new Button("Create New Member");
			Button newStaff = new Button("Create New Staff");
			Button newClass = new Button("Create New Class");
			Button newCoach = new Button("Create New Coach");
			Button memberView = new Button("Member View");
			Button staffView = new Button("Staff View");
			
			//creating the TextInputs, Buttons and Text Fields for the newMember Page (layout)
			/*TextField firstName = new TextField();
			TextField firstName = new TextField();
			TextField firstName = new TextField();
			TextField firstName = new TextField();
			TextField firstName = new TextField();
			TextField firstName = new TextField();
			TextField firstName = new TextField();*/ 
			

			/******************************************** Making the Layouts ********************************************/


			//BorderPane root = new BorderPane();
			// creating a kind of layout called gridPane which is like a grid... this will be the home page
			GridPane homePage = new GridPane();
			GridPane newMemberPage = new GridPane();
			GridPane newStaffPage = new GridPane();
			GridPane newClassPage = new GridPane();
			GridPane newCoachPage = new GridPane();
			GridPane memberViewPage = new GridPane();
			GridPane staffViewPage = new GridPane();
			
		    //Setting size for the pane  
			homePage.setMinSize(400, 400);
			homePage.setPadding(new Insets(10, 10, 10, 10));//insets is a padding object (double top, right, bottom, left)
		    //Setting the vertical and horizontal gaps between the columns 
		    homePage.setVgap(50); 
		    homePage.setHgap(50);
		    //Setting the Grid alignment 
		    homePage.setAlignment(Pos.CENTER);
		    
		    //doing the same for the other pages
			newMemberPage.setMinSize(400, 400);
			newMemberPage.setPadding(new Insets(10));
		    newMemberPage.setVgap(50); 
		    newMemberPage.setHgap(50);
		    newMemberPage.setAlignment(Pos.CENTER);
		    
		    newStaffPage.setMinSize(400, 400);      
		    newStaffPage.setPadding(new Insets(10));
		    newStaffPage.setVgap(50);               
		    newStaffPage.setHgap(50);               
		    newStaffPage.setAlignment(Pos.CENTER);  
		    
		    newClassPage.setMinSize(400, 400);      
		    newClassPage.setPadding(new Insets(10));
		    newClassPage.setVgap(50);               
		    newClassPage.setHgap(50);               
		    newClassPage.setAlignment(Pos.CENTER);  
		    
		    newCoachPage.setMinSize(400, 400);      
		    newCoachPage.setPadding(new Insets(10));
		    newCoachPage.setVgap(50);               
		    newCoachPage.setHgap(50);               
		    newCoachPage.setAlignment(Pos.CENTER);  
		    
		    memberViewPage.setMinSize(400, 400);      
		    memberViewPage.setPadding(new Insets(10));
		    memberViewPage.setVgap(50);               
		    memberViewPage.setHgap(50);               
		    memberViewPage.setAlignment(Pos.CENTER);  
		    
		    staffViewPage.setMinSize(400, 400);      
		    staffViewPage.setPadding(new Insets(10));
		    staffViewPage.setVgap(50);               
		    staffViewPage.setHgap(50);               
		    staffViewPage.setAlignment(Pos.CENTER);
		    
			/******************************************** Adding the nodes to the right pages ********************************************/

		    
		    //adding the nodes to the homePage grid
		    homePage.add(memberView, 0, 0); 
		    homePage.add(homeText, 1, 0); 
		    homePage.add(staffView, 2, 0);
		    homePage.add(newMember, 0, 1);  
		    homePage.add(newStaff, 2, 1); 
		    homePage.add(newClass, 1, 2); 
		    homePage.add(newCoach, 2, 2);  
		    
			
			/******************************************** Creating scenes and adding the pages to them then starting the stage ********************************************/

		    
		    //Creating a scene objects where we will put our layout for each scene
			homeScene = new Scene(homePage,1280,720);
			newMemberScene = new Scene(newMemberPage,1280,720);
			newStaffScene = new Scene(newStaffPage,1280,720);
			newClassScene = new Scene(newClassPage,1280,720);
			newCoachScene = new Scene(newCoachPage,1280,720);
			memberViewScene = new Scene(memberViewPage,1280,720);
			staffViewScene = new Scene(staffViewPage,1280,720);
			
			
			//linking the CSS stylesheet to this scene
			homeScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			newMember.setOnAction(e -> primaryStage.setScene(newMemberScene));
			newStaff.setOnAction(e -> primaryStage.setScene(newStaffScene));
			newClass.setOnAction(e -> primaryStage.setScene(newClassScene));
			newCoach.setOnAction(e -> primaryStage.setScene(newCoachScene));
			memberView.setOnAction(e -> primaryStage.setScene(memberViewScene));
			staffView.setOnAction(e -> primaryStage.setScene(staffViewScene));
			
			
			//Setting title to the Stage 
		    primaryStage.setTitle("Home Page"); 
			primaryStage.setScene(homeScene);
			primaryStage.show();
			
		} catch(Exception e) {
			
			e.printStackTrace();
			
		}
		
	}
	
	/******************************************** MAIN PROGRAM ********************************************/
	
	public static void main(String[] args) {
		launch(args);
		
		
		LocalDate Date1 = LocalDate.parse("2019-12-31");//this is how you create a local date
		WorkoutClass[] aliGClasses = new WorkoutClass[3]; 
		/*
		 * each coach can have a max of 3 classes? we must instantiate this variable before making
		 * the coach and we cannot fill it until we make the workout class but we cant make the workout 
		 * class until we make the coach... it's a chicken and egg problem
		*/
		Coach aliG = new Coach("Ali", "G", LocalDate.parse("2095-12-31"), "alig@gmail.com", LocalDate.parse("2019-12-31"), LocalDate.parse("2020-12-31"), "yoga instructor", 500.0, aliGClasses);
		
		int monday[]= {0,1};
		int[] tuesday = {1, 5};
		int[] wednesday = {2, 6};
		List<int[]> yogaSchedIndex = new ArrayList<int[]>();
		boolean b = Collections.addAll(yogaSchedIndex, monday, tuesday, wednesday);

		
		WorkoutClass yogaClass = new WorkoutClass(yogaSchedIndex, "Biceb Workout","Get dem guns",LocalDate.parse("2019-12-31"), LocalDate.parse("2020-06-20"),aliG);
		WorkoutClass[] M1Classes = new WorkoutClass[10];
		WeeklyCalender M1Schedule = new WeeklyCalender(new boolean[7][72]);
		
		Member M1 = new Member("John", "Smith", LocalDate.parse("2019-12-31"), "johnSmith@email.com", LocalDate.parse("2019-12-31"), LocalDate.parse("2019-12-31"), 0, 3);		
		Member M2 = new Member("John", "Smith", LocalDate.parse("2019-12-31"), "johnSmith@email.com", LocalDate.parse("2019-12-31"), LocalDate.parse("2019-12-31"), 0, 3);
		Member M3 = new Member("John", "Smith", LocalDate.parse("2019-12-31"), "johnSmith@email.com", LocalDate.parse("2019-12-31"), LocalDate.parse("2019-12-31"), 0, 3);
		
		
		/*
		 *  //to do
		 *  test all the methods of member 
		 *  create data system and GUI (swift or simple textIO/BufferReader) in main
		 *  	methods to create and update members/staff/classes from user input and save the data in text files
		 *  add the personal trainer class if time allows
		 */
		
		
		/*
		 * http://www.groupkt.com/post/2f40241c/java---how-to-create-and-initialize-a-list-arraylist-in-efficient-way.htm 
		 * 
		 *    List<int[]> innerClass = new ArrayList<int[]>() {{
		 *    	 int[] a = {0,1};
		 *    	 add(a);
		 *    }};
		 *    int[] a = {0,0};
		 *    List<int[]> useCollections = new ArrayList<int[]>();
		 *    boolean b = Collections.addAll(useCollections,a); // returns true if the list changed as a result of the operation
		 *    
		 *    https://www.tutorialspoint.com/java/util/collections_addall.htm
		 * 
		 */
	}
	
	
	
}
