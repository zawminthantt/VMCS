package sg.edu.nus.iss.vmcs.customer.termination;

/**
 * 
 * @author kyawminthu
 *
 */
public class TerminationStrategyFactory {
	
	/**
	 * 
	 * @author kyawminthu
	 *
	 */
	public static enum TerminationType {
		CUSTOMER_ACTION,
		MAINTENER_ACTION,
		DISPENSE_FAULT,
		COIN_STORE_FAULT,
		CHANGE_FAULT;
	}
	
	/**
	 * 
	 * @param type
	 * @return
	 */
	public static TerminationStrategy create(TerminationType type) {
		switch(type) {
			case CUSTOMER_ACTION : 
				return new CustomerActionTermination();
			case MAINTENER_ACTION : 
				return new MaintenerLoginTermination();
			case CHANGE_FAULT : 
				return new ChangeFaultTermination();
			case DISPENSE_FAULT : 
				return new DispenseFaultTermination();
			case COIN_STORE_FAULT :
				return new CoinStoreFaultTermination();
		}
		return null;
	}
}
