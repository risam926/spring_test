package jp.co.sss.spring_test.controller;

import java.util.List;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import jp.co.sss.spring_test.entity.Carts;
import jp.co.sss.spring_test.form.CartsForm;
import jp.co.sss.spring_test.form.OrdersForm;
import jp.co.sss.spring_test.form.UsersForm;
import jp.co.sss.spring_test.repository.CartsRepository;
import jp.co.sss.spring_test.repository.ProductsRepository;
import jp.co.sss.spring_test.repository.UsersRepository;

@Controller
public class Order_indexController {
	 @Autowired
	 private CartsRepository cartsRepository;

	 @Autowired
	 private UsersRepository usersRepository;
	 
	 @Autowired
	 private ProductsRepository productsRepository;

	
	@GetMapping("/order_index")
    public String showOrder_index(@ModelAttribute OrdersForm form,HttpSession session,Model model) {
		model.addAttribute("OrdersForm", new OrdersForm());
		 UsersForm user = (UsersForm) session.getAttribute("user");
		    if (user != null) {
		  	  model.addAttribute("user", user);
		    }
        return "order_index";
    }
	
	@PostMapping("/order_index")
	public String toOrderIndex(
    		@ModelAttribute OrdersForm form,
    		Model model) {

	    model.addAttribute("OrdersForm", new OrdersForm());
	    return "order_index";
	}

	@PostMapping("/buy_now")
	public String buyNow(
			@ModelAttribute CartsForm cartForm,
	        HttpSession session) {

		Integer userId = (Integer) session.getAttribute("userId");
	    
	    List<Carts> existingCartList = cartsRepository.findByUserIdAndProductId(userId, cartForm.getProductId());
	    
	    Carts cart = new Carts();
	    
	    if (!existingCartList.isEmpty()) {
	                cart = existingCartList.get(0);
	        cart.setQuantity(cart.getQuantity() + cartForm.getQuantity());
	    } else {
	        
	        cart = new Carts();
	        cart.setUserId(userId);
	        cart.setProductId(cartForm.getProductId());
	        cart.setQuantity(cartForm.getQuantity());
	    }    

	    cart.setUserId(userId);

	    cartsRepository.save(cart);

	    return "redirect:/order_index";
	}



   
}

