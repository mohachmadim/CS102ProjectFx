package application;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class SampleController {
	public Member M2 = null;
	@FXML
	TextField memberView_fullNameTxtF ;
	@FXML
	Button memberView_findMemberButton;
	@FXML
    Label memberView_memberFnText;
	Button memberView_setFnButton;
	@FXML
    Label memberView_memberLnText;
	Button memberView_setLnButton;

	@FXML
    Label memberView_memberDobText;
	Button memberView_setDobButton;

	@FXML
    Label memberView_memberEmailText;
	Button memberView_setEmailButton;

	@FXML
    Label memberView_memberSDText;
	Button memberView_setSDButton;

	@FXML
    Label memberView_memberTypeText;
	Button memberView_setTypButton;

	@FXML
    Label memberView_memberEDText;
	Button memberView_setEDButton;

	@FXML
    Label memberView_memberMonthsText;
	Button memberView_setMonthsButton;

	@FXML
    Label memberView_memberFeesText;
	Button memberView_setFeesButton;
	
	
	
	
	
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
			
			 // and add this exception
			 
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
	
}
