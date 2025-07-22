package jp.co.sss.spring_test.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import jp.co.sss.spring_test.entity.Products;
import jp.co.sss.spring_test.entity.Reviews;
import jp.co.sss.spring_test.entity.Users;
import jp.co.sss.spring_test.form.ReviewsForm;
import jp.co.sss.spring_test.form.UsersForm;
import jp.co.sss.spring_test.repository.ProductsRepository;
import jp.co.sss.spring_test.repository.ReviewsRepository;
import jp.co.sss.spring_test.repository.UsersRepository;


@Controller
public class ReviewController {
	@Autowired
	private ProductsRepository productsRepository;
	
	@Autowired
	private ReviewsRepository reviewsRepository;
	
	@Autowired
	private UsersRepository usersRepository;
	
	@GetMapping("/review/{productId}")
    public String showReviewrForm(
    		@ModelAttribute ReviewsForm form,
    		@PathVariable Integer productId,
    		Model model,
    		HttpSession session) {
		Products product = productsRepository.findById(productId).orElse(null);
	    if (product == null) {
	        return "redirect:/error";
	    }
	    Integer userId = (Integer) session.getAttribute("userId");
    	if (userId == null) {
    	    return "redirect:/login";
    	}
    	Users user = usersRepository.findById(userId).orElse(null);
	    ReviewsForm reviewForm = new ReviewsForm();
	    reviewForm.setProductId(product.getProductId());
	    reviewForm.setRating(1);
	    reviewForm.setComment("");
	    reviewForm.setEmail(user.getEmail());
	    reviewForm.setReviewImgPath(""); 
	    reviewForm.setUserId(user.getUserId()); 

	    model.addAttribute("reviewsForm", reviewForm);
	    
	    UsersForm users = (UsersForm) session.getAttribute("user");
	    if (users != null) {
	  	  model.addAttribute("user", users);
	    }
        return "review";
    }
	
	@PostMapping("/review")
    public String submitReview(
    		@Validated
    		@ModelAttribute("reviewsForm") ReviewsForm form,
    		BindingResult result,
    		@RequestParam String dummyUserName,
    		@RequestParam Integer rating,
    		@RequestParam String comment,
    		@RequestParam String email,
            @RequestParam Integer productId,
            @RequestParam Integer userId,
            @RequestParam MultipartFile reviewImgPath,
            Model model) {
			String errorText ="";
			if(dummyUserName.isEmpty()) {
				errorText = "ユーザー名は必須です\n";
			}
			if(comment.length() > 300) {
				errorText += "コメントは300文字以内で入力してください";
			}else if(comment.length() == 0) {
				errorText += "コメントは必須です";
			}
			if(!errorText.isEmpty()) {
				model.addAttribute("error", errorText);
				return "review";
			}
		 	Reviews review = new Reviews();
		 	review.setProductId(review.getProductId());
		 	review.setDummyUserName(form.getDummyUserName());
		 	review.setRating(form.getRating());
		 	review.setComment(form.getComment());
		 	review.setReviewImgPath(reviewImgPath.getOriginalFilename());
		 	
		 	Products product = productsRepository.findById(productId).orElse(null);
		 	review.setProducts(product);
		 	Users user = usersRepository.findById(userId).orElse(null);
		 	review.setUserId(user.getUserId());
		 	review.setUsers(user);
		 	
		 	LocalDateTime now = LocalDateTime.now();
		 	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		 	String formattedDateTime = now.format(formatter);
		 	review.setCreatedAt(formattedDateTime);
		 	review.setUpdatedAt(formattedDateTime);
		 	
		 	reviewsRepository.save(review);
		 	
		 	return "redirect:/product_list";

		 
			}

}
