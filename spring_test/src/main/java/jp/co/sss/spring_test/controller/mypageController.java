package jp.co.sss.spring_test.controller;

import jakarta.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jp.co.sss.spring_test.form.UsersForm;

@Controller
public class mypageController {
	@GetMapping("/mypage")
	public String showMypage(HttpSession session, Model model) {
	    UsersForm user = (UsersForm) session.getAttribute("user");
	    if (user != null) {
	        model.addAttribute("usersForm", user); 
	        return "mypage";
	    } else {
	        return "redirect:/login";
	    }
	}


}
