package jp.co.sss.spring_test.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import jp.co.sss.spring_test.entity.Order_items;

public interface Order_itemsRepository extends JpaRepository<Order_items, Integer> {
}