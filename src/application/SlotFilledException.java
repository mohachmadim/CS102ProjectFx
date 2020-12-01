package application;

public class SlotFilledException extends Exception {
	
	public SlotFilledException() {
		super("error: number is neative");
		
	}

	public SlotFilledException(String message) {
		super(message);
	}

}
