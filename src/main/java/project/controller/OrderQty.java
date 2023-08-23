package project.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import project.dto.CartSession;
import project.dto.OrderItem;

/**
 * Servlet implementation class OrderQty
 */
@WebServlet("/OrderQty")
public class OrderQty extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			String action = request.getParameter("action");
			int id = Integer.parseInt(request.getParameter("productId"));
			CartSession cart = (CartSession) request.getSession().getAttribute("cart");
			
			if(action !=null && id>=1) {
				if(action.equals("inc")) {
					for(OrderItem orderItem : cart.getOrderItems()) {
						if(orderItem.getProduct().getId() == id) {
							orderItem.setQuantity(orderItem.getQuantity() + 1);
							cart.setTotalPrice(cart.getTotalPrice() + orderItem.getProduct().getPrice());
							response.sendRedirect("cart.jsp");
						}
					}
				} else {
					for(OrderItem orderItem : cart.getOrderItems()) {
						if(orderItem.getProduct().getId() == id) {
							orderItem.setQuantity(orderItem.getQuantity() - 1);
							cart.setTotalPrice(cart.getTotalPrice() - orderItem.getProduct().getPrice());
							response.sendRedirect("cart.jsp");
						}
					}
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		
}
