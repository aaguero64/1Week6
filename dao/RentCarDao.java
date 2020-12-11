package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

public class RentCarDao {
	
	private Connection connection;
	private final String CREATE_NEW_CAR_QUERY= "INSERT INTO rentcars(car_make, car_model, car_year, car_miles ) VALUES (?, ?, ?, ?)";
	private final String UPDATE_CAR_MILES = "UPDATE rentcars SET car_miles = car_miles + ? WHERE id = ?";
	
	public RentCarDao() {
		connection = DBCarConnection.getConnection();
	}
	
	public void createNewCar(String carMake, String carModel, int carYear, int carMiles) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(CREATE_NEW_CAR_QUERY);
		ps.setString(1, carMake);
		ps.setString(2, carModel);
		ps.setInt(3, carYear);
		ps.setInt(4, carMiles);
		
		ps.executeUpdate();

		System.out.println("One car was Added ");
	}
		
	public void updateMiles(int returnMiles, int carRecordId) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(UPDATE_CAR_MILES);
		ps.setInt(1, returnMiles);
		ps.setInt(2, carRecordId);
		
		ps.executeUpdate();
		
		System.out.println("Miles updated! ");
	}
	

}
