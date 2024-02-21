package Task23;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Jdbcsqlcon {

	public static void main(String[] args)  {
		// TODO Auto-generated method stub

		//give database connection
		String db_url = "jdbc:mysql:// localhost:3306/";
		String user = "root";
		String password = "root";
		
		// establish the database connection
		try {
			Connection connection = DriverManager.getConnection(db_url, user, password);
			if(connection!=null) {
				System.out.println("connection  sucessfull");
			}else {
				System.out.println("connection unsuccessfull");
			}
			// perform the operation
			Statement stmt  =  connection.createStatement();
			String createDB = "create database db_employeedemodetails";
			String use = "use db_employeedemodetails";
			String CreateTable = "create table employee_table(empcod int,empnam varchar(10),empag int,esalar int)";
			String select = "select * from employee_table"; 
			String insert = "insert into employee_table values (102,'jenny',25,10000),"
					                                 +"(102,'jacky',30,2000),"
					                                 +"(103,'joe',20,40000),"
					             					 +"(104,'john',40,80000),"
					             					 +"(105,'shameer',25,90000)";
			
			               // create db(database)   

			                stmt.execute(createDB);
					       // use db(database)
					         stmt.execute(use);
					       // create table
					         stmt.execute(CreateTable);
					       // insert the table
					         stmt.execute(insert);
			                // execute the quarry use select command
		                     ResultSet rst = stmt.executeQuery(select);
		                    
		                  // using validation purpose choosing while loop in  next method to display the jdbc table   
						     while(rst.next()) {
              System.out.println(rst.getInt("empcod")+" "+rst.getString("empnam")+" " +rst.getInt("empag")
                                +" "+rst.getInt("esalar"));
					}		
						    // close the Connection
						     connection.close();

		    } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		     }
	
	}

}
