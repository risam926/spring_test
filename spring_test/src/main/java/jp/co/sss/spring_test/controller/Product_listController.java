package jp.co.sss.spring_test.controller;

import java.util.List;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jp.co.sss.spring_test.entity.Products;
import jp.co.sss.spring_test.form.UsersForm;
import jp.co.sss.spring_test.repository.ProductsRepository;

@Controller
public class Product_listController {
	@Autowired private ProductsRepository productsRepository;  
	
	@GetMapping("/product_list")
	public String showProducts(HttpSession session,Model model) {
	    List<Products> product_list = productsRepository.findAll();
	    model.addAttribute("product_list", product_list);
	    
	    UsersForm user = (UsersForm) session.getAttribute("user");
	    if (user != null) {
	  	  model.addAttribute("user", user);
	    }
	    return "product_list";
}

	@GetMapping("/product_list/search")
	public String searchProducts(  HttpSession session,
			Model model) {
		Integer categoryId = (Integer) session.getAttribute("categoryId");
		String productName = (String) session.getAttribute("productName");
		if(productName == "") {
			List<Products> product_list = productsRepository.findByCategoryId(categoryId);
			model.addAttribute("product_list", product_list);
		}else {
			List<Products> product_list = productsRepository.findByProductNameAndCategoryId(productName,categoryId);
			model.addAttribute("product_list", product_list);
		}
	   
	    UsersForm user = (UsersForm) session.getAttribute("user");
	    if (user != null) {
		  	  model.addAttribute("user", user);
		    }
		return "product_list";
}
}