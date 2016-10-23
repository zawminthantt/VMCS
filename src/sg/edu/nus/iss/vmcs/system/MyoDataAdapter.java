package sg.edu.nus.iss.vmcs.system;

public class MyoDataAdapter implements MyoDataLoader {

	MyoAdvancedDataLoader advancedDataLoader;
	
	/**
	 * @param type
	 */
	public MyoDataAdapter(String type) {
		if (type.equalsIgnoreCase("MySQL")){
			advancedDataLoader = new MyoMySQLLoader();
		} else if (type.equalsIgnoreCase("PostgreSQL")) {
			advancedDataLoader = new MyoPostgreSQLLoader();
		}
	}
	
	@Override
	public void initialize(String type, String fileName) {
		// TODO Auto-generated method stub
		if (type.equalsIgnoreCase("MySQL")) {
			advancedDataLoader.loadMySQL("FileNameHere");
		} else if (type.equalsIgnoreCase("PostgreSQL")) {
			advancedDataLoader.loadPostgreSQL("FileNameHere");
		}
	}


	

}
