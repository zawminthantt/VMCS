package sg.edu.nus.iss.vmcs.customer.change;

import sg.edu.nus.iss.vmcs.store.StoreItem;

/**
 * 
 * @author swemonaung
 *
 */
public class OneDollarDispenser extends AbstractDispenser{
	
	public OneDollarDispenser(StoreItem storeItem) {
		this.storeItem = storeItem;
	}

	@Override
	public void setNextChain(AbstractDispenser dispenseChain) {
		this.dispenseChain = dispenseChain;
	}	

}
