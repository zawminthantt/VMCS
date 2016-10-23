package sg.edu.nus.iss.vmcs.store;

import java.util.ArrayList;
import java.util.List;

import sg.edu.nus.iss.vmcs.util.Observer;
import sg.edu.nus.iss.vmcs.util.Subject;

public class DrinkStoreItemNotifier implements Subject {

	private List<Observer> observers;
	private int quantity;
	private Boolean isChanged;
	private final Object MUTEX = new Object();
	
	private static final DrinkStoreItemNotifier sharedInstance = new DrinkStoreItemNotifier();

	private DrinkStoreItemNotifier() {
		super();

		this.observers = new ArrayList<>();
	}
	
	public static DrinkStoreItemNotifier shared() {
		return sharedInstance;
	}

	@Override
	public Object getUpdate() {
		return this.quantity;
	}

	@Override
	public void attach(Observer observer) {
		if (observer == null)
			throw new NullPointerException("Null Observer");

		synchronized (MUTEX) {
			if (!this.observers.contains(observer)) {
				this.observers.add(observer);
			}
		}

	}

	@Override
	public void detach(Observer observer) {
		synchronized (MUTEX) {
			if (this.observers.contains(observer)) {
				this.observers.remove(observer);
			}
		}

	}

	@Override
	public void notifyQuantityChanges() {
		List<Observer> observersLocal;
		
		synchronized (MUTEX) {
			if (!isChanged) return;
			
			observersLocal = new ArrayList<>(this.observers);
			this.isChanged = false;
		}
		
		observersLocal.forEach((object) -> {
			object.update(this.quantity);
		});

	}
		
	public void updateDrinkStoreItemChanges(int quantity) {
		System.out.println(">>> DrinkStoreItem " + quantity);
		this.quantity = quantity;
		this.isChanged = true;
		this.notifyQuantityChanges();
	}

}
