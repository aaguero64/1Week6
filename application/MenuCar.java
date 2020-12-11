package application;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import dao.CustomerCarDao;
import dao.RentCarDao;
import dao.TimerentCarDao;
import entity.TimerentCar;

public class MenuCar {
	private RentCarDao rentcarDao = new RentCarDao();
	private TimerentCarDao timerentCarDao = new TimerentCarDao();
	private CustomerCarDao customerCarDao = new CustomerCarDao();
	private Scanner scanner = new Scanner(System.in);
	private List<String> options = Arrays.asList(
			"Create a Car",
			"Display Customers",
			"Update Car Miles",
			"Delete a Car",
			"Display Car Rental Records");
			//"Display Customer by Car",
			//"Display Rent time by Car");

	
	public void enter() {
	
	String selection = " ";	

	do {
		printMenu();
		selection = scanner.nextLine();
		try {
			if (selection.equals("1")){
				createCar();
			} else if (selection.equals("2")) {
				readCustomers();
			} else if (selection.equals("3")) {
				updateCar();
			}else if (selection.equals("4")) {
				deleteCar();
			//}else if (selection.equals("5")) {
				//displayCustemerbyCar();
			//}else if (selection.equals("6")) {
				//displayCarbyTimeRent();
			}else if (selection.equals("5")) {
				displayCarRentalRecords();
			}
			
	} catch (SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println("Press enter to continue...");
		System.out.println("Option (-1) to exit Application.");
		scanner.nextLine();
			
		
	}while (!selection.equals("-1"));
	
}
	
private void printMenu() {
	System.out.println(" Select an Option: \n ...................");
	for (int i=0; i<options.size(); i++) {
		System.out.println(i + 1 + ")" + options.get(i));
	}
}

private void createCar() throws SQLException {
	System.out.print("Enter car make:  ");
	String carMake = scanner.nextLine();
	System.out.print("Enter car model:  ");
	String carModel = scanner.nextLine();
	System.out.print("Enter car year:  ");
	int carYear = Integer.parseInt(scanner.nextLine());
    System.out.print("Enter car miles:  ");	
    int carMiles = Integer.parseInt(scanner.nextLine());
	rentcarDao.createNewCar(carMake, carModel, carYear, carMiles);
}

private void readCustomers() throws SQLException {
	System.out.println("Customers List ");
	customerCarDao.getCustomer();
}
	
private void updateCar() throws SQLException {
	System.out.println("You selected Update Car Miles: \n");
	System.out.print("Please enter the Car Record ID: ");
	int carRecordId = scanner.nextInt();
	System.out.print("Please enter the Customer Record ID now: ");
	int custRecordId = scanner.nextInt();
	System.out.println("Next we will enter the dates: \n");
	scanner.nextLine();

	System.out.print("Now enter the Start Date for the Car Rental: ");
	String rentalStartDate = scanner.nextLine();
	System.out.print("Please enter the Date of Return for the Car: ");
	String rentalReturnDate = scanner.nextLine();
	System.out.print("Please enter the mileage of the Car: ");
	int returnMiles = scanner.nextInt();
	
	timerentCarDao.updateCarMiles(
			carRecordId, custRecordId, rentalStartDate,
			rentalReturnDate, returnMiles);
	rentcarDao.updateMiles(returnMiles, carRecordId);
	
	
}

private void deleteCar() throws SQLException {
	System.out.print("Enter car id to delete:");
	int id = Integer.parseInt(scanner.nextLine());
	timerentCarDao.deleteCarById(id);
	customerCarDao.deleteCarById(id);
	rentcarDao.deleteCarById(id);
}

private void displayCarRentalRecords() throws SQLException {
	List<TimerentCar> car = timerentCarDao.showAllRentRecords();
	for ( TimerentCar c : car ) {
		System.out.format("%-2s %12s %12s %10s %10s", c.getRentcars(), c.getCustomercars(), c.getStartDate(), c.getEndDate(), c.getMilesQty());
		System.out.println();
	}
}

}	
	
	

