package sg.edu.nus.iss.vmcs.customer.change;

import sg.edu.nus.iss.vmcs.store.StoreItem;

/**
 * 
 * @author swemonaung
 *
 */
public class TwentyCentDispenser extends AbstractDispenser{

	@Override
	public void setNextChain(AbstractDispenser successor) {
		this.successor = successor;
	}
	
	public TwentyCentDispenser(StoreItem storeItem) {
		super(storeItem);
	}
	
	public void dispense(int amountToDispenseCent) {
		System.out.println("Handling from " + this.getClass());
		
		super.dispense(amountToDispenseCent);
	}

}
