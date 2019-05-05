package parkinglot;

import java.io.*;
import java.util.Scanner;


public class ParkingLotManager {

	public static void main(String[] args) {
		
		System.out.println(Constants.InputGetterMessage);
		Scanner choice = new Scanner(System.in);
		int a = choice.nextInt();
		
		String line = null;
		BufferedReader lineReader = null;
		ParkingArea parkingArea = null;
		
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
			}
		
		try {
			while((line = lineReader.readLine()) != null) {
				String[] s = line.split(" ");
				
				int i =0;						
				while(i < s.length) {
					switch(s[i]) {
						case Constants.CreateParkinLot:
							if(i+1 < s.length)parkingArea = new ParkingArea(Integer.parseInt(s[i+1]));
							i = i+2;
							break;
						
						case Constants.ParkCar:
							if(i+2 < s.length) {
								boolean parkStatus =  parkingArea.parkCar(s[i+1], s[i+2]);
								if(!parkStatus) {
									OutPutWriter.log(Constants.CarUnavailabilityMessage);
									System.out.println(Constants.CarUnavailabilityMessage);
								}
							}
							i = i+3;
							break;
							
						case Constants.ExitCar:
							if(i+1 < s.length) {
								boolean exitStatus = parkingArea.exitCar(Integer.parseInt(s[i+1]));
								if(!exitStatus) {
									OutPutWriter.log(Constants.ExitMessage);
									System.out.println(Constants.ExitMessage);
								}
							}
							i=i+2;
							break;
							
						case Constants.Status:
							parkingArea.status();
							i++;
							break;
							
						case Constants.RegNumberByColor:
							if(i+1 < s.length)parkingArea.getRegistrationNumberByColor(s[i+1]);
							i = i+2;
							break;	
							
						case Constants.SlotNumberByColor:
							if(i+1 < s.length)parkingArea.getSlotNumberByColor(s[i+1]);
							i = i+2;
							break;	
						
						case Constants.SlotNumberByRegNumber:
							if(i+1 < s.length)parkingArea.getSlotNumberByRegistration(s[i+1]);
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
 
