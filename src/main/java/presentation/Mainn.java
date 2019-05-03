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
}
}

