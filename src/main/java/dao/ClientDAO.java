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
import model.Client;

public class ClientDAO {

	private static Connection conn;
	private final static String insertClient = "INSERT INTO client (id_c,name,address,email)" + " VALUES (?,?,?,?)";
	private final static String deleteClient = "DELETE FROM client WHERE id_c = ? ";
	private final static String editClient = "UPDATE client SET name=?, address=?, email=? WHERE id_c= ? ";
	private final static String findStatementString = "SELECT * FROM client where id_c = ?";

	
	public static int insertClient(int id, String name, String address, String email) {
		// conn=ConnectionFactory.getInstance();
		PreparedStatement stmt = null;
//		int insertedId = -1;
		ResultSet res;
		try {
			conn = ConnectionFactory.getConnection();
			stmt = conn.prepareStatement(insertClient, Statement.RETURN_GENERATED_KEYS);
			stmt.setLong(1, id);
			stmt.setString(2, name);
			stmt.setString(3, address);
			stmt.setString(4, email);
			stmt.executeUpdate();
			// stmt.executeQuery();
			res = stmt.getGeneratedKeys();
			
			ResultSet rs = stmt.executeQuery("SELECT *\r\n" + "FROM client\r\n");
			JTable table = new JTable(buildTableModel(rs));
			JOptionPane.showMessageDialog(null, new JScrollPane(table));
			
			// if (res.next()) {
			// insertedId = res.getInt(1);
			// }
		} catch (SQLException exc) {
			// LOGGER.log(Level.WARNING, "StudentDAO:insert " + e.getMessage());
			exc.printStackTrace();
			System.out.println("clientul cu acest id exista deja");
		} finally {
			ConnectionFactory.close(stmt);
			ConnectionFactory.close(conn);
		}
		// return Integer.parseInt(id);
		return id;
	}

	public static void deleteClient(int id) {
		// conn=ConnectionFactory.getInstance();
		PreparedStatement stmt = null;
		ResultSet res;
		try {
			conn = ConnectionFactory.getConnection();
			stmt = conn.prepareStatement(deleteClient, Statement.RETURN_GENERATED_KEYS);
			stmt.setLong(1, id);
			stmt.executeUpdate();
			res = stmt.getGeneratedKeys();
			
			ResultSet rs = stmt.executeQuery("SELECT *\r\n" + "FROM client\r\n");
			JTable table = new JTable(buildTableModel(rs));
			JOptionPane.showMessageDialog(null, new JScrollPane(table));
			
		} catch (SQLException exc) {
			exc.printStackTrace();
		} finally {
			ConnectionFactory.close(stmt);
			ConnectionFactory.close(conn);
		}
	}


	public static void editClient(int id,String name, String address, String email) {
		// conn=ConnectionFactory.getInstance();
		PreparedStatement stmt = null;
		ResultSet res;
		try {
			conn = ConnectionFactory.getConnection();
			stmt = conn.prepareStatement(editClient, Statement.RETURN_GENERATED_KEYS);
			stmt.setLong(4, id);
			stmt.setString(1, name);
			stmt.setString(2, address);
			stmt.setString(3, email);
			stmt.executeUpdate();
			res = stmt.getGeneratedKeys();
			
			ResultSet rs = stmt.executeQuery("SELECT *\r\n" + "FROM client\r\n");
			JTable table = new JTable(buildTableModel(rs));
			JOptionPane.showMessageDialog(null, new JScrollPane(table));
			
		} catch (SQLException exc) {
			exc.printStackTrace();
		} finally {
			ConnectionFactory.close(stmt);
			ConnectionFactory.close(conn);
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
	
	public static Client findById(int clientId) {
		Client toReturn = null;

		Connection dbConnection = ConnectionFactory.getConnection();
		PreparedStatement findStatement = null;
		ResultSet rs = null;
		try {
			findStatement = dbConnection.prepareStatement(findStatementString);
			findStatement.setLong(1, clientId);
			rs = findStatement.executeQuery();
			rs.next();

			String name = rs.getString("name");
			String address = rs.getString("address");
			String email = rs.getString("email");
	
			toReturn = new Client(clientId, name, address, email);
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

	
	// int id = insertClient(38,"dummy name", "dummy address", "dummy@address.co");
//System.out.println(id);
	//	deleteClient(18);
		editClient(1,"editedd","addresss","emailll");
	//	Client cl=new Client(0, null, null, null);
	//	cl=findById(2);
	//	System.out.println(cl);
	}

}
