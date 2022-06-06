package com.cdut.dao;

import com.cdut.pojo.User;

public interface UserDao {
    User findByUsername(String username);
}
