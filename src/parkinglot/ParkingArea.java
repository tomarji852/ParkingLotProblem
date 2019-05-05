package parkinglot;

import java.io.IOException;
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
	
	public void status () throws IOException {
		for(int i = 0;i<totalNumberOfSlots; ++i) {
			if(slots.get(i).getParkedCar() != null) {
				OutPutWriter.log(i+1 + "   " + slots.get(i).getParkedCar().getRegistrationNumber() 
						+ "  " + slots.get(i).getParkedCar().getColor());
				System.out.println(i+1 + "   " + slots.get(i).getParkedCar().getRegistrationNumber() 
						+ "  " + slots.get(i).getParkedCar().getColor());	
			}
		}
	}
	
	public ArrayList<Integer> getSlotNumberByColor(String color) throws IOException {
		ArrayList<Integer> slotNumbers = new ArrayList<Integer>(); 
		boolean found = false;
		String slots = "";
		for(Slot slot : this.slots) {
			if(slot.getParkedCar() !=null && slot.getParkedCar().getColor().equals(color)) {
				found = true;
				slots += slot.getParkedCar().getSlotNumber() +", ";
				slotNumbers.add(slot.getParkedCar().getSlotNumber());
				System.out.print(slot.getParkedCar().getSlotNumber() +", " );
			}				
		}
		if(!found) {
			OutPutWriter.log(Constants.NotFoundMessage);
			System.out.print(Constants.NotFoundMessage);
		}
		OutPutWriter.log(slots);
		System.out.print("\n");
		
		return slotNumbers;
	}
	
	
	public ArrayList<Integer> getSlotNumberByRegistration(String regNumber) throws IOException {
		ArrayList<Integer> slotNumbers = new ArrayList<Integer>(); 
		boolean found = false;
		String slots = "";
		for(Slot slot : this.slots) {
			ParkedCar parkedCar = slot.getParkedCar();
			if(slot.getParkedCar() !=null && parkedCar.getRegistrationNumber().equals(regNumber)) {
				found = true;
				slots += parkedCar.getSlotNumber() +", ";
				slotNumbers.add(parkedCar.getSlotNumber());
				System.out.print(parkedCar.getSlotNumber() +", ");
			}				
		}
		if(!found) {
			OutPutWriter.log(Constants.NotFoundMessage);
			System.out.print(Constants.NotFoundMessage);
		}
		OutPutWriter.log(slots);
		System.out.print("\n");
				
		return slotNumbers;
	}
	
	
	public ArrayList<String> getRegistrationNumberByColor(String color) throws IOException {
		ArrayList<String> registrationNumber = new ArrayList<String>();
		boolean found = false;
		String regNumbers = "";
		for(Slot slot : this.slots) {
			ParkedCar parkedCar = slot.getParkedCar();
			if(slot.getParkedCar() !=null && parkedCar.getColor().equals(color)) {
				found = true;
				regNumbers += parkedCar.getRegistrationNumber()+", ";
				registrationNumber.add(parkedCar.getRegistrationNumber());
				System.out.print(parkedCar.getRegistrationNumber()+", " );
			}				
		}
		if(!found) {
			OutPutWriter.log(Constants.NotFoundMessage);
			System.out.print(Constants.NotFoundMessage);
		}
		OutPutWriter.log(regNumbers);
		System.out.print("\n");
		
		return registrationNumber;
	}
	
}
