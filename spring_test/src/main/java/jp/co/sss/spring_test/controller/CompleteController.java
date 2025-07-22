package jp.co.sss.spring_test.controller;

import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jp.co.sss.spring_test.entity.Carts;
import jp.co.sss.spring_test.entity.Users;
import jp.co.sss.spring_test.form.CartsForm;
import jp.co.sss.spring_test.form.OrdersForm;
import jp.co.sss.spring_test.form.UsersForm;
import jp.co.sss.spring_test.repository.CartsRepository;
import jp.co.sss.spring_test.repository.Order_itemsRepository;
import jp.co.sss.spring_test.repository.OrdersRepository;
import jp.co.sss.spring_test.repository.UsersRepository;

@Controller
public class CompleteController {
	@Autowired
	 private Order_itemsRepository order_itemsRepository;
	@Autowired
	 private OrdersRepository ordersRepository;

	 @Autowired
	 private CartsRepository cartsRepository;

	 @Autowired
	 private UsersRepository usersRepository;
	 
	 
	 @GetMapping("/complete")
	    public String showComplete(Model model,HttpSession session) {
			
			Integer userId = (Integer) session.getAttribute("userId");
	        if (userId == null) {
	            return "redirect:/login";
	        }

	        Users user = usersRepository.findById(userId).orElse(null);
	        List<Carts> cart_index = cartsRepository.findByUsers(user);
	        
	        List<CartsForm> cartFormList = new ArrayList<>();
	        int totalWithTax = 0;
	        

	        for (Carts cart : cart_index) {
	            CartsForm form = new CartsForm();
	            form.setCartId(cart.getCartId()); 
	            form.setProductId(cart.getProducts().getProductId());
	            form.setProductName(cart.getProducts().getProductName());
	            form.setImgPath(cart.getProducts().getImgPath());
	            form.setPrice(cart.getProducts().getPrice());
	            form.setQuantity(cart.getQuantity());
	            
	            cartFormList.add(form);
	            
	            int quantity = cart.getQuantity();
	            int taxPrice = cart.getProducts().getTaxPrice();
	            
	            totalWithTax += taxPrice * quantity;
	           
	        }
	        model.addAttribute("cart_index", cartFormList);
	        model.addAttribute("totalWithTax", totalWithTax);
	        
	        OrdersForm sessionOrdersForm = (OrdersForm) session.getAttribute("ordersForm"); 
	        OrdersForm ordersForm = new OrdersForm();
	        ordersForm.setName(sessionOrdersForm.getName());
	        ordersForm.setAddress(sessionOrdersForm.getAddress());
	        ordersForm.setApartment(sessionOrdersForm.getApartment());
	        ordersForm.setCardNumber(sessionOrdersForm.getCardNumber());
	        ordersForm.setExpiryDate(sessionOrdersForm.getExpiryDate());
	        
	        
		    model.addAttribute("ordersForm", ordersForm);
		
		    
		    cartsRepository.deleteAll();
		    
		    UsersForm users = (UsersForm) session.getAttribute("user");
		    if (users != null) {
		  	  model.addAttribute("user", users);
		    }
			
	        return "complete";
		}
		


		


}