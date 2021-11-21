
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Login {

	private JFrame frmLogIn;
	private JTextField txtUserName;
	private JPasswordField passwordField;
	private JButton btnLogIn;
	private Company comp;

	public static void main(String[] args) {
		System.setProperty("file.encoding", "UTF-8");
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frmLogIn.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Login() {
		comp = new Company();

		// Get the screen size
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension screenSize = toolkit.getScreenSize();

		frmLogIn = new JFrame();
		frmLogIn.getContentPane().setBackground(new Color(240, 248, 255));
		frmLogIn.setResizable(false);
		frmLogIn.setTitle("Log in");
		frmLogIn.setBounds(100, 100, 300, 250);
		frmLogIn.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLogIn.getContentPane().setLayout(null);

		// Calculate the frame location
		int x = (screenSize.width - frmLogIn.getWidth()) / 2;
		int y = (screenSize.height - frmLogIn.getHeight()) / 2;

		// Set the new frame location
		frmLogIn.setLocation(x, y);

		frmLogIn.setBackground(new Color(127, 205, 205));

		JLabel lblUserName = new JLabel("User Name: ");
		lblUserName.setBounds(55, 31, 78, 14);
		frmLogIn.getContentPane().add(lblUserName);

		txtUserName = new JTextField();
		txtUserName.setBounds(143, 28, 86, 20);
		txtUserName.setColumns(10);
		frmLogIn.getContentPane().add(txtUserName);

		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(55, 65, 78, 14);
		frmLogIn.getContentPane().add(lblPassword);

		passwordField = new JPasswordField();
		passwordField.setBounds(143, 59, 86, 20);
		frmLogIn.getContentPane().add(passwordField);

		// CHANGE THEME
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");

		} catch (Exception e) {
			e.printStackTrace();
		}

		btnLogIn = new JButton("Log in");
		frmLogIn.getRootPane().setDefaultButton(btnLogIn); // DEFAULT ENTER BUTTON
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {
					String[] word = null;
					boolean flag = false;
					File myObj = new File("userInfo.txt");
					Scanner myReader = new Scanner(myObj, "utf-8");
					while (myReader.hasNextLine()) {
						String data = myReader.nextLine();
						word = data.split(";");
						if (txtUserName.getText().equalsIgnoreCase(word[0])
								&& passwordField.getText().equalsIgnoreCase((word[1]))) {
							if (word[2].equalsIgnoreCase("Admin")) {
								Add_deleteCar ap = new Add_deleteCar(frmLogIn, comp); // BURDA YOLLUCAZ
								ap.getAddDeleteFrame().setVisible(true);
								txtUserName.setText("");
								passwordField.setText("");
								frmLogIn.setVisible(false);
								flag = true;
								break;
							} else {

								Customer cus = new Customer(word[3], word[4], new Phone(word[5]),
										new Address(word[6], word[7]), word[0], word[1]);

								comp.setCustomer(cus);

								CustomerMenuPage mp = new CustomerMenuPage(frmLogIn, comp);

								mp.getMpFrame().setVisible(true);
								txtUserName.setText("");
								passwordField.setText("");
								frmLogIn.setVisible(false);
								flag = true;
								break;
							}

						}
					}
					if (!flag) {
						if (txtUserName.getText().equals("") || passwordField.getText().equals("")) {
							JOptionPane.showMessageDialog(frmLogIn, "All areas must be filled !");
							txtUserName.setText("");
							passwordField.setText("");
						} else {
							JOptionPane.showMessageDialog(frmLogIn, "Wrong password or user name !");
							txtUserName.setText("");
							passwordField.setText("");
						}

					} else

						myReader.close();
				} catch (FileNotFoundException e) {
					System.out.println("An error occurred.");
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		btnLogIn.setBounds(52, 105, 177, 23);
		frmLogIn.getContentPane().add(btnLogIn);

		JButton btnRegister = new JButton("Register");
		btnRegister.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Register reg = new Register(frmLogIn);
				reg.getRegisterFrame().setVisible(true);
				txtUserName.setText("");
				passwordField.setText("");
				frmLogIn.setVisible(false);
			}
		});
		btnRegister.setBounds(93, 150, 95, 23);
		frmLogIn.getContentPane().add(btnRegister);

		// LOGIN WINDOW ICON
		ImageIcon login_icon = new ImageIcon("login.png");
		frmLogIn.setIconImage(login_icon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));

		// USERNAME ICON
		ImageIcon image_1 = new ImageIcon("username.png");
		ImageIcon imageIcon_1 = new ImageIcon(
				new ImageIcon("username.png").getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
		JLabel myLabel_1 = new JLabel(imageIcon_1);
		myLabel_1.setBounds(20, 17, 45, 45);
		myLabel_1.setForeground(Color.RED);
		frmLogIn.getContentPane().add(myLabel_1);

		// PASSWORD ICON
		ImageIcon image_2 = new ImageIcon("password.png");
		ImageIcon imageIcon = new ImageIcon(
				new ImageIcon("password.png").getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
		JLabel myLabel_2 = new JLabel(imageIcon);
		myLabel_2.setBounds(20, 50, 45, 45);
		myLabel_2.setForeground(Color.RED);
		frmLogIn.getContentPane().add(myLabel_2);

		JLabel background;
		ImageIcon pic = new ImageIcon(
				new ImageIcon("bg.jpg").getImage().getScaledInstance(300, 250, Image.SCALE_SMOOTH));
		background = new JLabel("", pic, JLabel.CENTER);
		background.setBounds(0, 0, 300, 250);
		frmLogIn.add(background);

	}

	public JFrame getFrmLogIn() {
		return frmLogIn;
	}

	public Company getComp() {
		return comp;
	}

}