package sg.edu.nus.iss.vmcs.customer.termination;

import sg.edu.nus.iss.vmcs.customer.TransactionController;

/**
 * 
 * @author kyawminthu
 *
 */
public class ChangeFaultTermination extends AbstractTerminationTemplate {

	/**
	 * 
	 */
	@Override
	protected void doTerminationAction() {
		TransactionController.getTransactionControllerInstance().getCoinReceiver().storeCash();
	}

}
