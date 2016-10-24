package sg.edu.nus.iss.vmcs.system;

public class AdptDataAdapter implements AdptDataLoader {

	AdptAdvancedDataLoader advancedDataLoader;
	
	/**
	 * @param type
	 */
	public AdptDataAdapter(String type) {
		if (type.equalsIgnoreCase("MySQL")){
			advancedDataLoader = new AdptMySQLLoader();
		} else if (type.equalsIgnoreCase("PostgreSQL")) {
			advancedDataLoader = new AdptPostgreSQLLoader();
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
