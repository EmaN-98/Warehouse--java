package bll;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import bll.EmailValidator;
import bll.Validator;
import dao.OrderDetailDAO;
import dao.ProductDAO;
import model.OrderDetail;
import model.Product;


public class OrderDetailBLL {

	public static int insertOrderDetail(OrderDetail orderDetail) {

		return OrderDetailDAO.createOrder(orderDetail.getId_od(),orderDetail.getId_c(), orderDetail.getId_p(), orderDetail.getPieces());
	}

	public static void editProduct(Product product) {

		 OrderDetailDAO.editProduct(product.getId_p(),product.getName(), product.getPrice(), product.getNumber());
	}

	
	
}
