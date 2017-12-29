package airportSecurityState.airportStates;

import airportSecurityState.util.MyLogger;

public class AirportStateHelper {

	public int total_travellers = 0;
	public int total_days=0;
	public int avgTraffic=0;
	public int avgProhibit=0;
	public int total_prohibited;
	
	public AirportStateHelper() 
	{
		MyLogger.writeMessage("Helper class constructor called", MyLogger.DebugLevel.CONSTRUCTOR);
	}
	
	public void calculate(String Day, String Item) 
	{
		total_travellers++;
		if(Item.equals("Gun")||Item.equals("NailCutter")||Item.equals("Blade")||Item.equals("Knife")) 	//Check for prohibited Items
		{
			total_prohibited++;	
		}
		
		int temp = Integer.parseInt(Day);
		if(temp != total_days) {
			total_days++;
		}
		}
	public int avg_Traffic() {
		avgTraffic = total_travellers / total_days;	// Average Traffic Calculation
		return avgTraffic;
	}
	
	public int avg_Prohibit() {
		
		avgProhibit = total_prohibited / total_days;	// Average of Prohibited items Calculation
		return avgProhibit;
	}
}
