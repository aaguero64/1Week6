package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerCarDao {


	private Connection connection;
	
	private final String CREATE_CUSTOMERS_LIST_QUERY = "SELECT * FROM customers";
	//private final String DELETE_CAR_BY_ID_QUERY = "DELETE FROM customers WHERE rentcar_id = ?";
	private final String DELETE_CAR_BY_ID_QUERY = "UPDATE customers SET rentcar_id = null WHERE rentcar_id = ?";
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
	
}
