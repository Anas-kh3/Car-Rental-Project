
public class Customer extends Person {

	private Address address;

	public Customer(String firstName, String lastName, Phone phoneNumber, Address address, String username,
			String password) {
		super(username, password, firstName, lastName, phoneNumber);
		this.address = address;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

}
