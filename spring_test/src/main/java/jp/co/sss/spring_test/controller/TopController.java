package jp.co.sss.spring_test.controller;
 
import java.util.List;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jp.co.sss.spring_test.entity.Sales_items;
import jp.co.sss.spring_test.form.UsersForm;
import jp.co.sss.spring_test.repository.Sales_itemsRepository;
 

@Controller
public class TopController { 
@Autowired
Sales_itemsRepository repository;

@GetMapping("/top") 
	public String top(HttpSession session,Model model) { 
	List<Sales_items> items = repository.findAll();
    model.addAttribute("salesItems", items);
	  UsersForm user = (UsersForm) session.getAttribute("user");
    if (user != null) {
  	  model.addAttribute("user", user);
    }
	return "top"; 
	} 	
	
}
