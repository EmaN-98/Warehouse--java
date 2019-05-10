package bll;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import bll.EmailValidator;
import bll.Validator;
import dao.ProductDAO;
import model.Product;


public class ProductBLL {

	public static Product findProductById(int id) {
		Product cl = ProductDAO.findById(id);
		if (cl == null) {
			throw new NoSuchElementException("The product with id =" + id + " was not found!");
		}
		return cl;
	}

	public static int insertProduct(Product product) {

		return ProductDAO.insertProduct(product.getId_p(),product.getName(), product.getPrice(), product.getNumber());
	}

	public static void editProduct(Product product) {

		 ProductDAO.editProduct(product.getId_p(),product.getName(), product.getPrice(), product.getNumber());
	}

	public static void deleteProduct(int id) {

		ProductDAO.deleteProduct(id);
	}

	
}
