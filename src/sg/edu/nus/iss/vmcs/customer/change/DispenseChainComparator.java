package sg.edu.nus.iss.vmcs.customer.change;

import java.util.Comparator;

import sg.edu.nus.iss.vmcs.store.Coin;

public class DispenseChainComparator implements Comparator<DispenseChain> {

	@Override
	public int compare(DispenseChain o1, DispenseChain o2) {
		Coin coin = (Coin) o1.getStoreItem().getContent();
		int value1 = coin.getValue();
		
		Coin coin2 = (Coin) o2.getStoreItem().getContent();
		int value2 = coin2.getValue();
		
		if (value1 == value2) {
			return 0;
		} else if (value1 > value2) {
			return 1;
		} else {
			return -1;
		}
	}

}
