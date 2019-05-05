package parkinglot;

import java.io.*;
import java.util.Scanner;


public class ParkingLotManager {

	public static void main(String[] args) throws FileNotFoundException {
		
		System.out.println("Please enter 1 for taking in put using console otherwise enter 2");
		Scanner choice = new Scanner(System.in);
		String line = null;
		BufferedReader lineReader;
		ParkingArea parkingArea = null;
		try {
			lineReader = new BufferedReader(new InputStreamReader(
					new FileInputStream(System.getProperty("user.dir") + "/inp/file_inputs.txt")));

			while((line = lineReader.readLine()) != null) {
				String[] s = line.split(" ");
				
				int i =0;
				
				while(i < s.length) {

					switch(s[i]) {
						case Constants.CreateParkinLot:
							parkingArea = new ParkingArea(Integer.parseInt(s[+1]));
							i = i+2;
							break;
						
						case Constants.ParkCar:
							boolean parkStatus =  parkingArea.parkCar(s[i+1], s[i+2]);
							if(!parkStatus) {
								OutPutWriter.log(Constants.CarUnavailabilityMessage);
								System.out.println(Constants.CarUnavailabilityMessage);
							}
							i = i+3;
							break;
							
						case Constants.ExitCar:
							boolean exitStatus = parkingArea.exitCar(Integer.parseInt(s[i+1]));
							if(!exitStatus) {
								OutPutWriter.log(Constants.ExitMessage);
								System.out.println(Constants.ExitMessage);
							}
							i=i+2;
							break;
							
						case Constants.Status:
							parkingArea.status();
							i++;
							break;
							
						case Constants.RegNumberByColor:
							parkingArea.getRegistrationNumberByColor(s[i+1]);
							i = i+2;
							break;	
							
						case Constants.SlotNumberByColor:
							parkingArea.getSlotNumberByColor(s[i+1]);
							i = i+2;
							break;	
						
						case Constants.SlotNumberByRegNumber:
							parkingArea.getSlotNumberByRegistration(s[i+1]);
							i = i+2;
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
