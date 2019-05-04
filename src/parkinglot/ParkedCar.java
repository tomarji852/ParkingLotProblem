package parkinglot;

public class ParkedCar {
	private String color;
	private String registrationNumber;
	private int slotOccupied;
	
	public ParkedCar(String color, String regNumber, int slotOccupied) {
		this.color = color;
		this.registrationNumber = regNumber;
		this.slotOccupied = slotOccupied;
	}
}
