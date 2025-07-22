package jp.co.sss.spring_test.form;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class LoginFormWithValidation {
	@NotBlank(message = "ユーザー名は必須です")
	@Size(max = 50, message = "ユーザー名は50文字以内で入力してください")
	private String user_name;
	@NotBlank(message = "メールアドレスは必須です")
    @Email(message = "有効なメールアドレスを入力してください")
	private String email;
	@NotBlank(message = "パスワードは必須です")
	@Size(min = 8, max = 20, message = "パスワードは8〜20文字で入力してください")
	private String password;
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	

}
