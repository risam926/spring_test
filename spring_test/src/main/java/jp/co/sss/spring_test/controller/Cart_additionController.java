package jp.co.sss.spring_test.controller;

import java.util.List;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import jp.co.sss.spring_test.entity.Carts;
import jp.co.sss.spring_test.entity.Products;
import jp.co.sss.spring_test.form.CartsForm;
import jp.co.sss.spring_test.form.UsersForm;
import jp.co.sss.spring_test.repository.CartsRepository;
import jp.co.sss.spring_test.repository.ProductsRepository;

@Controller

public class Cart_additionController {

@Autowired
private ProductsRepository productsRepository;

@Autowired
private CartsRepository cartsRepository;

@GetMapping("/cart_addition/{productId}")
public String showCartAdd(@PathVariable Integer productId,
		HttpSession session,
		Model model) {
	  Products product = productsRepository.findById(productId).orElse(null);
	    if (product == null) {
	        return "redirect:/error";
	    }

    CartsForm cartForm = new CartsForm();
    cartForm.setProductId(product.getProductId());
    cartForm.setProductName(product.getProductName());
    cartForm.setImgPath(product.getImgPath());
    cartForm.setPrice(product.getPrice());
    cartForm.setQuantity(1); 
    
    model.addAttribute("cartsForm", cartForm);
    
    UsersForm user = (UsersForm) session.getAttribute("user");
    if (user != null) {
  	  model.addAttribute("user", user);
    }
    return "cart_addition";
  
}

@PostMapping("/cart_addition")
public String addToCart(@ModelAttribute CartsForm cartForm,HttpSession session) {

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
    
   

    return "redirect:/cart_addition/"+ cartForm.getProductId();
}



}
