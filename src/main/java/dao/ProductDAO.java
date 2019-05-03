package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import javax.swing.table.DefaultTableModel;

import com.mysql.cj.jdbc.result.ResultSetMetaData;

import connection.ConnectionFactory;

import model.Product;

public class ProductDAO {

	private static Connection conn;
	private final static String insertProduct = "INSERT INTO product (id_p,name,price,number)" + " VALUES (?,?,?,?)";
	private final static String deleteProduct = "DELETE FROM product WHERE id_p = ? ";
	private final static String editProduct = "UPDATE product SET name=?, price=?,number=? WHERE id_p= ? ";
	private final static String findStatementString = "SELECT * FROM product where id_p = ?";

	
	public static int insertProduct(int id, String name, float price, int number) {
		// conn=ConnectionFactory.getInstance();
		PreparedStatement stmt = null;
//		int insertedId = -1;
		ResultSet res;
		try {
			conn = ConnectionFactory.getConnection();
			stmt = conn.prepareStatement(insertProduct, Statement.RETURN_GENERATED_KEYS);
			stmt.setInt(1, id);
			stmt.setString(2, name);
			stmt.setFloat(3, price);
			stmt.setInt(4, number);
			stmt.executeUpdate();
			// stmt.executeQuery();
			res = stmt.getGeneratedKeys();
			
			ResultSet rs = stmt.executeQuery("SELECT *\r\n" + "FROM product\r\n");
			JTable table = new JTable(buildTableModel(rs));
			JOptionPane.showMessageDialog(null, new JScrollPane(table));
			// if (res.next()) {
			// insertedId = res.getInt(1);
			// }
		} catch (SQLException exc) {
			// LOGGER.log(Level.WARNING, "StudentDAO:insert " + e.getMessage());
			exc.printStackTrace();
		} finally {
			ConnectionFactory.close(stmt);
			ConnectionFactory.close(conn);
		}
		// return Integer.parseInt(id);
		return id;
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
	
	public static void deleteProduct(int id) {
		// conn=ConnectionFactory.getInstance();
		PreparedStatement stmt = null;
		ResultSet res;
		try {
			conn = ConnectionFactory.getConnection();
			stmt = conn.prepareStatement(deleteProduct, Statement.RETURN_GENERATED_KEYS);
			stmt.setInt(1, id);
			stmt.executeUpdate();
			res = stmt.getGeneratedKeys();
			
			ResultSet rs = stmt.executeQuery("SELECT *\r\n" + "FROM product\r\n");
			JTable table = new JTable(buildTableModel(rs));
			JOptionPane.showMessageDialog(null, new JScrollPane(table));
			
		} catch (SQLException exc) {
			exc.printStackTrace();
		} finally {
			ConnectionFactory.close(stmt);
			ConnectionFactory.close(conn);
		}
	}


	public static void editProduct(int id,String name, float price, int number) {
		// conn=ConnectionFactory.getInstance();
		PreparedStatement stmt = null;
		ResultSet res;
		try {
			conn = ConnectionFactory.getConnection();
			stmt = conn.prepareStatement(editProduct, Statement.RETURN_GENERATED_KEYS);
			stmt.setInt(4, id);
			stmt.setString(1, name);
			stmt.setFloat(2,price);
			stmt.setInt(3, number);
			stmt.executeUpdate();
			res = stmt.getGeneratedKeys();
			
			ResultSet rs = stmt.executeQuery("SELECT *\r\n" + "FROM product\r\n");
			JTable table = new JTable(buildTableModel(rs));
			JOptionPane.showMessageDialog(null, new JScrollPane(table));
			
		} catch (SQLException exc) {
			exc.printStackTrace();
		} finally {
			ConnectionFactory.close(stmt);
			ConnectionFactory.close(conn);
		}
	}

	public Product findById(int productId) {
		Product toReturn = null;

		Connection dbConnection = ConnectionFactory.getConnection();
		PreparedStatement findStatement = null;
		ResultSet rs = null;
		try {
			findStatement = dbConnection.prepareStatement(findStatementString);
			findStatement.setInt(1, productId);
			rs = findStatement.executeQuery();
			rs.next();

			String name = rs.getString("name");
			float price = rs.getFloat("price");
			int number = rs.getInt("number");
	
			toReturn = new Product(productId, name, price,number);
		} catch (SQLException e) {
			//LOGGER.log(Level.WARNING,"StudentDAO:findById " + e.getMessage());
			e.printStackTrace();
		} finally {
			ConnectionFactory.close(rs);
			ConnectionFactory.close(findStatement);
			ConnectionFactory.close(dbConnection);
		}
		return toReturn;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// ClientDAO c1=new ClientDAO();
		// c1.insertClient("5","b","addr","eml");
	//	Client c = new Client(6, "dummy name", "dummy address", "dummy@address.co");

	
		// int id = insertProduct(11,"dummy name", 55, 5);
//System.out.println(id);
	//	deleteProduct(10);
		editProduct(11,"editeeed",55,4);
	//	Client cl=new Client(0, null, null, null);
	//	cl=findById(2);
	//	System.out.println(cl);
	}

}
