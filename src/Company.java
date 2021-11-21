
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Company {
	static ArrayList<Car> cars = new ArrayList<Car>();
	private Customer customer;
	private Queue<Contract> contracts = new LinkedList<Contract>();

	public Company() {
		String[] row = null;
		try {
			File myObj = new File("cars.txt");
			Scanner myReader = new Scanner(myObj);
			while (myReader.hasNextLine()) {
				String data = myReader.nextLine();
				row = data.split(";");
				if (row[5] == null) {
					Car car = new Car(row[0], row[1], row[2], Integer.parseInt(row[3]), new CarType(row[4]), null);
					cars.add(car);
				}
				if (row[5] != null) {
					Car car = new Car(row[0], row[1], row[2], Integer.parseInt(row[3]), new CarType(row[4]), row[5]);
					cars.add(car);
				}

			}
			myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred!");
			e.printStackTrace();
		}

	}

	public ArrayList<Car> getCars() {
		return cars;
	}

	public void setCars(ArrayList<Car> cars) {
		this.cars = cars;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Queue<Contract> getContracts() {
		return contracts;
	}

	public void setContracts(Queue<Contract> contracts) {
		this.contracts = contracts;
	}
}
