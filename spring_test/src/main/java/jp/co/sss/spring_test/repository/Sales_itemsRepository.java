package jp.co.sss.spring_test.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import jp.co.sss.spring_test.entity.Sales_items;

public interface Sales_itemsRepository extends JpaRepository<Sales_items, Integer> { }