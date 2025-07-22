package jp.co.sss.spring_test.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import jp.co.sss.spring_test.entity.Products;

public interface ProductsRepository extends JpaRepository<Products, Integer> {
	// 曖昧検索
	List<Products> findByProductNameAndCategoryId(String name, Integer categoryId);
	
	List<Products> findByCategoryId(Integer productId);
}