package jp.co.sss.spring_test.controller;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jp.co.sss.spring_test.entity.Users;
import jp.co.sss.spring_test.form.LoginFormWithValidation;
import jp.co.sss.spring_test.repository.UsersRepository;

@Controller
public class RegistController {

    @Autowired
    private UsersRepository usersRepository;
    
    
    @GetMapping("/register")
    public String showRegisterForm(@ModelAttribute LoginFormWithValidation form,Model model) {
    	model.addAttribute("LoginFormWithValidation", new LoginFormWithValidation());
        return "register";
    }

    @PostMapping("/register")
    public String handleRegistration(
    		@Valid
    		@ModelAttribute("LoginFormWithValidation") LoginFormWithValidation form,
    		BindingResult result,
            @RequestParam String confirmPassword,
            Model model) {
    	if(result.hasErrors()) {
			model.addAttribute("error", "入力した値は正しくありません");
			return "register";
		}
        if (!form.getPassword().equals(confirmPassword)) {
            model.addAttribute("error", "パスワードが一致しません");
            return "register";
        }

       Users user = new Users();
       user.setUserName(form.getUser_name());
       user.setEmail(form.getEmail());
       user.setPasswords(form.getPassword());
       user.setPhone("");
       usersRepository.save(user);
        model.addAttribute("message", "登録が完了しました！");
        return "register";
    }
}

