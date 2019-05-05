package parkinglot;

import java.io.*;
import java.util.Scanner;

/**
 * 
 * @author Sunil
 *
 */
public class ParkingLotManager {

	/**
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		
		Scanner choice = new Scanner(System.in);
		int a;
		
		String line = null;
		BufferedReader lineReader = null;
		ParkingArea parkingArea = null;
		
		while(lineReader == null) {
			System.out.println(Constants.InputGetterMessage);
			a = choice.nextInt();

			switch(a) {
			case 1:
				lineReader = new BufferedReader(new InputStreamReader(System.in));
				break;
			case 2:
				try {
					lineReader = new BufferedReader(new InputStreamReader(
							new FileInputStream(System.getProperty("user.dir") + "/inp/file_inputs.txt")));							
				}
				catch(IOException e) {
					System.out.print(e);
				}
				break;
			default:
				System.out.println(Constants.InvalidInput);				
			}
		}
		
		
		try {
			while(( line = lineReader.readLine()) != null) {
				String[] s = line.split(" ");
				
				int i =0;						
				while(i < s.length) {
					switch(s[i]) {
						case Constants.CreateParkinLot:
							if(i+1 < s.length)parkingArea = new ParkingArea(Integer.parseInt(s[i+1]));
							i = i+2;
							break;
						
						case Constants.ParkCar:
							if(parkingArea != null && i+2 < s.length) {
								boolean parkStatus =  parkingArea.parkCar(s[i+1], s[i+2]);
								if(!parkStatus) {
									OutPutWriter.log(Constants.CarUnavailabilityMessage);
									System.out.println(Constants.CarUnavailabilityMessage);
								}
							}
							i = i+3;
							break;
							
						case Constants.ExitCar:
							if(parkingArea != null && i+1 < s.length) {	
								try {
									boolean exitStatus = parkingArea.exitCar(Integer.parseInt(s[i+1]));								
									if(!exitStatus) {
										OutPutWriter.log(Constants.ExitMessage);
										System.out.println(Constants.ExitMessage);
									}
								}catch(NumberFormatException e) {
									System.out.println(s[i+1] + " is not a valid interger");
								}
								
							}
							i=i+2;
							break;
							
						case Constants.Status:
							if(parkingArea != null)
								parkingArea.status();
							i++;
							break;
							
						case Constants.RegNumberByColor:
							if(parkingArea != null && i+1 < s.length)
								parkingArea.getRegistrationNumberByColor(s[i+1]);
							i = i+2;
							break;	
							
						case Constants.SlotNumberByColor:
							if(parkingArea != null && i+1 < s.length)
								parkingArea.getSlotNumberByColor(s[i+1]);
							i = i+2;
							break;	
						
						case Constants.SlotNumberByRegNumber:
							if(parkingArea != null && i+1 < s.length)
								parkingArea.getSlotNumberByRegistration(s[i+1]);
							i = i+2;
							break;
						default :
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
 
