package sg.edu.nus.iss.vmcs.util;

public interface Subject {
	
	public void attach(Observer observer);
	public void detach(Observer observer);
	public void notifyQuantityChanges();
	public Object getUpdate();
}
