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
				System.out.println(i+1 + "   " + slots.get(i).getParkedCar().getRegistrationNumber() + "  " + slots.get(i).getParkedCar().getColor());
			
		}
	}
	
	public ArrayList<Integer> getSlotNumberByColor(String color) {
		ArrayList<Integer> slotNumbers = new ArrayList<Integer>(); 
		
		for(Slot slot : this.slots) {
			if(slot.getParkedCar().getColor() == color) {
				slotNumbers.add(slot.getParkedCar().getSlotNumber());
			}				
		}
		
		return slotNumbers;
	}
	
	
	public ArrayList<Integer> getSlotNumberByRegistration(String regNumber) {
		ArrayList<Integer> slotNumbers = new ArrayList<Integer>(); 
		
		for(Slot slot : this.slots) {
			ParkedCar parkedCar = slot.getParkedCar();
			if(parkedCar.getRegistrationNumber() == regNumber) {
				slotNumbers.add(parkedCar.getSlotNumber());
			}				
		}
		
		return slotNumbers;
	}
	
	
	public ArrayList<String> getRegistrationNumberByColor(String color) {
		ArrayList<String> registrationNumber = new ArrayList<String>();
		
		for(Slot slot : this.slots) {
			ParkedCar parkedCar = slot.getParkedCar();
			if(parkedCar.getColor() == color) {
				registrationNumber.add(parkedCar.getRegistrationNumber());
			}				
		}
		return registrationNumber;
	}
	
}
