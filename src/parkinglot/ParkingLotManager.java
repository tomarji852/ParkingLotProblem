package parkinglot;

import java.io.*;
import java.util.Scanner;


public class ParkingLotManager {

	public static void main(String[] args) {
		
		System.out.println("Please enter 1 for taking in put using console otherwise enter 2");
		
		String line = null;
		BufferedReader lineReader;
		ParkingArea parkingArea = null;
		try {
			lineReader = new BufferedReader(new InputStreamReader(
					new FileInputStream(System.getProperty("user.dir") + "/inp/file_inputs.txt")));

			while((line = lineReader.readLine()) != null) {
				String[] s = line.split(" ");
				
				//System.out.print(line);
				int i =0;
				
				while(i < s.length) {

					switch(s[i]) {
						case Constants.CreateParkinLot:
							parkingArea = new ParkingArea(Integer.parseInt(s[+1]));
							i = i+2;
							break;
						
						case Constants.ParkCar:
							boolean parkStatus =  parkingArea.parkCar(s[i+1], s[i+2]);
							if(!parkStatus)System.out.print("No slot is available");
							i = i+3;
							break;
							
						case Constants.ExitCar:
							parkingArea.exitCar(Integer.parseInt(s[i+1]));
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
	
	public static void log(String message) throws IOException { 
	      PrintWriter out = new PrintWriter(new FileWriter("output.txt", true), true);
	      out.write(message);
	      out.close();
	    }
}
