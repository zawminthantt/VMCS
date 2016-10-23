package sg.edu.nus.iss.vmcs.customer.change;

import sg.edu.nus.iss.vmcs.store.StoreItem;

/**
 * 
 * @author swemonaung
 *
 */
public class OneDollarDispenser extends AbstractDispenser{
	
	public OneDollarDispenser(StoreItem storeItem) {
		super(storeItem);
	}

	@Override
	public void setNextChain(AbstractDispenser successor) {
		this.successor = successor;
	}	
	
	public void dispense(int amountToDispenseCent) {
		System.out.println("Handling from " + this.getClass());
		
		super.dispense(amountToDispenseCent);
	}

}
