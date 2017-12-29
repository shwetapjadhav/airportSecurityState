
package airportSecurityState.util;

import java.io.BufferedReader;
import java.io.File;
//import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileProcessor {
	String filename;
	private String reader;
	public int line_count;

	public FileProcessor() {
		MyLogger.writeMessage("FileProcessor class constructor called", MyLogger.DebugLevel.CONSTRUCTOR);
		line_count = 0;
	}

	public FileProcessor(String inputFile) 
	{
		MyLogger.writeMessage("FileProcessor class constructor called", MyLogger.DebugLevel.CONSTRUCTOR);
		filename = inputFile;
		line_count = 0;
	}

	public String readInLine() {
		line_count = 0;
    	try {
            StringBuilder sb = new StringBuilder();
            BufferedReader b = new BufferedReader(new FileReader(filename));
            MyLogger.writeMessage("IN results", MyLogger.DebugLevel.IN_RESULTS);

            while ((reader = b.readLine()) != null) {
            	sb.append(reader);
            	sb.append("\n");
            	line_count++;
            }
            reader = sb.toString();
            b.close();
        } catch (IOException e) {
        	System.err.println("IO Exception occured:"+e);
            e.printStackTrace();
            System.exit(1);
        }
		return reader;
	}

	public void writeFile(String out) throws Exception {
		FileWriter writer = null;
		try {
			File file = new File(filename);
			file.createNewFile();
			writer = new FileWriter(file.getAbsoluteFile(), true);
			writer.write("\n");
			writer.write(out);
			writer.close();

		} catch (IOException io) {
			System.err.println("I/O Exception: " + io);
			io.printStackTrace();
			System.exit(1);
		} catch (NullPointerException ne) {
			System.err.println("Input file may be empty: "+ ne);
			ne.printStackTrace();
			System.exit(1);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.err.println("Index Out of bound \n");
			e.printStackTrace();
			System.exit(1);
		} finally {
			writer.close();
		}
	}
}

