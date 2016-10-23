package sg.edu.nus.iss.vmcs.customer.change;

import sg.edu.nus.iss.vmcs.store.Coin;
import sg.edu.nus.iss.vmcs.store.StoreItem;

/**
 * 
 * @author swemon
 *
 */
public class DispenserFactory {

	public static AbstractDispenser createDispenser(StoreItem storeItem) {

		Coin coin = (Coin) storeItem.getContent();

		AbstractDispenser dispenseChain = null;
		switch (coin.getValue()) {

		case 5:
			dispenseChain = new FiveCentDispenser(storeItem);
			break;

		case 10:
			dispenseChain = new TenCentDispenser(storeItem);
			break;

		case 20:
			dispenseChain = new TwentyCentDispenser(storeItem);
			break;

		case 50:
			dispenseChain = new FiftyCentDispenser(storeItem);
			break;

		case 100:
			dispenseChain = new OneDollarDispenser(storeItem);
			break;
		}
		return dispenseChain;
	}
}
