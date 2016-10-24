package sg.edu.nus.iss.vmcs.customer.change;

import sg.edu.nus.iss.vmcs.store.StoreItem;
import sg.edu.nus.iss.vmcs.util.InsufficientChangeException;
import sg.edu.nus.iss.vmcs.util.VMCSException;

/**
 * 
 * @author swemonaung
 *
 */
public class TenCentDispenser extends AbstractDispenser{
	
	@Override
	public void setNextChain(AbstractDispenser successor) {
		this.successor = successor;
	}
	
	public TenCentDispenser(StoreItem storeItem) {
		super(storeItem);
	}	
	
	public void dispense(int amountToDispenseCent) throws InsufficientChangeException {
		System.out.println("Handling from " + this.getClass());
		
		super.dispense(amountToDispenseCent);
	}

}
