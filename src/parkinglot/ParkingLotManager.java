package parkinglot;

import java.io.*;
import java.util.Scanner;

/**
 * This is a flow class or controller of all the activity inside parking area
 * This class the driver class for the application 
 * ParkingLotManager will manage parking area 
 * @author Sunil
 *
 */
public class ParkingLotManager {

	/**
	 * Main function to manage parking area and slots 
	 * this method will decide which functionality to call for given command
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		
		Scanner choice = new Scanner(System.in);
		int a;
		
		String line = null;
		BufferedReader lineReader = null;
		ParkingArea parkingArea = null;
		
		//loop will terminate only when application will get the right choice to read input from console or file
		while(lineReader == null) {
			System.out.println(Constants.InputGetterMessage);
			a = choice.nextInt();

			switch(a) {
			case 1:  // case to read input from console
				lineReader = new BufferedReader(new InputStreamReader(System.in));
				break;
			case 2:  // case to read input from txt file
				try {
					lineReader = new BufferedReader(new InputStreamReader(
							new FileInputStream(System.getProperty("user.dir") + "/inp/file_inputs.txt")));							
				}
				catch(IOException e) {
					System.out.print(e);
				}
				break;
			default: // if other choice is given it will show error message
				System.out.println(Constants.InvalidInput);				
			}
		}
		
		// This flow will be called once after system will have the input to executed the command
		try {
			while(( line = lineReader.readLine()) != null) {
				String[] s = line.split(" ");				
				int i =0;						
				while(i < s.length) {
					switch(s[i]) {
						case Constants.CreateParkinLot:  // create parking lot with given number of slots
							try {
								if(i+1 < s.length) {
									parkingArea = new ParkingArea(Integer.parseInt(s[i+1]));
								}
							}catch(NumberFormatException e) {
								System.out.println(s[i+1] + " is not a valid interger");
							}
							
							i = i+2;
							break;
						
						case Constants.ParkCar: // Park a car inside the parking area in nearest slot from entry
							if(parkingArea != null && i+2 < s.length) {
								boolean parkStatus =  parkingArea.parkCar(s[i+1], s[i+2]);
								if(!parkStatus) {
									OutPutWriter.log(Constants.CarUnavailabilityMessage);
									System.out.println(Constants.CarUnavailabilityMessage);
								}
							}
							i = i+3;
							break;
							
						case Constants.ExitCar: // exit the car and update the parking area when car leaves
							if(parkingArea != null && i+1 < s.length) {	
								try {  
									boolean exitStatus = parkingArea.exitCar(Integer.parseInt(s[i+1]));								
									if(!exitStatus) {
										OutPutWriter.log(Constants.ExitMessage);
										System.out.println(Constants.ExitMessage);
									}
								}catch(NumberFormatException e) { // catch exception when invalid slot value is provide as input
									System.out.println(s[i+1] + " is not a valid interger");
								}								
							}
							i=i+2;
							break;
							
						case Constants.Status: // provide the current status of parking area (car in slots)
							if(parkingArea != null)
								parkingArea.status();
							i++;
							break;
							
						case Constants.RegNumberByColor: // provide the information registration number by color of the car
							if(parkingArea != null && i+1 < s.length)
								parkingArea.getRegistrationNumberByColor(s[i+1]);
							i = i+2;
							break;	
							
						case Constants.SlotNumberByColor: // provide the information slot number by color of the car
							if(parkingArea != null && i+1 < s.length)
								parkingArea.getSlotNumberByColor(s[i+1]);
							i = i+2;
							break;	
						
						case Constants.SlotNumberByRegNumber: // provide the information slot number by registration of the car
							if(parkingArea != null && i+1 < s.length)
								parkingArea.getSlotNumberByRegistration(s[i+1]);
							i = i+2;
							break;
							
						default :  // handle the case when other input commands are provided 
							System.out.println(Constants.InvalidInput);
							OutPutWriter.log(Constants.InvalidInput);
							i++;
							break;
					} 
				}							
			}
		}
		catch(IOException e) { 
			System.out.print(e);
		}
	}	
}	
 
