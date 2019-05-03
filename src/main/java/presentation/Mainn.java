package presentation;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JTextPane;
import javax.swing.DropMode;

public class Mainn {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mainn window = new Mainn();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Mainn() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 230, 195));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 0, 260);
		panel.setBackground(new Color(255, 230, 180));
		frame.getContentPane().add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblSubiectul = new JLabel("Assignment 3");
		lblSubiectul.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblSubiectul.setForeground(new Color(140, 0, 0));
		lblSubiectul.setBackground(new Color(255, 160, 120));
		lblSubiectul.setHorizontalAlignment(SwingConstants.CENTER);
		lblSubiectul.setBounds(131, 11, 136, 28);
		frame.getContentPane().add(lblSubiectul);
		
		JButton btnNewButton = new JButton("Client");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClientView nw=new ClientView();
				nw.NewScreen();			}
		});
		btnNewButton.setForeground(new Color(220, 20, 60));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		btnNewButton.setBounds(32, 58, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Product");
//		btnNewButton_1.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				Ex3b3 nw=new Ex3b3();
//				nw.NewScreen();
//			}
//		});
		btnNewButton_1.setForeground(new Color(220, 20, 60));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		btnNewButton_1.setBounds(32, 106, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
/*		
		JButton btnNewButton_2 = new JButton("Ex.4a");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ex4a2 nw=new Ex4a2();
				nw.NewScreen();
			}
		});
		btnNewButton_2.setForeground(new Color(220, 20, 60));
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		btnNewButton_2.setBounds(32, 154, 89, 23);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Ex.4b");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ex4b nw=new Ex4b();
				nw.NewScreen();
			}
		});
		btnNewButton_3.setForeground(new Color(220, 20, 60));
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		btnNewButton_3.setBounds(32, 205, 89, 23);
		frame.getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Ex.5a");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ex5a nw=new Ex5a();
				nw.NewScreen();
			}
		});
		btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		btnNewButton_4.setForeground(new Color(220, 20, 60));
		btnNewButton_4.setBounds(304, 58, 89, 23);
		frame.getContentPane().add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Ex.5b");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ex5b nw=new Ex5b();
				nw.NewScreen();
			}
		});
		btnNewButton_5.setForeground(new Color(220, 20, 60));
		btnNewButton_5.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		btnNewButton_5.setBounds(304, 106, 89, 23);
		frame.getContentPane().add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("Ex.6a");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ex6a nw=new Ex6a();
				nw.NewScreen();
			}
		});
		btnNewButton_6.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		btnNewButton_6.setForeground(new Color(220, 20, 60));
		btnNewButton_6.setBounds(304, 154, 89, 23);
		frame.getContentPane().add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("Ex.6b");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ex6b nw=new Ex6b();
				nw.NewScreen();
			}
		});
		btnNewButton_7.setForeground(new Color(220, 20, 60));
		btnNewButton_7.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		btnNewButton_7.setBounds(304, 205, 89, 23);
		frame.getContentPane().add(btnNewButton_7);
		
		JTextPane txtpnBazeDeDate = new JTextPane();
		txtpnBazeDeDate.setBackground(new Color(255, 228, 196));
		txtpnBazeDeDate.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		txtpnBazeDeDate.setForeground(new Color(199, 21, 133));
		txtpnBazeDeDate.setText("B\r\n a\r\nz\r\n e\r\n\r\nde\r\n\r\nd\r\n a\r\nt\r\n e");
		txtpnBazeDeDate.setBounds(204, 58, 52, 188);
		frame.getContentPane().add(txtpnBazeDeDate);
*/	}
}

