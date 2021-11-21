import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.Box;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.Point;
import java.awt.Toolkit;

import javax.swing.JProgressBar;
import javax.swing.JEditorPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.DropMode;
import javax.swing.JPasswordField;
import javax.swing.event.CaretListener;

import javax.swing.event.CaretEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JButton;

public class Register extends JFrame {

	private JFrame registerFrame;
	private JPanel contentPane;
	private JTextField firstNameText;
	private JTextField lastNameText;
	private JLabel lblNewLabel_1;
	private JTextField usernameText;
	private JTextField passwordText;
	private JTextField phoneText;
	private JTextField cityText;
	private JTextField countryText;
	private JPasswordField passwordField;
	private JTextField confirmPasswordText;
	private JPasswordField confirmPasswordField;
	private JLabel cityInvalidLabel;
	private JLabel countryInvalidLabel;

	// Create a new blank cursor.

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Register frame = new Register();
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
	public Register(JFrame logFrame) {

		// Get the screen size
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension screenSize = toolkit.getScreenSize();

		// CHANGE THEME
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");

		} catch (Exception e) {
			e.printStackTrace();
		}

		registerFrame = new JFrame("Register");
		registerFrame.getContentPane().setBackground(new Color(240, 248, 255));
		registerFrame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				logFrame.setVisible(true);
				try {
					this.finalize();
				} catch (Throwable e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		});

		//REGISTER WINDOW ICON
		ImageIcon register_icon = new ImageIcon("register.png");
		registerFrame.setIconImage(register_icon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));


		registerFrame.setBounds(100, 100, 304, 477);
		registerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		registerFrame.getContentPane().setLayout(null);
		registerFrame.setBackground(new Color(127, 205, 205));

		// Calculate the frame location
		int x = (screenSize.width - registerFrame.getWidth()) / 2;
		int y = (screenSize.height - registerFrame.getHeight()) / 2;

		// Set the new frame location
		registerFrame.setLocation(x, y);

		lastNameText = new JTextField();
		lastNameText.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (lastNameText.getText().equals("Surname")) {
					lastNameText.setText("");
				}

			}

			@Override
			public void focusLost(FocusEvent e) {
				if (lastNameText.getText().equals("")) {
					lastNameText.setText("Surname");
				}

			}
		});
		lastNameText.setHorizontalAlignment(SwingConstants.CENTER);
		lastNameText.setText("Surname");
		lastNameText.setForeground(Color.BLACK);
		lastNameText.setColumns(10);
		lastNameText.setBounds(151, 31, 127, 27);
		registerFrame.getContentPane().add(lastNameText);

		lblNewLabel_1 = new JLabel("Create Your Account");
		lblNewLabel_1.setForeground(Color.BLUE);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(39, 11, 216, 13);
		registerFrame.getContentPane().add(lblNewLabel_1);

		usernameText = new JTextField();
		usernameText.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (usernameText.getText().equals("Username")) {
					usernameText.setText("");
				}

			}

			@Override
			public void focusLost(FocusEvent e) {
				if (usernameText.getText().equals("")) {
					usernameText.setText("Username");
				}

			}
		});
		usernameText.setForeground(Color.BLACK);
		usernameText.setHorizontalAlignment(SwingConstants.CENTER);
		usernameText.setText("Username");
		usernameText.setBounds(10, 68, 268, 27);
		registerFrame.getContentPane().add(usernameText);
		usernameText.setColumns(10);

		JLabel phoneInvalidLabel = new JLabel("Invalid Input!");
		phoneInvalidLabel.setHorizontalAlignment(SwingConstants.CENTER);
		phoneInvalidLabel.setVisible(false);
		phoneInvalidLabel.setForeground(Color.RED);
		phoneInvalidLabel.setBounds(109, 205, 77, 14);
		registerFrame.getContentPane().add(phoneInvalidLabel);

		passwordText = new JTextField();
		passwordText.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				passwordText.setVisible(false);
				passwordField.setVisible(true);
			}

			@Override
			public void focusLost(FocusEvent e) {

			}
		});
		passwordText.setHorizontalAlignment(SwingConstants.CENTER);
		passwordText.setForeground(Color.BLACK);
		passwordText.setText("Password");
		passwordText.setColumns(10);
		passwordText.setBounds(10, 102, 268, 27);
		registerFrame.getContentPane().add(passwordText);

		phoneText = new JTextField();
		phoneText.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				char c = e.getKeyChar();
				if (!Character.isLetter(c) || Character.isWhitespace(c) || Character.isISOControl(c)) {
					phoneInvalidLabel.setVisible(false);
					phoneText.setEditable(true);
				} else {
					phoneText.setEditable(false);
					phoneInvalidLabel.setVisible(true);
				}

			}
		});

		phoneText.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (phoneText.getText().equals("Phone Number")) {
					phoneText.setText("");
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (phoneText.getText().length() != 10) {
					phoneInvalidLabel.setVisible(true);
					phoneInvalidLabel.setText("Invalid Input!");

				}
				if (phoneText.getText().equals("")) {
					phoneText.setText("Phone Number");
					phoneInvalidLabel.setVisible(false);
				}
				phoneText.setEditable(true);
				phoneInvalidLabel.setVisible(false);

			}
		});
		phoneText.setHorizontalAlignment(SwingConstants.CENTER);
		phoneText.setText("Phone Number");
		phoneText.setColumns(10);
		phoneText.setBounds(10, 175, 268, 27);
		registerFrame.getContentPane().add(phoneText);

		cityText = new JTextField();
		cityText.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				char c = e.getKeyChar();
				if (Character.isLetter(c) || Character.isWhitespace(c) || Character.isISOControl(c)) {
					cityInvalidLabel.setVisible(false);
					cityText.setEditable(true);
				} else {
					cityText.setEditable(false);
					cityInvalidLabel.setVisible(true);
				}
			}
		});
		cityText.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (cityText.getText().equals("City")) {
					cityText.setText("");
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (cityText.getText().equals("")) {
					cityText.setText("City");
				}
				cityText.setEditable(true);
				cityInvalidLabel.setVisible(false);
			}
		});
		cityText.setHorizontalAlignment(SwingConstants.CENTER);
		cityText.setText("City");
		cityText.setColumns(10);
		cityText.setBounds(10, 228, 127, 27);
		registerFrame.getContentPane().add(cityText);

		countryText = new JTextField();
		countryText.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				char c = e.getKeyChar();
				if (Character.isLetter(c) || Character.isWhitespace(c) || Character.isISOControl(c)) {
					countryInvalidLabel.setVisible(false);
					countryText.setEditable(true);
				} else {
					countryText.setEditable(false);
					countryInvalidLabel.setVisible(true);
				}
			}
		});
		countryText.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (countryText.getText().equals("Country")) {
					countryText.setText("");
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (countryText.getText().equals("")) {
					countryText.setText("Country");
				}
				countryText.setEditable(true);
				countryInvalidLabel.setVisible(false);
			}
		});
		countryText.setHorizontalAlignment(SwingConstants.CENTER);
		countryText.setText("Country");
		countryText.setColumns(10);
		countryText.setBounds(151, 228, 127, 27);
		registerFrame.getContentPane().add(countryText);

		firstNameText = new JTextField();
		firstNameText.setForeground(Color.BLACK);
		firstNameText.setHorizontalAlignment(SwingConstants.CENTER);
		firstNameText.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (firstNameText.getText().equals("Name")) {
					firstNameText.setText("");
				}

			}

			@Override
			public void focusLost(FocusEvent e) {
				if (firstNameText.getText().equals("")) {
					firstNameText.setText("Name");
				}
			}
		});
		firstNameText.setText("Name");
		firstNameText.setBounds(10, 32, 127, 26);
		registerFrame.getContentPane().add(firstNameText);
		firstNameText.setColumns(10);

		confirmPasswordText = new JTextField();
		confirmPasswordText.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				confirmPasswordText.setVisible(false);
				confirmPasswordField.setVisible(true);
			}

			@Override
			public void focusLost(FocusEvent e) {

			}
		});
		confirmPasswordText.setText("Confirm Password");
		confirmPasswordText.setHorizontalAlignment(SwingConstants.CENTER);
		confirmPasswordText.setForeground(Color.BLACK);
		confirmPasswordText.setColumns(10);
		confirmPasswordText.setBounds(10, 136, 268, 27);
		registerFrame.getContentPane().add(confirmPasswordText);

		confirmPasswordField = new JPasswordField();
		confirmPasswordField.setHorizontalAlignment(SwingConstants.CENTER);
		confirmPasswordField.setVisible(false);
		confirmPasswordField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				confirmPasswordField.setVisible(true);
			}

			@Override
			public void focusLost(FocusEvent e) {
				String confirmPassword = String.valueOf(confirmPasswordField.getPassword());

				if (confirmPassword.equals("")) {
					System.out.println("girdi");
					confirmPasswordField.setVisible(false);
					confirmPasswordText.setVisible(true);
					confirmPasswordText.setText("Confirm Password");
				}

			}
		});
		confirmPasswordField.setBounds(10, 136, 268, 27);
		registerFrame.getContentPane().add(confirmPasswordField);

		passwordField = new JPasswordField();
		passwordField.setVisible(false);
		passwordField.setHorizontalAlignment(SwingConstants.CENTER);
		passwordField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				passwordField.setVisible(true);
			}

			@Override
			public void focusLost(FocusEvent e) {
				String password = String.valueOf(passwordField.getPassword());

				if (password.equals("")) {
					passwordField.setVisible(false);
					passwordText.setVisible(true);
					passwordText.setText("Password");
				}

			}
		});
		passwordField.setBounds(10, 102, 268, 27);
		registerFrame.getContentPane().add(passwordField);

		cityInvalidLabel = new JLabel("Please Enter a City Name");
		cityInvalidLabel.setVisible(false);
		cityInvalidLabel.setFont(new Font("Tahoma", Font.PLAIN, 10));
		cityInvalidLabel.setForeground(Color.RED);
		cityInvalidLabel.setBounds(11, 258, 127, 14);
		registerFrame.getContentPane().add(cityInvalidLabel);

		countryInvalidLabel = new JLabel("Please Enter a Country Name");
		countryInvalidLabel.setVisible(false);
		countryInvalidLabel.setForeground(Color.RED);
		countryInvalidLabel.setFont(new Font("Tahoma", Font.PLAIN, 9));
		countryInvalidLabel.setBounds(152, 258, 127, 14);
		registerFrame.getContentPane().add(countryInvalidLabel);

		JButton registerButton = new JButton("Register");
		registerButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				boolean found = true;
				String confirmPassword = String.valueOf(confirmPasswordField.getPassword());
				String password = String.valueOf(passwordField.getPassword());

				if (!firstNameText.getText().toString().equals("") && !firstNameText.getText().toString().equals("Name")
						&& !lastNameText.getText().toString().equals("")
						&& !lastNameText.getText().toString().equals("Surname")
						&& !phoneText.getText().toString().equals("")
						&& !phoneText.getText().toString().equals("Phone Number")
						&& !cityText.getText().toString().equals("") && !cityText.getText().toString().equals("City")
						&& !countryText.getText().toString().equals("")
						&& !countryText.getText().toString().equals("Country")
						&& !usernameText.getText().toString().equals("")
						&& !usernameText.getText().toString().equals("Username") && !password.equals("")
						&& !confirmPassword.equals("")) {
					try {
						String[] words;
						File myObj = new File("userInfo.txt");
						Scanner myReader = new Scanner(myObj);
						while (myReader.hasNextLine()) {
							String data = myReader.nextLine();
							words = data.split(";");
							if (usernameText.getText().toString().equals(words[0])) {
								JOptionPane.showMessageDialog(registerFrame, "Your Username already exists.");
								found = false;
								break;

							}
						}
						myReader.close();
					} catch (FileNotFoundException x) {
						System.out.println("An error occurred.");
						x.printStackTrace();
					}
					if (found) {
						JOptionPane.showMessageDialog(registerFrame, "Registration success!");
						registerFrame.setVisible(false);
						logFrame.setVisible(true);

						String username = usernameText.getText().toString();
						String name = firstNameText.getText().toString();
						String surname = lastNameText.getText().toString();
						String phoneNumber = phoneText.getText().toString();
						String city = cityText.getText().toString();
						String country = countryText.getText().toString();

						try {
							FileWriter fileWritter = new FileWriter("userInfo.txt", true);
							BufferedWriter bw = new BufferedWriter(fileWritter);
							bw.append(username + ";" + password + ";" + "Customer" + ";" + name + ";" + surname + ";"
									+ phoneNumber + ";" + city + ";" + country + "\n");
							bw.close();
						} catch (IOException x) {
							x.printStackTrace();
						}

//						Customer cus = new Customer(firstNameText.getText().toString(), lastNameText.getText().toString(),
//								new Phone(phoneText.getText().toString()),
//								new Address(cityText.getText().toString(), countryText.getText().toString()),
//								usernameText.getText().toString(), String.valueOf(passwordField.getPassword()));
					}

				} else if (!String.valueOf(passwordField.getPassword())
						.equalsIgnoreCase(String.valueOf(confirmPasswordField.getPassword()))) {
					JOptionPane.showMessageDialog(registerFrame, "Passwords don't pair !");
				}

				else {
					JOptionPane.showMessageDialog(registerFrame, "All areas must be filled !");
				}

			}
		});
		registerButton.setBounds(100, 301, 85, 21);
		registerFrame.getContentPane().add(registerButton);

		JButton haveAccount = new JButton("Login Page");
		haveAccount.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				registerFrame.setVisible(false);
				logFrame.setVisible(true);

			}
		});
		haveAccount.setBounds(96, 376, 95, 21);
		registerFrame.getContentPane().add(haveAccount);

		JLabel lblNewLabel = new JLabel("Already have an account?");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(69, 358, 146, 13);
		registerFrame.getContentPane().add(lblNewLabel);

		/*
		 * //LOGIN WINDOW ICON ImageIcon login_icon = new ImageIcon("login.png");
		 * registerFrame.setIconImage(login_icon.getImage());
		 * 
		 * //USERNAME ICON ImageIcon image_1 = new ImageIcon("icon_1.png"); ImageIcon
		 * imageIcon_1 = new ImageIcon(new
		 * ImageIcon("icon_1.png").getImage().getScaledInstance(20, 20,
		 * Image.SCALE_DEFAULT)); JLabel myLabel_1 = new JLabel(imageIcon_1);
		 * myLabel_1.setBounds(20, 29, 41, 19); myLabel_1.setForeground(Color.RED);
		 * registerFrame.getContentPane().add(myLabel_1);
		 * 
		 * //PASSWORD ICON ImageIcon image_2 = new ImageIcon("icon_2.png"); ImageIcon
		 * imageIcon = new ImageIcon(new
		 * ImageIcon("icon_2.png").getImage().getScaledInstance(20, 20,
		 * Image.SCALE_DEFAULT)); JLabel myLabel_2 = new JLabel(imageIcon);
		 * myLabel_2.setBounds(21, 62, 41, 19); myLabel_2.setForeground(Color.RED);
		 * registerFrame.getContentPane().add(myLabel_2);
		 */

	}

	public JFrame getRegisterFrame() {
		return registerFrame;
	}

	public void setRegisterFrame(JFrame registerFrame) {
		this.registerFrame = registerFrame;
	}

	public JPanel getContentPane() {
		return contentPane;
	}

	public void setContentPane(JPanel contentPane) {
		this.contentPane = contentPane;
	}
}