package jp.co.sss.spring_test.controller;

import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import jp.co.sss.spring_test.entity.Carts;
import jp.co.sss.spring_test.entity.Users;
import jp.co.sss.spring_test.form.CartsForm;
import jp.co.sss.spring_test.form.OrdersForm;
import jp.co.sss.spring_test.form.UsersForm;
import jp.co.sss.spring_test.repository.CartsRepository;
import jp.co.sss.spring_test.repository.UsersRepository;

@Controller
public class Order_checkController {
	
	 @Autowired
	 private CartsRepository cartsRepository;

	 @Autowired
	 private UsersRepository usersRepository;
	 

	
	@GetMapping("/ordr_check")
	public String orderCheck() {
		return "order_check";
	}
	 
	@PostMapping("/order_check")
	public String confirmPurchase(
			@Valid
			@ModelAttribute("OrdersForm") OrdersForm ordersform,
			BindingResult result,
	        Model model,
	        HttpSession session) {
		if(result.hasErrors()) {
			model.addAttribute("error", "入力した値は正しくありません");
			return "order_index";
		}
		
	    model.addAttribute("ordersForm", ordersform);
	    session.setAttribute("ordersForm", ordersform);

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

	    UsersForm users = (UsersForm) session.getAttribute("user");
	    if (users != null) {
	  	  System.out.println("headeruser");
	  	  model.addAttribute("user", users);
	    }
	    return "order_check";
	}


}	






