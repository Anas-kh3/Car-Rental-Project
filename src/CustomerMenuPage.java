import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.List;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;

public class CustomerMenuPage {
	JMenu menu, submenu, about;
	JMenuItem i1, i2, i3, i4, i5;
	static JLabel isAvailable;
	static JFrame mpFrame;
	static JPanel GridPanel;
	static ArrayList<JLabel> Availability = new ArrayList<>();
	static ArrayList<JPanel> panelList = new ArrayList<>();
	static ArrayList<JButton> buttonList = new ArrayList<>();
	static ArrayList<BufferedImage> photos = new ArrayList<>();

	public static void createItemPanel(ArrayList<JPanel> arr, ArrayList<Car> car, ArrayList<JButton> butt, int x,
			Company comp, JFrame frame2, ArrayList<JLabel> kek, ArrayList<BufferedImage> photos) throws IOException {
		JPanel a = new JPanel();
		a.setLayout(null);
		JLabel infoCarModel = new JLabel(car.get(x).getModel());
		JLabel infoCarBrand = new JLabel(car.get(x).getBrand());
		JLabel infoCarType = new JLabel(car.get(x).getType().getTypeName().toUpperCase());
		JLabel infoCarPrice = new JLabel(String.valueOf(car.get(x).getPriceforday()) + " ₺ ");
		JLabel label2 = new JLabel(" / Day ");
		
		
		infoCarModel.setFont(new Font("Calibri", Font.ITALIC, 20));
		infoCarBrand.setFont(new Font("Calibri", Font.CENTER_BASELINE, 20));
		infoCarType.setFont(new Font("Calibri", Font.BOLD, 20));
		infoCarPrice.setFont(new Font("Calibri", Font.ITALIC, 20));
		label2.setFont(new Font("Calibri", Font.TRUETYPE_FONT, 15));
		infoCarType.setForeground(Color.WHITE);

		isAvailable = new JLabel();
		if (car.get(x).isIs_available().equals("true")) {
			isAvailable.setText("Available");
			isAvailable.setForeground(new Color(49, 140, 40));
			isAvailable.setFont(new Font("Calibri", Font.BOLD, 20));
		} else if (car.get(x).isIs_available().equals("false")) {
			isAvailable.setText("Not Available");
			isAvailable.setForeground(Color.red);
			isAvailable.setFont(new Font("Calibri", Font.BOLD, 20));
		}

		JButton button1 = new JButton();
		infoCarBrand.setBounds(300, 0, 150, 25);
		infoCarModel.setBounds(300, 0, 150, 65);
		infoCarType.setBounds(300, 50, 150, 40);
		infoCarPrice.setBounds(700, 30, 200, 50);
		label2.setBounds(755, 30, 200, 50);
		isAvailable.setBounds(700, 0, 200, 50);
		a.add(infoCarModel);
		a.add(infoCarBrand);
		a.add(infoCarType);
		a.add(isAvailable);
		a.add(label2);
		a.add(infoCarPrice);
		if (car.get(x).getImagePath() != null) {

			ImageIcon image_2 = new ImageIcon(car.get(x).getImagePath());
			ImageIcon imageIcon_2 = new ImageIcon(image_2.getImage().getScaledInstance(180, 90, Image.SCALE_SMOOTH));

			JLabel myLabel_2 = new JLabel(imageIcon_2);
			myLabel_2.setBounds(0, 0, 200, 100);
			
			a.add(myLabel_2);
		}
		

		button1.setText("RENT");
		button1.setFont(new Font("Calibri", Font.BOLD, 15));
		button1.setForeground(Color.white);
		button1.setBackground(Color.black);
		button1.setBounds(850, 0, 100, 90);
		a.add(button1);
		a.setBackground(new Color(160, 160, 160));
		butt.add(button1);
		arr.add(a);
		frame2.getContentPane().add(a);
		kek.add(isAvailable);
		
		button1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (car.get(buttonList.indexOf(button1)).isIs_available().equals("true")) {
					RentCar rc = new RentCar(mpFrame, comp, car.get(buttonList.indexOf(button1)));
					mpFrame.setVisible(false);
				} else {
					JOptionPane.showMessageDialog(mpFrame, "This car is not available");

				}

			}
		});

	}

	public CustomerMenuPage(JFrame frmLogIn, Company comp) throws IOException {

		mpFrame = new JFrame();
		mpFrame.setTitle("Welcome " + comp.getCustomer().getFirstName() + " " + comp.getCustomer().getLastName());
		mpFrame.setResizable(false);
		mpFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JMenuBar mb = new JMenuBar();
		menu = new JMenu("Menu");

		JMenuItem profile = new JMenuItem("Profile");
		profile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				profileFrame a = new profileFrame(mpFrame, comp);
				mpFrame.setVisible(false);
			}
		});
		JMenuItem logout = new JMenuItem("LOGOUT");

		logout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int answer = JOptionPane.showConfirmDialog(mpFrame, "Do you want to log out?", "LOGOUT",
						JOptionPane.YES_NO_OPTION);
				if (answer == 0) {
					frmLogIn.setVisible(true);
					mpFrame.setVisible(false);

				}
			}
		});
		JMenuItem aboutus = new JMenuItem("About us");

		aboutus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(mpFrame,
						"DEVELOPED BY : \n Burak Konuk \n Ekin Uzunbaz \n Mehmet Yıldız \n GURURLA SUNAR BEKLEMEDE KALIN \n Patch:q0.240/42-version3.1 ",
						"Who are we ?", JOptionPane.DEFAULT_OPTION);

			}
		});
		menu.add(profile);
		menu.add(aboutus);
		menu.add(logout);

		mb.add(menu);
		mpFrame.setJMenuBar(mb);
		GridPanel = new JPanel();
		mpFrame.getContentPane().add(GridPanel);

		for (int i = 0; i < comp.getCars().size(); i++) {
			createItemPanel(panelList, comp.getCars(), buttonList, i, comp, frmLogIn, Availability, photos);
		}

		int kekw = panelList.size();
		GridPanel.setLayout(new GridLayout(kekw, 1, 0, 10));

		GridPanel.setPreferredSize(new Dimension(800, kekw * 100));

		for (int i = 0; i < panelList.size(); i++) {
			GridPanel.add(panelList.get(i));
		}
		JScrollPane scroll = new JScrollPane(GridPanel);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		mpFrame.getContentPane().add(scroll, BorderLayout.CENTER);
		scroll.getVerticalScrollBar().setUnitIncrement(8);
		mpFrame.setSize(1000, 750);
		mpFrame.setVisible(true);

		// Get the screen size
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension screenSize = toolkit.getScreenSize();

		// Calculate the frame location
		int x = (screenSize.width - mpFrame.getWidth()) / 2;
		int y = (screenSize.height - mpFrame.getHeight()) / 2;

		// Set the new frame location
		mpFrame.setLocation(x, y);

		if (comp.getCars().size() == 0) {
			CustomerMenuPage.GridPanel.setBackground(Color.black);
			JOptionPane.showMessageDialog(mpFrame, "BATTIK");
		} else {
			CustomerMenuPage.GridPanel.setBackground(new Color(171, 219, 210));
			mpFrame.getContentPane().setBackground(new Color(171, 219, 210));
		}

	}

	public JFrame getMpFrame() {
		return mpFrame;
	}

	public void setMpFrame(JFrame mpFrame) {
		this.mpFrame = mpFrame;
	}

}