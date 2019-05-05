package parkinglot;

/**
 * This class contains properties and functionality of the cars 
 * which are parked or going to be parked in parking area
 * @author Sunil
 *
 */
public class ParkedCar {
	private String color;
	private String registrationNumber;
	private int slotOccupied;
	
	public ParkedCar(String color, String regNumber, int slotOccupied) {
		this.color = color;
		this.registrationNumber = regNumber;
		this.slotOccupied = slotOccupied;
	} 
	
	/**
	 * This method will give the color of care
	 * @return string as a color
	 */
	public String getColor() {
		return color;		
	}
	
	/**
	 * This method is providing the registration number of the car
	 * @return registrationNumber string 
	 */
	public String getRegistrationNumber() {
		return registrationNumber;		
	}
	
	/**
	 * This method is providing the slot number in which car is parked
	 * @return integer value of slot number
	 */
	public int getSlotNumber() {
		return slotOccupied;		
	}
}
