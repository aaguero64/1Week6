Java - MySQL - jdbc --- A simple CRUD application using car rental example

This simple Rental Car Application demonstrates the basic CRUD functionalities using Java, MySQL and the jdbc connector.
We use INSERT for the Create aspect of CRUD, specifically when adding a car and adding a customer.
We use SELECT for the Read aspect of CRUD, specifically when displaying the cars, the customers, and the rental transactions.
We use UPDATE for the Update aspect of CRUD, specifically while adding the rental car transactions to update the total miles on the car that was rented by a customer.
We use DELETE for the Delete aspect of CRUD, specifically while deleting a car.

For this simple Rental Car application our database is called “rentcar”.  We use three(3) entities in this application demonstration:
-	Cars (rentcars table)
-	Customers (customers table)
-	Transactions (timerent table)

For the flow of the application testing – 
1.	Add a car option allows you to add the Car Make, Car Model, the YEAR of the car and the miles in the car. The table used is rentcars.
2.	Display cars option outputs all the car rows in the table.
3.	Add a customer option allows you to add a customer to the database in the customers table.
4.	Display customers option allows you to output all the rows in the customers table.
5.	Update Rental Transaction option allows you to create a transaction record while miles used during the transaction is used to update the total miles for that car in the rentcars table.  This utilizes the car id and customer id fields to create the record in the timerent table.
Please feel free to use this application code as you wish!

