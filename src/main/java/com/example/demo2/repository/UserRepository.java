package com.example.demo2.repository;

import com.example.demo2.entity.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

/**
 * user表映射
 */
public interface UserRepository extends CrudRepository<User,Long> {
    @Transactional
    @Modifying
    @Query(value = "UPDATE User SET password = :password WHERE id = :id", nativeQuery = true)
    void updatePasswordById(@Param("id") Long id, @Param("password") String password);
}
