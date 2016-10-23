package sg.edu.nus.iss.vmcs.system;

public class MyoFileLoader implements MyoDataLoader {

	MyoDataAdapter dataAdapter;
	@Override
	public void initialize(String type, String fileName) {
		// TODO Auto-generated method stub
		if (type.equalsIgnoreCase("File")) {
			
		} else if (type.equalsIgnoreCase("MySQL") || type.equalsIgnoreCase("PostgreSQL")) {
			dataAdapter = new MyoDataAdapter(type);
			dataAdapter.initialize(type, fileName);
		} else {
			System.out.println("Invalid Database! " + type + " not supported.");
		}
	}

}
