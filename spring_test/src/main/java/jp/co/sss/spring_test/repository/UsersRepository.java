package jp.co.sss.spring_test.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import jp.co.sss.spring_test.entity.Users;

public interface UsersRepository extends JpaRepository<Users, Integer> {
	 Users findByEmail(String email);
	 Users findByUserIdAndPasswords(Integer userId, String passwords);
	 
}

