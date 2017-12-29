package airportSecurityState.airportStates;
import airportSecurityState.util.MyLogger;
import airportSecurityState.util.Results;


public class AirportStateContext {

	AirportStateI low_Risk;
	AirportStateI mod_Risk;
	AirportStateI high_Risk;
	Results result;
	AirportStateI state;
	AirportStateHelper helper;
	
	public AirportStateContext(Results res)
	{
		MyLogger.writeMessage("Context class constructor called", MyLogger.DebugLevel.CONSTRUCTOR);
		low_Risk = new Low_Risk(this);
		mod_Risk = new Mod_Risk(this);
		high_Risk = new High_Risk(this);
		state = low_Risk;
		result = res;		
	}
	
	public void tightenorLoosenSecurity(AirportStateHelper helper, String outputString, Results res) {

		this.state.tightenorLoosenSecurity(helper, outputString, res);
	}
	
	void setState(AirportStateI state) {
		this.state = state;		//State is changed and now it is set to This state
	}
	
	public AirportStateI getLowRisk() {
		return this.state;
	}
	
	public AirportStateI getModRisk() {
		return this.state;
	}
	
	public AirportStateI getHighRisk() {
		return this.state;
	}
	
}
