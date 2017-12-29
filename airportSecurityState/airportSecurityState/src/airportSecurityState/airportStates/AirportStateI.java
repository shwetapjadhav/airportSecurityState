package airportSecurityState.airportStates;
import airportSecurityState.util.Results;

public interface AirportStateI {
	
	public void tightenorLoosenSecurity(AirportStateHelper helper, String outputString, Results result);	
	
}
