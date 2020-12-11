package entity;

import java.util.Date;
import java.util.List;


public class TimerentCar {
	
	private Date startDate;
	private Date endDate;
	private int milesQty;
	private List<RentCar> rentcars;
	private List<CustomerCar> customercars;
	
	public TimerentCar(int int1, int int2, String string1, String string2, int int3) {		
		this.setRentcars(rentcars);
		this.setCustomercars(customercars);
		this.setStartDate(startDate);
		this.setEndDate(endDate);
		this.setMilesQty(milesQty);
	}


	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public int getMilesQty() {
		return milesQty;
	}

	public void setMilesQty(int milesQty) {
		this.milesQty = milesQty;
	}

	public List<RentCar> getRentcars() {
		return rentcars;
	}

	public void setRentcars(List<RentCar> rentcars) {
		this.rentcars = rentcars;
	}

	public List<CustomerCar> getCustomercars() {
		return customercars;
	}

	public void setCustomercars(List<CustomerCar> customercars) {
		this.customercars = customercars;
	}
	

}
