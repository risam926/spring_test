package jp.co.sss.spring_test.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import jp.co.sss.spring_test.entity.Carts;
import jp.co.sss.spring_test.entity.Users;

public interface CartsRepository extends JpaRepository<Carts, Integer> {
	List<Carts> findByUserIdAndProductId(Integer userId, Integer productId);
	List<Carts> findByUsers(Users users);
	
}
