package presentation;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import dao.ClientDAO;
import dao.OrderDetailDAO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;

import bll.OrderDetailBLL;

import javax.swing.JButton;
import model.OrderDetail;

public class OrderDetailView extends JFrame {

	private JFrame frame;
	private JTextField txtIdorderdetail;
	private JTextField txtIdclient;
	private JTextField txtIdproduct;
	private JTextField txtPieces;

	/**
	 * Launch the application.
	 */
	public static void NewScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OrderDetailView window = new OrderDetailView();
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
	public OrderDetailView() {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 450, 300);

		JPanel panel = new JPanel();

		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JLabel lblClient = new JLabel("Order");
		lblClient.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblClient.setBounds(10, 11, 80, 25);
		panel.add(lblClient);

		txtIdorderdetail = new JTextField();
		txtIdorderdetail.setText("id_order");
		txtIdorderdetail.setBounds(10, 50, 90, 20);
		panel.add(txtIdorderdetail);
		txtIdorderdetail.setColumns(10);

		txtIdclient = new JTextField();
		txtIdclient.setText("id_client");
		txtIdclient.setBounds(100, 50, 90, 20);
		panel.add(txtIdclient);
		txtIdclient.setColumns(10);

		txtIdproduct = new JTextField();
		txtIdproduct.setText("id_product");
		txtIdproduct.setBounds(190, 50, 90, 20);
		panel.add(txtIdproduct);
		txtIdproduct.setColumns(10);

		txtPieces = new JTextField();
		txtPieces.setText("pieces");
		txtPieces.setBounds(280, 50, 90, 20);
		panel.add(txtPieces);
		txtPieces.setColumns(10);

		JButton btnInsert = new JButton("Create order");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String txt = txtIdorderdetail.getText();
				String txt2 = txtIdclient.getText();
				String txt3 = txtIdproduct.getText();
				String txt4 = txtPieces.getText();
				int id = Integer.parseInt(txt);
				int id2 = Integer.parseInt(txt2);
				int id3 = Integer.parseInt(txt3);
				int id4 = Integer.parseInt(txt4);
				try {
					OrderDetail o1 = new OrderDetail(id, id2, id3, id4);
					OrderDetailBLL.insertOrderDetail(o1);

				} catch (Exception ex) {
					System.out.println("comanda nu poate fi adaugata");
					JOptionPane.showMessageDialog(null, "Sorry, cannot create order. Check the ID's");

				}

			}
		});
		btnInsert.setBounds(1, 80, 150, 23);
		panel.add(btnInsert);

		JButton btnView = new JButton("Bill");
		btnView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String txt = txtIdorderdetail.getText();
				String txt2 = txtIdclient.getText();
				String txt3 = txtIdproduct.getText();
				String txt4 = txtPieces.getText();
				int id = Integer.parseInt(txt);
				int id2 = Integer.parseInt(txt2);
				int id3 = Integer.parseInt(txt3);
				int id4 = Integer.parseInt(txt4);
				OrderDetail o1 = new OrderDetail(0, 0, 0, 0);
				o1.setId_od(id);
				o1.setId_c(id2);
				o1.setId_p(id3);
				o1.setPieces(id4);
				OrderDetailDAO.createBill(o1);
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
		btnBack.setBounds(1, 200, 90, 23);
		panel.add(btnBack);
	}
}
