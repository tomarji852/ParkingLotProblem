/**
 * 
 */
package parkinglot;

/**
 * This class provide all the constants used in the application
 * @author Sunil
 *
 */
public final class Constants {

	/*
	 * Initial Message for user to take mode of input either from file or from console  
	 */
	public static final String InputGetterMessage = "Please enter 1 for taking input from console enter 2 for text file: ";
	
	/*
	 * Command message to create total number of slot
	 */
	public static final String CreateParkinLot = "create_parking_lot";
	
	/*
	 * Command message to park a car in parking are
	 */
	public static final String ParkCar = "park";
	
	/*
	 * Command message to update the parking lot area when a leaves the parking area
	 */
	public static final String ExitCar = "leave";
	
	/*
	 * Command message to show the current status of parking area (cars with their slots numbers)  
	 */
	public static final String Status = "status";
	
	/*
	 * Command to get Registration number of all car by given color of the car 
	 */
	public static final String RegNumberByColor = "registration_numbers_for_cars_with_colour";
	
	/*
	 * Command to get slot number of all car present in parking area by the color of car 
	 */
	public static final String SlotNumberByColor = "slot_numbers_for_cars_with_colour";
	
	/*
	 * Command to get slot number of all car present in parking area by the registration number of car 
	 */
	public static final String SlotNumberByRegNumber = "slot_number_for_registration_number";
	
	/*
	 * Message to display when no slot is available in parking area
	 */
	public static final String CarUnavailabilityMessage = "Sorry, parking lot is full";
	
	/*
	 * Message to display when slot is already empty 
	 */
	public static final String ExitMessage = "Sorry, given parking lot is already empty";
	
	/*
	 * Message to display when information is not available in parking area for given command 
	 */
	public static final String NotFoundMessage = "Not found";
	
	/*
	 * Message to display when user enters invalid input
	 */
	public static final String InvalidInput = "This is not a valid input. Please enter valid input";
}
