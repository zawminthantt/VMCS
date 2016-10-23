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
		STORE_FAULT,
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
			case STORE_FAULT :
				//TODO create Store fault termination strategy.
				return new DispenseFaultTermination();
		}
		return null;
	}
}
