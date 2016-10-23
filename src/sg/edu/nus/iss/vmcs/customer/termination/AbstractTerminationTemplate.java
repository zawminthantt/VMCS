package sg.edu.nus.iss.vmcs.customer.termination;

import sg.edu.nus.iss.vmcs.customer.TransactionController;

/**
 * 
 * @author kyawminthu
 *
 */
public abstract class AbstractTerminationTemplate implements TerminationStrategy {
	/**
	 * 
	 */
	@Override
	public void terminate() {
		disableSelection();
		doTerminationAction();
		refreshMachineryDisplay();
	}
	
	/**
	 * 
	 */
	private void disableSelection() {
		TransactionController.getTransactionControllerInstance().getDispenseController().allowSelection(false);
	}
	
	/**
	 * 
	 */
	private void refreshMachineryDisplay() {
		TransactionController.getTransactionControllerInstance().refreshMachineryDisplay();
	}

	/**
	 * 
	 */
	protected abstract void doTerminationAction();
}
