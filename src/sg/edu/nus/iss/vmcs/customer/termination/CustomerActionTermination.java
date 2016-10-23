package sg.edu.nus.iss.vmcs.customer.termination;

import sg.edu.nus.iss.vmcs.customer.CoinReceiver;
import sg.edu.nus.iss.vmcs.customer.TransactionController;

/**
 * 
 * @author kyawminthu
 *
 */
public class CustomerActionTermination implements TerminationStrategy {

	/**
	 * 
	 */
	@Override
	public void terminate() {
		System.out.println("CancelTransaction: Begin");
		// Need to edit after Changing the transaction controller to singleton.
		TransactionController tracsactionController = TransactionController.getTransactionControllerInstance();
		CoinReceiver coinReceiver = tracsactionController.getCoinReceiver();
		coinReceiver.stopReceive();
		coinReceiver.refundCash();
		tracsactionController.getDispenseController().allowSelection(true);
		tracsactionController.refreshMachineryDisplay();
		System.out.println("CancelTransaction: End");
	}

}
