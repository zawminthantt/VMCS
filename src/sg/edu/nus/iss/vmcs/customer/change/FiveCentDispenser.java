package sg.edu.nus.iss.vmcs.customer.change;

import sg.edu.nus.iss.vmcs.store.Coin;
import sg.edu.nus.iss.vmcs.store.StoreItem;

/**
 * 
 * @author swemonaung
 *
 */
public class FiveCentDispenser extends AbstractDispenser{
	
	AbstractDispenser dispenseChain;

	@Override
	public void setNextChain(AbstractDispenser dispenseChain) {
		this.dispenseChain = dispenseChain;
	}
	
	public FiveCentDispenser(StoreItem storeItem) {
		this.storeItem = storeItem;
	}

	@Override
	public void dispense(int amountToDispenseCent) {
		
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
				// number of coins are less qty to dispense.
				if (storeItem.getQuantity() != 0) {
					reminder = (num - storeItem.getQuantity()) * value;
					storeItem.setQuantity(0);
				} else {
					System.out.println("Insufficient quantity to refund " + coinName);
					reminder = amountToDispenseCent;
				}
			}
			if (reminder != 0) {
				if (dispenseChain == null) { 
					System.out.println("End of the Chain");
				} else {
					dispenseChain.dispense(reminder);
				}
			}
		} else {
			dispenseChain.dispense(amountToDispenseCent);
		}
	}

}
