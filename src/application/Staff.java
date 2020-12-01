package application;
import java.time.LocalDate;
import java.util.Date;

public abstract class Staff extends Person{
	
	private double salary;
    public String designation;
    
    
     public Staff(String fn, String ln, LocalDate dob, String email, LocalDate startDate, LocalDate endDate, double salary, String designation) {
		super(fn, ln, dob, email, startDate, endDate);
		this.salary = salary;
		this.designation = designation;
	}


	public double getSalary() {
		return salary;
	}


//	public abstract double calculateSalary() ;

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getDesignation() {
		return designation;
	}

	

	public void setDesignation(String designation) {
		this.designation = designation;
	}


	@Override
	public String toString() {
		return "staff profile: " + super.toString() + "salary = " + getSalary()+ ", designation = " + this.designation;
	}

     
     

     
 }