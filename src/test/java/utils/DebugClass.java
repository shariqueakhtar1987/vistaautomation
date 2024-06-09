package utils;


import net.bytebuddy.implementation.bind.MethodDelegationBinder;

import java.io.IOException;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;


public class DebugClass {



	public static void main(String[] args) throws IOException, SQLException {
		Map<String, String> TestData = getSQLTestData("Login", "LoginScenario3");
		System.out.println(TestData.get("ScenarioId"));
		System.out.println(TestData.get("ScenarioType"));
		System.out.println(TestData.get("EmailId"));
		System.out.println(TestData.get("Password"));
	}


	public static Map<String, String> getSQLTestData(String PageName, String ScenarioId) throws IOException, SQLException {
		Map<String, String> TestData = new HashMap<>();
		String query="";
		switch (PageName) {
			case "Login":
				query = "SELECT * FROM VB_LoginDetails";
				break;
			case "Registeration":
				//query = "SELECT * FROM VB_LoginDetails";
				//break;
			case "Shopping":
				//query = "SELECT * FROM VB_LoginDetails";
				//	break;
		}
		try{
			Connection con = getSQLConnection();
			Statement statement = con.createStatement();
			ResultSet resultSet = statement.executeQuery(query);
			ResultSetMetaData RS = resultSet.getMetaData();
			int row= 1;
			int column=1;
			while (resultSet.next()){
				row = row ++;
					if(resultSet.getString(row).equalsIgnoreCase(ScenarioId)){
						while(column<=RS.getColumnCount()) {
							TestData.put(RS.getColumnName(column),resultSet.getString(column));
							column++;
						}
						break;
				}
			}
			con.close();
		}catch(Exception e){
			e.printStackTrace();
		}


		return TestData;
	}

	public static Connection getSQLConnection(){
		String connectString = "jdbc:sqlserver://DEV-NANO1\\SQLEXPRESS;Database=VistaBusiness;encrypt=false;IntegratedSecurity=false";
		try{
			if(DriverManager.getConnection(connectString,"root","root").isClosed()){
				return null;
			}else{
				return DriverManager.getConnection(connectString,"root","root");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
}
