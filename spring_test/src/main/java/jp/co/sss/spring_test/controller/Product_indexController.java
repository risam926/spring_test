package jp.co.sss.spring_test.controller;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import jp.co.sss.spring_test.entity.Products;
import jp.co.sss.spring_test.form.CartsForm;
import jp.co.sss.spring_test.form.UsersForm;
import jp.co.sss.spring_test.repository.CartsRepository;
import jp.co.sss.spring_test.repository.ProductsRepository;
import jp.co.sss.spring_test.repository.ReviewsRepository;

@Controller

public class Product_indexController {
	@Autowired private ProductsRepository productsRepository; 
	@Autowired private ReviewsRepository reviewsRepository; 
	@Autowired private CartsRepository cartsRepository;
	
	
	 @GetMapping("/product_index/{productId}") public String dashboard(@PathVariable Integer productId,
			 HttpSession session,
			 Model model) { 
		 Products product = productsRepository.findById(productId).orElse(null);
		    if (product == null) {
		        return "redirect:/error";
		    }
		 CartsForm cartForm = new CartsForm();
		 cartForm.setProductId(product.getProductId());
		 cartForm.setQuantity(1);
		 model.addAttribute("product", productsRepository.findById(productId).orElse(null));
		 model.addAttribute("carts", cartsRepository.findAll());
		 model.addAttribute("reviews", reviewsRepository.findByProductId(productId));
		 model.addAttribute("cartsForm", cartForm);
		 
		 UsersForm user = (UsersForm) session.getAttribute("user");
		    if (user != null) {
		  	  model.addAttribute("user", user);
		    }
		
		 return "product_index"; 
}
}
