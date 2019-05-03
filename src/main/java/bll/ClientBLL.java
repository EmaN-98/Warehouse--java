package bll;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import bll.EmailValidator;
import bll.Validator;
import dao.ClientDAO;
import model.Client;

/**
 * @Author: Technical University of Cluj-Napoca, Romania Distributed Systems
 *          Research Laboratory, http://dsrl.coned.utcluj.ro/
 * @Since: Apr 03, 2017
 */
public class ClientBLL {

	private static List<Validator<Client>> validators;

	public ClientBLL() {
		validators = new ArrayList<Validator<Client>>();
		validators.add(new EmailValidator());
		// validators.add(new StudentAgeValidator());
	}

	public static Client findClientById(int id) {
	//	ClientDAO dao=new ClientDAO();
		Client cl = ClientDAO.findById(id);
		if (cl == null) {
			throw new NoSuchElementException("The client with id =" + id + " was not found!");
		}
		return cl;
	}

	public static int insertClient(Client client) {
		// for (Validator<Client> v : validators) {
		// v.validate(client);
		// }
		return ClientDAO.insertClient(client.getId(), client.getName(), client.getAddress(), client.getEmail());
	}

	public static void deleteClient(int id) {

		ClientDAO.deleteClient(id);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Client c = new Client(10, "Aname", "Aaddress", "Adummy@address.co");
		Client cl = new Client(0, null, null, null);
		// int id = insertClient(c);
		// System.out.println(id);
		cl = findClientById(3);
		// System.out.println(id);
		System.out.println(cl);
		deleteClient(10);
	}

}
