package application;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class SampleController {
	public Member M2 = null;
	
	@FXML
	Button memberView_goBackButton;
	
	@FXML
	TextField memberView_fullNameTxtF ;
	@FXML
	Button memberView_findMemberButton;
	@FXML
    Label memberView_memberFnText;
	Button memberView_setFnButton;
	@FXML
	TextField memberView_setFnTxtF;
	
	@FXML
    Label memberView_memberLnText;
	Button memberView_setLnButton;
	@FXML
	TextField memberView_setLnTxtF;

	@FXML
    Label memberView_memberDobText;
	Button memberView_setDobButton;
	@FXML
	DatePicker memberView_setDobTxtF;

	@FXML
    Label memberView_memberEmailText;
	Button memberView_setEmailButton;
	@FXML
	TextField memberView_setEmailTxtF;

	@FXML
    Label memberView_memberSDText;
	Button memberView_setSDButton;
	@FXML
	DatePicker memberView_setSDTxtF;

	@FXML
    Label memberView_memberTypeText;
	Button memberView_setTypButton;
	@FXML
	TextField memberView_setTypeTxtF;

	@FXML
    Label memberView_memberEDText;
	Button memberView_setEDButton;
	@FXML
	DatePicker memberView_setEDTxtF;

	@FXML
    Label memberView_memberMonthsText;
	Button memberView_setMonthsButton;
	@FXML
	TextField memberView_setMonthsTxtF;

	@FXML
    Label memberView_memberFeesText;
	Button memberView_setFeesButton;
	@FXML
	TextField memberView_setFeesTxtF;
	
	
	
	public void setType() {
		
		M2.setType(Integer.parseInt(memberView_setTypeTxtF.getText()));
		M2.setFees(M2.calculateFees(Integer.parseInt(memberView_setTypeTxtF.getText()), M2.months));
		
		memberView_memberTypeText.setText(M2.getType());
		memberView_memberFeesText.setText(Double.toString(M2.getFee()));
		
		
	}

	public void setFees() {
		M2.setFees(Double.parseDouble(memberView_setFeesTxtF.getText()));
		memberView_memberFeesText.setText(Double.toString(M2.getFee()));
	}
	
	public void setfName() {
		M2.setfName(memberView_setFnTxtF.getText());
		memberView_memberFnText.setText(M2.getfName());
	}
	
	public void setlName() {
		M2.setlName(memberView_setLnTxtF.getText());
		memberView_memberLnText.setText(M2.getlName());
		
	}
	
	public void setMonth() {
		M2.months = Integer.parseInt(memberView_setMonthsTxtF.getText());
		memberView_memberMonthsText.setText(Integer.toString(M2.months));
		
	}
	
	public void setdOB() {
		M2.setdOB(memberView_setDobTxtF.getValue());
		memberView_memberDobText.setText(M2.getdOB().toString());
		
	}
	
	public void setEmail() {
		M2.setEmail(memberView_setEmailTxtF.getText());
		memberView_memberEmailText.setText(M2.getEmail());
		
	}
	
	public void setStartDate() {
		M2.setStartDate(memberView_setSDTxtF.getValue());
		memberView_memberSDText.setText(M2.getStartDate().toString());
		
	}
	
	public void setEndDate() {
		M2.setEndDate(memberView_setEDTxtF.getValue());
		memberView_memberEDText.setText(M2.getEndDate().toString());
		
	}
	
	public void findMember() {
		
		
		
		try{
			
			System.out.println(memberView_fullNameTxtF.getText());
			
			String fileName = memberView_fullNameTxtF.getText().replaceAll("\\s+", "") + ".ser";
			System.out.println(fileName);
			
			FileInputStream fi = new FileInputStream(new File("output/members/" + fileName));
			ObjectInputStream oi = new ObjectInputStream(fi);
			
			Object obj = oi.readObject();
			
			// Read objects
			M2 = (Member) obj;
			
			System.out.println(M2.toString());
			
			fi.close();
			oi.close();
			
			memberView_memberFnText.setText(M2.getfName());
			memberView_memberLnText.setText(M2.getlName());
			memberView_memberDobText.setText(M2.getdOB().toString());
			memberView_memberSDText.setText(M2.getStartDate().toString());
			memberView_memberEDText.setText(M2.getEndDate().toString());
			memberView_memberMonthsText.setText(Integer.toString(M2.months));
			memberView_memberEmailText.setText(M2.getEmail());
			memberView_memberTypeText.setText(M2.getType());
			memberView_memberFeesText.setText(Double.toString(M2.getFee()));
			
			 
		}catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
        	e.printStackTrace();
            System.out.println("Error initializing stream");
        } catch(Exception e){
       	 e.printStackTrace();
   	 	}
		
		
		//memberView_fullNameTxtF.setText("success");
		
		//System.out.println(memberView_fullNameTxtF.getText());
	}
	
	public void memberView_saveChangeButton() {
		try{
		   	
   		    System.out.println(M2.toString());
   		    
   		    //create a file output stream and give it a directory. replace all uses regex to remove all spaces. 
   		    //https://knpcode.com/java/java-basics/remove-spaces-from-string-java-trim-strip/
   		    String fileName = (M2.getfName() + M2.getlName() + ".ser").replaceAll("\\s+", "");
   		    FileOutputStream f = new FileOutputStream(new File("output/members/" + fileName));
   		    //create an object output stream and give it a file output stream
   		    ObjectOutputStream o = new ObjectOutputStream(f);
   		    
   		    // Write objects to file
            o.writeObject(M2);
            
            //close the streams
            o.close();
            f.close();
            
            
            
            /*
             * When reading the files we will do something like this
             * We must make sure that the object is serialiazable. this means all its properties and its super classes are serializable
             * https://www.tutorialspoint.com/java/java_serialization.htm
             * https://docs.oracle.com/javase/8/docs/api/java/io/InvalidClassException.html
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
		}catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
        	e.printStackTrace();
            System.out.println("Error initializing stream");
        } catch(Exception e){
       	 e.printStackTrace();
   	 	}
	}
	
}
