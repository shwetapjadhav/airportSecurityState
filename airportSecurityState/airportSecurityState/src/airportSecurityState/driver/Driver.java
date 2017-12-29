package airportSecurityState.driver;

import airportSecurityState.airportStates.AirportStateContext;
import airportSecurityState.airportStates.AirportStateHelper;
import airportSecurityState.util.FileProcessor;
import airportSecurityState.util.MyLogger;
import airportSecurityState.util.Results;

public class Driver 
{
	static String outputString;
	static int i;
	static String fileWrite[] = new String[3];
	static String[] result = new String[10000];
	static AirportStateContext context;

	public static void main(String[] args) 
	{
			if (args.length == 3) 
			{
				try {
						FileProcessor fp1 = new FileProcessor(args[0]);
						FileProcessor outFile = new FileProcessor(args[1]);
						i = Integer.parseInt(args[2]);
						MyLogger.setDebugValue(i);
						Results res = new Results(outFile);
						AirportStateHelper helper = new AirportStateHelper();
						context = new AirportStateContext(res);
						
						outputString = fp1.readInLine();
						result = outputString.split("\n");
						for(i=0; i<fp1.line_count; i++)
						{
								context.tightenorLoosenSecurity(helper, result[i], res);
						}

						for (i = 0; i < res.counter; i++) 
						{
							String temp;
							temp = res.result[i];
							res.writeToFile(temp);
						}
						
					}catch (IllegalArgumentException ie) {
						System.err.println("Invalid Number Of Arguments"+ie);
						ie.printStackTrace();
						System.exit(1);
					} catch (ArrayIndexOutOfBoundsException ae) {
						System.err.println("Array Index Out Of Bound Exception"+ae);
						ae.printStackTrace();
						System.exit(1);
					} catch (Exception e) {
						System.err.println("Exception occured"+e);
						e.printStackTrace();
						System.exit(1);
					} 
			}else {
					System.out.println("Invalid number of arguments");
				 }

}	
}
