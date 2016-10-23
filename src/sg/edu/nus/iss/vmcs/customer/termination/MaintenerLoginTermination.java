package sg.edu.nus.iss.vmcs.customer.termination;

import sg.edu.nus.iss.vmcs.customer.CoinReceiver;
import sg.edu.nus.iss.vmcs.customer.TransactionController;

/**
 * 
 * @author kyawminthu
 *
 */
public class MaintenerLoginTermination extends AbstractTermination {

	/**
	 * 
	 */
	@Override
	protected void doTerminationAction() {
		TransactionController tracsactionController = TransactionController.getTransactionControllerInstance();
		CoinReceiver coinReceiver = tracsactionController.getCoinReceiver();
		coinReceiver.stopReceive();
		coinReceiver.refundCash();
		if(tracsactionController.getCustomerPanel() !=null){
			tracsactionController.getCustomerPanel().setTerminateButtonActive(false);
		}
	}

}
