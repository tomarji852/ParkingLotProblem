package parkinglot;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 
 * @author Sunil
 * this class contains the method to write out
 */
public class OutPutWriter {

	public OutPutWriter() {
		
	}
	
	/**
	 * This method will write message in fileoutout.txt file
	 * @param message
	 * @throws IOException
	 */
	public static void log(String message) throws IOException { 
	      PrintWriter writer = new PrintWriter(new FileWriter(System.getProperty("user.dir") + "/output/file_output.txt", true), true);
	      writer.write(message + "\n");	      
	      writer.close();
	}

}
