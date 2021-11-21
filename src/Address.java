
public class Address {
	private String City;
	private String Country;

	public Address(String city, String country) {
		this.City = city;
		this.Country = country;
	}

	public String getCity() {
		return City;
	}

	public void setCity(String city) {
		City = city;
	}

	public String getCountry() {
		return Country;
	}

	public void setCountry(String country) {
		Country = country;
	}

	public String toString() {
		return City + "," + Country;
	}

}
