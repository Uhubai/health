package com.cdut.service;

import com.cdut.pojo.User;

public interface UserService {
    public User findByUsername(String username);
}
