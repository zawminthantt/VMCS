package sg.edu.nus.iss.vmcs.customer.change;

import sg.edu.nus.iss.vmcs.store.StoreItem;

/**
 * 
 * @author swemonaung
 *
 */
public class FiftyCentDispenser extends AbstractDispenser {
	
	@Override
	public void setNextChain(AbstractDispenser dispenseChain) {
		this.dispenseChain = dispenseChain;
	}

	public FiftyCentDispenser(StoreItem storeItem) {
		super();
		this.storeItem = storeItem;
	}

}
