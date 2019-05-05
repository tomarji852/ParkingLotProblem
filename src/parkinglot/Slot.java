package parkinglot;

/**
 * This class contains properties and functionality of slots 
 * of given parking area
 * @author Sunil
 *
 */
public class Slot {
	private int slotNumber;
	private ParkedCar parkedCar;
	
	public Slot(int slotNumber, ParkedCar parkedCar ) {
		this.slotNumber = slotNumber;
		this.parkedCar = parkedCar;
	} 
	
	/**
	 * Method checks the slot where it is empty or file
	 * @return boolean value
	 */
	public boolean isSlotEmpty() {		
		return (parkedCar == null);
	}
	
	/**
	 * Method provide the parked car details
	 * @return car object
	 */
	public ParkedCar getParkedCar() {		
		return parkedCar;
	}
	
	/**
	 * This method set the car in particular slot
	 * @param parkedCar
	 */
	public void setParkedCar(ParkedCar parkedCar) {
		 this.parkedCar = parkedCar;
	}		
}
