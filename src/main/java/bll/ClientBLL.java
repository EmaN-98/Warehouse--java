package bll;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import bll.EmailValidator;
import bll.Validator;
import dao.ClientDAO;
import model.Client;

public class ClientBLL {

	private static List<Validator<Client>> validators;

	public ClientBLL() {
		validators = new ArrayList<Validator<Client>>();
		validators.add(new EmailValidator());
	}

	public static Client findClientById(int id) {
		Client cl = ClientDAO.findById(id);
		if (cl == null) {
			throw new NoSuchElementException("The client with id =" + id + " was not found!");
		}
		return cl;
	}

	public static int insertClient(Client client) {

		return ClientDAO.insertClient(client.getId(), client.getName(), client.getAddress(), client.getEmail());
	}

	public static void editClient(Client client) {

		 ClientDAO.editClient(client.getId(), client.getName(), client.getAddress(), client.getEmail());
	}

	public static void deleteClient(int id) {

		ClientDAO.deleteClient(id);
	}

	
}
