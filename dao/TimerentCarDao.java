package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TimerentCarDao {

	private Connection connection;
	private final String UPDATE_CAR_MILES = "INSERT INTO timerent("
			+ "rentcar_id, customer_id, start_date, end_date, miles_qty)"
			+ " VALUES (?, ?, ?, ?,?)";

	public TimerentCarDao()		{
		connection = DBCarConnection.getConnection();
	}
	
	public void updateCarMiles(int carRecordId, int custRecordId, String rentalStartDate, String rentalReturnDate,
			int returnMiles) throws SQLException {
		
		PreparedStatement ps = connection.prepareStatement(UPDATE_CAR_MILES);
		ps.setInt(1, carRecordId);
		ps.setInt(2, custRecordId);
		ps.setString(3, rentalStartDate);
		ps.setString(4, rentalReturnDate);
		ps.setInt(5,  returnMiles);
		
		ps.executeUpdate();
		
		System.out.println("Rental Transaction Dates Added! ");
	}
	
}
