package airportSecurityState.airportStates;
import airportSecurityState.airportStates.AirportStateHelper;
import airportSecurityState.util.MyLogger;
import airportSecurityState.util.Results;

public class High_Risk implements AirportStateI{

	AirportStateContext context;
	
	public High_Risk(AirportStateContext context) {
		this.context = context;
	}

	@Override
	public void tightenorLoosenSecurity(AirportStateHelper helper, String outputString, Results result) {
		String[] temp = outputString.split(";");
		String[] temp1 = temp[0].split(":");
		String[] temp2 = temp[3].split(":");
		helper.calculate(temp1[1], temp2[1]);
		
		if((helper.avg_Traffic() >= 4 && helper.avg_Prohibit() >=1) || (helper.avg_Traffic() < 8 && helper.avg_Prohibit() < 2)) 
		{
			context.setState(context.mod_Risk);
			MyLogger.writeMessage("State Changed", MyLogger.DebugLevel.IN_RUN);
			result.storeNewResults("2 3 5 8 9");
		}
		else if((helper.avg_Traffic() >= 8) || (helper.avg_Prohibit() >= 2)) 
		{
			//The state is set to HIGH_Risk from conditions and new result is stored
			context.setState(context.high_Risk);
			result.storeNewResults("2 4 6 8 10");
		}
	}
			
}
