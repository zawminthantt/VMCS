package sg.edu.nus.iss.vmcs.customer.change;

import sg.edu.nus.iss.vmcs.store.Coin;
import sg.edu.nus.iss.vmcs.store.StoreItem;
import sg.edu.nus.iss.vmcs.util.InsufficientChangeException;
import sg.edu.nus.iss.vmcs.util.VMCSException;

/**
 * 
 * @author swemonaung
 *
 */
public abstract class AbstractDispenser {
	
	protected AbstractDispenser successor;
	
	private StoreItem storeItem;
	
	public abstract void setNextChain(AbstractDispenser successor);

	public AbstractDispenser(StoreItem storeItem) {
		this.storeItem = storeItem;
	}
	
	public void dispense(int amountToDispenseCent) throws InsufficientChangeException {
		
		Coin coin = (Coin)storeItem.getContent();
		int value = coin.getValue();
		String coinName = coin.getName();
		
		int reminder = 0;
		
		if (amountToDispenseCent >= value) {
			int num = amountToDispenseCent / value;
			
			if (storeItem.getQuantity() >= num) {
				
				System.out.println("Dispensing " + coinName + " X " + num);
				
				reminder = amountToDispenseCent % value;
				storeItem.setQuantity(storeItem.getQuantity() - num);
				
			} else {
				// less coins
				if (storeItem.getQuantity() != 0) {
					reminder = (num - storeItem.getQuantity()) * value;
					storeItem.setQuantity(0);
				} else {
					System.out.println("Insufficient quantity to refund " + coin);
					reminder = amountToDispenseCent;
				}
			}
			
			if (reminder != 0) {
				if (successor == null) {// end of chain 
					System.out.println("End of the Chain");
					throw new InsufficientChangeException(reminder);
				} else {	
					successor.dispense(reminder);//
				}
			}
		} else {
			successor.dispense(amountToDispenseCent);
		}
	}

	public StoreItem getStoreItem() {
		return storeItem;
	}

}
