import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;

public class Main {
	static ArrayList<JPanel> panelList = new ArrayList<>();
	public static void createItemPanel(ArrayList<JPanel> arr, Color c) {
		JPanel a = new JPanel();
		a.setBackground(c);
		arr.add(a);
	}
	public static void main(String[] args) {
		
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		
		JPanel panel = new JPanel();
		JLabel l = new JLabel();
		panel.setSize(600 , 600);
		panel.setLayout(new GridLayout(0 , 1));
		panel.setBackground(Color.red);
		panel.setPreferredSize(new Dimension(1000,1000));

		createItemPanel(panelList,Color.cyan);
		createItemPanel(panelList,Color.black);
		createItemPanel(panelList,Color.cyan);
		createItemPanel(panelList,Color.black);
		createItemPanel(panelList,Color.cyan);
		createItemPanel(panelList,Color.black);
		createItemPanel(panelList,Color.cyan);
		createItemPanel(panelList,Color.black);
		createItemPanel(panelList,Color.cyan);
		createItemPanel(panelList,Color.black);
		createItemPanel(panelList,Color.cyan);
		createItemPanel(panelList,Color.black);
		createItemPanel(panelList,Color.cyan);
		createItemPanel(panelList,Color.GREEN);
		createItemPanel(panelList,Color.cyan);
		createItemPanel(panelList,Color.black);
		createItemPanel(panelList,Color.cyan);
		createItemPanel(panelList,Color.GREEN);
		createItemPanel(panelList,Color.cyan);
		createItemPanel(panelList,Color.black);
		createItemPanel(panelList,Color.cyan);
		createItemPanel(panelList,Color.GREEN);
		createItemPanel(panelList,Color.cyan);
		createItemPanel(panelList,Color.black);
		createItemPanel(panelList,Color.cyan);
		createItemPanel(panelList,Color.GREEN);
		
		for (int i = 0; i < panelList.size(); i++) {
			panel.add(panelList.get(i));
		}
		JScrollPane scroll = new JScrollPane(panel);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		frame.getContentPane().add(scroll, BorderLayout.CENTER);



	
		
		frame.setSize(600,600);
		frame.setVisible(true);

	}

}
