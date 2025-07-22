package jp.co.sss.spring_test.controller;

import jakarta.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jp.co.sss.spring_test.form.UsersForm;

@Controller
public class mypageController {
	@GetMapping("/mypage")
    public String showMyPage(HttpSession session,Model model) {
        UsersForm form = new UsersForm();
        form.setUserName("藤原里紗");
        form.setUserNameKana("ふじわらりさ");
        form.setPhone("090-xxxx-yyyy");

        model.addAttribute("usersForm", form);
        
        UsersForm user = (UsersForm) session.getAttribute("user");
        if (user != null) {
      	  model.addAttribute("user", user);
        }
        return "mypage";
    }

}
