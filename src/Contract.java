
public class Contract {

	private Car car;
	private Customer customer;
	private String rentalDay;
	private String rentLocation;

	public Contract(Car car, Customer customer, String rentalDay, String rentLocation) {
		this.car = car;
		this.customer = customer;
		this.rentalDay = rentalDay;
		this.rentLocation = rentLocation;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getRentalDay() {
		return rentalDay;
	}

	public void setRentalDay(String rentalDay) {
		this.rentalDay = rentalDay;
	}

	public String getRentLocation() {
		return rentLocation;
	}

	public void setRentLocation(String rentLocation) {
		this.rentLocation = rentLocation;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

}
