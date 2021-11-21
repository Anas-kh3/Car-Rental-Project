
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.UIManager;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AdminMenuPage {

	private JFrame adminFrame;
	private JRadioButton rbtnBookASeat;
	private JRadioButton rbtnDisplayAllP;
	private JRadioButton rbtnDisplayAllS;
	private JRadioButton rbtnSearch;
	private JRadioButton rbtnExit;

	public AdminMenuPage(JFrame logFrame) {

		// CHANGE THEME
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");

		} catch (Exception e) {
			e.printStackTrace();
		}

		adminFrame = new JFrame();
		adminFrame.setTitle("Admin Menu");
		adminFrame.setBounds(100, 100, 342, 293);
		adminFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		adminFrame.getContentPane().setLayout(null);

		JButton addCarButton = new JButton("Add Car");
		addCarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		addCarButton.setBounds(78, 40, 158, 21);
		adminFrame.getContentPane().add(addCarButton);

		JButton deleteCarButton = new JButton("Delete Car");
		deleteCarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		deleteCarButton.setBounds(78, 71, 158, 21);
		adminFrame.getContentPane().add(deleteCarButton);

		JButton btnDeleteAllData = new JButton("Delete All Data");
		btnDeleteAllData.setForeground(Color.RED);
		btnDeleteAllData.setBounds(78, 100, 158, 21);
		adminFrame.getContentPane().add(btnDeleteAllData);

		JButton backButton = new JButton("Back");
		backButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				logFrame.setVisible(true);
				adminFrame.setVisible(false);
			}
		});
		backButton.setBounds(78, 132, 158, 21);
		adminFrame.getContentPane().add(backButton);

		// ADMIN MENU ICON
		ImageIcon admin_icon = new ImageIcon("admin.png");
		adminFrame.setIconImage(admin_icon.getImage());

		// ADD CAR ICON
		ImageIcon image_1 = new ImageIcon("add_car.png");
		ImageIcon imageIcon_1 = new ImageIcon(
				new ImageIcon("add_car.png").getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
		JLabel myLabel_1 = new JLabel(imageIcon_1);
		myLabel_1.setBounds(50, 35, 28, 26);
		myLabel_1.setForeground(Color.RED);
		adminFrame.getContentPane().add(myLabel_1);

		// DELETE CAR ICON
		ImageIcon image_2 = new ImageIcon("delete_car.png");
		ImageIcon imageIcon_2 = new ImageIcon(
				new ImageIcon("delete_car.png").getImage().getScaledInstance(25, 35, Image.SCALE_SMOOTH));
		JLabel myLabel_2 = new JLabel(imageIcon_2);
		myLabel_2.setBounds(55, 69, 20, 22);
		myLabel_2.setForeground(Color.RED);
		adminFrame.getContentPane().add(myLabel_2);

		// DELETE DATA ICON
		ImageIcon image_3 = new ImageIcon("delete_data.png");
		ImageIcon imageIcon_3 = new ImageIcon(
				new ImageIcon("delete_data.png").getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
		JLabel myLabel_3 = new JLabel(imageIcon_3);
		myLabel_3.setBounds(2, 45, 127, 132);
		myLabel_3.setForeground(Color.RED);
		adminFrame.getContentPane().add(myLabel_3);

		// BACK
		ImageIcon image_4 = new ImageIcon("back.png");
		ImageIcon imageIcon_4 = new ImageIcon(
				new ImageIcon("back.png").getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
		JLabel myLabel_4 = new JLabel(imageIcon_4);
		myLabel_4.setBounds(44, 131, 41, 27);
		myLabel_4.setForeground(Color.RED);
		adminFrame.getContentPane().add(myLabel_4);

	}

	public JFrame getFrame() {
		return adminFrame;
	}

	public void setFrame(JFrame frame) {
		this.adminFrame = frame;
	}
}
