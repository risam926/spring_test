package jp.co.sss.spring_test.controller;


import java.util.List;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jp.co.sss.spring_test.entity.Products;
import jp.co.sss.spring_test.repository.ProductsRepository;

@Controller
public class IndexController {
	
	  @Autowired
	    private ProductsRepository productsRepository;
	// 曖昧検索
	  @GetMapping("/search")
	  public String searchItems(@RequestParam("productName") String productName,
              @RequestParam("category") Integer categoryId,
              HttpSession session,
              Model model) {
	      List<Products> products = productsRepository
	          .findByProductNameAndCategoryId(productName,categoryId); 
	      session.setAttribute("productName", productName); 
	      session.setAttribute("categoryId", categoryId); 
	      model.addAttribute("products", products);
	      return "redirect:product_list/search"; 
	  }


	  
	  @PostMapping("/logout")
	  public String logout(HttpSession session) {
	      session.invalidate(); 
	      return "redirect:/login"; 
	  }
	
	  @GetMapping("/footer")
	    public String showFooter() {
	        return "common/footer"; 
	    }
}