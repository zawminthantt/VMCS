package sg.edu.nus.iss.vmcs.system;

public class AdptFileLoader implements AdptDataLoader {

	AdptDataAdapter dataAdapter;
	@Override
	public void initialize(String type, String fileName) {
		// TODO Auto-generated method stub
		if (type.equalsIgnoreCase("File")) {
			// Handle in MainController
		} else if (type.equalsIgnoreCase("MySQL") || type.equalsIgnoreCase("PostgreSQL")) {
			dataAdapter = new AdptDataAdapter(type);
			dataAdapter.initialize(type, fileName);
		} else {
			System.out.println("Invalid Database! " + type + " not supported.");
		}
	}

}
