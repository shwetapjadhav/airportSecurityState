package airportSecurityState.util;

public class Results implements FileDisplayInterface, StdoutDisplayInterface 
{
	FileProcessor fp;
	public String[] result = new String[10000];
	public int counter = 0;

	public Results(FileProcessor fileIn) {
		fp = fileIn;
	}

	public void writeToStdout(String str) {
	//	MyLogger.writeMessage("From Results", MyLogger.DebugLevel.FROM_RESULTS);
    		System.out.println(str);

	}

	public void writeToFile(String str) {
		try {
			fp.writeFile(str);
	//		MyLogger.writeMessage("From Results", MyLogger.DebugLevel.FROM_RESULTS);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void storeNewResults(String str) {
		MyLogger.writeMessage("FROM Results", MyLogger.DebugLevel.FROM_RESULTS);
		System.out.println(str);
		result[counter] = str;
		counter++;

	}
}
