package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

public class CustomerCarDao {


	private Connection connection;
	
	private final String CREATE_CUSTOMERS_LIST_QUERY = "SELECT * FROM customers";
	private final String DELETE_CAR_BY_ID_QUERY = "UPDATE customers SET rentcar_id = null WHERE rentcar_id = ?";
	private final String ADD_NEW_CUSTOMER_QUERY= "INSERT INTO customers(rentcar_id, first_name, last_name, address ) VALUES (?, ?, ?, ?)";
	
	// This connection need to be done at any DAO class to be able to connect to the Connection class.
	public CustomerCarDao() {
		connection = DBCarConnection.getConnection();
	}
	
	public void getCustomer() throws SQLException {
		ResultSet rs = connection.prepareStatement(CREATE_CUSTOMERS_LIST_QUERY).executeQuery();
			while (rs.next()) {
				System.out.println("Full Name: " + rs.getString(3) + " " + rs.getString(4));
			}
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
	
}
