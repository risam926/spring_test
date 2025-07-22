package jp.co.sss.spring_test.controller;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import jp.co.sss.spring_test.entity.Users;
import jp.co.sss.spring_test.form.UsersForm;
import jp.co.sss.spring_test.repository.UsersRepository;

@Controller

public class LoginController {
	@Autowired
	UsersRepository usersRepository;

	// ログイン画面表示
	@GetMapping("/login")
	public String showLoginForm(@ModelAttribute UsersForm form,Model model) {
		model.addAttribute("users", new UsersForm());
	    return "login";
	}

	// ログイン処理
	@PostMapping("/login")
	public String login(
			@Validated 
			@ModelAttribute("users") UsersForm form,
			BindingResult result,
			Model model, 
			HttpSession session) {
		if(result.hasErrors()) {
			model.addAttribute("error", "入力した値は正しくありません");
			return "login";
		}
		Users user = usersRepository.findByEmail(form.getEmail());
	    if (user != null
	        && form.getPasswords().equals(user.getPasswords())) {
	    	UsersForm usersForm = new UsersForm();
	    	usersForm.setUserId(user.getUserId());
	    	usersForm.setUserName(user.getUserName());
	    	session.setAttribute("user", usersForm);
	    	session.setAttribute("userId", user.getUserId()); 

	    	return "redirect:/top";
	    }
	    model.addAttribute("error", "メールアドレスまたはパスワードが正しくありません");
	    return "login";
	}
	}
	
	

