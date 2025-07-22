package jp.co.sss.spring_test.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import jp.co.sss.spring_test.entity.Reviews;

public interface ReviewsRepository extends JpaRepository<Reviews, Integer> {
	List<Reviews> findByProductId(Integer productId);

}