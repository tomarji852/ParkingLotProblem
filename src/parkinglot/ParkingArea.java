package parkinglot;

import java.util.ArrayList;

public class ParkingArea {
	
	private int currentEmptySlots;
	private int totalNumberOfSlots;	
	private ArrayList<Slot> slots;
	
	public ParkingArea(int numberOfSlots) {
		this.totalNumberOfSlots = numberOfSlots;
		slots = new ArrayList<Slot>(numberOfSlots);
		for(int i=0;i<numberOfSlots;++i) {			 
			this.slots.add(new Slot(i+1 ,null));
		}			
	}
	
	
	/**
	 * 
	 * @param regNumber
	 * @param color
	 */
	public boolean parkCar(String regNumber, String color) {			
		boolean isCarParked = false;
		
		for(int i =0;i<this.totalNumberOfSlots;++i) {
			if(slots.get(i).isSlotEmpty()) {
				slots.get(i).setParkedCar(new ParkedCar(color, regNumber, i+1));
				isCarParked = true;
				break;
			}			
		}
		
		return isCarParked;
	}
	
	
	public boolean exitCar(int slotNumber) {
		boolean isCarExit = false;
		
		if(!slots.get(slotNumber-1).isSlotEmpty()) {
			slots.get(slotNumber-1).setParkedCar(null);
			isCarExit = true;
		} 
		
		return isCarExit;
	}
	
	public void status () {
		for(int i = 0;i<totalNumberOfSlots; ++i) {
			if(slots.get(i).getParkedCar() != null)
				System.out.println(i+1 + "   " + slots.get(i).getParkedCar().getRegistrationNumber() 
						+ "  " + slots.get(i).getParkedCar().getColor());			
		}
	}
	
	public ArrayList<Integer> getSlotNumberByColor(String color) {
		ArrayList<Integer> slotNumbers = new ArrayList<Integer>(); 
		boolean found = false;
		for(Slot slot : this.slots) {
			if(slot.getParkedCar().getColor().equals(color)) {
				found = true;
				slotNumbers.add(slot.getParkedCar().getSlotNumber());
				System.out.print(slot.getParkedCar().getSlotNumber() +", " );
			}				
		}
		if(!found)System.out.print(Constants.NotFoundMessage);
		System.out.print("\n");
		
		return slotNumbers;
	}
	
	
	public ArrayList<Integer> getSlotNumberByRegistration(String regNumber) {
		ArrayList<Integer> slotNumbers = new ArrayList<Integer>(); 
		boolean found = false;
		for(Slot slot : this.slots) {
			ParkedCar parkedCar = slot.getParkedCar();
			if(parkedCar.getRegistrationNumber().equals(regNumber)) {
				found = true;
				slotNumbers.add(parkedCar.getSlotNumber());
				System.out.print(parkedCar.getSlotNumber() +", ");
			}				
		}
		if(!found)System.out.print(Constants.NotFoundMessage);
		System.out.print("\n");
		
		return slotNumbers;
	}
	
	
	public ArrayList<String> getRegistrationNumberByColor(String color) {
		ArrayList<String> registrationNumber = new ArrayList<String>();
		boolean found = false;
		for(Slot slot : this.slots) {
			ParkedCar parkedCar = slot.getParkedCar();
			if(parkedCar.getColor().equals(color)) {
				found = true;
				registrationNumber.add(parkedCar.getRegistrationNumber());
				System.out.print(parkedCar.getRegistrationNumber()+", " );
			}				
		}
		if(!found)System.out.print(Constants.NotFoundMessage);
		System.out.print("\n");
		
		return registrationNumber;
	}
	
}
