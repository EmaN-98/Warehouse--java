package presentation;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.jdbc.result.ResultSetMetaData;

import java.awt.Font;
import java.awt.Label;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.awt.event.ActionEvent;

public class ClientView {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void NewScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientView window = new ClientView();
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
	public ClientView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		JTextField tf = new JTextField(2);
		JTextField tf1 = new JTextField(2);
		JTextField tf2 = new JTextField(2);
		JTextField tf3 = new JTextField(2);
		Label label = new Label("id_c:");

		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 248, 220));
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Client");
		lblNewLabel.setForeground(new Color(220, 20, 60));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel.setBounds(30, 11, 53, 27);
		panel.add(lblNewLabel);

		JTextArea textArea = new JTextArea();
		textArea.setBounds(412, 116, -378, 101);
		panel.add(textArea);

		JTextArea txtrAsistenJuridicDin = new JTextArea();
		txtrAsistenJuridicDin.setBackground(new Color(255, 228, 196));
		txtrAsistenJuridicDin.setForeground(new Color(220, 20, 60));
		txtrAsistenJuridicDin.setFont(new Font("Verdana", Font.ITALIC, 13));
		txtrAsistenJuridicDin.setRows(5);
		txtrAsistenJuridicDin.setText("Se pot adauga, sterge, edita si vizualiza clientii");
		txtrAsistenJuridicDin.setBounds(30, 49, 368, 77);
		panel.add(txtrAsistenJuridicDin);


		label.setForeground(new Color(220, 20, 60));
		label.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		label.setBounds(30, 11, 53, 27);
		panel.add(label);
		label.setAlignment(Label.LEFT);
		panel.add(tf);
//		panel.add(tf1);
//		panel.add(tf2);
//		panel.add(tf3);
		
		JButton btnBack = new JButton("Revenire");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Mainn nw=new Mainn();
				// nw.Mmain();
				frame.setVisible(false);
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		btnBack.setForeground(new Color(220, 20, 60));
		btnBack.setBounds(30, 194, 107, 23);
		panel.add(btnBack);

		
		JButton btnNewButton = new JButton("Insert");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				
			}

			public /* static */ DefaultTableModel buildTableModel(ResultSet rs) throws SQLException {

				ResultSetMetaData metaData = (ResultSetMetaData) rs.getMetaData();

				// names of columns
				Vector<String> columnNames = new Vector<String>();
				int columnCount = metaData.getColumnCount();
				for (int column = 1; column <= columnCount; column++) {
					columnNames.add(metaData.getColumnName(column));
				}

				// data of the table
				Vector<Vector<Object>> data = new Vector<Vector<Object>>();
				while (rs.next()) {
					Vector<Object> vector = new Vector<Object>();
					for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
						vector.add(rs.getObject(columnIndex));
					}
					data.add(vector);
				}

				return new DefaultTableModel(data, columnNames);

			}
		});
		btnNewButton.setForeground(new Color(46, 139, 87));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		btnNewButton.setBounds(322, 138, 89, 23);
		panel.add(btnNewButton);
	}
}
