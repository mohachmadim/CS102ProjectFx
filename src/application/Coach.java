package application;
import java.time.LocalDate;
import java.util.Date;

public class Coach extends Staff {
	public WorkoutClass[] courses = new WorkoutClass[3];

	public Coach(String fn, String ln, LocalDate dob, String email, LocalDate startDate, LocalDate endDate, String designation, double salary, WorkoutClass[] courses) {
		super(fn, ln, dob, email, startDate, endDate, salary, designation);
		this.courses = courses;

	}
	
	/*
	 *   // to do
	 * add method to add/remove a workout class to courses by class name
	 */
	
	


	}

