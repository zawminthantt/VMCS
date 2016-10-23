package sg.edu.nus.iss.vmcs.system;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class MyoMySQLLoader implements MyoAdvancedDataLoader {

	@Override
	public void loadMySQL(String fileName) {
		// JDBC driver name and database URL
		   final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
		   final String DB_URL = "jdbc:mysql://localhost:3306/vmcs";

		   //  Database credentials
		   final String USER = "root";
		   final String PASS = "root";
		   
		   Connection conn = null;
		   Statement stmt = null;
		   Statement stmt2 = null;
		   int i = 1;
		   int j = 1;
		   try{
		      //STEP 2: Register JDBC driver
		      Class.forName("com.mysql.jdbc.Driver");

		      //STEP 3: Open a connection
		      System.out.println("Connecting to database...");
		      conn = DriverManager.getConnection(DB_URL,USER,PASS);

		      //STEP 4: Execute a query
		      System.out.println("Creating statement...");
		      stmt = conn.createStatement();
		      String sql;
		      sql = "SELECT name, quantity, price FROM DrinkPropertyFile";
		      ResultSet rs = stmt.executeQuery(sql);

		      File fout = new File("DrinkPropertyFile.txt");
		      FileOutputStream fos = new FileOutputStream(fout);
		      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
		      
		      Date date = new Date();
		      bw.write("#");
		      bw.newLine();
		      bw.write("#" + date.toString());
		      bw.newLine();
		      //STEP 5: Extract data from result set
		      while(rs.next()){
		         //Retrieve by column name
		         String name  = rs.getString("name");
		         String quantity = rs.getString("quantity");
		         String price = rs.getString("price");

		         bw.write("Name" + i + "=" + name);
		         bw.newLine();
		         bw.write("Quantity" + i + "=" + quantity);
		         bw.newLine();
		         bw.write("Price" + i + "=" + price);
		         bw.newLine();
		         //Display values
		         System.out.print(" Name: " + name);
		         System.out.print(", Quantity: " + quantity);
		         System.out.print(", Price: " + price);
		         i = i + 1;
		      }
		      i = i - 1;
		      bw.write("NumOfItems=" + i);
		      bw.close();
		      
		      
		    //STEP 4: Execute a query
		      System.out.println("Creating statement2...");
		      stmt2 = conn.createStatement();
		      String sql2;
		      sql2 = "SELECT name, value, quantity, weight FROM CashPropertyFile";
		      ResultSet rs2 = stmt2.executeQuery(sql2);

		      File fout2 = new File("CashPropertyFile.txt");
		      FileOutputStream fos2 = new FileOutputStream(fout2);
		      BufferedWriter bw2 = new BufferedWriter(new OutputStreamWriter(fos2));
		      
		      Date date2 = new Date();
		      bw2.write("#");
		      bw2.newLine();
		      bw2.write("#" + date2.toString());
		      bw2.newLine();
		      //STEP 5: Extract data from result set
		      while(rs2.next()){
		         //Retrieve by column name
		         String name  = rs2.getString("name");
		         String value = rs2.getString("value");
		         String quantity = rs2.getString("quantity");
		         String weight = rs2.getString("weight");

		         bw2.write("Name" + j + "=" + name);
		         bw2.newLine();
		         bw2.write("Value" + j + "=" + value);
		         bw2.newLine();
		         bw2.write("Quantity" + j + "=" + quantity);
		         bw2.newLine();
		         bw2.write("Weight" + j + "=" + weight);
		         bw2.newLine();
		         
		         j = j + 1;
		      }
		      j = j - 1;
		      bw2.write("NumOfItems=" + j);
		      bw2.close();
		      //STEP 6: Clean-up environment
		      rs2.close();
		      rs.close();
		      stmt.close();
		      stmt2.close();
		      conn.close();
		   }catch(SQLException se){
		      //Handle errors for JDBC
		      se.printStackTrace();
		   }catch(Exception e){
		      //Handle errors for Class.forName
		      e.printStackTrace();
		   }finally{
		      //finally block used to close resources
		      try{
		         if(stmt!=null)
		            stmt.close();
		      }catch(SQLException se2){
		      }// nothing we can do
		      try{
		         if(conn!=null)
		            conn.close();
		      }catch(SQLException se){
		         se.printStackTrace();
		      }//end finally try
		   }//end try
		   System.out.println("Goodbye!");
		//}//end main
	}
	@Override
	public void loadPostgreSQL(String fileName) {
		// Do Nothing
	}
}
