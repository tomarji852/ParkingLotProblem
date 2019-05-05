package parkinglot;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SlotTest {
	
	@BeforeEach
	void setUp() throws Exception {		
	}

	@Test
	void testIsSlotEmptyWhenParkedIsNull() {
		//Give: Parked car is null
		ParkedCar parkedCar = null;
		Slot slot = new Slot(1,parkedCar);
		
		boolean isEmpty = slot.isSlotEmpty();
		
		assertEquals(isEmpty, true);
	}
	
	@Test
	void testIsSlotEmptyWhenParkedIsNotNull() {
		//Give: car is parked in slot 1
		ParkedCar parkedCar = new ParkedCar("White", "KA-01-HH-1234", 1);
		Slot slot = new Slot(1,parkedCar);
		
		boolean isEmpty = slot.isSlotEmpty();
		
		//Check isEmpty as false;
		assertEquals(isEmpty, false);
	}
	
	@Test
	void testGetParkedCarWhenSlotHasCar() {
		//Give: car is parked in slot 1
		ParkedCar parkedCar = new ParkedCar("White", "KA-01-HH-1234", 1);
		Slot slot = new Slot(1,parkedCar);
		
		ParkedCar expectedCar = slot.getParkedCar();
		
		//Check details of parked car;
		assertEquals(expectedCar, parkedCar);
	}
	
	@Test
	void testSetParkedCarWhenSlotHasNoCar() {
		//Give: car is leaving in slot 1
		ParkedCar parkedCar = new ParkedCar("White", "KA-01-HH-1234", 1);
		Slot slot = new Slot(1,parkedCar);
		
		slot.setParkedCar(null);
		
		//Check details of parked car;
		assertEquals(slot.getParkedCar(), null);
	}

}
