package application;
public class WeeklyCalender{
	
	public boolean[][] WeeklySchedule = new boolean[7][72];
	
    public WeeklyCalender(boolean[][] weeklySchedule) {
		this.WeeklySchedule = weeklySchedule;
	}
    
    public WeeklyCalender() {
    	this.WeeklySchedule = new boolean[7][72];
		this.resetCalender();
	}
    
    public void resetCalender() {
    	for (int columns = 0; columns < 7 ; columns++) {
    		for (int rows = 0; rows < 72; rows++) {
    			this.WeeklySchedule[columns][rows] = false;
    		}
    	}
    }
}