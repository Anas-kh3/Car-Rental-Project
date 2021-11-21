
public class Car {
	private String brand;
	private String model;
	private String is_available;
	private int priceforday;
	private CarType type;
	private String imagePath;

	// Overloading
	public Car(String brand, String model, String is_available, int priceforday, CarType type, String imagePath) {
		this.brand = brand;
		this.model = model;
		this.is_available = is_available;
		this.priceforday = priceforday;
		this.type = type;
		this.imagePath = imagePath;

	}

	// KONTRAT KISMI İÇİN
	public Car(String brand, String model, CarType type) {
		this.brand = brand;
		this.model = model;
		this.type = type;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String isIs_available() {
		return is_available;
	}

	public void setIs_available(String is_available) {
		this.is_available = is_available;
	}

	public int getPriceforday() {
		return priceforday;
	}

	public void setPriceforday(int priceforday) {
		this.priceforday = priceforday;
	}

	public CarType getType() {
		return type;
	}

	public void setType(CarType type) {
		this.type = type;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

}