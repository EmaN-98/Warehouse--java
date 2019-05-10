package presentation;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import dao.ClientDAO;
import dao.ProductDAO;
import model.Product;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;

import bll.ProductBLL;

import javax.swing.JButton;

public class ProductView extends JFrame {

	private JFrame frame;
	private JTextField txtIdproduct;
	private JTextField txtName;
	private JTextField txtPrice;
	private JTextField txtNumber;
	//int id_p;
	//private String name;
	//private float price;
	//private int number;
	
	/**
	 * Launch the application.
	 */
	public static void NewScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProductView window= new ProductView();
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
	public ProductView() {
		frame=new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 450, 300);
		
		JPanel panel = new JPanel();

		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		
		JLabel lblClient = new JLabel("Product");
		lblClient.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblClient.setBounds(10, 11, 80, 25);
		panel.add(lblClient);
		
		txtIdproduct = new JTextField();
		txtIdproduct.setText("id_product");
		txtIdproduct.setBounds(10, 50, 86, 20);
		panel.add(txtIdproduct);
		txtIdproduct.setColumns(10);
		
		txtName = new JTextField();
		txtName.setText("name");
		txtName.setBounds(100, 50, 86, 20);
		panel.add(txtName);
		txtName.setColumns(10);
		
		txtPrice = new JTextField();
		txtPrice.setText("price");
		txtPrice.setBounds(190, 50, 86, 20);
		panel.add(txtPrice);
		txtPrice.setColumns(10);
		
		txtNumber = new JTextField();
		txtNumber.setText("number");
		txtNumber.setBounds(280, 50, 86, 20);
		panel.add(txtNumber);
		txtNumber.setColumns(10);
		
		JButton btnInsert = new JButton("Insert");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String txt = txtIdproduct.getText();
				String txt2 = txtName.getText();
				String txt3 = txtPrice.getText();
				String txt4 = txtNumber.getText();
				int id=Integer.parseInt(txt);
				float price=Float.parseFloat(txt3);
				int number=Integer.parseInt(txt4);
				try {
				Product p1=new Product(id,txt2,price,number);
				ProductBLL.insertProduct(p1);
				}
				catch(Exception ex) {
					System.out.println("produsul nu poate fi adaugat");
				}
			}
		});
		btnInsert.setBounds(1, 80, 90, 23);
		panel.add(btnInsert);
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String txt = txtIdproduct.getText();
				String txt2 = txtName.getText();
				String txt3 = txtPrice.getText();
				String txt4 = txtNumber.getText();
				int id=Integer.parseInt(txt);
				float price=Float.parseFloat(txt3);
				int number=Integer.parseInt(txt4);
				try {
					Product p1=new Product(id,txt2,price,number);
					ProductBLL.editProduct(p1);
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
				String txt = txtIdproduct.getText();
				int id=Integer.parseInt(txt);
				try {
				//ProductDAO p1=new ProductDAO();
				ProductBLL.deleteProduct(id);
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
				//ProductDAO p1=new ProductDAO();
				ProductBLL.deleteProduct(0);
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
