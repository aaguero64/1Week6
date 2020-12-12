package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.CustomerCar;

public class CustomerCarDao {


	private static Connection connection;
	
	private final String CREATE_CUSTOMERS_LIST_QUERY = "SELECT (id, first_name, last_name, phone_number) FROM customers";
	private final String DELETE_CAR_BY_ID_QUERY = "DELETE FROM customers WHERE rentcar_id = ?";
	
	// This connection need to be done at any DAO class to be able to connect to the Connection class.
	public CustomerCarDao() {
		connection = DBCarConnection.getConnection();
	}
	
	public List<CustomerCar> showAllCustomersRecords() throws SQLException{
		List<CustomerCar> cus = new ArrayList<CustomerCar>();
		ResultSet rs =  connection.prepareStatement(CREATE_CUSTOMERS_LIST_QUERY).executeQuery();		
		 while(rs.next()) {
			 cus.add(populateCustomerData(rs.getInt(1), rs.getString(3), rs.getString(4), rs.getInt(9)));
		 }
		 return cus;
		 
	}
		
	private CustomerCar populateCustomerData(int id, String name, String lastname, int phone) {
		return new CustomerCar(id, name, lastname, phone);
			
	}

	public void deleteCarById(int id) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(DELETE_CAR_BY_ID_QUERY);
		ps.setInt(1, id);
		ps.executeUpdate();
		
	}

	public void addCustomer(String firstName, String lastName, String customerAddress, int carId) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(ADD_NEW_CUSTOMER_QUERY);
		if(carId==0) {
			ps.setNull(1, Types.INTEGER);
		}else {
			ps.setInt(1, carId);
		}	
		ps.setString(2, firstName);
		ps.setString(3, lastName);
		ps.setString(4, customerAddress);
		
		ps.executeUpdate();

		System.out.println("Customer record has been added.");
		
	}
	
	//public void getCustomer() throws SQLException {
			//ResultSet rs = connection.prepareStatement(CREATE_CUSTOMERS_LIST_QUERY).executeQuery();
				//while (rs.next()) {
					//System.out.println("Full Name: " + rs.getString(3) + " " + rs.getString(4));
			//	}
		//}
}
