package application;
import java.util.Date;
import java.time.*;

public abstract class Person{

    private String fName;
    private String lName;
    private LocalDate dOB;
    private String email;
    private LocalDate startDate;
    private LocalDate endDate;

    public Person(String fn, String ln, LocalDate dob, String email, LocalDate startDate, LocalDate endDate)
    {
        this.fName = fn;
        this.lName = ln;
        this.dOB = dob;
        this.email = email;
        this.startDate = startDate;
        this.endDate = endDate;
        System.out.println("New person is created");
    }
    
    public Person(String fn, String ln, LocalDate dob, String email)
    {
        this.fName = fn;
        this.lName = ln;
        this.dOB = dob;
        this.email = email;
        System.out.println("New person is created");
    }

    
    
    public String toString()
    {
        
		return "First Name= " + getfName() +  ",  Date of Birth= " + dOB + ", Email=  " + email+ ", Start Date =" +startDate+ ", End Date = " +endDate;
	
    }



	public String getfName() {
		return fName;
	}



	public void setfName(String fName) {
		this.fName = fName;
	}



	public String getlName() {
		return lName;
	}



	public void setlName(String lName) {
		this.lName = lName;
	}



	public LocalDate getdOB() {
		return dOB;
	}



	public void setdOB(LocalDate dOB) {
		this.dOB = dOB;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public LocalDate getStartDate() {
		return startDate;
	}



	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}



	public LocalDate getEndDate() {
		return endDate;
	}



	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
}