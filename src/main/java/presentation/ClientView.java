package presentation;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import model.Client;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;

import bll.ClientBLL;

import javax.swing.JButton;

public class ClientView extends JFrame {

	private JFrame frame;
	private JTextField txtIdclient;
	private JTextField txtName;
	private JTextField txtAddress;
	private JTextField txtEmail;

	/**
	 * Launch the application.
	 */
	public static void NewScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientView window= new ClientView();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ClientView() {
		frame=new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 450, 300);
		
		JPanel panel = new JPanel();

		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		
		JLabel lblClient = new JLabel("Client");
		lblClient.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblClient.setBounds(10, 11, 80, 25);
		panel.add(lblClient);
		
		txtIdclient = new JTextField();
		txtIdclient.setText("id_client");
		txtIdclient.setBounds(10, 50, 86, 20);
		panel.add(txtIdclient);
		txtIdclient.setColumns(10);
		
		txtName = new JTextField();
		txtName.setText("name");
		txtName.setBounds(100, 50, 86, 20);
		panel.add(txtName);
		txtName.setColumns(10);
		
		txtAddress = new JTextField();
		txtAddress.setText("address");
		txtAddress.setBounds(190, 50, 86, 20);
		panel.add(txtAddress);
		txtAddress.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setText("email");
		txtEmail.setBounds(280, 50, 86, 20);
		panel.add(txtEmail);
		txtEmail.setColumns(10);
		
		JButton btnInsert = new JButton("Insert");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String txt = txtIdclient.getText();
				String txt2 = txtName.getText();
				String txt3 = txtAddress.getText();
				String txt4 = txtEmail.getText();
				int id=Integer.parseInt(txt);
				try {
					Client c1=new Client(id,txt2,txt3,txt4);
					ClientBLL.insertClient(c1);
				}
				catch(Exception ex) {
				}
			}
		});
		btnInsert.setBounds(1, 80, 90, 23);
		panel.add(btnInsert);
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String txt = txtIdclient.getText();
				String txt2 = txtName.getText();
				String txt3 = txtAddress.getText();
				String txt4 = txtEmail.getText();
				int id=Integer.parseInt(txt);
				try {
					Client c1=new Client(id,txt2,txt3,txt4);
					ClientBLL.editClient(c1);
				}
				catch(Exception ex) {
					System.out.println("clientul nu poate fi editat");
				}
			}
		});
		btnEdit.setBounds(1, 110, 90, 23);
		panel.add(btnEdit);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String txt = txtIdclient.getText();
				int id=Integer.parseInt(txt);
				try {
				ClientBLL.deleteClient(id);
				}
				catch(Exception ex) {
					System.out.println("clientul nu poate fi sters");
				}
			}
		});
		btnDelete.setBounds(1, 140, 90, 23);
		panel.add(btnDelete);
		
		JButton btnView = new JButton("View");
		btnView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClientBLL.deleteClient(0);
			}
		});
		btnView.setBounds(1, 170, 90, 23);
		panel.add(btnView);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
			}
		});
		btnBack.setBounds(1, 200, 89, 23);
		panel.add(btnBack);
	}
}
