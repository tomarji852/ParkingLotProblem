package parkinglot;

public class Slot {
	private int slotNumber;
	private ParkedCar parkedCar;
	
	public Slot(int slotNumber, ParkedCar parkedCar ) {
		this.slotNumber = slotNumber;
		this.parkedCar = parkedCar;
	} 
	
	public boolean isSlotEmpty() {		
		return (parkedCar == null);
	}
	
	public ParkedCar getParkedCar() {		
		return parkedCar;
	}
	
	public void setParkedCar(ParkedCar parkedCar) {
		 this.parkedCar = parkedCar;
	}		
}
