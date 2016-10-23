package sg.edu.nus.iss.vmcs.customer.change;

import sg.edu.nus.iss.vmcs.store.StoreItem;

/**
 * 
 * @author swemonaung
 *
 */
public class TenCentDispenser extends AbstractDispenser{
	
	@Override
	public void setNextChain(AbstractDispenser dispenseChain) {
		this.dispenseChain = dispenseChain;
	}
	
	public TenCentDispenser(StoreItem storeItem) {
		this.storeItem = storeItem;
	}	

}
