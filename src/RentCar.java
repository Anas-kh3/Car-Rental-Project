import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Point;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class RentCar extends JFrame implements SignContract {

	private JFrame rentFrame;
	private JPanel contentPane;
	private JTextField daysRentedTextField;
	private JTextField rentLocationTextField;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					RentCar frame = new RentCar();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public RentCar(JFrame frameCusMenu, Company comp, Car car) {

		JOptionPane.showMessageDialog(rentFrame,
				"You are being directed to renting page for: " + car.getBrand() + " " + car.getModel());

		// CHANGE THEME
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");

		} catch (Exception e) {
			e.printStackTrace();
		}

		rentFrame = new JFrame("Rent Your Car");
		rentFrame.getContentPane().setBackground(new Color(240, 248, 255));

		rentFrame.setBounds(100, 100, 304, 477);
		rentFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		rentFrame.getContentPane().setLayout(null);
		rentFrame.setBackground(new Color(127, 205, 205));

		JLabel lblNewLabel = new JLabel("Days want to rent");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 33, 123, 13);
		rentFrame.getContentPane().add(lblNewLabel);

		JLabel lblRentLocation = new JLabel("Rent Location");
		lblRentLocation.setHorizontalAlignment(SwingConstants.CENTER);
		lblRentLocation.setBounds(10, 84, 123, 13);
		rentFrame.getContentPane().add(lblRentLocation);

		JLabel daysInvalidLabel = new JLabel("Invalid input!");
		daysInvalidLabel.setHorizontalAlignment(SwingConstants.CENTER);
		daysInvalidLabel.setVisible(false);
		daysInvalidLabel.setForeground(Color.RED);
		daysInvalidLabel.setBounds(143, 55, 96, 13);
		rentFrame.getContentPane().add(daysInvalidLabel);

		JLabel locationInvalidLabel = new JLabel("Invalid input!");
		locationInvalidLabel.setHorizontalAlignment(SwingConstants.CENTER);
		locationInvalidLabel.setVisible(false);
		locationInvalidLabel.setForeground(Color.RED);
		locationInvalidLabel.setBounds(143, 106, 96, 13);
		rentFrame.getContentPane().add(locationInvalidLabel);

		daysRentedTextField = new JTextField();
		daysRentedTextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				char c = e.getKeyChar();
				if (!Character.isLetter(c) || Character.isWhitespace(c) || Character.isISOControl(c)) {
					daysInvalidLabel.setVisible(false);
					daysRentedTextField.setEditable(true);

				} else {
					daysRentedTextField.setEditable(false);
					daysInvalidLabel.setVisible(true);
				}

			}
		});
		daysRentedTextField.setBounds(143, 27, 96, 28);
		rentFrame.getContentPane().add(daysRentedTextField);
		daysRentedTextField.setColumns(10);

		rentLocationTextField = new JTextField();
		rentLocationTextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				char c = e.getKeyChar();
				if (Character.isLetter(c) || Character.isWhitespace(c) || Character.isISOControl(c)) {
					locationInvalidLabel.setVisible(false);
					rentLocationTextField.setEditable(true);
				} else {
					rentLocationTextField.setEditable(false);
					locationInvalidLabel.setVisible(true);
				}
			}
		});
		rentLocationTextField.setColumns(10);
		rentLocationTextField.setBounds(143, 78, 96, 28);
		rentFrame.getContentPane().add(rentLocationTextField);

		JButton menuPageButton = new JButton("Menu Page");
		menuPageButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frameCusMenu.setVisible(true);
				rentFrame.setVisible(false);

			}
		});
		menuPageButton.setBounds(91, 167, 104, 21);
		rentFrame.getContentPane().add(menuPageButton);

		JButton rentButton = new JButton("Rent Now!");
		rentButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (!daysRentedTextField.getText().equals("") && !rentLocationTextField.getText().equals("")) {
					// Customer temp = comp.getCustomer();
					String days = daysRentedTextField.getText();
					String location = rentLocationTextField.getText();

					signContract(comp, car, days, location);

					car.setIs_available("false");
					CustomerMenuPage.Availability.get(comp.cars.indexOf(car)).setText("Not Available");
					CustomerMenuPage.Availability.get(comp.cars.indexOf(car)).setForeground(Color.red);
					frameCusMenu.getContentPane().revalidate();
					frameCusMenu.getContentPane().repaint();

					frameCusMenu.setVisible(true);
					JOptionPane.showMessageDialog(rentFrame,
							"You rented a " + car.getBrand() + " " + car.getModel() + " for " + days + "days");
					try {
						FileWriter fileWritter = new FileWriter("cars.txt");
						BufferedWriter bw = new BufferedWriter(fileWritter);
						for (int i = 0; i < comp.cars.size(); i++) {
							bw.write(comp.cars.get(i).getBrand() + ";" + comp.cars.get(i).getModel() + ";"
									+ comp.cars.get(i).isIs_available() + ";" + comp.cars.get(i).getPriceforday() + ";"
									+ comp.cars.get(i).getType().getTypeName() + ";" + comp.cars.get(i).getImagePath()
									+ ";" + "\n");
						}
						bw.close();
					} catch (IOException x) {
						x.printStackTrace();
					}

					rentFrame.setVisible(false);

				} else {
					JOptionPane.showMessageDialog(rentFrame, "All areas must be filled !");
				}

			}
		});
		rentButton.setBounds(99, 135, 85, 21);
		rentFrame.getContentPane().add(rentButton);
		rentFrame.setResizable(false);
		rentFrame.setSize(new Dimension(300, 300));
		rentFrame.setVisible(true);

		// Get the screen size
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension screenSize = toolkit.getScreenSize();

		// Calculate the frame location
		int x = (screenSize.width - rentFrame.getWidth()) / 2;
		int y = (screenSize.height - rentFrame.getHeight()) / 2;

		// Set the new frame location
		rentFrame.setLocation(x, y);

	}

	public JFrame getRentFrame() {
		return rentFrame;
	}

	public void setRentFrame(JFrame rentFrame) {
		this.rentFrame = rentFrame;
	}

	public JPanel getContentPane() {
		return contentPane;
	}

	public void setContentPane(JPanel contentPane) {
		this.contentPane = contentPane;
	}

	@Override
	public void signContract(Company comp, Car car, String days, String location) {
		try {
			FileWriter fileWritter = new FileWriter("contracts.txt", true);
			BufferedWriter bw = new BufferedWriter(fileWritter);
			bw.append(comp.getCustomer().getUsername() + ";" + comp.getCustomer().getPassword() + ";"
					+ comp.getCustomer().getFirstName() + ";" + comp.getCustomer().getLastName() + ";"
					+ comp.getCustomer().getPhoneNumber().getNumber() + ";" + comp.getCustomer().getAddress().getCity()
					+ ";" + comp.getCustomer().getAddress().getCountry() + ";" + car.getBrand() + ";" + car.getModel()
					+ ";" + car.getType().getTypeName() + ";" + days + ";" + location + "\n");
			bw.close();
		} catch (IOException x) {
			x.printStackTrace();
		}
		Contract cont = new Contract(car, comp.getCustomer(), days, location);
		comp.getContracts().add(cont);

	}
}