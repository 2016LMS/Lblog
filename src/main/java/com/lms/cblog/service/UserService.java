package com.lms.cblog.service;

import com.lms.cblog.po.User;
import org.springframework.stereotype.Service;

/**
 * Autor Lms
 * Time 2019/9/1/001
 */

public interface UserService {
    User checkUser(String username,String password);
}
