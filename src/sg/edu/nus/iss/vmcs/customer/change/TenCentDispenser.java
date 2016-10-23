package sg.edu.nus.iss.vmcs.customer.change;

import sg.edu.nus.iss.vmcs.store.Coin;
import sg.edu.nus.iss.vmcs.store.StoreItem;

/**
 * 
 * @author swemonaung
 *
 */
public class TenCentDispenser extends DispenseChain{
	
	DispenseChain dispenseChain;

	@Override
	public void setNextChain(DispenseChain dispenseChain) {
		this.dispenseChain = dispenseChain;
	}
	
	public TenCentDispenser(StoreItem storeItem) {
		this.storeItem = storeItem;
	}

	@Override
	public void dispense(int amountToDispenseCent) {
		
		Coin coin = (Coin)storeItem.getContent();
		int value = coin.getValue();
		
		int reminder = 0;
		
		if (amountToDispenseCent >= value) {
			int num = amountToDispenseCent / value;
			
			if (num >= storeItem.getQuantity()) {
				
				System.out.println("Dispensing 10 Cent X " + num);
				
				reminder = amountToDispenseCent % value;
				
				storeItem.setQuantity(storeItem.getQuantity() - num);
			} else {
				// less coins
				
				System.out.println("Dispensing 10 Cent X " + storeItem.getQuantity());
				
				reminder = ( num - storeItem.getQuantity() ) * value;
				
				storeItem.setQuantity(0);
			}
			
			if (reminder != 0) {
				
				if (dispenseChain == null) {// end of chain 
					System.out.println("End of the Chain");
				}	
				dispenseChain.dispense(reminder);
			}
		} else {
			dispenseChain.dispense(amountToDispenseCent);
		}
	}

}
