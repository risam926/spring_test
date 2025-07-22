package jp.co.sss.spring_test.controller;



import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jp.co.sss.spring_test.entity.Carts;
import jp.co.sss.spring_test.entity.Users;
import jp.co.sss.spring_test.form.CartsForm;
import jp.co.sss.spring_test.form.UsersForm;
import jp.co.sss.spring_test.repository.CartsRepository;
import jp.co.sss.spring_test.repository.UsersRepository;



@Controller
public class Cart_indexController {

    @Autowired
    private CartsRepository cartsRepository;

    @Autowired
    private UsersRepository usersRepository;

    @GetMapping("/cart_index")
    public String viewCart(Model model, HttpSession session) {
    
        Integer userId = (Integer) session.getAttribute("userId");
        if (userId == null) {
            return "redirect:/login";
        }

        Users user = usersRepository.findById(userId).orElse(null);
        List<Carts> cart_index = cartsRepository.findByUsers(user);

        List<CartsForm> cartFormList = new ArrayList<>();
        int totalQuantity = 0;
        int totalPrice = 0;
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
            int price = cart.getProducts().getPrice();
            int taxPrice = cart.getProducts().getTaxPrice();

            totalQuantity += quantity;
            totalPrice += price * quantity;
            totalWithTax += taxPrice * quantity;
        }

        model.addAttribute("cart_index", cartFormList);
        model.addAttribute("totalQuantity", totalQuantity);
        model.addAttribute("totalPrice", totalPrice);
        model.addAttribute("totalWithTax", totalWithTax);
        
        UsersForm users = (UsersForm) session.getAttribute("user");
        if (users != null) {
      	  model.addAttribute("user", users);
        }

        return "cart_index";
    }
    
   
    @PostMapping("/cart_delete")
    public String deleteCartItem(@RequestParam("cartId") Integer cartId) {  
        cartsRepository.deleteById(cartId);
        return "redirect:/cart_index";
    }
}
