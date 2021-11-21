import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.*;

import javax.swing.table.*;

public class Add_deleteCar {

	private JFrame addDeleteFrame;
	private JScrollPane pane;
	private JTable jTable1;
	private JTableHeader header;

	private JButton btnAdd_woutPhoto;
	private JButton btnDelete;

	private DefaultTableModel model;

	private JPanel panel;

	private List<String[]> lst;

	private JLabel invalidBrandLabel;
	private JLabel invalidModelLabel;
	private JLabel invalidPriceLabel;
	private JLabel invalidCarTypeLabel;

	private JTextField brandTextField;
	private JTextField modelTextField;
	private JTextField priceTextField;
	private JTextField typeTextField;
	private JButton btnAdd_wPhoto;
	private JButton listContractsButton;

	private Queue<Contract> contractQueue = new LinkedList<Contract>();

//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Add_deleteCar window = new Add_deleteCar();
//					window.addDeleteFrame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	public void writeToFile(Company comp, String fileName) {

		try {
			FileWriter fileWritter = new FileWriter(fileName + ".txt");
			BufferedWriter bw = new BufferedWriter(fileWritter);
			for (int i = 0; i < comp.getCars().size(); i++) {
				bw.write(comp.getCars().get(i).getBrand() + ";" + comp.getCars().get(i).getModel() + ";"
						+ comp.getCars().get(i).isIs_available() + ";" + comp.getCars().get(i).getPriceforday() + ";"
						+ comp.getCars().get(i).getType().getTypeName() + ";" + comp.getCars().get(i).getImagePath()
						+ ";" + "\n");
			}
			bw.close();
		} catch (IOException x) {
			x.printStackTrace();
		}

	}

	public Add_deleteCar(JFrame frmLogIn, Company comp) {
		// CHANGE THEME
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");

		} catch (Exception e) {
			e.printStackTrace();
		}

		addDeleteFrame = new JFrame("Add/Delete Car");
		addDeleteFrame.setResizable(false);

		
		panel = new JPanel();
		panel.setBackground(new Color(240, 248, 255));

		brandTextField = new JTextField();
		brandTextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				char c = e.getKeyChar();
				if (Character.isLetter(c) || Character.isWhitespace(c) || Character.isISOControl(c)) {
					invalidBrandLabel.setVisible(false);
					brandTextField.setEditable(true);
				} else {
					brandTextField.setEditable(false);
					invalidBrandLabel.setVisible(true);
				}

			}
		});

		brandTextField.setBounds(135, 20, 182, 28);
		panel.add(brandTextField);
		brandTextField.setColumns(10);

		modelTextField = new JTextField();
		modelTextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				char c = e.getKeyChar();
				if (Character.isLetter(c) || Character.isDigit(c) || Character.isWhitespace(c)
						|| Character.isISOControl(c)) {
					invalidModelLabel.setVisible(false);
					modelTextField.setEditable(true);
				} else {
					modelTextField.setEditable(false);
					invalidModelLabel.setVisible(true);
				}
			}
		});
		modelTextField.setColumns(10);
		modelTextField.setBounds(135, 66, 182, 28);
		panel.add(modelTextField);

		priceTextField = new JTextField();
		priceTextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				char c = e.getKeyChar();
				if (!Character.isLetter(c) || Character.isWhitespace(c) || Character.isISOControl(c)) {
					invalidPriceLabel.setVisible(false);
					priceTextField.setEditable(true);
				} else {
					priceTextField.setEditable(false);
					invalidPriceLabel.setVisible(true);
				}
			}
		});
		priceTextField.setColumns(10);
		priceTextField.setBounds(135, 112, 182, 27);
		panel.add(priceTextField);

		typeTextField = new JTextField();
		typeTextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				char c = e.getKeyChar();
				if (Character.isLetter(c) || Character.isWhitespace(c) || Character.isISOControl(c)) {
					invalidCarTypeLabel.setVisible(false);
					typeTextField.setEditable(true);
				} else {
					typeTextField.setEditable(false);
					invalidCarTypeLabel.setVisible(true);
				}
			}
		});
		typeTextField.setColumns(10);
		typeTextField.setBounds(135, 158, 182, 28);
		panel.add(typeTextField);

		lst = new ArrayList<String[]>();

		for (int i = 0; i < comp.getCars().size(); i++) {
			lst.add(new String[] { comp.getCars().get(i).getBrand(), comp.getCars().get(i).getModel(),
					String.valueOf(comp.getCars().get(i).getPriceforday()),
					comp.getCars().get(i).getType().getTypeName(), comp.getCars().get(i).isIs_available() });
		}

		String col[] = { "Brand", "Model", "Price", "Type", "Availability" };

		model = new DefaultTableModel(col, 0) {
			@Override
			public boolean isCellEditable(int row, int column) {
				// all cells false
				return false;
			}
		};
		for (String[] row : lst) {
			model.addRow(row);
		}

		jTable1 = new JTable();
		jTable1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent evt) {
				int update_row = jTable1.rowAtPoint(evt.getPoint());

				brandTextField.setText(model.getValueAt(update_row, 0).toString());
				modelTextField.setText(model.getValueAt(update_row, 1).toString());
				priceTextField.setText(model.getValueAt(update_row, 2).toString());
				typeTextField.setText(model.getValueAt(update_row, 3).toString());
			}
		});

		jTable1.setModel(model);

		header = jTable1.getTableHeader();
		header.setEnabled(false);
		header.setBackground(new Color(240, 248, 255));
		panel.setLayout(null);

		pane = new JScrollPane(jTable1);
		pane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		pane.setBounds(48, 247, 380, 444);
		jTable1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

		panel.add(pane);
		addDeleteFrame.getContentPane().add(panel);

		btnDelete = new JButton("Delete selected");
		btnDelete.setForeground(Color.RED);
		panel.add(btnDelete);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int answer = -1;
				int selectedRow = jTable1.getSelectedRow();
				if (selectedRow >= 0) {
					answer = JOptionPane.showConfirmDialog(addDeleteFrame, "Are you sure you want to delete this car?",
							"WARNING", JOptionPane.YES_NO_OPTION);
				}
				if (selectedRow < 0) {
					JOptionPane.showMessageDialog(addDeleteFrame, "Please select a car!");
				}

				if (selectedRow >= 0 && answer == 0) {
					model.removeRow(selectedRow);
					comp.getCars().remove(selectedRow);
					brandTextField.setText("");
					modelTextField.setText("");
					priceTextField.setText("");
					typeTextField.setText("");

					writeToFile(comp, "cars");

				}
			}
		});

		btnDelete.setBackground(UIManager.getColor("Button.background"));
		btnDelete.setBounds(327, 110, 130, 31);

		invalidBrandLabel = new JLabel("Invalid input!");
		invalidBrandLabel.setHorizontalAlignment(SwingConstants.CENTER);
		invalidBrandLabel.setVisible(false);
		invalidBrandLabel.setForeground(Color.RED);
		invalidBrandLabel.setBounds(135, 48, 182, 13);
		panel.add(invalidBrandLabel);

		invalidModelLabel = new JLabel("Invalid input!");
		invalidModelLabel.setHorizontalAlignment(SwingConstants.CENTER);
		invalidModelLabel.setVisible(false);
		invalidModelLabel.setForeground(Color.RED);
		invalidModelLabel.setBounds(135, 94, 182, 13);
		panel.add(invalidModelLabel);

		invalidPriceLabel = new JLabel("Invalid input!");
		invalidPriceLabel.setHorizontalAlignment(SwingConstants.CENTER);
		invalidPriceLabel.setVisible(false);
		invalidPriceLabel.setForeground(Color.RED);
		invalidPriceLabel.setBounds(135, 140, 182, 13);
		panel.add(invalidPriceLabel);

		invalidCarTypeLabel = new JLabel("Invalid input!");
		invalidCarTypeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		invalidCarTypeLabel.setVisible(false);
		invalidCarTypeLabel.setForeground(Color.RED);
		invalidCarTypeLabel.setBounds(135, 186, 182, 13);
		panel.add(invalidCarTypeLabel);

		// ***** ADD *****
		btnAdd_woutPhoto = new JButton("Add (w/out_photo)");
		btnAdd_woutPhoto.setForeground(Color.BLUE);
		panel.add(btnAdd_woutPhoto);
		btnAdd_woutPhoto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (!brandTextField.getText().equals("") && !modelTextField.getText().equals("")
						&& !priceTextField.getText().equals("") && !typeTextField.getText().equals("")) {

					comp.getCars().add(new Car(brandTextField.getText(), modelTextField.getText(), "true",
							Integer.parseInt(priceTextField.getText()), new CarType(typeTextField.getText()), null));
					model.addRow(new Object[] { brandTextField.getText(), modelTextField.getText(),
							priceTextField.getText(), typeTextField.getText(), "true" });
					JOptionPane.showMessageDialog(addDeleteFrame, "Successfully added!");

					brandTextField.setText("");
					modelTextField.setText("");
					priceTextField.setText("");
					typeTextField.setText("");
					writeToFile(comp, "cars");
				} else {
					JOptionPane.showMessageDialog(addDeleteFrame, "All texts must be filled!");
				}

			}
		});

		btnAdd_woutPhoto.setBackground(UIManager.getColor("Button.background"));
		btnAdd_woutPhoto.setBounds(327, 18, 130, 31);

		JLabel brandLabel = new JLabel("Brand:");
		panel.add(brandLabel);
		brandLabel.setBounds(48, 26, 57, 14);

		JLabel modelLabel = new JLabel("Model:");
		panel.add(modelLabel);
		modelLabel.setBounds(48, 72, 80, 14);

		JLabel priceLabel = new JLabel("Price for day:");
		panel.add(priceLabel);
		priceLabel.setBounds(48, 118, 80, 14);

		JLabel cartypeLabel = new JLabel("Car type:");
		panel.add(cartypeLabel);
		cartypeLabel.setBounds(48, 164, 80, 14);

		JButton deleteAllButton = new JButton("Delete All Data");
		deleteAllButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int answer = JOptionPane.showConfirmDialog(addDeleteFrame, "Are you sure you want to delete all cars?",
						"WARNING", JOptionPane.YES_NO_OPTION);

				if (answer == 0) {
					String password = JOptionPane.showInputDialog(addDeleteFrame, "Enter Password", "LAST WARNING",
							JOptionPane.PLAIN_MESSAGE);

					if (password != null && password.equals("12345")) {

						while (model.getRowCount() > 0) {
							model.removeRow(0);
						}

						comp.getCars().clear();
						writeToFile(comp, "cars");
					}

				}
			}
		});
		deleteAllButton.setForeground(Color.RED);
		deleteAllButton.setBackground(UIManager.getColor("Button.background"));
		deleteAllButton.setBounds(327, 155, 130, 31);
		panel.add(deleteAllButton);

		// ***** ADD WITH PHOTO *****
		btnAdd_wPhoto = new JButton("Add (w/photo)");
		btnAdd_wPhoto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser j = new JFileChooser(System.getProperty("user.home") + "/Desktop");
				String filePath = null;
				int result = j.showOpenDialog(null);
				if (result == JFileChooser.APPROVE_OPTION) {
					File selectedFile = j.getSelectedFile();
					filePath = selectedFile.getAbsolutePath();
					// select file
				} else if (result == JFileChooser.CANCEL_OPTION) {
					filePath = "";
				}
				BufferedImage img = null;

				if (!brandTextField.getText().equals("") && !modelTextField.getText().equals("")
						&& !priceTextField.getText().equals("") && !typeTextField.getText().equals("")) {

					comp.getCars()
							.add(new Car(brandTextField.getText(), modelTextField.getText(), "true",
									Integer.parseInt(priceTextField.getText()), new CarType(typeTextField.getText()),
									filePath));
					model.addRow(new Object[] { brandTextField.getText(), modelTextField.getText(),
							priceTextField.getText(), typeTextField.getText(), "true" });
					JOptionPane.showMessageDialog(addDeleteFrame, "Successfully added!");

					brandTextField.setText("");
					modelTextField.setText("");
					priceTextField.setText("");
					typeTextField.setText("");
					writeToFile(comp, "cars");
				} else {
					JOptionPane.showMessageDialog(addDeleteFrame, "All texts must be filled!");
				}

			}
		});
		btnAdd_wPhoto.setForeground(Color.BLUE);
		btnAdd_wPhoto.setBackground(SystemColor.menu);
		btnAdd_wPhoto.setBounds(327, 64, 130, 31);
		panel.add(btnAdd_wPhoto);

		JButton logoutButton = new JButton("Logout");
		logoutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				writeToFile(comp, "cars");
				addDeleteFrame.setVisible(false);
				frmLogIn.setVisible(true);
			}
		});
		logoutButton.setForeground(Color.BLUE);
		logoutButton.setBounds(81, 209, 123, 21);
		panel.add(logoutButton);

		listContractsButton = new JButton("List Contracts");
		listContractsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] row = null;
				try {
					File myObj = new File("contracts.txt");
					Scanner myReader = new Scanner(myObj);
					while (myReader.hasNextLine()) {
						String data = myReader.nextLine();
						row = data.split(";");
						contractQueue.add(new Contract(
								new Car(row[7], row[8], new CarType(row[9])), new Customer(row[2], row[3],
										new Phone(row[4]), new Address(row[5], row[6]), row[0], row[1]),
								row[10], row[11]));

					}
					myReader.close();
				} catch (FileNotFoundException g) {
					System.out.println("An error occurred!");
					g.printStackTrace();
				}
				String showContract = "";

				for (Contract cont : contractQueue) {
					showContract += "Username:" + cont.getCustomer().getUsername() + " " + "_FirstName:"
							+ cont.getCustomer().getFirstName() + " " + "_LastName:" + cont.getCustomer().getLastName()
							+ " " + "_Brand:" + cont.getCar().getBrand() + " " + "_Model:" + cont.getCar().getModel()
							+ " " + "_RentDay:" + cont.getRentalDay() + " " + "_RentLocation:" + cont.getRentLocation()
							+ "\n";
				}

				JTextArea textArea = new JTextArea(showContract);
				textArea.setEditable(false);
				JScrollPane scrollPane = new JScrollPane(textArea);
				scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);

				scrollPane.setPreferredSize(new Dimension(500, 500));
				if (!contractQueue.isEmpty()) {
					JOptionPane.showMessageDialog(null, scrollPane, "All Contracts Done So Far", JOptionPane.OK_OPTION);
				}
				if (contractQueue.isEmpty()) {
					JOptionPane.showMessageDialog(addDeleteFrame, "There is no contract");
				}

			}
		});
		listContractsButton.setForeground(Color.BLUE);
		listContractsButton.setBounds(262, 209, 123, 21);
		panel.add(listContractsButton);

		addDeleteFrame.setSize(500, 750);
		addDeleteFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addDeleteFrame.setVisible(true);

		// Get the screen size
		Toolkit toolkit = Toolkit.getDefaultToolkit(); // FRAME LOCATION
		Dimension screenSize = toolkit.getScreenSize();

		// Calculate the frame location
		int x = (screenSize.width - addDeleteFrame.getWidth()) / 2;
		int y = (screenSize.height - addDeleteFrame.getHeight()) / 2;

		// Set the new frame location
		addDeleteFrame.setLocation(x, y);

	}

	public JFrame getAddDeleteFrame() {
		return addDeleteFrame;
	}

	public void setAddDeleteFrame(JFrame addDeleteFrame) {
		this.addDeleteFrame = addDeleteFrame;
	}
}