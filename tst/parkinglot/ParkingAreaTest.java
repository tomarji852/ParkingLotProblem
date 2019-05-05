/**
 * 
 */
package parkinglot;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author Sunil
 *
 */
class ParkingAreaTest {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testParkCarForGivenCarDetailsWithAvailableSlotThenReturnTrue() {
		//Given: Total slots empty as 6 and details of car to be parked 
		int totalSlots = 6;
		String regNumber = "KA-01-HH-1234", color = "White";
		ParkingArea parkingArea = new ParkingArea(totalSlots); 
		
		//When: Method parkCar is executed
		boolean isParked = parkingArea.parkCar(regNumber, color);
		
		//Then: Verify isParked status as true
		assertEquals(true, isParked);
	}
	
	@Test
	void testParkCarForGivenCarDetailsAndNoSlotIsEmptyThenReturnTrue() {
		//Given: Total slot as 1 and details of car to be parked
		//And: No slot is empty
		int totalSlots = 1;
		String regNumber = "KA-01-HH-1234", color = "White";
		ParkingArea parkingArea = new ParkingArea(totalSlots); 
		parkingArea.parkCar("KA-012-12", "Black");
		
		//When: Method parkCar is executed
		boolean isParked = parkingArea.parkCar(regNumber, color);
		
		//Then: Verify isParked status as false
		assertEquals(false, isParked);
	}
	
	@Test
	void testExitCarForGivenSlotNumberAndCarIsAvailableSlotThenReturnTrue() {
		//Given: Total slot as 1 and slot number for car exit
		int totalSlots = 1;
		ParkingArea parkingArea = new ParkingArea(totalSlots); 
		parkingArea.parkCar("KA-012-12", "Black");
		int exitSlot = 1;
		
		//When: Method parkCar is executed
		boolean isExit = parkingArea.exitCar(exitSlot);
		
		//Then: Verify isExit status as true
		assertEquals(true, isExit);
	}
	
	@Test
	void testExitCarForGivenSlotNumberAndSlotIsAreadyEmptySlotThenReturnFalse() {
		//Given: Total slot as 1 and slot number for car exit
		//And : slot is already empty 
		int totalSlots = 1;
		ParkingArea parkingArea = new ParkingArea(totalSlots); 
		int exitSlot = 1;
		
		//When: Method parkCar is executed
		boolean isExit = parkingArea.exitCar(exitSlot);
		
		//Then: Verify isExit status as false
		assertEquals(false, isExit);
	}
	
	@Test
	void testGetSlotNumberByColorForGivenColorThenReturnListOfSlotNumbersWith2Entries() throws IOException {
		//Given: 3 car are parked and two of them are of white color 
		int totalSlots = 3;
		String color = "White";
		ParkingArea parkingArea = new ParkingArea(totalSlots); 
		parkingArea.parkCar("KA-012-12", "White"); // car 1
		parkingArea.parkCar("KA-016-15", "Black"); // car 2
		parkingArea.parkCar("KA-014-16", "White"); // car 3
		
		//When: Method getSlotNumberByColor is executed
		ArrayList<Integer> slotNumbers = parkingArea.getSlotNumberByColor(color);
		
		//Then: Verify list has slot number as 1, 3
		assertEquals(1,slotNumbers.get(0));
		assertEquals(3,slotNumbers.get(1));
	}
	
	@Test
	void testGetSlotNumberByColorForGivenColorAndNoCarIsPresentInThenSlotForThatColorThenReturnZeroSlot() throws IOException {
		//Given: 3 car are parked and none of them are of white color 
		int totalSlots = 3;
		String color = "White";
		ParkingArea parkingArea = new ParkingArea(totalSlots); 
		parkingArea.parkCar("KA-012-12", "Blue"); // car 1
		parkingArea.parkCar("KA-016-15", "Black"); // car 2
		parkingArea.parkCar("KA-014-16", "Red"); // car 3
		
		//When: Method getSlotNumberByColor is executed
		ArrayList<Integer> slotNumbers = parkingArea.getSlotNumberByColor(color);
		
		//Then: Verify list has no slots
		assertEquals(true,slotNumbers.isEmpty());		
	}
	
	@Test
	void testgetSlotNumberByRegistrationForGivenRegistrationThenReturnListOfSlotNumbersWith1Entries() throws IOException {
		//Given: 3 car are parked and there is one car with given registration number
		int totalSlots = 3;
		String registration = "KA-012-12";
		ParkingArea parkingArea = new ParkingArea(totalSlots); 
		parkingArea.parkCar("KA-012-12", "White"); // car 1
		parkingArea.parkCar("KA-016-15", "Black"); // car 2
		parkingArea.parkCar("KA-014-16", "White"); // car 3
		
		//When: MethodgetSlotNumberByRegistration is executed
		ArrayList<Integer> slotNumbers = parkingArea.getSlotNumberByRegistration(registration);
		
		//Then: Verify list has slot number as 1
		assertEquals(1,slotNumbers.get(0));
	}
	
	@Test
	void testGetSlotNumberByRegistrationForGivenRegistrationThenReturnListOfSlotNumbersWith0Entries() throws IOException {
		//Given: 3 car are parked and there is no car with given registration number
		int totalSlots = 3;
		String registrateion = "MA-012-12";
		ParkingArea parkingArea = new ParkingArea(totalSlots); 
		parkingArea.parkCar("KA-012-12", "White"); // car 1
		parkingArea.parkCar("KA-016-15", "Black"); // car 2
		parkingArea.parkCar("KA-014-16", "White"); // car 3
		
		//When: Method getSlotNumberByRegistration is executed
		ArrayList<Integer> slotNumbers = parkingArea.getSlotNumberByRegistration(registrateion);
		
		//Then: Verify empty list 
		assertEquals(true,slotNumbers.isEmpty());
	}
	
	@Test
	void testGetRegistrationNumberByColorForGivenColorThenReturnListOfSlotNumbersWith2Entries() throws IOException {
		//Given: 3 car are parked and there are two cars of given color
		int totalSlots = 3;
		String color = "White";
		ParkingArea parkingArea = new ParkingArea(totalSlots); 
		parkingArea.parkCar("KA-012-12", "White"); // car 1
		parkingArea.parkCar("KA-016-15", "Black"); // car 2
		parkingArea.parkCar("KA-014-16", "White"); // car 3
		
		//When: Method getRegistrationNumber is executed
		ArrayList<String> regNumbers = parkingArea.getRegistrationNumberByColor(color);	
		
		//Then: Verify list has two reg numbers "KA-014-16", "KA-012-12"
		assertEquals("KA-012-12",regNumbers.get(0));
		assertEquals("KA-014-16",regNumbers.get(1));
	}
	
	@Test
	void testGetRegistrationNumberByColorForGivenColorThenReturnListOfSlotNumbersWith0Entries() throws IOException {
		//Given: 3 car are parked and there are no cars of given color
		int totalSlots = 3;
		String color = "Red";
		ParkingArea parkingArea = new ParkingArea(totalSlots); 
		parkingArea.parkCar("KA-012-12", "White"); // car 1
		parkingArea.parkCar("KA-016-15", "Black"); // car 2
		parkingArea.parkCar("KA-014-16", "White"); // car 3
		
		//When: Method getRegistrationNumber is executed
		ArrayList<String> regNumbers = parkingArea.getRegistrationNumberByColor(color);	
		
		//Then: Verify empty list 
		assertEquals(true,regNumbers.isEmpty());
	}
}




