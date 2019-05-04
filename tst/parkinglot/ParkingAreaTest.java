/**
 * 
 */
package parkinglot;

import static org.junit.jupiter.api.Assertions.*;

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
	void testExitCarForGivenSlotNumberAndCarIsAvailableThenSlotThenReturnTrue() {
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
	void testExitCarForGivenSlotNumberAndSlotIsAreadyEmptyThenSlotThenReturnFalse() {
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

}
