package sg.edu.nus.iss.vmcs.customer;

import sg.edu.nus.iss.vmcs.customer.termination.TerminationStrategy;
import sg.edu.nus.iss.vmcs.customer.termination.TerminationStrategyFactory;
import sg.edu.nus.iss.vmcs.customer.termination.TerminationStrategyFactory.TerminationType;

/**
 * 
 * @author kyawminthu
 *
 */
public abstract class AbstractTerminationState implements State {
	// Added by Min Thu.
	/**
	 * 
	 */
	private TerminationStrategy terminationStrategy;
	
	/**
	 * 
	 * @param event
	 */
	public void setStrategy(TerminationType event) {
		terminationStrategy = TerminationStrategyFactory.create(event);
	}
	
	/**
	 * 
	 */
	public void terminate() {
		terminationStrategy.terminate();
	}
}
