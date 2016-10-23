package sg.edu.nus.iss.vmcs.customer.change;

import sg.edu.nus.iss.vmcs.store.StoreItem;

/**
 * 
 * @author swemonaung
 *
 */
public abstract class AbstractDispenser {
	
	protected StoreItem storeItem;
	
	public abstract void setNextChain(AbstractDispenser dispenseChain);

	public abstract void dispense(int amountToDispense);

	public StoreItem getStoreItem() {
		return storeItem;
	}

}
