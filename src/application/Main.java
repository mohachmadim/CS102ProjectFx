package application;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Date;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;


public class Main extends Application {
	//public static int currentFileNumber

	/******************************************************** GUI Start Method Starts the Stage (the window) ********************************************************/
	@Override
	public void start(Stage primaryStage) {
		try {
		    //Creating scene objects without initializing where we will put our different layouts
			Scene homeScene, newMemberScene, newStaffScene, newClassScene, newCoachScene, memberViewScene, staffViewScene;
			
			/******************************************** creating the nodes which will be added to each page(layout)  ********************************************/

			
			/*****Home Page*****/
			//creating Texts and Buttons (nodes) for the home Page
			Text homeText = new Text("Gym Manager Home Page");
			homeText.getStyleClass().add("text");// all we are doing here is adding a css class to this element so we can refer to it in the CSS and style it easily we will do this to all the nodes
			homeText.setId("homeText");          // we add a class to refer to the type (eg. .button{ color: biege} ) and id to refer to the specific node (eg. #homeText{ font: 16}
												 // If we created our nodes with fxml instead of java code we wouldn't have to do this tedious task but, I'm just making this up as I go along and learning new things so ... XD
			Button newMember = new Button("Create New Member");
			newMember.getStyleClass().add("button");
			newMember.setId("newMember"); 
			
			Button newStaff = new Button("Create New Staff");
			newStaff.getStyleClass().add("button");
			newStaff.setId("newStaff");   
			
			Button newClass = new Button("Create New Class");
			newClass.getStyleClass().add("button");
			newClass.setId("newClass");
			
			Button newCoach = new Button("Create New Coach");
			newCoach.getStyleClass().add("button");
			newCoach.setId("newCoach");      
			
			Button memberView = new Button("Member View");
			memberView.getStyleClass().add("button");
			memberView.setId("memberView");      
			
			Button staffView = new Button("Staff View");
			staffView.getStyleClass().add("button");
			staffView.setId("staffView");          
			
			/*****New Member Page*****/
			
			//creating the TextInputs, Buttons and Text Fields for the newMember Page (layout)
			
			//Text inputs for the name and email
			TextField newMember_firstNameTxtF = new TextField();
			newMember_firstNameTxtF.setPromptText("Enter first name.");
			newMember_firstNameTxtF.setPrefColumnCount(10);//set size of text field
			TextField newMember_lastNameTxtF = new TextField();
			newMember_lastNameTxtF.setPromptText("Enter last name.");
			newMember_lastNameTxtF.setPrefColumnCount(10);
			TextField newMember_emailTxtF = new TextField();
			newMember_emailTxtF.setPromptText("Enter email.");
			newMember_emailTxtF.setPrefColumnCount(10);
			
			
			//Texts and Date Pickers for the Start and End Dates and the DOB
			Text newMember_dobText = new Text("Date of Birth: ");
			//date picker to choose date of Birth 
		    DatePicker newMember_dobDatePicker = new DatePicker();
		    //same for start date
			Text newMember_startDateText = new Text("Start Date: "); 
		    DatePicker newMember_startDatePicker = new DatePicker();
		    //same for end date 
			Text newMember_endDateText = new Text("End Date: "); 
		    DatePicker newMember_endDatePicker = new DatePicker();
		    
		    //Radio Buttons for the Type (student or regular)
		    Text newMember_typeText = new Text("Member Type: "); 
		    ToggleGroup newMember_groupType = new ToggleGroup(); 
		    RadioButton newMember_studentRadio = new RadioButton("Student"); 
		    newMember_studentRadio.setToggleGroup(newMember_groupType); 
		    RadioButton newMember_regularRadio = new RadioButton("Regular"); 
		    newMember_regularRadio.setToggleGroup(newMember_groupType); 
		    
		    
		    //a slider for the months a member wants to register
		    Text newMember_monthText = new Text("months: "); 
		    Slider newMember_monthSlider = new Slider(0, 12, 1);
		    newMember_monthSlider.setShowTickMarks(true);//tick marks are shown
		    newMember_monthSlider.setShowTickLabels(true);//and labeled
		    newMember_monthSlider.setSnapToTicks(true);// the slider snaps to the tick marks instead of sliding smoothly
		    newMember_monthSlider.setMajorTickUnit(1.0f);// the tick units have a value of 1
		    newMember_monthSlider.setMin(0.0);           //the min value is 0 month (for users who are paying daily rate
		    newMember_monthSlider.setMinorTickCount(0); //no minor tick marks but the main ticks
		    newMember_monthSlider.setBlockIncrement(1.0f);//this is what the documentation said so I just put 1:The amount by which to adjust the slider if the track of the slider is clicked.
			newMember_monthSlider.setOrientation(Orientation.HORIZONTAL );// the orientation of the slider
		    
			//Register Button
		    Button newMember_registerButton = new Button("Register"); 
		    newMember_registerButton.getStyleClass().add("button");
		    newMember_registerButton.setId("newMember_registerButton");
		    //Go Back Button
		    Button newMember_backButton = new Button("Go Back");
		    newMember_backButton.getStyleClass().add("button");
		    newMember_backButton.setId("newMember_backButton");
		    
		   
		    
			/*
			TextField firstName = new TextField();
			TextField firstName = new TextField();
			TextField firstName = new TextField();
			TextField firstName = new TextField();
			*/
			

			/******************************************** Making the Layouts (Pages) ********************************************/

		    
		    /*****Initializing All the Pages*****/
		    
			// creating a kind of layout called gridPane which is like a grid... These are all the pages we will have
			GridPane homePage = new GridPane();
			GridPane newMemberPage = new GridPane();
			GridPane newStaffPage = new GridPane();
			GridPane newClassPage = new GridPane();
			GridPane newCoachPage = new GridPane();
			GridPane memberViewPage = new GridPane();
			GridPane staffViewPage = new GridPane();
			
			/*****Home Page Layout Config*****/
		    //Setting size for the pane  
			homePage.setMinSize(400, 400);
			homePage.setPadding(new Insets(10, 10, 10, 10));//insets is a padding object (double top, right, bottom, left)
		    //Setting the vertical and horizontal gaps between the columns 
		    homePage.setVgap(50); 
		    homePage.setHgap(50);
		    //Setting the Grid alignment 
		    homePage.setAlignment(Pos.CENTER);
		    
		    /*****New Member Page Layout Config*****/
			newMemberPage.setMinSize(400, 400);
			newMemberPage.setPadding(new Insets(10));
		    newMemberPage.setVgap(50); 
		    newMemberPage.setHgap(50);
		    newMemberPage.setAlignment(Pos.CENTER);
		    
		    /*****New Staff Page Layout Config*****/
		    newStaffPage.setMinSize(400, 400);      
		    newStaffPage.setPadding(new Insets(10));
		    newStaffPage.setVgap(50);               
		    newStaffPage.setHgap(50);               
		    newStaffPage.setAlignment(Pos.CENTER);  
		    
		    /*****New Class Page Layout Config*****/
		    newClassPage.setMinSize(400, 400);      
		    newClassPage.setPadding(new Insets(10));
		    newClassPage.setVgap(50);               
		    newClassPage.setHgap(50);               
		    newClassPage.setAlignment(Pos.CENTER);  
		    
		    /*****New Coach Page Layout Config*****/
		    newCoachPage.setMinSize(400, 400);      
		    newCoachPage.setPadding(new Insets(10));
		    newCoachPage.setVgap(50);               
		    newCoachPage.setHgap(50);               
		    newCoachPage.setAlignment(Pos.CENTER);  
		    
		    /*****Member View Page Layout Config*****/
		    memberViewPage.setMinSize(400, 400);      
		    memberViewPage.setPadding(new Insets(10));
		    memberViewPage.setVgap(50);               
		    memberViewPage.setHgap(50);               
		    memberViewPage.setAlignment(Pos.CENTER);  
		    
		    /*****Staff View Page Layout Config*****/
		    staffViewPage.setMinSize(400, 400);      
		    staffViewPage.setPadding(new Insets(10));
		    staffViewPage.setVgap(50);               
		    staffViewPage.setHgap(50);               
		    staffViewPage.setAlignment(Pos.CENTER);
		    
		    
			/******************************************** Adding the nodes to the right pages ********************************************/

			/*                GRID SYSTEM
			 *         (0, 0)	(1, 0)	(2, 0)
			 *         (0, 1)   (1, 1)  (2, 1)		
			 *         (0, 2)	(1, 2)	(2, 2)
			 */
		    
		    /*****Home Page Node Placement*****/
		    homePage.add(memberView, 0, 0); 
		    homePage.add(homeText, 1, 0); 
		    homePage.add(staffView, 2, 0);
		    homePage.add(newMember, 0, 1);  
		    homePage.add(newStaff, 2, 1); 
		    homePage.add(newClass, 1, 2); 
		    homePage.add(newCoach, 2, 2);
		    
		    
		    /*****New Member Page Node Placement*****/
		    //Input Texts
		    newMemberPage.add(newMember_firstNameTxtF, 1, 0); 
		    newMemberPage.add(newMember_lastNameTxtF, 1, 1);       
		    newMemberPage.add(newMember_emailTxtF, 1, 2);       
		    
		    //Input Date Pickers
		    newMemberPage.add(newMember_dobText, 0, 3); 
		    newMemberPage.add(newMember_dobDatePicker, 1, 3); 
		    newMemberPage.add(newMember_startDateText, 0, 4); 
		    newMemberPage.add(newMember_startDatePicker, 1, 4);       
		    newMemberPage.add(newMember_endDateText, 0, 5); 
		    newMemberPage.add(newMember_endDatePicker, 1, 5); 
		    
		    //Input Radio Buttons
		    newMemberPage.add(newMember_typeText, 0, 6);       
		    newMemberPage.add(newMember_studentRadio, 1, 6);
		    newMemberPage.add(newMember_regularRadio, 2, 6);
		    
		    //The month slider
		    newMemberPage.add(newMember_monthText, 0, 7); 
		    newMemberPage.add(newMember_monthSlider, 1, 7);  
		    
		    //Register and Back Buttons
		    newMemberPage.add(newMember_registerButton, 2, 9);
		    newMemberPage.add(newMember_backButton, 0, 9);
		    
		    
		    /********************************************************************** Handling Events **********************************************************************/
		    
		    /*
		     * Set an setOnMouseClicked listener using Using Convenience Methods. this function is activated whenever the register button is clicked. it will create 
		     * an object file for each member which can later be read and searched from the member view 
		     * https://www.tutorialspoint.com/javafx/javafx_event_handling.htm
		     */
		    newMember_registerButton.setOnMouseClicked((new EventHandler<MouseEvent>() { 
		    	
		         public void handle(MouseEvent event) { 
		        	 try{
		        		 
		        		 Member M1;
		        		 if(newMember_studentRadio.isSelected()) {
		        			M1 = createMember(newMember_firstNameTxtF.getText(), newMember_lastNameTxtF.getText(), newMember_dobDatePicker.getValue(), newMember_emailTxtF.getText(), newMember_startDatePicker.getValue(), newMember_endDatePicker.getValue(), 1, (int)newMember_monthSlider.getValue());
		        		 } else if(newMember_regularRadio.isSelected()) {
		        			M1 = createMember(newMember_firstNameTxtF.getText(), newMember_lastNameTxtF.getText(), newMember_dobDatePicker.getValue(), newMember_emailTxtF.getText(), newMember_startDatePicker.getValue(), newMember_endDatePicker.getValue(), 0, (int)newMember_monthSlider.getValue());
		        		 }else { 
		        			M1 = createMember(newMember_firstNameTxtF.getText(), newMember_lastNameTxtF.getText(), newMember_dobDatePicker.getValue(), newMember_emailTxtF.getText(), newMember_startDatePicker.getValue(), newMember_endDatePicker.getValue(), 100, (int)newMember_monthSlider.getValue());
		        		 }
		        		 
		        		 System.out.println(M1.toString());
		        		 
		        		 //create a file output stream and give it a directory. replace all uses regex to remove all spaces. 
		        		 //https://knpcode.com/java/java-basics/remove-spaces-from-string-java-trim-strip/
		        		 String fileName = (M1.getfName() + M1.getlName() + ".txt").replaceAll("\\s+", "");
		        		 FileOutputStream f = new FileOutputStream(new File("output/members/" + fileName));
		        		 //create an object output stream and give it a file output stream
		        		 ObjectOutputStream o = new ObjectOutputStream(f);
		        		 
		        		 // Write objects to file
		                 o.writeObject(M1);
		                 
		                 //close the streams
		                 o.close();
		                 f.close();
		                 
		                 
		                 
		                 /*
		                  * When reading the files we will do something like this
		                  * 
		                  * FileInputStream fi = new FileInputStream(new File("myObjects.txt"));
		                  * ObjectInputStream oi = new ObjectInputStream(fi);
		                  * 
		                  * // Read objects
		                  * Member M2 = (Member) oi.readObject();
		                  * 
		                  * System.out.println(pr1.toString());
		                  * System.out.println(pr2.toString());
		                  * 
		                  * fi.close();
		                  * oi.close()
		                  * 
		                  *  // and add this exception
		                  *  
		                  * catch (ClassNotFoundException e) {
		                  * 	// TODO Auto-generated catch block
		                  * 	e.printStackTrace();
		                  * }
		                  */
		                 
		        	 } catch (InvalidDateException e) {
		                 System.out.println(e.getMessage());
		        	 } catch (InvalidEmailException e) {
		                 System.out.println(e.getMessage());
		        	 } catch (EmptyStringException e) {
		                 System.out.println(e.getMessage());
		        	 } catch (EmptyTypeException e) {
		                 System.out.println(e.getMessage());
		             } catch (FileNotFoundException e) {
		                 System.out.println("File not found");
		             } catch (IOException e) {
		                 System.out.println("Error initializing stream");
		             } catch(Exception e){
		            	 e.printStackTrace();
		        	 }
		        	 
		        	 
		          } 
		       }));
		    
		    
			
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
	
	public static Member createMember(String fn, String ln, LocalDate dob, String email, LocalDate startDate, LocalDate endDate, int type, int months) throws InvalidDateException, InvalidEmailException, EmptyStringException, EmptyTypeException {
		//java regex (regular expression) used to facilitate searches of string types. We will use this to set the allowable pattern for email.
		String EMAIL_REGEX = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
		
		if(endDate.isBefore(startDate)) {
			throw new InvalidDateException("End Date cannot be before Start Date!");
		}
		
		if(!email.matches(EMAIL_REGEX)) {
			throw new InvalidEmailException("Invalid Email!");
		}
		
		if(fn == "" || ln == "") {
			throw new EmptyStringException("First Name or Last Name can't be empty! ");
		}
		
		if(type == 100) {
			throw new EmptyTypeException("You must choose a member type!");
		}
		
		
		return new Member(fn, ln, dob, email, startDate, endDate, type, months);
		
		
		
		
	}
	
}
