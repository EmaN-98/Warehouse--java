package start;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import bll.ClientBLL;
import model.Client;


/**
 * @Author: Technical University of Cluj-Napoca, Romania Distributed Systems
 *          Research Laboratory, http://dsrl.coned.utcluj.ro/
 * @Since: Apr 03, 2017
 */
public class Start {
	protected static final Logger LOGGER = Logger.getLogger(Start.class.getName());

	public static void main(String[] args) throws SQLException {

		Client client = new Client(22,"dummy name", "dummy address", "dummy@address.co");

		ClientBLL clientBll = new ClientBLL();
		int id = clientBll.insertClient(client);
		if (id > 0) {
			clientBll.findClientById(id);
		}
		
		
		// Generate error
		try {
			clientBll.findClientById(1);
		} catch (Exception ex) {
			LOGGER.log(Level.INFO, ex.getMessage());
		}
		
		
		//obtain field-value pairs for object through reflection
		ReflectionExample.retrieveProperties(client);
	}
	
	

}