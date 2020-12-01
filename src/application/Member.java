package application;

import java.time.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Member extends Person {

	private int type;
	private double fee;
	public static double oneMonthRate = 100;
	public static double threeMonthRate = 95;
	public static double sixMonthRate = 90;
	public static double yearlyRate = 80;
	public static double studentDiscount = 0.9;// for now.(10%)
	public double discount;
	//public WorkoutClass[] registeredClasses = new ;
	public int months;
	//public WeeklyCalender memberSchedule;
	//public List<int[]> filledSlotsIndex = new ArrayList<int[]>(); // {[1,0], [1,1], ...} has the addresses that contain
																	// true

	public Member(String fn, String ln, LocalDate dob, String email, LocalDate startDate, LocalDate endDate, int type, int months) {
		// this constructor is if the user inputs months start date and end date

		super(fn, ln, dob, email, startDate, endDate);

		this.type = type;
		this.months = months;
		this.fee = calculateFees(type, this.months);
		//this.memberSchedule = memberSchedule;
		// this.memberSchedule.resetCalender();//set all slots to false
	}

	public Member(String fn, String ln, LocalDate dob, String email, LocalDate startDate, int type, int months) {
		// this constructor is if the user only inputs months and start date

		super(fn, ln, dob, email);
		super.setStartDate(startDate);

		LocalDate endDate = startDate.plusMonths(Integer.toUnsignedLong(months));// can throw InputMismatchException and
																					// if a negative is given it is
																					// converted to a large number
																					// making it apparent but not
																					// throwing an error
		super.setEndDate(endDate);

		this.type = type;
		this.months = months;
		this.fee = calculateFees(type, this.months);
		//this.memberSchedule = memberSchedule;
		//this.memberSchedule.resetCalender();
		// set all slots to false
	}

	public Member(String fn, String ln, LocalDate dob, String email, int type, int months) {
		// this constructor is if the user only inputs months

		super(fn, ln, dob, email);

		LocalDate startDate = LocalDate.now();
		super.setStartDate(startDate);
		LocalDate endDate = startDate.plusMonths(Integer.toUnsignedLong(months));
		super.setEndDate(endDate);

		this.type = type;
		this.months = months;
		this.fee = calculateFees(type, this.months);
		//this.memberSchedule = memberSchedule;
		//this.memberSchedule.resetCalender();
		// set all slots to false
	}

	public double calculateFees(int Type, int Months) {
		if (type == 1) {

			if (months == 3) {
				return months * threeMonthRate * studentDiscount;
			}

			else if (months == 6) {
				return months * sixMonthRate * studentDiscount;
			}

			else if (months == 12) {
				return months * yearlyRate * studentDiscount;
			}

			else {
				return months * oneMonthRate * studentDiscount;
			}
		}

		else {
			if (months == 3) {
				return months * threeMonthRate;
			}

			else if (months == 6) {
				return months * sixMonthRate;
			}

			else if (months == 12) {
				return months * yearlyRate;
			}

			else {
				return months * oneMonthRate;
			}
		}
	}

	public double getFee() {
		return this.fee;
	}

	public String getType() {
		if (type == 1) {
			return "Student member";
		} else {
			return "Regular member";
		}
	}

	public void setType(int Type) {
		this.type = Type;
		setFees(calculateFees(Type, months));
	}

	public void setFees(double fees) {
		this.fee = fees;
	}
	
	
	/*

	public void addCLassesToSchedule() throws SlotFilledException {
		// add exception if schedule is already filled
		for (WorkoutClass workoutClass : this.registeredClasses) { // loop through classes in resgisteredClasses[]
																	// array; each class is stored in workoutClass
			for (int columns = 0; columns < 7; columns++) { // loop through columns for each
															// WorkoutCourse.weeklySchedule in the ^ array
				for (int rows = 0; rows < 72; rows++) { // loop through the rows (times)
					if (workoutClass.workoutSchedule.WeeklySchedule[columns][rows]
							&& !this.memberSchedule.WeeklySchedule[columns][rows]) {
						throw new SlotFilledException("this slot is already filled");
					}
					if (workoutClass.workoutSchedule.WeeklySchedule[columns][rows]) { // checks if this
																						// WorkoutCourse.workoutSchedule
																						// slot has a true in it and if
																						// so,
						this.memberSchedule.WeeklySchedule[columns][rows] = true; // adds true to the corresponding
																					// Member.memberSchedule.WeeklySchedule
																					// cell
						int[] address = { columns, rows }; // update the filled slots index
						this.filledSlotsIndex.add(address);
					}

				}
			}
		}
	}
	
	*/

	/*
	 * // to do 
	 * add a method to remove classes from schedule add method that updates
	 * the registered classes and calls the addClassToSchedule() or the remove class
	 * method. or should this be in the main?
	 * 
	 */

}