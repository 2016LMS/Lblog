package com.lms.cblog.service.impl;

import com.lms.cblog.dao.UserRepository;
import com.lms.cblog.po.User;
import com.lms.cblog.service.UserService;
import com.lms.cblog.utility.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Autor Lms
 * Time 2019/9/1/001
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User checkUser(String username,String password){
        User user= userRepository.findByUsernameAndPassword(username, MD5Utils.code(password));
        return user;
    }

    @Override
    public User getUserByname(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User saveUser(User user) {

        return userRepository.save(user);
    }
}
