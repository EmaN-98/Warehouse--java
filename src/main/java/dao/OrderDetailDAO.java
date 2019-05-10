package dao;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.jdbc.result.ResultSetMetaData;

import connection.ConnectionFactory;
import model.Client;
import model.OrderDetail;
import model.Product;

public class OrderDetailDAO {
	private static Connection conn;
	private final static String createOrder = "INSERT INTO orderdetail (id_od,id_c,id_p,pieces)" + " VALUES (?,?,?,?)";
	private final static String findStatementString = "SELECT * FROM client where id_c = ?";
	private final static String findStatementString1 = "SELECT * FROM product where id_p = ?";
	private final static String editProduct = "UPDATE product SET name=?, price=?,number=? WHERE id_p= ? ";

	public static int createOrder(int id_od, int id_c, int id_p, int quantity) {
		PreparedStatement stmt = null;
		Client c1 = new Client(0, null, null, null);
		c1 = findByIdC(id_c);
		Product p1 = new Product(0, null, 0, 0);
		p1 = findByIdP(id_p);
		if (p1.getNumber() < quantity) {
			System.out.println("stoc epuizat!");
			JOptionPane.showMessageDialog(null, "Stoc epuizat!");
		} else {
			p1.setNumber(p1.getNumber() - quantity);
			editProduct(p1.getId_p(), p1.getName(), p1.getPrice(), p1.getNumber());
			if (c1 != null && p1 != null) {
				try {
					conn = ConnectionFactory.getConnection();
					stmt = conn.prepareStatement(createOrder, Statement.RETURN_GENERATED_KEYS);
					stmt.setInt(1, id_od);
					stmt.setInt(2, id_c);
					stmt.setInt(3, id_p);
					stmt.setInt(4, quantity);
					stmt.executeUpdate();
					ResultSet rs = stmt.executeQuery("SELECT *\r\n" + "FROM orderdetail\r\n");
					JTable table = new JTable(buildTableModel(rs));
					JOptionPane.showMessageDialog(null, new JScrollPane(table));
					ResultSet rs2 = stmt.executeQuery("SELECT *\r\n" + "FROM product\r\n");
					JTable table2 = new JTable(buildTableModel(rs2));
					JOptionPane.showMessageDialog(null, new JScrollPane(table2));
				} catch (SQLException exc) {
					exc.printStackTrace();
					JOptionPane.showMessageDialog(null, "Sorry, cannot create order. Check the ID's or the quantity");
				} finally {
					ConnectionFactory.close(stmt);
					ConnectionFactory.close(conn);
				}
			} else
				System.out.println("nu exista clientul sau produsul");
		}
		return id_od;
	}

	public static void editProduct(int id, String name, float price, int number) {

		PreparedStatement stmt = null;
		ResultSet res;
		try {
			conn = ConnectionFactory.getConnection();
			stmt = conn.prepareStatement(editProduct, Statement.RETURN_GENERATED_KEYS);
			stmt.setInt(4, id);
			stmt.setString(1, name);
			stmt.setFloat(2, price);
			stmt.setInt(3, number);
			stmt.executeUpdate();
			res = stmt.getGeneratedKeys();

		} catch (SQLException exc) {
			exc.printStackTrace();
		} finally {
			ConnectionFactory.close(stmt);
			ConnectionFactory.close(conn);
		}
	}

	public static void createBill(OrderDetail o) {
		Writer writer = null;

		try {
			writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("bill.txt"), "utf-8"));
			writer.write("Bill: ");
			((BufferedWriter) writer).newLine();
			writer.write(o.toString());
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			try {
				writer.close();
			} catch (Exception ex) {
			}
		}

	}

	public static DefaultTableModel buildTableModel(ResultSet rs) throws SQLException {

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

	public static Client findByIdC(int clientId) {
		Client toReturn = null;

		Connection dbConnection = ConnectionFactory.getConnection();
		PreparedStatement findStatement = null;
		ResultSet rs = null;
		try {
			findStatement = dbConnection.prepareStatement(findStatementString);
			findStatement.setInt(1, clientId);
			rs = findStatement.executeQuery();
			rs.next();

			String name = rs.getString("name");
			String address = rs.getString("address");
			String email = rs.getString("email");

			toReturn = new Client(clientId, name, address, email);
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			ConnectionFactory.close(rs);
			ConnectionFactory.close(findStatement);
			ConnectionFactory.close(dbConnection);
		}
		return toReturn;
	}

	public static Product findByIdP(int productId) {
		Product toReturn = null;

		Connection dbConnection = ConnectionFactory.getConnection();
		PreparedStatement findStatement = null;
		ResultSet rs = null;
		try {
			findStatement = dbConnection.prepareStatement(findStatementString1);
			findStatement.setInt(1, productId);
			rs = findStatement.executeQuery();
			rs.next();

			String name = rs.getString("name");
			float price = rs.getFloat("price");
			int number = rs.getInt("number");
			toReturn = new Product(productId, name, price, number);
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			ConnectionFactory.close(rs);
			ConnectionFactory.close(findStatement);
			ConnectionFactory.close(dbConnection);
		}
		return toReturn;
	}

}
