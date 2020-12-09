package application;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


import dao.RentCarDao;

public class MenuCar {
	private RentCarDao rentcarDao = new RentCarDao();
	private Scanner scanner = new Scanner(System.in);
	private List<String> options = Arrays.asList(
			"Create a Car",
			"Display Customers",
			"Update Car Miles",
			"Delete a Car");
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
				//readCustomers();
			} else if (selection.equals("3")) {
				//updateCar();
			}else if (selection.equals("4")) {
				//deleteCar();
			//}else if (selection.equals("5")) {
				//displayCustemerbyCar();
			//}else if (selection.equals("6")) {
				//displayCarbyTimeRent();
			}
			
	} catch (SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println("Press enter to continue...");
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
	System.out.println("Enter car model:  ");
	String carModel = scanner.nextLine();
	System.out.println("Enter car year:  ");
	int carYear = Integer.parseInt(scanner.nextLine());
    System.out.println("Enter car miles:  ");	
    int carMiles = Integer.parseInt(scanner.nextLine());
	rentcarDao.createNewCar(carMake, carModel, carYear, carMiles);
}
	
}	
	
	

