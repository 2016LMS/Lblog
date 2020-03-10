package com.lms.cblog.dao;

import com.lms.cblog.po.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Autor Lms
 * Time 2019/9/1/001
 */
public interface UserRepository extends JpaRepository<User,Long> {
    User findByUsernameAndPassword(String username,String password);
}
