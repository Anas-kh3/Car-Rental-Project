import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class profileFrame {
	private JFrame pframe;
	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel model;
	private List<String[]> lst;
	private JTextField brandTextField;
	private JTextField modelTextField;
	private JTextField priceTextField;
	private JTextField typeTextField;
	private JTableHeader header;
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					profileFrame frame = new profileFrame();
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
	public profileFrame(JFrame frmRentCar, Company comp) {
		pframe = new JFrame();
		pframe.setTitle("Welcome " + comp.getCustomer().getFirstName() + " " + comp.getCustomer().getLastName());
		JPanel panel = new JPanel();
		panel.setBackground(new Color(240, 248, 255));

		

		
		lst = new ArrayList<String[]>();
		try {
			String[] words;
		      File myObj = new File("contracts.txt");
		      Scanner myReader = new Scanner(myObj);
		      while (myReader.hasNextLine()) {
		        String data = myReader.nextLine();
		        words = data.split(";");
		        if (words[0].equals(comp.getCustomer().getUsername())) {
		        	lst.add(new String[] { words[7], words[8],
							String.valueOf(words[9]),
							words[10] , words[11]});
				}

		      }
		      myReader.close();
		    } catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }

		String col[] = { "Brand", "Model", "Type", "Rent Day" , "Rent Location"};
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
		table = new JTable();


		table.setModel(model);
		header = table.getTableHeader();
		header.setEnabled(false);
		header.setBackground(new Color(240, 248, 255));
		panel.setLayout(null);

		JScrollPane pane = new JScrollPane(table);
		pane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		pane.setBounds(57, 151, 380, 444);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
		panel.add(pane);
		pframe.getContentPane().add(panel);
		
		JLabel lblNewLabel = new JLabel("Name: " + comp.getCustomer().getFirstName());
		lblNewLabel.setBounds(57, 11, 137, 23);
		panel.add(lblNewLabel);
		
		JLabel lblSurname = new JLabel("Surname: " + comp.getCustomer().getLastName());
		lblSurname.setBounds(57, 36, 137, 23);
		panel.add(lblSurname);
		
		JLabel lblNewLabel_1 = new JLabel("Phone: " + comp.getCustomer().getPhoneNumber().getNumber());
		lblNewLabel_1.setBounds(57, 61, 137, 23);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Address: " + comp.getCustomer().getAddress().getCity() + " " + comp.getCustomer().getAddress().getCountry() );
		lblNewLabel_1_1.setBounds(57, 86, 190, 23);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_2 = new JLabel("Your Rented Cars : ");
		lblNewLabel_2.setBounds(57, 126, 137, 14);
		lblNewLabel_2.setForeground(new Color(0,100,0));
		lblNewLabel_2.setFont(new Font("Calibri", Font.BOLD, 15));
		panel.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Rent Page");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pframe.setVisible(false);
				frmRentCar.setVisible(true);
				
			}
		});
		btnNewButton.setBounds(348, 61, 89, 23);
		panel.add(btnNewButton);
		pframe.setSize(500, 750);
		pframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pframe.setVisible(true);
		
		// Get the screen size
				Toolkit toolkit = Toolkit.getDefaultToolkit();
				Dimension screenSize = toolkit.getScreenSize();

				// Calculate the frame location
				int x = (screenSize.width - pframe.getWidth()) / 2;
				int y = (screenSize.height - pframe.getHeight()) / 2;

				// Set the new frame location
				pframe.setLocation(x, y);
	}
}
